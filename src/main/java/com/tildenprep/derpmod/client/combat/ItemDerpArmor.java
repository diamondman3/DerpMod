package com.tildenprep.derpmod.client.combat;

import com.tildenprep.derpmod.DerpMod;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemDerpArmor extends ItemArmor{
	
	public ItemDerpArmor(ArmorMaterial material, int x, int y){
		super(material, x, y);
        setCreativeTab(DerpMod.tabDerpMod);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		if(slot == 0 || slot == 1 || slot == 3){
			return DerpMod.MODID + ":textures/models/armor/derpArmorLayer1.png";
		}
		else if(slot == 2){
			return DerpMod.MODID + ":textures/models/armor/derpArmorLayer2.png";
		}
		else{
			return null;
		}
	}

}
