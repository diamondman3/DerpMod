package com.tildenprep.derpmod.block;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.Random;

public class TrollBlock extends Block {

    public TrollBlock (Material material)
    {
        super(material);
        setUnlocalizedName("trollBlock");
        setCreativeTab(DerpMod.tabDerpMod);
        setHardness(2.0F);
        setHarvestLevel("shears", 0);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return 0;
    }

}
