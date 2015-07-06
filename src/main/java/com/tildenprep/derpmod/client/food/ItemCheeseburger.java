package com.tildenprep.derpmod.client.food;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

/**
 * Created by diamondman3 on 9/21/2014.
 */
public class ItemCheeseburger extends ItemFood {
    public ItemCheeseburger(){
        super(20, 32F, true);
        this.setCreativeTab(DerpMod.tabDerpMod);
        this.setUnlocalizedName("itemCheeseburger");
    }
}
