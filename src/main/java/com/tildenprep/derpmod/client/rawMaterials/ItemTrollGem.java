package com.tildenprep.derpmod.client.rawMaterials;

import com.tildenprep.derpmod.DerpMod;
import com.tildenprep.derpmod.client.GenericItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemTrollGem extends GenericItem {

    public final String name = "trollGem";

    public ItemTrollGem() {
        super();
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(63);
        setUnlocalizedName("trollGem");
        GameRegistry.registerItem(this, name);
    }

    public String getName(){return name;}
}
