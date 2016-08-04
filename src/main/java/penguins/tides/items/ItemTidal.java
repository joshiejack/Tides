package penguins.tides.items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static penguins.tides.lib.TidesInfo.MODID;

public class ItemTidal extends Item {
    public Item register(String name) {
        setUnlocalizedName(name);
        setRegistryName(new ResourceLocation(MODID, name));
        GameRegistry.register(this);
        return this;
    }
}
