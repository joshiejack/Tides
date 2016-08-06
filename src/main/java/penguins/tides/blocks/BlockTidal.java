package penguins.tides.blocks;

import com.google.common.base.Function;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import penguins.tides.Tides;

import javax.annotation.Nullable;
import java.util.List;

import static net.minecraft.block.BlockLiquid.LEVEL;
import static penguins.tides.TClientProxy.NO_WATER;
import static penguins.tides.lib.TidesInfo.MODID;

public abstract class BlockTidal<E extends Enum<E> & IStringSerializable> extends Block {
    protected static PropertyEnum<?> temp;
    protected final PropertyEnum<E> property;
    protected final E[] values;

    public BlockTidal(Material material, Class<E> clazz) {
        super(preInit(material, clazz));
        property = (PropertyEnum<E>) temp;
        values = clazz.getEnumConstants();
        setDefaultState(blockState.getBaseState());
        setCreativeTab(Tides.TAB); //Default out the tab
    }

    private static Material preInit(Material material, Class clazz) {
        temp = PropertyEnum.create(clazz.getSimpleName().toLowerCase(), clazz);
        return material;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        if(property == null) return new BlockStateContainer(this, LEVEL, temp);
        return new BlockStateContainer(this, LEVEL, property);
    }

    @Deprecated
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(property, getEnumFromMeta(meta));
    }

    public IBlockState getStateFromEnum(E e) {
        return getDefaultState().withProperty(property, e);
    }

    public E getEnumFromMeta(int meta) {
        if (meta < 0 || meta >= values.length) {
            meta = 0;
        }

        return values[meta];
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return (state.getValue(property)).ordinal();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public boolean isFullCube(IBlockState blockState) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        return false;
    }

    @Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
        for (E e: values) {
            list.add(new ItemStack(this, 1, e.ordinal()));
        }
    }

    public BlockTidal register(String name) {
        setUnlocalizedName(name);
        setRegistryName(new ResourceLocation(MODID, name));
        GameRegistry.register(this);
        ItemBlock item = new ItemMultiTexture(this, this, new Function<ItemStack, String>() {
            @Nullable
            public String apply(@Nullable ItemStack stack) {
                return getEnumFromMeta(stack.getItemDamage()).getName();
            }
        });

        item.setRegistryName(new ResourceLocation(MODID, name));
        item.setUnlocalizedName(name);
        GameRegistry.register(item);

        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            this.registerModels();
        }

        return this;
    }

    @SideOnly(Side.CLIENT)
    public void registerModels() {
        ModelLoader.setCustomStateMapper(this, NO_WATER);

        for (E e: values) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), e.ordinal(), new ModelResourceLocation(getRegistryName(), e.getClass().getSimpleName().toLowerCase() + "=" + e.getName()));
        }
    }
}
