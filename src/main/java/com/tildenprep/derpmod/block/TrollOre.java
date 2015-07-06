package com.tildenprep.derpmod.block;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.Random;

/**
 * Created by kenny on 4/23/14.
 */
public class TrollOre extends Block {

    public TrollOre (Material material)
    {
        super(material);
        setUnlocalizedName("trollOre");
        setCreativeTab(DerpMod.tabDerpMod);
        setHardness(2.0F);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("axe", 2);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return 0;
    }

}
