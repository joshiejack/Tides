package penguins.tides.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import static net.minecraft.block.BlockLiquid.LEVEL;

public class BlockAnimal extends BlockTidal {
    private static final AxisAlignedBB STARFISH_AABB = new AxisAlignedBB(0.2D, 0.0D, 0.25D, 0.75D, 0.1D, 0.75D);
    public enum Animal implements IStringSerializable {
        STARFISH;

        @Override
        public String getName() {
            return name().toLowerCase();
        }
    }

    public BlockAnimal() {
        super(Material.WATER, Animal.class);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        if(property == null) return new BlockStateContainer(this, LEVEL, temp);
        return new BlockStateContainer(this, LEVEL, property);
    }

    @Deprecated
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return STARFISH_AABB;
    }
}
