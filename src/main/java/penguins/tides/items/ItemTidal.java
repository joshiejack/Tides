package penguins.tides.items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import penguins.tides.Tides;

import static penguins.tides.lib.TidesInfo.MODID;

public class ItemTidal extends Item {
    public ItemTidal() {
        setCreativeTab(Tides.TAB);
    }

    public Item register(String name) {
        setUnlocalizedName(name);
        setRegistryName(new ResourceLocation(MODID, name));
        setCreativeTab(Tides.TAB); //Default out the tab
        GameRegistry.register(this);
        return this;
    }
}
