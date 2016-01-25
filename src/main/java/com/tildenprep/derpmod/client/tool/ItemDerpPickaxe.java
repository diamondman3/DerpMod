package com.tildenprep.derpmod.client.tool;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by kenny on 4/2/14.
 */
public class ItemDerpPickaxe extends ItemPickaxe {

    private final String name  = "pickaxeDerp";

    public ItemDerpPickaxe(Item.ToolMaterial material){
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
