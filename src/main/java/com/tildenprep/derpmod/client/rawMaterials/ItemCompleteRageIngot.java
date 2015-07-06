package com.tildenprep.derpmod.client.rawMaterials;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCompleteRageIngot extends Item{


    public ItemCompleteRageIngot(){
        super();
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(64);
        setUnlocalizedName("rageIngot");
    }
}

