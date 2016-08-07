package penguins.tides.world;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeOcean;
import penguins.tides.entities.EntityUrchin;

public class BiomeCoralReef extends BiomeOcean {
    public BiomeCoralReef(BiomeProperties properties) {
        super(properties);
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityUrchin.class, 12, 4, 4));
        this.topBlock = Blocks.SAND.getDefaultState();
    }
}
