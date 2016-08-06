package penguins.tides.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;
import penguins.tides.blocks.BlockPlants.Plant;

public class BlockPlants extends BlockTidal<Plant> {
    public enum Plant implements IStringSerializable {
        KELP_BOTTOM, KELP_MIDDLE, KELP_TOP, GRASS_SHORT, GRASS_DOUBLE, GRASS_TOP;

        @Override
        public String getName() {
            return name().toLowerCase();
        }
    }

    public BlockPlants() {
        super(Material.WATER, Plant.class);
    }
}
