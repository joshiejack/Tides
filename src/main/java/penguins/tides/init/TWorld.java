package penguins.tides.init;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import penguins.tides.world.BiomeCoralReef;
import penguins.tides.world.BiomeKelpForest;
import penguins.tides.world.BiomeSeagrassMeadow;
import penguins.tides.world.WorldTypeOcean;

public class TWorld {
    public static final Biome REEF = new BiomeCoralReef((new Biome.BiomeProperties("Coral Reef")).setBaseHeight(-0.5F).setHeightVariation(0.05F).setRainfall(0.5F).setWaterColor(0x279FBA));
    public static final Biome MEADOW = new BiomeSeagrassMeadow((new Biome.BiomeProperties("Seagrass Meadow")).setBaseHeight(-0.35F).setHeightVariation(0.01F).setRainfall(0.1F).setWaterColor(0x179FD1));
    public static final Biome FOREST = new BiomeKelpForest((new Biome.BiomeProperties("Kelp Forest")).setBaseHeight(-0.7F).setHeightVariation(0.075F).setRainfall(0.2F).setWaterColor(0x089BBC));
    public static final WorldType OCEANS = new WorldTypeOcean();

    public static void init() {
        registerBiome(50, "coral_reef", REEF);
        registerBiome(51, "seagrass_meadow", MEADOW);
        registerBiome(52, "kelp_forest", FOREST);
    }

    private static void registerBiome(int id, String name, Biome biome) {
        Biome.registerBiome(id, name, biome);
        BiomeDictionary.registerBiomeType(biome, Type.OCEAN);
        BiomeManager.oceanBiomes.add(biome);
        MinecraftForge.TERRAIN_GEN_BUS.register(biome);
    }
}
