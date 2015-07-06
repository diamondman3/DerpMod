package com.tildenprep.derpmod.client.combat;

import com.tildenprep.derpmod.client.lore.ItemSwordLore;
import net.minecraft.block.Block;
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

    public BlockPos posMark2;
    public ItemBattlehoe(Item.ToolMaterial material, String loreLine1, String loreLine2){
        super(material, 0, loreLine1, loreLine2);
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        posMark2.east(pos.getX());
        posMark2.up(pos.getY() + 1);
        posMark2.south(pos.getZ());

        if (!player.canPlayerEdit(pos, p_77648_7_, stack))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(player, stack, world, pos);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }

            if (event.getResult() == Event.Result.ALLOW)
            {
                stack.damageItem(1, player);
                return true;
            }

            Block block = world.getBlockState(pos).getBlock();

            if (!p_77648_7_.equals(0) && world.getBlockState(posMark2).getBlock().isAir(world, posMark2) && (block == Blocks.grass || block == Blocks.dirt))
            {
                Block farmland = Blocks.farmland;
                world.playSoundEffect((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), "dig." + block.stepSound, (farmland.stepSound.getVolume() + 1.0F) / 2.0F, farmland.stepSound.getFrequency() * 0.8F);

                if (world.isRemote)
                {
                    return true;
                }
                else
                {
                    world.setBlockState(pos, Blocks.farmland.getDefaultState());
                    stack.damageItem(1, player);
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
    }

}

