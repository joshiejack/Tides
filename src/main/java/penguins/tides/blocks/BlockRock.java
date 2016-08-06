package penguins.tides.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import penguins.tides.blocks.BlockRock.Rock;

public class BlockRock extends BlockTidal<Rock> {
    public enum Rock implements IStringSerializable {
        RAW;

        @Override
        public String getName() {
            return name().toLowerCase();
        }
    }

    public BlockRock() {
        super(Material.ROCK, Rock.class);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        if(property == null) return new BlockStateContainer(this, temp);
        return new BlockStateContainer(this, property);
    }

    @Override
    public boolean isFullCube(IBlockState blockState) {
        return true;
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }
}
