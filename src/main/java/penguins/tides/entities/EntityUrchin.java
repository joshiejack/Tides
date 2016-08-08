package penguins.tides.entities;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityUrchin extends EntityAnimal {
    private boolean clientSideTouchedGround;

    public EntityUrchin(World worldIn) {
        super(worldIn);
        this.experienceValue = 10;
        this.setSize(0.85F, 0.85F);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntityUrchin(ageable.worldObj);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, net.minecraft.entity.monster.EntityGuardian.class, 12.0F, 0.01F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.025D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4D);
    }

    @Override
    protected PathNavigate getNewNavigator(World worldIn) {
        return new PathNavigateSwimmer(this, worldIn);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return (this.isInWater() ? SoundEvents.ENTITY_SQUID_AMBIENT : SoundEvents.ENTITY_SQUID_AMBIENT);
    }

    @Override
    protected SoundEvent getHurtSound() {
        return (this.isInWater() ? SoundEvents.ENTITY_SQUID_HURT : SoundEvents.ENTITY_SQUID_HURT);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return  (this.isInWater() ? SoundEvents.ENTITY_SQUID_DEATH : SoundEvents.ENTITY_SQUID_DEATH);
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public float getEyeHeight() {
        return this.height * 0.25F;
    }

    @Override
    public float getBlockPathWeight(BlockPos pos) {
        return this.worldObj.getBlockState(pos).getMaterial() == Material.WATER ? 10.0F + this.worldObj.getLightBrightness(pos) - 0.5F : super.getBlockPathWeight(pos);
    }

    @Override
    public void onLivingUpdate() {
        if (this.worldObj.isRemote) {
            if (!this.isInWater()) {
                if (this.motionY > 0.0D && this.clientSideTouchedGround && !this.isSilent()) {
                    this.worldObj.playSound(this.posX, this.posY, this.posZ, SoundEvents.ENTITY_GUARDIAN_FLOP, this.getSoundCategory(), 1.0F, 1.0F, false);
                }

                this.clientSideTouchedGround = this.motionY < 0.0D && this.worldObj.isBlockNormalCube((new BlockPos(this)).down(), false);
            }
        }

        if (this.inWater) {
            this.setAir(300);
        } else if (this.onGround) {
            this.motionY += 0.5D;
            this.motionX += (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F);
            this.motionZ += (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F);
            this.rotationYaw = this.rand.nextFloat() * 360.0F;
            this.onGround = false;
            this.isAirBorne = true;
        }

        super.onLivingUpdate();
    }

    @Override
    public boolean isNotColliding() {
        return this.worldObj.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.worldObj.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty();
    }

    @Override
    public boolean getCanSpawnHere() {
        return true;
    }

    @Override
    public int getVerticalFaceSpeed() {
        return 180;
    }

    @Override
    public void moveEntityWithHeading(float strafe, float forward) {
        if (this.isServerWorld()) {
            if (this.isInWater()) {
                this.moveRelative(strafe, forward, 0.1F);
                this.moveEntity(this.motionX, this.motionY, this.motionZ);
                this.motionX *= 0.8999999761581421D;
                this.motionY *= 0.8999999761581421D;
                this.motionZ *= 0.8999999761581421D;
            } else {
                super.moveEntityWithHeading(strafe, forward);
            }
        } else {
            super.moveEntityWithHeading(strafe, forward);
        }
    }
}
