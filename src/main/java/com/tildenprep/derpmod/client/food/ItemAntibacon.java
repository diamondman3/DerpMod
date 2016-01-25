package com.tildenprep.derpmod.client.food;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by kenny on 5/7/14.
 */
public class ItemAntibacon extends ItemFood {

private final String name = "antibacon";

    public ItemAntibacon(){
        super(-8, -12.8F, true);
        this.setAlwaysEdible();
        setCreativeTab(DerpMod.tabDerpMod);
        setUnlocalizedName(DerpMod.MODID + "_" + name);
        GameRegistry.registerItem(this, name);
    }

    public String getName(){
        return name;
    }
}
