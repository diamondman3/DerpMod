package com.tildenprep.derpmod.client.rawMaterials;

import com.tildenprep.derpmod.DerpMod;
import com.tildenprep.derpmod.client.GenericItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemUnfinishedRageIngot extends GenericItem{

	public int globStage;
	public ItemUnfinishedRageIngot(int stage){
        super();
        this.globStage = stage;
        switch(stage){
        case 0:
        	setUnlocalizedName("uri1");
        	break;
        case 1:
        	setUnlocalizedName("uri2");
        	break;
        case 2:
        	setUnlocalizedName("uri3");
        	break;
        case 3:
        	setUnlocalizedName("uri4");
        	break;
        case 4:
        	setUnlocalizedName("uri5");
        	break;
        case 5:
        	setUnlocalizedName("uri6");
        	break;
        case 6:
        	setUnlocalizedName("uri7");
        	break;
        }
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(64);
        setMaxDamage(6);
	}
	public int getGlobStage(){
		return globStage;
	}
}
