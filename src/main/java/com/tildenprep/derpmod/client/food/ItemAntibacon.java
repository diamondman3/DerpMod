package com.tildenprep.derpmod.client.food;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by kenny on 5/7/14.
 */
public class ItemAntibacon extends ItemFood {

    public ItemAntibacon(){
        super(-8, -12.8F, true);
        this.setAlwaysEdible();
        setCreativeTab(DerpMod.tabDerpMod);
        setUnlocalizedName("itemAntibacon");
    }

    public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par2World.playSoundAtEntity(par3EntityPlayer,("derpmod:trollSongClip"), 1, 1);

    }
}
