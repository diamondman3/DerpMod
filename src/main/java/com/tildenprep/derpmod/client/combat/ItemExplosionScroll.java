package com.tildenprep.derpmod.client.combat;

import com.tildenprep.derpmod.DerpMod;
import com.tildenprep.derpmod.client.GenericItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.tildenprep.derpmod.entity.ScrollSpellEntity;

public class ItemExplosionScroll extends GenericItem {

    public final String name = "explosionScroll";

	public ItemExplosionScroll(){
		super();
        setCreativeTab(DerpMod.tabDerpMod);
        setUnlocalizedName(DerpMod.MODID + "_" + name);
        setMaxDamage(32);
        setMaxStackSize(1);
        GameRegistry.registerItem(this, name);
	}

    public String getName(){return name;}

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
