package penguins.tides.world;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeOcean;

import static penguins.tides.blocks.BlockPlants.Plant.*;

public class BiomeKelpForest extends BiomeOcean {
    public BiomeKelpForest(BiomeProperties properties) {
        super(properties);
        this.topBlock = Blocks.SAND.getDefaultState();
    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        return new OceanDecorator(new WorldGenPlant(KELP_TOP), new WorldGenPlant(KELP_TOP, KELP_MIDDLE, KELP_BOTTOM));
    }
}
