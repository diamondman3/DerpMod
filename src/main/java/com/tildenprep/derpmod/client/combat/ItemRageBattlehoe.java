package com.tildenprep.derpmod.client.combat;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

/**
 * Created by diamondman3 on 11/28/2014.
 */
public class ItemRageBattlehoe extends ItemBattlehoe {

    Random dropChance = new Random();
    ItemStack droppedItem = new ItemStack(Blocks.dirt, 1);
    EntityItem entityDroppedItem = new EntityItem(null);
    World w = null;
    public final String name = "rageBattlehoe";

    public ItemRageBattlehoe(ToolMaterial material){
        super(material, "Hit a player to", "break their equipment! -dm3");
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(1);
        setUnlocalizedName(DerpMod.MODID + "_" + name);
        GameRegistry.registerItem(this, name);
    }

    public String getName(){
        return name;
    }

    //drop equip
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase player, EntityLivingBase target) {
        int doesMobDropLoot = dropChance.nextInt(2);
        ItemStack armor = new ItemStack(DerpMod.derpHelmet, 1, 548);
        //ItemStack damagedArmor = new ItemStack(DerpMod.derpHelmet, 1, 549);
        w = player.worldObj;
        if (!w.isRemote) {
            //considers armored mob player
            if(target instanceof EntityPlayer){
                armor = ((EntityPlayer) target).getCurrentArmor(0);
/*error here*/  armor.setItemDamage(armor.getItemDamage() + 20);
               // damagedArmor = armorToDamage;

                target.setCurrentItemOrArmor(0, armor);
            //damage shirt
            //etcetera
        }
        else if(target instanceof EntityZombie || target instanceof EntityPigZombie || target instanceof EntitySkeleton)
            if(doesMobDropLoot == 0){
                System.out.println("Zero");
                if(target.getEquipmentInSlot(1)!= null) {
                    droppedItem = target.getEquipmentInSlot(1);
                    System.out.println("droppedItem set");
                    entityDroppedItem = new EntityItem(w, target.posX, target.posY, target.posZ, droppedItem);
                    System.out.println("edi set");
                    w.spawnEntityInWorld(entityDroppedItem);
                    System.out.println("edi spawned");
                    target.setCurrentItemOrArmor(1, null);
                    System.out.println("Item removed");
                }
                //drop pants
                //etcetera
            }
            else{
                System.out.println("!Zero");
            }
        }
        return true;
    }
}
