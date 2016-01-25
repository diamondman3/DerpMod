package com.tildenprep.derpmod.client.tool;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by kenny on 4/9/14.
 */
public class ItemDerpHoe extends ItemHoe {

    private final String name = "hoeDerp";

    public ItemDerpHoe(Item.ToolMaterial material){
        super(material);
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(1);
        setUnlocalizedName(DerpMod.MODID + "_" + name);
        GameRegistry.registerItem(this, name);
    }

    public String getName(){
        return name;
    }
}
