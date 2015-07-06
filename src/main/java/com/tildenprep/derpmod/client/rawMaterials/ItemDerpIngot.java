package com.tildenprep.derpmod.client.rawMaterials;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by kenny on 3/19/14.
 */
public class ItemDerpIngot extends Item {
	
	

    public ItemDerpIngot(){
        super();
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(64);
        setUnlocalizedName("derpIngot");
    }
}
