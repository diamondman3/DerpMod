package com.tildenprep.derpmod.client.tool;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

/**
 * Created by kenny on 4/9/14.
 */
public class ItemDerpHoe extends ItemHoe {

    public ItemDerpHoe(Item.ToolMaterial material){
        super(material);
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(1);
        setUnlocalizedName("derpHoe");

    }
}
