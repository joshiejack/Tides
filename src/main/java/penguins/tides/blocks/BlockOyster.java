package penguins.tides.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;

public class BlockOyster extends BlockTidal {
    public enum Oyster implements IStringSerializable {
        EMPTY, SAND, PEARL;

        @Override
        public String getName() {
            return name().toLowerCase();
        }
    }

    public BlockOyster() {
        super(Material.WATER, Oyster.class);
        setTickRandomly(true);
    }
}
