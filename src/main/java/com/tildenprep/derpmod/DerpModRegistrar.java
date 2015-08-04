package com.tildenprep.derpmod;

import com.tildenprep.derpmod.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;

/**
 * Created by diamondman3 on 7/6/2015.
 */
public class DerpModRegistrar {

    public final static Block derpOre = new DerpOre(Material.gourd);
    public final static Block derpBlock = new DerpBlock(Material.gourd);
    public final static Block trollOre = new TrollOre(new Material(MapColor.ironColor));
    public final static Block trollBlock = new TrollBlock(new Material(MapColor.ironColor));
    public final static Block repeaterBomb = new RepeaterBomb();
    public final static Block rageOre = new RageOre(Material.rock);
    public final static Block rageBlock= new RageBlock(Material.rock);
    public final static Block reversePiston = new ReversePiston(false);
    public final static Block reverseStickyPiston = new ReversePiston(true);



    public void registerBlocks(){

        GameRegistry.registerBlock(derpOre, derpOre.getUnlocalizedName());
        GameRegistry.registerBlock(derpBlock, derpBlock.getUnlocalizedName());
        GameRegistry.registerBlock(trollOre, trollOre.getUnlocalizedName());
        GameRegistry.registerBlock(rageOre, rageOre.getUnlocalizedName());
        GameRegistry.registerBlock(trollBlock, trollBlock.getUnlocalizedName());
        GameRegistry.registerBlock(rageBlock, rageBlock.getUnlocalizedName());
        GameRegistry.registerBlock(repeaterBomb, repeaterBomb.getUnlocalizedName());
        GameRegistry.registerBlock(reversePiston, reversePiston.getUnlocalizedName());
        GameRegistry.registerBlock(reverseStickyPiston, reverseStickyPiston.getUnlocalizedName());
    }
}
