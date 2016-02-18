package com.tildenprep.derpmod;

import com.tildenprep.derpmod.block.*;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by diamondman3 on 7/6/2015.
 */
public class DerpModRegistrar {

    public final static DerpOre derpOre = new DerpOre(Material.gourd);
    public final static DerpBlock derpBlock = new DerpBlock(Material.gourd);
    public final static TrollOre trollOre = new TrollOre(new Material(MapColor.ironColor));
    public final static TrollBlock trollBlock = new TrollBlock(new Material(MapColor.ironColor));
    public final static RepeaterBomb repeaterBomb = new RepeaterBomb();
    public final static RageOre rageOre = new RageOre(Material.rock);
    public final static RageBlock rageBlock= new RageBlock(Material.rock);
    public final static ReversePiston reversePiston = new ReversePiston(false);
    public final static ReversePiston reverseStickyPiston = new ReversePiston(true);

   // public final static ItemDerpIngot derpIngot = new ItemDerpIngot();

    public void addNames(){

    }

    public void registerBlocks(){

        GameRegistry.registerBlock(derpOre, derpOre.getUnlocalizedName());

        GameRegistry.registerBlock(trollOre, trollOre.getUnlocalizedName());
        GameRegistry.registerBlock(rageOre, rageOre.getUnlocalizedName());

        GameRegistry.registerBlock(trollBlock, trollBlock.getUnlocalizedName());
        GameRegistry.registerBlock(rageBlock, rageBlock.getUnlocalizedName());

        GameRegistry.registerBlock(repeaterBomb, repeaterBomb.getUnlocalizedName());
        GameRegistry.registerBlock(reversePiston, reversePiston.getUnlocalizedName());
        GameRegistry.registerBlock(reverseStickyPiston, reverseStickyPiston.getUnlocalizedName());
    }

 /*   public void registerItems(char itemSet){
        switch(itemSet){
            case 'd':
                GameRegistry.registerItem(derpIngot, derpIngot.getName());
            default:
                System.out.println("No valid items in set.");
                break;
        }
    }*/

    public void registerOresBlock(){
        OreDictionary.registerOre(derpOre.getName(), derpOre);
        OreDictionary.registerOre(derpBlock.getName(), derpBlock);
        OreDictionary.registerOre(trollOre.getName(), trollOre);
        OreDictionary.registerOre(trollBlock.getName(), trollBlock);
        OreDictionary.registerOre(rageOre.getName(), rageOre);
        OreDictionary.registerOre(rageBlock.getName(), rageBlock);
        OreDictionary.registerOre(repeaterBomb.getName(), repeaterBomb);
        OreDictionary.registerOre(reversePiston.getName(), reversePiston);
        OreDictionary.registerOre(reverseStickyPiston.getName(), reverseStickyPiston);
    }

    public void registerOresItem(){
        OreDictionary.registerOre(DerpMod.completeRageIngot.getName(), DerpMod.completeRageIngot);
        OreDictionary.registerOre(DerpMod.derpIngot.getName(), DerpMod.derpIngot);
        OreDictionary.registerOre(DerpMod.trollGem.getName(), DerpMod.trollGem);
        OreDictionary.registerOre(DerpMod.uri0.getName(), DerpMod.uri0);
        OreDictionary.registerOre(DerpMod.uri1.getName(), DerpMod.uri1);
        OreDictionary.registerOre(DerpMod.uri2.getName(), DerpMod.uri2);
        OreDictionary.registerOre(DerpMod.uri3.getName(), DerpMod.uri3);
        OreDictionary.registerOre(DerpMod.uri4.getName(), DerpMod.uri4);
        OreDictionary.registerOre(DerpMod.uri5.getName(), DerpMod.uri5);
        OreDictionary.registerOre(DerpMod.uri6.getName(), DerpMod.uri6);

        OreDictionary.registerOre(DerpMod.derpAxe.getName(), DerpMod.derpAxe);
        OreDictionary.registerOre(DerpMod.derpGrenade.getName(), DerpMod.derpGrenade);
        OreDictionary.registerOre(DerpMod.derpHoe.getName(), DerpMod.derpHoe);
        OreDictionary.registerOre(DerpMod.derpPickaxe.getName(), DerpMod.derpPickaxe);
        OreDictionary.registerOre(DerpMod.derpShovel.getName(), DerpMod.derpShovel);
        OreDictionary.registerOre(DerpMod.derpSword.getName(), DerpMod.derpSword);
        OreDictionary.registerOre(DerpMod.explosionScroll.getName(), DerpMod.explosionScroll);
        OreDictionary.registerOre(DerpMod.itemSwordOfGoodbye.getName(), DerpMod.itemSwordOfGoodbye);
        OreDictionary.registerOre(DerpMod.pickOfDividingOresByAFraction.getName(), DerpMod.pickOfDividingOresByAFraction);
        OreDictionary.registerOre(DerpMod.trollsDagger.getName(), DerpMod.trollsDagger);
        OreDictionary.registerOre(DerpMod.trollchemistsStone.getName(), DerpMod.trollchemistsStone);

        OreDictionary.registerOre(DerpMod.itemAntibacon.getName(), DerpMod.itemAntibacon);
        OreDictionary.registerOre(DerpMod.itemBurger.getName(), DerpMod.itemBurger);
        OreDictionary.registerOre(DerpMod.itemCheese.getName(), DerpMod.itemCheese);
        OreDictionary.registerOre(DerpMod.itemCheeseburger.getName(), DerpMod.itemCheeseburger);
        OreDictionary.registerOre(DerpMod.itemTrolldenApple.getName(), DerpMod.itemTrolldenApple);

        OreDictionary.registerOre(DerpMod.derpHelmet.getName(), DerpMod.derpHelmet);
        OreDictionary.registerOre(DerpMod.derpShirt.getName(), DerpMod.derpShirt);
        OreDictionary.registerOre(DerpMod.derpPants.getName(), DerpMod.derpPants);
        OreDictionary.registerOre(DerpMod.derpBoots.getName(), DerpMod.derpBoots);
    }

}
