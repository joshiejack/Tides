package penguins.tides.items;

import net.minecraft.item.Item;

public class TItems {
    public static Item PEARL;
    public static Item TURTLE;

    public static void init() {
        PEARL = new Item();
        TURTLE = new ItemSpawner("turtle").register("turtle");
    }
}
