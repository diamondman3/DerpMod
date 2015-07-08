package com.tildenprep.derpmod.client.rawMaterials;

import com.tildenprep.derpmod.DerpMod;
import com.tildenprep.derpmod.client.GenericItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTrollGem extends GenericItem {

        public ItemTrollGem(){
            super();
            setCreativeTab(DerpMod.tabDerpMod);
            setMaxStackSize(63);
            setUnlocalizedName("trollGem");
        }
}
