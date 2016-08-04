package penguins.tides;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static penguins.tides.lib.TidesInfo.*;


@Mod(modid = MODID, version = VERSION)
public class Tides {
    public static final Logger LOGGER = LogManager.getLogger(MODNAME);

    @SidedProxy(clientSide = JAVAPATH + "TClientProxy", serverSide = JAVAPATH + "TCommonProxy")
    public static TCommonProxy proxy;

    @Instance(MODID)
    public static Tides instance;

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
