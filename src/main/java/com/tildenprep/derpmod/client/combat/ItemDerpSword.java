package com.tildenprep.derpmod.client.combat;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemDerpSword extends ItemSword {

    public final String name = "swordDerp";

    public ItemDerpSword(ToolMaterial material){
        super(material);
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(1);
        setUnlocalizedName(DerpMod.MODID + "_" + name);
        GameRegistry.registerItem(this, name);
    }

    public String getName(){return name;}
}
