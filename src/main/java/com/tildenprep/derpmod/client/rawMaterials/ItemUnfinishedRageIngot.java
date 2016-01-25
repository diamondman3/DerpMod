package com.tildenprep.derpmod.client.rawMaterials;

import com.tildenprep.derpmod.DerpMod;
import com.tildenprep.derpmod.client.GenericItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemUnfinishedRageIngot extends GenericItem{

    private String name = "uri";
	public int globStage;
    public String stageAsString = "0";

	public ItemUnfinishedRageIngot(int stage){
        super();
        this.globStage = stage;
        stageAsString = stage + "";
        setUnlocalizedName(DerpMod.MODID + "_" + name + stageAsString);
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(64);
        setMaxDamage(6);
        name = name + stageAsString;
        GameRegistry.registerItem(this, name);
	}
	public int getGlobStage(){
		return globStage;
	}

    public String getName(){
        return name;
    }
}
