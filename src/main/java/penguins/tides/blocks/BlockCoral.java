package penguins.tides.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;
import penguins.tides.blocks.BlockCoral.Coral;

public class BlockCoral extends BlockTidal<Coral> {
    public enum Coral implements IStringSerializable {
        BLUE, CYAN, GREEN, ORANGE, PINK, RED;

        @Override
        public String getName() {
            return name().toLowerCase();
        }
    }

    public BlockCoral() {
        super(Material.WATER, Coral.class);
    }
}
