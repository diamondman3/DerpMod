package com.tildenprep.derpmod;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;

/**
 * Created by diamondman3 on 7/6/2015.
 */
public class BlockRegister {

    public void registerBlocks(){

        GameRegistry.registerBlock(derpOre, derpOre.getUnlocalizedName());
        GameRegistry.registerBlock(trollOre, trollOre.getUnlocalizedName());
        GameRegistry.registerBlock(rageOre, rageOre.getUnlocalizedName());
        GameRegistry.registerBlock(derpBlock, derpBlock.getUnlocalizedName());
        GameRegistry.registerBlock(trollBlock, trollBlock.getUnlocalizedName());
        GameRegistry.registerBlock(rageBlock, rageBlock.getUnlocalizedName());
        GameRegistry.registerBlock(repeaterBomb, repeaterBomb.getUnlocalizedName());
    }
}
