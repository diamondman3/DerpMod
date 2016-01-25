package com.tildenprep.derpmod.client.combat;

import com.tildenprep.derpmod.DerpMod;
import com.tildenprep.derpmod.client.lore.ItemSwordLore;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;


/**
 * Created by diamondman3 on 9/3/2014.
 */
public class ItemSwordOfGoodbye extends ItemSwordLore {

    private final String name = "swordOfGoodbye";

    public ItemSwordOfGoodbye(Item.ToolMaterial material) {
        super(material, 0, "If unenchanted, right click to enchant.", "This actually barely negatively impacts the user. -dm3");
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(1);
        setUnlocalizedName(DerpMod.MODID + "_" + name);
        GameRegistry.registerItem(this, name);
    }

    public String getName(){
        return name;
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
            if(!par3Player.capabilities.isCreativeMode){
                PotionEffect slowness = new PotionEffect(2, 6000, 1);
                par3Player.addPotionEffect(slowness);
            }
        }
        else{
            par3Player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }
        return itemStack;
    }

}