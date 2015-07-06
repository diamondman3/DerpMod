package com.tildenprep.derpmod.client.rawMaterials;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTrollGem extends Item {

        public ItemTrollGem(){
            super();
            setCreativeTab(DerpMod.tabDerpMod);
            setMaxStackSize(63);
            setUnlocalizedName("trollGem");
        }
}
