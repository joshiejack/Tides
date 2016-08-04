package penguins.tides;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import penguins.tides.init.TBlocks;

import static net.minecraft.block.BlockLiquid.LEVEL;

public class TClientProxy extends TCommonProxy {
    @Override
    public void initClient() {
        ModelLoader.setCustomStateMapper(TBlocks.animal, (new StateMap.Builder()).ignore(LEVEL).build());
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TBlocks.animal), 0, new ModelResourceLocation(TBlocks.animal.getRegistryName(), "animal=starfish"));
    }
}
