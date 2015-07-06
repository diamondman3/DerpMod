package com.tildenprep.derpmod.entity;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.tildenprep.derpmod.world.NondamagingExplosion;

public class ScrollSpellEntity extends EntityThrowable{

	boolean hasSpawned = false;

	public ScrollSpellEntity(World world){

		super(world);
	}

	public ScrollSpellEntity(World world, EntityLivingBase par2EntityLivingBase)
	{
		super(world, par2EntityLivingBase);
	}

	public ScrollSpellEntity(World world, double par2, double par4, double par6)
	{
		super(world, par2, par4, par6);
	}



	@Override
	protected void onImpact(MovingObjectPosition movingObjPos) 
	{
		if(!this.worldObj.isRemote){
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 10f, true);
			this.kill();
		}
	}
}
