package com.tildenprep.derpmod.client.food;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

/**
 * Created by diamondman3 on 9/8/2014.
 */
public class ItemBurger extends ItemFood{

    public ItemBurger(){
        super(18, 24.8F, true);
        this.setCreativeTab(DerpMod.tabDerpMod);
        setUnlocalizedName("itemBurger");
    }
}
