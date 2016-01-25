package com.tildenprep.derpmod.client.food;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by diamondman3 on 11/30/2014.
 */
public class ItemTrolldenApple extends ItemFood {

    private final String name = "trolldenApple";

    public ItemTrolldenApple(){
        super(-4, -9.6F, false);
        this.setAlwaysEdible();
        setCreativeTab(DerpMod.tabDerpMod);
        setUnlocalizedName(DerpMod.MODID + "_" + name);
        GameRegistry.registerItem(this, name);
    }

    public String getName(){return name;}

    public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
        par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.wither.id, 80, 1));
        par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.healthBoost.id, 2400, -2));
    }

}
