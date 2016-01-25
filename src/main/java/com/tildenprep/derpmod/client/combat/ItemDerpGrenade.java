package com.tildenprep.derpmod.client.combat;

import com.tildenprep.derpmod.DerpMod;
import com.tildenprep.derpmod.client.GenericItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.tildenprep.derpmod.entity.EntityDerpGrenade;

public class ItemDerpGrenade extends GenericItem {

    private final String name = "derpGrenade";

    public ItemDerpGrenade(){
        super();
        setCreativeTab(DerpMod.tabDerpMod);
        setUnlocalizedName(DerpMod.MODID + "_" + name);
        setMaxStackSize(8);
        GameRegistry.registerItem(this, name);
    }

    public String getName(){return name;}

    public ItemStack onItemRightClick(ItemStack stack, World w, EntityPlayer player)
    {
        if (!player.capabilities.isCreativeMode)
        {
            --stack.stackSize;
        }
        w.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if (!w.isRemote)
        {
            w.spawnEntityInWorld(new EntityDerpGrenade(w, player));
        }
        return stack;
    }

}
