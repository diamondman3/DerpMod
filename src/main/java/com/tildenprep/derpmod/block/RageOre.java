package com.tildenprep.derpmod.block;

import java.util.Random;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
public class RageOre extends Block{
	
    public RageOre (Material material)
    {
        super(material);
        setUnlocalizedName("rageOre");
        setCreativeTab(DerpMod.tabDerpMod);
        setHardness(3.5F);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 3);
	}

	public int idDropped(int par1, Random par2Random, int par3)
    {
        return 0;
    }

}
