package com.tildenprep.derpmod.block;

/**
 * Created by kenny on 3/12/14.
 */

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GenericBlock extends Block
{

    public GenericBlock (Material material)
    {
        super(material);

    }

    public String getName(){return DerpMod.MODID + "_" + this.getName();}
}