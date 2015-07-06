package com.tildenprep.derpmod.client.tool;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;

/**
 * Created by kenny on 4/9/14.
 */
public class ItemDerpAxe extends ItemAxe {
	
    public ItemDerpAxe(Item.ToolMaterial material){
        super(material);
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(1);
        setUnlocalizedName("derpAxe");
    }
    
   /* public ItemStack onItemRightClick(ItemStack stack, World w, Entity entsAreUnfortuatelyNotInMinecraft, int par4, boolean par5){
    	
    	EntityPlayer player = (EntityPlayer)entsAreUnfortuatelyNotInMinecraft;
    	w = player.worldObj;
    	w.spawnEntityInWorld(pig, player.get);
    	
        return stack;
    }*/
}
