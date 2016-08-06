package penguins.tides.init;

import net.minecraftforge.fml.common.registry.EntityRegistry;
import penguins.tides.Tides;
import penguins.tides.entities.EntityTurtle;
import penguins.tides.entities.EntityUrchin;

public class TEntities {
    public static void init() {
        EntityRegistry.registerModEntity(EntityTurtle.class, "turtle", 5, Tides.instance, 150, 3, true, 0x00661A, 0x004000);
        EntityRegistry.registerModEntity(EntityUrchin.class, "urchin", 6, Tides.instance, 150, 3, true, 0xFFFFFF, 0xCCCCCC);
    }
}
