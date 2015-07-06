package com.tildenprep.derpmod.entity;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.tildenprep.derpmod.world.NondamagingExplosion;

public class EntityDerpGrenade extends EntityThrowable{

	boolean hasSpawned = false;

	public EntityDerpGrenade(World world){

		super(world);
	}

	public EntityDerpGrenade(World world, EntityLivingBase par2EntityLivingBase)
	{
		super(world, par2EntityLivingBase);
	}

	public EntityDerpGrenade(World world, double par2, double par4, double par6)
	{
		super(world, par2, par4, par6);
	}



	@Override
	protected void onImpact(MovingObjectPosition movingObjPos) 
	{
		if(!this.worldObj.isRemote){
		NondamagingExplosion ndx = new NondamagingExplosion(this.worldObj, this, this.posX, this.posY, this.posZ, 3F);

        //isSmoking means "will it damage blocks" for some reason.
        ndx.doExplosionA();
        ndx.doExplosionB(true);

		Random rand = new Random();
		int randInt = rand.nextInt(4);
		

		if (randInt == 0 && !hasSpawned){
        	EntityPig pig = new EntityPig(worldObj);
        	pig.setPosition(this.posX, this.posY, this.posZ);
        	hasSpawned = true;
        	this.worldObj.spawnEntityInWorld(pig);
        }
        else if (randInt == 1 && !hasSpawned){
        	EntityVillager villager = new EntityVillager(worldObj);
        	villager.setPosition(this.posX, this.posY, this.posZ);
        	hasSpawned = true;
        	this.worldObj.spawnEntityInWorld(villager);
        }
        else if (randInt == 2 && !hasSpawned){
        	EntitySheep sheep = new EntitySheep(worldObj);
        	sheep.setPosition(this.posX, this.posY, this.posZ);
        	hasSpawned = true;
        	this.worldObj.spawnEntityInWorld(sheep);
        }
        else if (randInt == 3 && !hasSpawned){
        	EntitySquid squid = new EntitySquid(worldObj);
        	squid.setPosition(this.posX, this.posY, this.posZ);
        	hasSpawned = true;
        	this.worldObj.spawnEntityInWorld(squid);
        }

		}
	}

}
