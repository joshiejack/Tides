package penguins.tides.init;

import net.minecraft.item.Item;
import penguins.tides.items.ItemPearl;

public class TItems {
    public static Item PEARL;
    public static Item TURTLE;

    public static void init() {
        PEARL = new ItemPearl().register("pearl");
        //TURTLE = new ItemSpawner("turtle").register("turtle");
    }
}
