package com.tildenprep.derpmod.client.tool;

import com.tildenprep.derpmod.DerpMod;
import com.tildenprep.derpmod.client.GenericItem;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldSettings;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemTrollchemistsStone extends GenericItem{

    private final String name = "trollchemistsStone";

    public ItemTrollchemistsStone(){
        super();
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(1);
        setUnlocalizedName(DerpMod.MODID + "_" + name);
        setNoRepair();
        setMaxDamage(64);
        int dmg = this.getDamage(new ItemStack(this)) + 1;
        ItemStack stone = new ItemStack(this, dmg);
        Item stoneIndividual = stone.getItem();
        setContainerItem(stoneIndividual);
        GameRegistry.registerItem(this, name);
    }

    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
//if player is in creative mode
        itemStack.setItemDamage(itemStack.getItemDamage() + 1);
        return itemStack;
    }
}
