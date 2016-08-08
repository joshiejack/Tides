package penguins.tides.world;

import net.minecraft.world.biome.BiomeDecorator;

import static penguins.tides.blocks.BlockPlants.Plant.*;

public class BiomeKelpForest extends BiomeSandy {
    public BiomeKelpForest(BiomeProperties properties) {
        super(properties);
    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        return new PlantDecorator(new WorldGenPlant(KELP_TOP).setFrequency(32), new WorldGenPlant(KELP_TOP, KELP_MIDDLE, KELP_BOTTOM).setFrequency(16));
    }
}
