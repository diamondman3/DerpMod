package com.tildenprep.derpmod.block;

import java.util.Random;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneRepeater;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by kenny on 4/9/14.
 */
public class RepeaterBomb extends BlockRedstoneRepeater {

    public final String name = "materialRepeaterBomb";
    boolean exploded;
    //Todo: Bomb explodes when powered from any side.

    public RepeaterBomb ()
    {
    	super(false);
        setUnlocalizedName(DerpMod.MODID+"_"+name);
        setCreativeTab(DerpMod.tabDerpMod);
        setHardness(0F);
        exploded = false;
        setStepSound(Block.soundTypeStone);

    }

    public String getName(){
        return name;
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return super.getItemDropped(this.getDefaultState(), p_149650_2_, p_149650_3_);
    }

    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock){
        super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
        if(worldIn.isBlockIndirectlyGettingPowered(pos)>0){
            worldIn.setBlockState(pos, Blocks.air.getDefaultState());
            worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 6F, true);
        }
    }

    @Override
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
        worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 6F, true);
        worldIn.setBlockState(new BlockPos((int)Math.floor(this.getBlockBoundsMinX()), (int)Math.floor(this.getBlockBoundsMinY()), (int)Math.floor(this.getBlockBoundsMinZ())), Blocks.air.getDefaultState());
    }

    protected boolean canPowerSide(Block blockIn)
    {
        return isRedstoneRepeaterBlockID(blockIn);
    }

	/*@Override
	protected int func_149901_b(int var1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected BlockRedstoneDiode getBlockPowered() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected BlockRedstoneDiode getBlockUnpowered() {
		// TODO Auto-generated method stub
		return null;
	}*/
}


//    @Override
//    public void onBlockDestroyedByPlayer(){
//
//        super.onBlockDestroyedByPlayer(World world);
//    }



