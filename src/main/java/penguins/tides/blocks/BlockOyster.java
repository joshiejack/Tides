package penguins.tides.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import penguins.tides.blocks.BlockOyster.Oyster;
import penguins.tides.init.TItems;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Random;

import static net.minecraft.block.BlockHorizontal.FACING;
import static net.minecraft.block.BlockLiquid.LEVEL;
import static net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
import static penguins.tides.TClientProxy.NO_WATER;

public class BlockOyster extends BlockTidal<Oyster> {
    private static final Item SAND = Item.getItemFromBlock(Blocks.SAND);
    private static final ItemStack WHITE = new ItemStack(TItems.PEARL, 1, 0);
    private static final ItemStack BLACK = new ItemStack(TItems.PEARL, 1, 1);

    public enum Oyster implements IStringSerializable {
        EMPTY, SAND, PEARL_WHITE, PEARL_BLACK;

        @Override
        public String getName() {
            return name().toLowerCase();
        }
    }

    public BlockOyster() {
        super(Material.WATER, Oyster.class);
        setTickRandomly(true);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        if(property == null) return new BlockStateContainer(this, LEVEL, FACING, temp);
        return new BlockStateContainer(this, LEVEL, FACING, property);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return (state.getValue(FACING)).getHorizontalIndex();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileOyster();
    }

    private static EnumFacing getFacingFromEntity(EntityLivingBase entity) {
        int direction = MathHelper.floor_double(entity.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
        EnumFacing dir = EnumFacing.NORTH;
        if (direction == 0) return EnumFacing.NORTH;
        if (direction == 1) return EnumFacing.EAST;
        if (direction == 2) return EnumFacing.SOUTH;
        if (direction == 3) return EnumFacing.WEST;
        return dir;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
        world.setBlockState(pos, state.withProperty(FACING, getFacingFromEntity(entity)));
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (worldIn.rand.nextInt(8) == 0) {
            worldIn.getTileEntity(pos).getCapability(ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN).insertItem(0, WHITE.copy(), false);
        } else if (worldIn.rand.nextInt(32) == 0) {
            worldIn.getTileEntity(pos).getCapability(ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN).insertItem(0, BLACK.copy(), false);
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        Oyster oyster = getEnumFromMeta(getMetaFromState(getActualState(state, worldIn, pos)));
        if (oyster == Oyster.EMPTY) {
            if (heldItem != null && heldItem.getItem() == SAND) {
                ItemStack held = worldIn.getTileEntity(pos).getCapability(ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN).insertItem(0, heldItem, false);
                playerIn.setHeldItem(hand, held);
                return true;
            }
        } else if (oyster == Oyster.PEARL_WHITE || oyster == Oyster.PEARL_BLACK || oyster == Oyster.SAND) {
            if (heldItem == null) {
                ItemStack result = worldIn.getTileEntity(pos).getCapability(ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN).extractItem(0, 1, false);
                playerIn.setHeldItem(hand, result);
                return true;
            }
        }

        return false;
    }

    @Deprecated
    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        ItemStack stack = worldIn.getTileEntity(pos).getCapability(ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN).getStackInSlot(0);
        if (stack == null) return state.withProperty(property, Oyster.EMPTY);
        else if (stack.getItem() == SAND) return state.withProperty(property, Oyster.SAND);
        else if (stack.getItem() == TItems.PEARL && stack.getItemDamage() == 0) return state.withProperty(property, Oyster.PEARL_WHITE);
        else if (stack.getItem() == TItems.PEARL && stack.getItemDamage() == 1) return state.withProperty(property, Oyster.PEARL_BLACK);
        else return state;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
        list.add(new ItemStack(this, 1, 0));
    }

    @SideOnly(Side.CLIENT)
    public void registerModels() {
        ModelLoader.setCustomStateMapper(this, NO_WATER);

        for (Oyster e: values) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), e.ordinal(), new ModelResourceLocation(getRegistryName(), "inventory"));
        }
    }
}
