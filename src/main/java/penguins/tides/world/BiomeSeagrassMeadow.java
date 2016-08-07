package penguins.tides.world;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeOcean;
import penguins.tides.entities.EntityTurtle;

import static penguins.tides.blocks.BlockPlants.Plant.*;

public class BiomeSeagrassMeadow extends BiomeOcean {
    public BiomeSeagrassMeadow(BiomeProperties properties) {
        super(properties);
        this.spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntityTurtle.class, 30, 2, 3));
        this.topBlock = Blocks.SAND.getDefaultState();
        this.fillerBlock = Blocks.SANDSTONE.getDefaultState();
    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        return new OceanDecorator(new WorldGenPlant(GRASS_SHORT), new WorldGenPlant(GRASS_TOP, GRASS_DOUBLE));
    }
}
