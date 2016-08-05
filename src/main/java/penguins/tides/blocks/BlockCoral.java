package penguins.tides.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.IStringSerializable;
import penguins.tides.blocks.BlockCoral.Coral;

import static net.minecraft.block.BlockLiquid.LEVEL;

public class BlockCoral extends BlockTidal<Coral> {
    public enum Coral implements IStringSerializable {
        BLUE, CYAN, GREEN, ORANGE, PINK;

        @Override
        public String getName() {
            return name().toLowerCase();
        }
    }

    public BlockCoral() {
        super(Material.WATER, Coral.class);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        if(property == null) return new BlockStateContainer(this, LEVEL, temp);
        return new BlockStateContainer(this, LEVEL, property);
    }
}
