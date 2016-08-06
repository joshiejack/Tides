package penguins.tides.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemPearl extends ItemTidal {
    public ItemPearl() {}

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        if (stack.getItemDamage() == 0) return ("" + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".white.name")).trim();
        else return ("" + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".black.name")).trim();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
        list.add(getEntity("turtle"));
        list.add(getEntity("urchin"));
        list.add(new ItemStack(this, 1, 0));
        list.add(new ItemStack(this, 1, 1));
    }

    private ItemStack getEntity(String name) {
        ItemStack itemstack = new ItemStack(Items.SPAWN_EGG, 1);
        ItemMonsterPlacer.applyEntityIdToItemStack(itemstack, "tides." + name);
        return itemstack;
    }
}
