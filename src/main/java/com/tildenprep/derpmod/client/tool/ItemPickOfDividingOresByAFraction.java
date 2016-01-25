package com.tildenprep.derpmod.client.tool;

import com.tildenprep.derpmod.DerpModRegistrar;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.tildenprep.derpmod.DerpMod;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemPickOfDividingOresByAFraction extends ItemPickaxe{
	
	ItemStack stack = new ItemStack(Blocks.stone);
    private final String name = "pickOfDividingOresByAFraction";
	
	public ItemPickOfDividingOresByAFraction(ToolMaterial material){
		super(material);
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(1);
        setUnlocalizedName(DerpMod.MODID + "_" + name);
        GameRegistry.registerItem(this, name);
	}

    public String getName(){
        return name;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
        return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
    }

    public boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase player)
    {
        BlockPos pos = new BlockPos(p_150894_4_ ,p_150894_5_, p_150894_6_);

    	if(!world.isRemote) {
    		if(block.equals(Blocks.diamond_ore)) {
    			stack = new ItemStack(Items.diamond, 7);
    			
    		}
    		else if(block.equals(Blocks.coal_ore)) {
    			stack = new ItemStack(Items.coal, 7);
    			
    		}
    		else if(block.equals(Blocks.quartz_ore)) {
    			stack = new ItemStack(Items.quartz, 7);
    			
    		}
    		else if(block.equals(Blocks.lit_redstone_ore) || block.equals(Blocks.redstone_ore)) {
    			stack = new ItemStack(Items.redstone, 14);
    		}
    		else if(block.equals(Blocks.lapis_ore)) {
    			stack = new ItemStack(Items.dye, 21, 4);

    		}
    		else if(block.equals(Blocks.emerald_ore)){
    			stack = new ItemStack(Items.emerald, 3);
    			
    		}
    		else if(block.equals(Blocks.iron_ore)){
    			stack = new ItemStack(Blocks.iron_ore, 7);
    			
    		}
    		else if(block.equals(Blocks.gold_ore)){
    			stack = new ItemStack(Blocks.gold_ore, 7);
    			
    		}
    		else if(block.equals(DerpModRegistrar.derpOre)){
    			stack = new ItemStack(DerpModRegistrar.derpOre, 7);
    			
    		}
    		else if(block.equals(DerpModRegistrar.trollOre)){
    			stack = new ItemStack(DerpModRegistrar.trollOre, 7);
    			
    		}
    		else if(block.equals(DerpModRegistrar.rageOre)){
    			stack = new ItemStack(DerpModRegistrar.rageOre, 3);
    		}
            else if(block.equals(Blocks.lit_furnace)){
                stack = new ItemStack(DerpMod.pickOfDividingOresByAFraction, 1, 0);
                
            }
    			player.entityDropItem(stack, 1);
    	}
    	
        if ((double)block.getBlockHardness(world, pos) != 0.0D)
        {
            stack.damageItem(1, player);
        }

        return true;
    }
}
