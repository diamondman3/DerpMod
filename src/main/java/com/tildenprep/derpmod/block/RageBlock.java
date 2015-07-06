package com.tildenprep.derpmod.block;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class RageBlock extends Block{
	
	public RageBlock(Material material){
		super(Material.rock);
		setUnlocalizedName("rageBlock");
        setCreativeTab(DerpMod.tabDerpMod);
        setHardness(3.5F);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 3);
	}

}
