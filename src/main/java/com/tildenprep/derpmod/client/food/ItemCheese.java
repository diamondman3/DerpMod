package com.tildenprep.derpmod.client.food;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

/**
 * Created by diamondman3 on 9/7/2014.
 */
public class ItemCheese extends ItemFood {

    private final String name = "cheese";

    public ItemCheese(){
        super(5, 6.0F, false);
        this.setCreativeTab(DerpMod.tabDerpMod);
        setUnlocalizedName(DerpMod.MODID + "_" + name);
    }

    public String getName(){return name;}

}
