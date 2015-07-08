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
    public ItemDerpIngot(){
        super();
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(64);
        setUnlocalizedName("derpIngot");
        GameRegistry.registerItem(this, this.getName());
    }
}
