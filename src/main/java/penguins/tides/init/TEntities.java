package penguins.tides.init;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import penguins.tides.Tides;
import penguins.tides.entities.EntityTurtle;
import penguins.tides.entities.EntityUrchin;
import penguins.tides.entities.models.EntityCrab;

public class TEntities {
    public static void init() {
        EntityRegistry.registerModEntity(EntityTurtle.class, "turtle", 5, Tides.instance, 80, 3, true, 0x00661A, 0x004000);
        EntityRegistry.registerModEntity(EntityUrchin.class, "urchin", 6, Tides.instance, 80, 3, true, 0x000000, 0xCCCCCC);
        EntityRegistry.registerModEntity(EntityCrab.class, "crab", 7, Tides.instance, 80, 3, true, 0xB68670, 0xB54932);
        EntityRegistry.addSpawn(EntityTurtle.class, 30, 2, 3, EnumCreatureType.WATER_CREATURE, TWorld.MEADOW);
        EntityRegistry.addSpawn(EntityUrchin.class, 30, 5, 11, EnumCreatureType.WATER_CREATURE, TWorld.REEF);
        EntityRegistry.addSpawn(EntityCrab.class, 30, 1, 3, EnumCreatureType.WATER_CREATURE, TWorld.REEF, Biomes.BEACH);
    }
}
