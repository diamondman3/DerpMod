package com.tildenprep.derpmod.client.rawMaterials;

import com.tildenprep.derpmod.DerpMod;
import com.tildenprep.derpmod.client.GenericItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by kenny on 3/19/14.
 */
public class ItemDerpIngot extends GenericItem{

    private final String name = "ingotDerp";
    public ItemDerpIngot(){
        super();
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(64);
        setUnlocalizedName(DerpMod.MODID + "_" + name);
        GameRegistry.registerItem(this, name);
    }

    public String getName(){return name;}
}
