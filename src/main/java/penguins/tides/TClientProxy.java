package penguins.tides;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import penguins.tides.entities.EntityTurtle;
import penguins.tides.entities.models.ModelSeaTurtle;
import penguins.tides.entities.models.RenderCreature;
import penguins.tides.init.TBlocks;
import penguins.tides.init.TItems;

import static net.minecraft.block.BlockLiquid.LEVEL;

public class TClientProxy extends TCommonProxy {
    private static final StateMap NO_WATER = new StateMap.Builder().ignore(LEVEL).build();

    @Override
    public void initClient() {
        ModelLoader.setCustomStateMapper(TBlocks.animal, NO_WATER);
        ModelLoader.setCustomStateMapper(TBlocks.coral, NO_WATER);
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TBlocks.animal), 0, new ModelResourceLocation(TBlocks.animal.getRegistryName(), "animal=starfish"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TBlocks.coral), 0, new ModelResourceLocation(TBlocks.coral.getRegistryName(), "coral=blue"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TBlocks.coral), 1, new ModelResourceLocation(TBlocks.coral.getRegistryName(), "coral=cyan"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TBlocks.coral), 2, new ModelResourceLocation(TBlocks.coral.getRegistryName(), "coral=green"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TBlocks.coral), 3, new ModelResourceLocation(TBlocks.coral.getRegistryName(), "coral=orange"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TBlocks.coral), 4, new ModelResourceLocation(TBlocks.coral.getRegistryName(), "coral=pink"));

        RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class, new IRenderFactory<EntityTurtle>() {
            @Override
            public Render<? super EntityTurtle> createRenderFor(RenderManager manager) {
                return new RenderCreature(manager, new ModelSeaTurtle(), "turtle");
            }
        });

        ModelLoader.setCustomModelResourceLocation(TItems.PEARL, 0, new ModelResourceLocation(TItems.PEARL.getRegistryName(), "white"));
        ModelLoader.setCustomModelResourceLocation(TItems.PEARL, 1, new ModelResourceLocation(TItems.PEARL.getRegistryName(), "black"));
    }
}
