package penguins.tides.entities;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityTurtle extends EntityAnimal {
    private static final DataParameter<Byte> STATUS = EntityDataManager.<Byte>createKey(net.minecraft.entity.monster.EntityGuardian.class, DataSerializers.BYTE);
    private boolean clientSideTouchedGround;
    private EntityAIWander wander;

    public EntityTurtle(World worldIn) {
        super(worldIn);
        this.experienceValue = 10;
        this.setSize(0.85F, 0.85F);
        this.moveHelper = new TurtleMoveHelper(this);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntityTurtle(ageable.worldObj);
    }

    @Override
    protected void initEntityAI() {
        EntityAIMoveTowardsRestriction entityaimovetowardsrestriction = new EntityAIMoveTowardsRestriction(this, 1.0D);
        this.wander = new EntityAIWander(this, 1.0D, 80);
        this.tasks.addTask(5, entityaimovetowardsrestriction);
        this.tasks.addTask(7, this.wander);
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.wander.setMutexBits(3);
        entityaimovetowardsrestriction.setMutexBits(3);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(24D);
    }

    @Override
    protected PathNavigate getNewNavigator(World worldIn) {
        return new PathNavigateSwimmer(this, worldIn);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(STATUS, Byte.valueOf((byte) 0));
    }

    private boolean isSyncedFlagSet(int flagId) {
        return (((Byte) this.dataManager.get(STATUS)).byteValue() & flagId) != 0;
    }

    private void setSyncedFlag(int flagId, boolean state) {
        byte b0 = ((Byte) this.dataManager.get(STATUS)).byteValue();

        if (state) {
            this.dataManager.set(STATUS, Byte.valueOf((byte) (b0 | flagId)));
        } else {
            this.dataManager.set(STATUS, Byte.valueOf((byte) (b0 & ~flagId)));
        }
    }

    public boolean isMoving() {
        return this.isSyncedFlagSet(2);
    }

    private void setMoving(boolean moving) {
        this.setSyncedFlag(2, moving);
    }

    @Override
    public int getTalkInterval() {
        return 160;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return (this.isInWater() ? SoundEvents.ENTITY_RABBIT_AMBIENT : SoundEvents.ENTITY_RABBIT_AMBIENT);
    }

    @Override
    protected SoundEvent getHurtSound() {
        return (this.isInWater() ? SoundEvents.ENTITY_GUARDIAN_DEATH_LAND : SoundEvents.ENTITY_GUARDIAN_DEATH_LAND);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return  (this.isInWater() ? SoundEvents.ENTITY_GUARDIAN_DEATH_LAND : SoundEvents.ENTITY_GUARDIAN_DEATH_LAND);
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public float getEyeHeight() {
        return this.height * 0.5F;
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

            if (this.isMoving() && this.isInWater()) {
                Vec3d vec3d = this.getLook(0.0F);

                for (int i = 0; i < 2; ++i) {
                    this.worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width - vec3d.xCoord * 1.5D, this.posY + this.rand.nextDouble() * (double) this.height - vec3d.yCoord * 1.5D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width - vec3d.zCoord * 1.5D, 0.0D, 0.0D, 0.0D, new int[0]);
                }
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

                if (!this.isMoving() && this.getAttackTarget() == null) {
                    this.motionY -= 0.005D;
                }
            } else {
                super.moveEntityWithHeading(strafe, forward);
            }
        } else {
            super.moveEntityWithHeading(strafe, forward);
        }
    }

    static class TurtleMoveHelper extends EntityMoveHelper {
        private final EntityTurtle entityTurtle;

        public TurtleMoveHelper(EntityTurtle turtle) {
            super(turtle);
            this.entityTurtle = turtle;
        }

        @Override
        public void onUpdateMoveHelper() {
            if (this.action == EntityMoveHelper.Action.MOVE_TO && !this.entityTurtle.getNavigator().noPath()) {
                double d0 = this.posX - this.entityTurtle.posX;
                double d1 = this.posY - this.entityTurtle.posY;
                double d2 = this.posZ - this.entityTurtle.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                d3 = (double) MathHelper.sqrt_double(d3);
                d1 = d1 / d3;
                float f = (float) (MathHelper.atan2(d2, d0) * (180D / Math.PI)) - 90.0F;
                this.entityTurtle.rotationYaw = this.limitAngle(this.entityTurtle.rotationYaw, f, 90.0F);
                this.entityTurtle.renderYawOffset = this.entityTurtle.rotationYaw;
                float f1 = (float) (this.speed * this.entityTurtle.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                this.entityTurtle.setAIMoveSpeed(this.entityTurtle.getAIMoveSpeed() + (f1 - this.entityTurtle.getAIMoveSpeed()) * 0.125F);
                double d4 = Math.sin((double) (this.entityTurtle.ticksExisted + this.entityTurtle.getEntityId()) * 0.5D) * 0.05D;
                double d5 = Math.cos((double) (this.entityTurtle.rotationYaw * 0.017453292F));
                double d6 = Math.sin((double) (this.entityTurtle.rotationYaw * 0.017453292F));
                this.entityTurtle.motionX += d4 * d5;
                this.entityTurtle.motionZ += d4 * d6;
                d4 = Math.sin((double) (this.entityTurtle.ticksExisted + this.entityTurtle.getEntityId()) * 0.75D) * 0.05D;
                this.entityTurtle.motionY += d4 * (d6 + d5) * 0.25D;
                this.entityTurtle.motionY += (double) this.entityTurtle.getAIMoveSpeed() * d1 * 0.1D;
                EntityLookHelper entitylookhelper = this.entityTurtle.getLookHelper();
                double d7 = this.entityTurtle.posX + d0 / d3 * 2.0D;
                double d8 = (double) this.entityTurtle.getEyeHeight() + this.entityTurtle.posY + d1 / d3;
                double d9 = this.entityTurtle.posZ + d2 / d3 * 2.0D;
                double d10 = entitylookhelper.getLookPosX();
                double d11 = entitylookhelper.getLookPosY();
                double d12 = entitylookhelper.getLookPosZ();

                if (!entitylookhelper.getIsLooking()) {
                    d10 = d7;
                    d11 = d8;
                    d12 = d9;
                }

                this.entityTurtle.getLookHelper().setLookPosition(d10 + (d7 - d10) * 0.125D, d11 + (d8 - d11) * 0.125D, d12 + (d9 - d12) * 0.125D, 10.0F, 40.0F);
                this.entityTurtle.setMoving(true);
            } else {
                this.entityTurtle.setAIMoveSpeed(0.0F);
                this.entityTurtle.setMoving(false);
            }
        }
    }
}
