package com.tildenprep.derpmod.client.combat;

import com.tildenprep.derpmod.DerpMod;
import com.tildenprep.derpmod.client.lore.ItemSwordLore;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


/**
 * Created by diamondman3 on 9/3/2014.
 */
public class ItemSwordOfGoodbye extends ItemSwordLore {

    public ItemSwordOfGoodbye(Item.ToolMaterial material) {
        super(material, 0, "If unenchanted, right click to enchant.", "THIS IS NOT A TROLL ATTEMPT. -dm3");
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(1);
        setUnlocalizedName("itemSwordOfGoodbye");
    }

    @Override
    public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_){
        return true;
    }
    @Override
    public void onCreated(ItemStack stack, World w, EntityPlayer player) {
        super.onCreated(stack, w, player);
        stack.addEnchantment(Enchantment.knockback, 127);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World par2World, EntityPlayer par3Player){
        if(itemStack.getEnchantmentTagList()== null){
            itemStack.addEnchantment(Enchantment.knockback, 127);
        }
        else{
            par3Player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }
        return itemStack;
    }

}