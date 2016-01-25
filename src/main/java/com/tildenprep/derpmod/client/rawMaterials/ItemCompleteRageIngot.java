package com.tildenprep.derpmod.client.rawMaterials;

import com.tildenprep.derpmod.DerpMod;
import com.tildenprep.derpmod.client.GenericItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemCompleteRageIngot extends GenericItem{

    private final String name = "completeRageIngot";

    public ItemCompleteRageIngot(){
        super();
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(64);
        setUnlocalizedName(DerpMod.MODID + "_" + name);
        GameRegistry.registerItem(this, name);
    }

    public String getName(){
        return name;
    }
}

