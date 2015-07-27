package com.tildenprep.derpmod;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;

/**
 * Created by diamondman3 on 7/6/2015.
 */
public class BlockRegister {

    public void registerBlocks(Block block){
        GameRegistry.registerBlock(block, block.getUnlocalizedName());
    }
}
