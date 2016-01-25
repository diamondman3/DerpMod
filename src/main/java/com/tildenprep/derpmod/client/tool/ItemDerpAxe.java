package com.tildenprep.derpmod.client.tool;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by kenny on 4/9/14.
 */
public class ItemDerpAxe extends ItemAxe {

    private final String name = "axeDerp";
	
    public ItemDerpAxe(Item.ToolMaterial material){
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
