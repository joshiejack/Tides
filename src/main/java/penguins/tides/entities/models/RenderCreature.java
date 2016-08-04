package penguins.tides.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import static penguins.tides.lib.TidesInfo.MODID;

public class RenderCreature extends RenderLiving<EntityLiving> {
    private ResourceLocation texture;

    public RenderCreature(RenderManager manager, ModelBase model, String name) {
        super(manager, model, 1F);
        texture = new ResourceLocation(MODID, "textures/entity/" + name + ".png");
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityLiving entityLiving) {
        return texture;
    }
}
