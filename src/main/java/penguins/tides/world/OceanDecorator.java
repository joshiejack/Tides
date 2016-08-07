package penguins.tides.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;

import java.util.Random;

public class OceanDecorator extends BiomeDecorator {
    private final WorldGenPlant shortPlant;
    private final WorldGenPlant tallPlant;

    public OceanDecorator(WorldGenPlant shortPlant, WorldGenPlant tallPlant) {
        this.shortPlant = shortPlant;
        this.tallPlant = tallPlant;
    }

    @Override
    protected void genDecorations(Biome biomeGenBaseIn, World worldIn, Random random) {
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Pre(worldIn, random, chunkPos));
        this.generateOres(worldIn, random);

        for (int l2 = 0; l2 < 10; ++l2) {
            int i7 = random.nextInt(16) + 8;
            int l10 = random.nextInt(16) + 8;
            BlockPos blockpos1 = chunkPos.add(i7, 0, l10);
            this.shortPlant.generate(worldIn, random, blockpos1);
            this.tallPlant.generate(worldIn, random, blockpos1);
        }
    }
}
