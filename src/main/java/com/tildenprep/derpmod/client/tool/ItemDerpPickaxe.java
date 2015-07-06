package com.tildenprep.derpmod.client.tool;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

/**
 * Created by kenny on 4/2/14.
 */
public class ItemDerpPickaxe extends ItemPickaxe {


    public ItemDerpPickaxe(Item.ToolMaterial material){
        super(material);
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(1);
        setUnlocalizedName("derpPickaxe");

    }

}
