package penguins.tides.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;
import penguins.tides.blocks.BlockPlants.Plant;

public class BlockPlants extends BlockTidal<Plant> {
    public enum Plant implements IStringSerializable {
        KELP_BOTTOM, KELP_MIDDLE, KELP_TOP, GRASS_1, GRASS_2, GRASS_3, GRASS_4,
        GRASS_DOUBLE, GRASS_DOUBLE1, GRASS_DOUBLE2, GRASS_DOUBLE3, GRASS_DOUBLE4;

        @Override
        public String getName() {
            return name().toLowerCase();
        }
    }

    public BlockPlants() {
        super(Material.WATER, Plant.class);
    }
}
