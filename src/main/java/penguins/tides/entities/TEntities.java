package penguins.tides.entities;

import net.minecraftforge.fml.common.registry.EntityRegistry;
import penguins.tides.Tides;

public class TEntities {
    public static void init() {
        EntityRegistry.registerModEntity(EntityTurtle.class, "turtle", 5, Tides.instance, 150, 3, true);
    }
}
