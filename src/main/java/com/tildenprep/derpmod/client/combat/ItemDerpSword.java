package com.tildenprep.derpmod.client.combat;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.item.ItemSword;

/**
 * Created by kenny on 3/26/14.
 */
public class ItemDerpSword extends ItemSword {

    public ItemDerpSword(ToolMaterial material){
        super(material);
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(1);
        setUnlocalizedName("derpSword");

    }

}
