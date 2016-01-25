package com.tildenprep.derpmod.client.combat;

import com.tildenprep.derpmod.client.lore.ItemSwordLore;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * Created by diamondman3 on 11/28/2014.
 */
public class ItemBattlehoe extends ItemSwordLore {
    public BlockPos posTilledBlock;
    public ItemBattlehoe(Item.ToolMaterial material, String loreLine1, String loreLine2){
        super(material, 0, loreLine1, loreLine2);
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
        {
            return false;
        }
        else
        {
            int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos);
            if (hook != 0) return hook > 0;

            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (side != EnumFacing.DOWN && worldIn.isAirBlock(pos.up()))
            {
                if (block == Blocks.grass)
                {
                    return this.till(stack, playerIn, worldIn, pos, Blocks.farmland.getDefaultState());
                }
                if (block == Blocks.mycelium)
                {
                    return this.till(stack, playerIn, worldIn, pos, Blocks.dirt.getDefaultState());
                }

                if (block == Blocks.dirt)
                {
                    switch (ItemBattlehoe.SwitchDirtType.TYPE_LOOKUP[((BlockDirt.DirtType)iblockstate.getValue(BlockDirt.VARIANT)).ordinal()])
                    {
                        case 1:
                            return this.till(stack, playerIn, worldIn, pos, Blocks.farmland.getDefaultState());
                        case 2:
                            return this.till(stack, playerIn, worldIn, pos, Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
                    }
                }
            }

            return false;
        }
    }

    protected boolean till(ItemStack stack, EntityPlayer player, World worldIn, BlockPos target, IBlockState newState){
        worldIn.playSoundEffect((double)((float)target.getX() + 0.5F), (double)((float)target.getY() + 0.5F), (double)((float)target.getZ() + 0.5F), newState.getBlock().stepSound.getStepSound(), (newState.getBlock().stepSound.getVolume() + 1.0F) / 2.0F, newState.getBlock().stepSound.getFrequency() * 0.8F);

        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            worldIn.setBlockState(target, newState);
            stack.damageItem(1, player);
            return true;
        }
    }

    static final class SwitchDirtType
    {
        static final int[] TYPE_LOOKUP = new int[BlockDirt.DirtType.values().length];
        private static final String __OBFID = "CL_00002179";

        static
        {
            try
            {
                TYPE_LOOKUP[BlockDirt.DirtType.DIRT.ordinal()] = 1;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                TYPE_LOOKUP[BlockDirt.DirtType.COARSE_DIRT.ordinal()] = 2;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }

}

