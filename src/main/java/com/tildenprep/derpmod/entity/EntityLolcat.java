package com.tildenprep.derpmod.entity;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by diamondman3 on 10/27/2014.
 */
public class EntityLolcat extends EntityOcelot{

    public EntityLolcat(World par1World){
        super(par1World);
        this.setSize(0.6F, 0.8F);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, this.aiSit);
        this.tasks.addTask(2, new EntityAIFollowOwner(this, 1.0D, 10.0F, 5.0F));
        this.tasks.addTask(3, new EntityAIOcelotSit(this, 1.33D));
        this.tasks.addTask(4, new EntityAIWander(this, 0.8D));
        this.tasks.addTask(5, new EntityAIOcelotAttack(new EntityChicken(this.getEntityWorld())));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
    }


    public boolean canDespawn() { return false; }
}
