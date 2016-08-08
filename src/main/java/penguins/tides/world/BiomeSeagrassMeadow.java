package penguins.tides.world;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import penguins.tides.entities.EntityTurtle;

import static penguins.tides.blocks.BlockPlants.Plant.*;

public class BiomeSeagrassMeadow extends BiomeSandy {
    public BiomeSeagrassMeadow(BiomeProperties properties) {
        super(properties);
        this.spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntityTurtle.class, 30, 2, 3));
    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        return new PlantDecorator(new WorldGenPlant(GRASS_SHORT), new WorldGenPlant(GRASS_TOP, GRASS_DOUBLE));
    }
}
