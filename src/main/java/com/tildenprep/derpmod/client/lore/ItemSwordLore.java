package com.tildenprep.derpmod.client.lore;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import java.util.List;
/**
 * Created by diamondman3 on 11/8/2014.
 */

public class ItemSwordLore extends ItemSword {

    //text in the lore
    String loreTextLn1;
    String loreTextLn2;

    public ItemSwordLore(ToolMaterial material, int par1, String loreTextLn1, String loreTextLn2){
        super(material);
        this.loreTextLn1 = loreTextLn1;
        this.loreTextLn2 = loreTextLn2;
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4){
        par3List.add(loreTextLn1);
        par3List.add(loreTextLn2);
    }
}
