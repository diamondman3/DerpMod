package com.tildenprep.derpmod.client.tool;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.item.ItemSpade;

/**
 * Created by kenny on 4/2/14.
 */
public class ItemDerpShovel extends ItemSpade {

    public ItemDerpShovel(ToolMaterial material){
        super(material);
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(1);
        setUnlocalizedName("derpShovel");

    }

}
