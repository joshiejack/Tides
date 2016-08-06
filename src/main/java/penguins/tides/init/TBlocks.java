package penguins.tides.init;

import net.minecraftforge.fml.common.registry.GameRegistry;
import penguins.tides.blocks.*;

import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static penguins.tides.lib.TidesInfo.MODID;

public class TBlocks {
    public static BlockTidal oyster;
    public static BlockTidal animal;
    public static BlockTidal formations;
    public static BlockTidal rock;
    public static BlockTidal coral;
    public static BlockTidal plants;

    public static void init() {
        LOGGER.log(Level.INFO, "Registering the animal block");
        oyster = new BlockOyster().register("oyster");
        animal = new BlockAnimal().register("animal");
        coral = new BlockCoral().register("coral");
        rock = new BlockRock().register("rock");
        plants = new BlockPlants().register("plants");
        GameRegistry.registerTileEntity(TileOyster.class, MODID + ":oyster");
    }
}
