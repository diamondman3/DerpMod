package com.tildenprep.derpmod.block;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.lang.ref.Reference;
import java.util.Random;

/**
 * Created by kenny on 3/19/14.
 */
public class DerpBlock extends Block{

    public final String name = "blockDerp";

    public DerpBlock (Material material)
    {
        super(Material.rock);
        setUnlocalizedName(DerpMod.MODID+"_"+name);
        setCreativeTab(DerpMod.tabDerpMod);
        setHardness(2.0F);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 2);
        GameRegistry.registerBlock(this, name);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return 0;
    }

    public String getName()
    {
        return name;
    }
}
