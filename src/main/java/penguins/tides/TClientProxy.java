package penguins.tides;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import penguins.tides.entities.EntityTurtle;
import penguins.tides.entities.EntityUrchin;
import penguins.tides.entities.models.ModelSeaTurtle;
import penguins.tides.entities.models.ModelSeaUrchin;
import penguins.tides.entities.models.RenderCreature;
import penguins.tides.init.TItems;

import static net.minecraft.block.BlockLiquid.LEVEL;

public class TClientProxy extends TCommonProxy {
    public static final StateMap NO_WATER = new StateMap.Builder().ignore(LEVEL).build();

    @Override
    public void initClient() {
        RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class, new IRenderFactory<EntityTurtle>() {
            @Override
            public Render<? super EntityTurtle> createRenderFor(RenderManager manager) {
                return new RenderCreature(manager, new ModelSeaTurtle(), "turtle");
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityUrchin.class, new IRenderFactory<EntityUrchin>() {
            @Override
            public Render<? super EntityUrchin> createRenderFor(RenderManager manager) {
                return new RenderCreature(manager, new ModelSeaUrchin(), "urchin");
            }
        });

        ModelLoader.setCustomModelResourceLocation(TItems.PEARL, 0, new ModelResourceLocation(TItems.PEARL.getRegistryName(), "white"));
        ModelLoader.setCustomModelResourceLocation(TItems.PEARL, 1, new ModelResourceLocation(TItems.PEARL.getRegistryName(), "black"));
    }
}
