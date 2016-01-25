package com.tildenprep.derpmod.client.combat;
import com.tildenprep.derpmod.DerpMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ItemTrollsDagger extends ItemSword{

    private final String name = "trollsDagger";
	
	public ItemTrollsDagger(ToolMaterial material){
		super(material);
        setCreativeTab(DerpMod.tabDerpMod);
        setMaxStackSize(1);
        setUnlocalizedName(DerpMod.MODID + "_" + name);
        GameRegistry.registerItem(this, name);
	}

    public String getName(){return name;}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(1, attacker);
        target.addPotionEffect(new PotionEffect(Potion.poison.id, 12000, 10));
        target.addPotionEffect(new PotionEffect(Potion.regeneration.id, 12000, 10));
        return true;
    }

}
