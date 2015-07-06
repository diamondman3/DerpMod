package com.tildenprep.derpmod.entity;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;

import javax.swing.text.html.parser.*;

public class EntityRageGuy extends EntityMob{

    public EntityRageGuy(World par1World){
        super(par1World);
        this.setSize(0.6F, 1.8F);
        this.isImmuneToFire = false;
        Float var2 = 0.25F;


        //tasks
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.5, false));
        this.tasks.addTask(3, new EntityAIMoveTowardsTarget(this, 2.0, 16.0F));
        this.tasks.addTask(4, new EntityAIWander(this, var2));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityOcelot.class, true, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLolcat.class, true, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWolf.class, true, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityHorse.class, true, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true, true));
    }

    public boolean isAIEnabled(){
        return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(27.182818284590452353602874713526624977572470936999595749669676277240766303535475945713821785251664274274663919320030599218174135966290435729003342952605956307381323286279434907632338298807531952510190115738341879307021540891499348841675092447614606680822648001684774118537423454424371075390777449920695517027618386062D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3141592653589793238462643383279502884197169399375105820974944592307816406286);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
    }

    public void onLivingUpdate()
    {
        boolean canBlockSeeTheSky = false;
        float f = this.getBrightness(1.0F);

        for(int airCheckY = 256; airCheckY > MathHelper.ceiling_double_int(this.getPosition().getY()); airCheckY--) {
            if (this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.getPosition().getX()), airCheckY, MathHelper.floor_double(this.getPosition().getZ()))) != Blocks.air.getDefaultState()){
                canBlockSeeTheSky = false;
                airCheckY = MathHelper.ceiling_double_int(this.getPosition().getY());
            }
            else{canBlockSeeTheSky = true;}
        }


        if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && canBlockSeeTheSky);
        {
            ItemStack itemstack = this.getEquipmentInSlot(4);

            if (itemstack != null)
            {
                if (itemstack.isItemStackDamageable())
                {
                    itemstack.setItemDamage(itemstack.getItemDamage() + this.rand.nextInt(2));

                    if (itemstack.getItemDamage() >= itemstack.getMaxDamage())
                    {
                        this.renderBrokenItemStack(itemstack);
                        this.setCurrentItemOrArmor(4, null);
                    }
                }

            }
        }

        super.onLivingUpdate();
    }

    public void onKillEntity(EntityLivingBase p_70074_1_)
    {
        super.onKillEntity(p_70074_1_);

        this.worldObj.removeEntity(p_70074_1_);

        this.worldObj.playAuxSFXAtEntity(null, 1016, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 0);
        this.worldObj.playAuxSFXAtEntity(null, 1016, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 0);
    }
}





