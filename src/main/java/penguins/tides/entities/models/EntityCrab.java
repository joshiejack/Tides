package penguins.tides.entities.models;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityCrab extends EntityAnimal {
    public EntityCrab(World world) {
        super(world);
        this.setSize(0.5F, 0.5F);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1D);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (source == DamageSource.drown) return false;
        else return super.attackEntityFrom(source, amount);
    }

    @Override
    public void onEntityUpdate() {
        if (this.inWater) {
            this.setAir(300);
        }

        super.onEntityUpdate();
    }

    @Override
    public float getEyeHeight() {
        return 0.4F;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntityCrab(ageable.getEntityWorld());
    }
}
