package com.tildenprep.derpmod.block;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.Random;

/**
 * Created by kenny on 3/19/14.
 */
public class DerpOre extends Block {

    public DerpOre (Material material)
    {
        super(material);
        setUnlocalizedName("derpmod:derpOre");
        setCreativeTab(DerpMod.tabDerpMod);
        setHardness(2.0F);
        setStepSound(Block.soundTypeWood);
        setHarvestLevel("pickaxe", 2);
    }
}
