package com.tildenprep.derpmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.BlockPistonMoving;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3i;
import net.minecraft.world.World;

/**
 * Created by student on 7/8/2015.
 */
public class ReversePiston extends BlockPistonBase{

    boolean isSticky = false;
    public ReversePiston(boolean isSticky){super(isSticky);}

    public boolean shouldBeExtended(World worldIn, BlockPos pos, EnumFacing facing){
        return super(worldIn, pos, facing);
    }

    private boolean doMove(World worldIn, BlockPos pos, EnumFacing direction, boolean extending) {
        direction = direction.getOpposite();
        return super(worldIn, pos, direction, extending);
    }

    public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam){
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

        if (!worldIn.isRemote)
        {
            boolean flag = this.shouldBeExtended(worldIn, pos, enumfacing);

            if (flag && eventID == 1)
            {
                worldIn.setBlockState(pos, state.withProperty(EXTENDED, Boolean.valueOf(true)), 2);
                return false;
            }

            if (!flag && eventID == 0)
            {
                return false;
            }
        }

        if (eventID == 0)
        {
            if (!this.doMove(worldIn, pos, enumfacing, true))
            {
                return false;
            }

            worldIn.setBlockState(pos, state.withProperty(EXTENDED, Boolean.valueOf(true)), 2);
            worldIn.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "tile.piston.out", 0.5F, worldIn.rand.nextFloat() * 0.25F + 0.6F);
        }
        else if (eventID == 1)
        {
            TileEntity tileentity1 = worldIn.getTileEntity(pos.offset(enumfacing));

            if (tileentity1 instanceof TileEntityPiston)
            {
                ((TileEntityPiston)tileentity1).clearPistonTileEntity();
            }

            worldIn.setBlockState(pos, Blocks.piston_extension.getDefaultState().withProperty(BlockPistonMoving.FACING, enumfacing).withProperty(BlockPistonMoving.TYPE, this.isSticky ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT), 3);
            worldIn.setTileEntity(pos, BlockPistonMoving.newTileEntity(this.getStateFromMeta(eventParam), enumfacing, false, true));

            if (this.isSticky)
            {
                BlockPos blockpos1 = pos.add(enumfacing.getFrontOffsetX() * 2, enumfacing.getFrontOffsetY() * 2, enumfacing.getFrontOffsetZ() * 2);
                Block block = worldIn.getBlockState(blockpos1).getBlock();
                boolean flag1 = false;

                if (block == Blocks.piston_extension)
                {
                    TileEntity tileentity = worldIn.getTileEntity(blockpos1);

                    if (tileentity instanceof TileEntityPiston)
                    {
                        TileEntityPiston tileentitypiston = (TileEntityPiston)tileentity;

                        if (tileentitypiston.getFacing() == enumfacing && tileentitypiston.isExtending())
                        {
                            tileentitypiston.clearPistonTileEntity();
                            flag1 = true;
                        }
                    }
                }

                if (!flag1 && !block.isAir(worldIn, blockpos1) && canPush(block, worldIn, blockpos1, enumfacing.getOpposite(), false) && (block.getMobilityFlag() == 0 || block == Blocks.piston || block == Blocks.sticky_piston))
                {
                    this.doMove(worldIn, pos, enumfacing, false);
                }
            }
            else
            {
                worldIn.setBlockToAir(pos.offset(enumfacing));
            }

            worldIn.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "tile.piston.in", 0.5F, worldIn.rand.nextFloat() * 0.15F + 0.6F);
        }

        return true;
    }
}
