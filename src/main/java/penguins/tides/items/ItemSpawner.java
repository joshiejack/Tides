package penguins.tides.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import penguins.tides.Tides;

import static penguins.tides.lib.TidesInfo.MODID;

public class ItemSpawner extends ItemTidal {
    private final String name;

    public ItemSpawner(String name) {
        setCreativeTab(Tides.TAB);
        this.name = MODID + "." + name;
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            Entity entity = EntityList.createEntityByIDFromName(name, world);
            if (entity != null) {
                entity.setPosition(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
                world.spawnEntityInWorld(entity);
            }
        }

        return EnumActionResult.FAIL;
    }
}
