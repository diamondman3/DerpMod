package com.tildenprep.derpmod.client.combat;

import com.tildenprep.derpmod.DerpMod;
import com.tildenprep.derpmod.client.GenericItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.tildenprep.derpmod.entity.ScrollSpellEntity;

public class ItemExplosionScroll extends GenericItem {

	public ItemExplosionScroll(){
		super();
        setCreativeTab(DerpMod.tabDerpMod);
        setUnlocalizedName("explosionScroll");
        setMaxDamage(32);
        setMaxStackSize(1);
	}
	
	 public ItemStack onItemRightClick(ItemStack stack, World w, EntityPlayer player)
	  {
	     if (!w.isRemote)
	      	{
	    	 	stack.setItemDamage(stack.getItemDamage() + 1);
	      		w.spawnEntityInWorld(new ScrollSpellEntity(w, player));
	      	}
	     return stack;
	  }

}
