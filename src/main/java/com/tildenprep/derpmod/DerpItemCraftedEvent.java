package com.tildenprep.derpmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * Created by diamondman3 on 11/12/2014.
 */
public class DerpItemCraftedEvent extends net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent {

    public final ItemStack crafting;
    public final IInventory craftMatrix;

    public DerpItemCraftedEvent(EntityPlayer player, ItemStack crafting, IInventory craftMatrix) {
        super(player, crafting, craftMatrix);
        this.crafting = crafting;
        this.craftMatrix = craftMatrix;

        for (int i = 0; i < craftMatrix.getSizeInventory(); i++) {
            if (craftMatrix.getStackInSlot(i) != null) {
                ItemStack j = craftMatrix.getStackInSlot(i);
                if (j.getItem() == DerpMod.trollchemistsStone) {
                    ItemStack k = new ItemStack(DerpMod.trollchemistsStone, 2, j.getItemDamage() + 1);
                    craftMatrix.setInventorySlotContents(i, k);
                }
            }
        }
    }
}
