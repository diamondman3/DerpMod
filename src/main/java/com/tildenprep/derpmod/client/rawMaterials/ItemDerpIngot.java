package com.tildenprep.derpmod.client.rawMaterials;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by kenny on 3/19/14.
 */
public class ItemDerpIngot extends Item {

    private final String name = "derpIngot";
    public ItemDerpIngot(){
        super();
        GameRegistry.registerItem(this, "derpIngot");
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(64);
        setUnlocalizedName("derpIngot");
    }

    public String getName(){
        return name;
    }
}
