package penguins.tides.init;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import penguins.tides.blocks.BlockAnimal;
import penguins.tides.blocks.BlockCoral;
import penguins.tides.blocks.TileOyster;

import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static penguins.tides.lib.TidesInfo.MODID;

public class TBlocks {
    public static Block oyster;
    public static Block animal;
    public static Block formations;
    public static Block coral;
    public static Block plants;

    public static void init() {
        LOGGER.log(Level.INFO, "Registering the animal block");
        animal = new BlockAnimal().register("animal");
        coral = new BlockCoral().register("coral");
        GameRegistry.registerTileEntity(TileOyster.class, MODID + ":oyster");
    }
}
