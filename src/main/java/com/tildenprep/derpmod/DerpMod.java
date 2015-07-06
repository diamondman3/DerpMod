package com.tildenprep.derpmod;

import com.tildenprep.derpmod.block.*;
import com.tildenprep.derpmod.client.*;
import com.tildenprep.derpmod.client.combat.*;
import com.tildenprep.derpmod.client.food.*;
import com.tildenprep.derpmod.client.rawMaterials.ItemCompleteRageIngot;
import com.tildenprep.derpmod.client.rawMaterials.ItemDerpIngot;
import com.tildenprep.derpmod.client.rawMaterials.ItemTrollGem;
import com.tildenprep.derpmod.client.rawMaterials.ItemUnfinishedRageIngot;
import com.tildenprep.derpmod.client.tool.*;
import com.tildenprep.derpmod.client.tool.ItemPickOfDividingOresByAFraction;
import com.tildenprep.derpmod.entity.EntityLolcat;
import com.tildenprep.derpmod.entity.EntityRageGuy;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.EnumHelper;

import com.tildenprep.derpmod.entity.EntityDerpGrenade;
import com.tildenprep.derpmod.entity.EntityManager;
import com.tildenprep.derpmod.world.DerpWorld;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = DerpMod.MODID, version = DerpMod.VERSION)
public class DerpMod

    //TODO: LOOK UP CONFIG/ATTRIBUTE FILES FOR TEXTURES!!!
    //TODO: Rage ItemBattlehoe
    //TODO: Update texture settings
{
	public static final String MODID = "DerpMod";
	public static final String VERSION = "0.0.4";

    public final static CreativeTabs tabDerpMod = new CreativeTabs("derpMod") {

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return DerpMod.derpIngot;
        }
    };

	public final static Block derpOre = new DerpOre(Material.gourd);
	public final static Block derpBlock = new DerpBlock(Material.gourd);
	public final static Block trollOre = new TrollOre(new Material(MapColor.ironColor));
	public final static Block trollBlock = new TrollBlock(new Material(MapColor.ironColor));
	public final static Block repeaterBomb = new RepeaterBomb();
	public final static Block rageOre = new RageOre(Material.rock);
	public final static Block rageBlock= new RageBlock(Material.rock);

	public static Item derpIngot;
	public static Item derpSword;
	public static Item derpShovel;
	public static Item derpPickaxe;
	public static Item derpAxe;
	public static Item derpHoe;
	public static Item derpGrenade;
	public static Item derpHelmet;
	public static Item derpShirt;
	public static Item derpPants;
	public static Item derpBoots;

	public static Item trollGem;
	public static Item trollsDagger;
	public static Item oreFracDivPick;
	public static Item explosionScroll;

    public static Item trollchemistsStone;

	public static ItemUnfinishedRageIngot itemUnfinishedRageIngot;
	public static ItemCompleteRageIngot cri;
	public static Item rickRollDisc;

    public static ItemSwordOfGoodbye itemSwordOfGoodbye;
    public static ItemRageBattlehoe rageBattlehoe;
	
	public static ItemAntibacon itemAntibacon;
    public static ItemBurger itemBurger;
    public static ItemCheese itemCheese;
    public static ItemCheeseburger itemCheeseburger;
    public static ItemTrolldenApple itemTrolldenApple;

	@Mod.Instance(value = "DerpMod")
	public static DerpMod instance;

	@SidedProxy(clientSide ="com.tildenprep.derpmod.client.ClientProxy", serverSide = "com.tildenprep.derpmod.CommonProxy")
	public static ClientProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		EntityManager.mainRegistry();

        itemBurger = new ItemBurger();
        itemCheese = new ItemCheese();
        itemCheeseburger = new ItemCheeseburger();
        GameRegistry.registerItem(itemBurger, itemBurger.getUnlocalizedName());
        GameRegistry.registerItem(itemCheese, itemCheese.getUnlocalizedName());
        GameRegistry.registerItem(itemCheeseburger, itemCheeseburger.getUnlocalizedName());
        GameRegistry.addShapedRecipe(new ItemStack(itemBurger, 1), "b  ", "s  ", "b  ", 'b', Items.bread, 's', Items.cooked_beef);
        GameRegistry.addShapedRecipe(new ItemStack(itemBurger, 1), " b ", " s ", " b ", 'b', Items.bread, 's', Items.cooked_beef);
        GameRegistry.addShapedRecipe(new ItemStack(itemBurger, 1), "  b", "  s", "  b", 'b', Items.bread, 's', Items.cooked_beef);
        GameRegistry.addShapelessRecipe(new ItemStack(itemCheese, 1), new ItemStack(Items.milk_bucket), new ItemStack(Items.sugar));
        GameRegistry.addShapelessRecipe(new ItemStack(itemCheeseburger, 1), new ItemStack(itemBurger, 1), new ItemStack(itemCheese, 1));

		GameRegistry.registerBlock(derpOre, derpOre.getUnlocalizedName());
		GameRegistry.registerBlock(trollOre, trollOre.getUnlocalizedName());
		GameRegistry.registerBlock(rageOre, rageOre.getUnlocalizedName());

        derpIngot = new ItemDerpIngot();
		ItemStack dIS = new ItemStack(derpIngot, 1);
		GameRegistry.addSmelting(derpOre, dIS, 1F);
		GameRegistry.registerItem(derpIngot, derpIngot.getUnlocalizedName());
		Item.ToolMaterial derpM = new EnumHelper().addToolMaterial("Derp", 5, 251, 100F, 2F, 30);
		final ArmorMaterial derpArmorMat = new EnumHelper().addArmorMaterial("derp", "textures/models/armor/derpArmorLayer1", 259, new int[]{2, 6, 5, 2}, 15);

		GameRegistry.registerBlock(derpBlock, derpBlock.getUnlocalizedName());
		GameRegistry.addShapedRecipe(new ItemStack(derpBlock, 1), "ddd", "ddd", "ddd", 'd', dIS);
		GameRegistry.addShapelessRecipe(new ItemStack(derpIngot, 9), new ItemStack(derpBlock));

		derpSword = new ItemDerpSword(derpM);
		GameRegistry.registerItem(derpSword, derpSword.getUnlocalizedName());
		GameRegistry.addShapedRecipe(new ItemStack(derpSword, 1), "d  ", "d  ", "s  ", 'd', dIS, 's', new ItemStack(Items.stick));
		GameRegistry.addShapedRecipe(new ItemStack(derpSword, 1), " d ", " d ", " s ", 'd', dIS, 's', new ItemStack(Items.stick));
		GameRegistry.addShapedRecipe(new ItemStack(derpSword, 1), "  d", "  d", "  s", 'd', dIS, 's', new ItemStack(Items.stick));

		derpShovel = new ItemDerpShovel(derpM);
		GameRegistry.registerItem(derpShovel, derpShovel.getUnlocalizedName());
		GameRegistry.addShapedRecipe(new ItemStack(derpShovel, 1), "d  ", "s  ", "s  ", 'd', dIS, 's', new ItemStack(Items.stick));
		GameRegistry.addShapedRecipe(new ItemStack(derpShovel, 1), " d ", " s ", " s ", 'd', dIS, 's', new ItemStack(Items.stick));
		GameRegistry.addShapedRecipe(new ItemStack(derpShovel, 1), "  d", "  s", "  s", 'd', dIS, 's', new ItemStack(Items.stick));

		derpPickaxe = new ItemDerpPickaxe(derpM);
		GameRegistry.registerItem(derpPickaxe, derpPickaxe.getUnlocalizedName());
		GameRegistry.addShapedRecipe(new ItemStack(derpPickaxe, 1), "ddd", " s ", " s ", 'd', dIS, 's', new ItemStack(Items.stick));


		derpAxe = new ItemDerpAxe(derpM);
		GameRegistry.registerItem(derpAxe, derpAxe.getUnlocalizedName());
		GameRegistry.addShapedRecipe(new ItemStack(derpAxe, 1), "dd ", "ds ", " s ", 'd', dIS, 's', new ItemStack(Items.stick));
		GameRegistry.addShapedRecipe(new ItemStack(derpAxe, 1), " dd", " sd", " s ", 'd', dIS, 's', new ItemStack(Items.stick));

		derpHoe = new ItemDerpHoe(derpM);
		GameRegistry.registerItem(derpHoe, derpHoe.getUnlocalizedName());
		GameRegistry.addShapedRecipe(new ItemStack(derpHoe, 1), "dd ", " s ", " s ", 'd', dIS, 's', new ItemStack(Items.stick));
		GameRegistry.addShapedRecipe(new ItemStack(derpHoe, 1), " dd", " s ", " s ", 'd', dIS, 's', new ItemStack(Items.stick));

		derpHelmet = new ItemDerpArmor(derpArmorMat, this.proxy.addArmor("DerpHelmet"), 0);
			derpHelmet.setUnlocalizedName("derpHelmet");
			derpHelmet.setCreativeTab(DerpMod.tabDerpMod);
			GameRegistry.addShapedRecipe(new ItemStack(derpHelmet, 1), "ddd", "d d", "   ", 'd', dIS);
			GameRegistry.addShapedRecipe(new ItemStack(derpHelmet, 1), "   ", "ddd", "d d", 'd', dIS);
			GameRegistry.registerItem(derpHelmet,  derpHelmet.getUnlocalizedName());
		derpShirt = new ItemDerpArmor(derpArmorMat, this.proxy.addArmor("DerpShirt"), 1);
			derpShirt.setUnlocalizedName("derpShirt");
			derpShirt.setCreativeTab(DerpMod.tabDerpMod);
			GameRegistry.addShapedRecipe(new ItemStack(derpShirt, 1), "d d", "ddd", "ddd", 'd', dIS);
			GameRegistry.registerItem(derpShirt,  derpShirt.getUnlocalizedName());
		derpPants = new ItemDerpArmor(derpArmorMat, this.proxy.addArmor("DerpPants"), 2);
			derpPants.setUnlocalizedName("derpPants");
			derpPants.setCreativeTab(DerpMod.tabDerpMod);
			GameRegistry.addShapedRecipe(new ItemStack(derpPants, 1), "ddd", "d d", "d d", 'd', dIS);
			GameRegistry.registerItem(derpPants,  derpPants.getUnlocalizedName());
		derpBoots = new ItemDerpArmor(derpArmorMat, this.proxy.addArmor("DerpBoots"), 3);
			derpBoots.setUnlocalizedName("derpBoots");
			derpBoots.setCreativeTab(DerpMod.tabDerpMod);
			GameRegistry.addShapedRecipe(new ItemStack(derpBoots, 1), "d d", "d d", "   ", 'd', dIS);
			GameRegistry.addShapedRecipe(new ItemStack(derpBoots, 1), "   ", "d d", "d d", 'd', dIS);
			GameRegistry.registerItem(derpBoots,  derpBoots.getUnlocalizedName());
		
		derpGrenade = new ItemDerpGrenade();
		GameRegistry.registerItem(derpGrenade, derpGrenade.getUnlocalizedName());
		GameRegistry.addShapedRecipe(new ItemStack(derpGrenade, 4), " d ", "dtd", " d ", 'd', dIS, 't', new ItemStack(Blocks.tnt));

		trollGem = new ItemTrollGem();
		ItemStack tGS = new ItemStack(trollGem);
		GameRegistry.registerItem(trollGem, trollGem.getUnlocalizedName());
		GameRegistry.addShapedRecipe(new ItemStack(trollGem, 8), "ooo", "oco", "ooo", 'o', new ItemStack(trollOre), 'c', new ItemStack(Items.coal));
		Item.ToolMaterial trollM = new EnumHelper().addToolMaterial("Troll", 5, 1337, 100F, 1F, 30);

		GameRegistry.registerBlock(trollBlock, trollBlock.getUnlocalizedName());
		GameRegistry.addShapedRecipe(new ItemStack(trollBlock, 1), "ttt", "ttt", "ttt", 't', new ItemStack(trollGem));
		GameRegistry.addShapelessRecipe(new ItemStack(trollGem, 9), new ItemStack(trollBlock, 1));

        trollchemistsStone = new ItemTrollchemistsStone();
        GameRegistry.registerItem(trollchemistsStone, trollchemistsStone.getUnlocalizedName());

        GameRegistry.addShapelessRecipe(new ItemStack(Items.emerald, 2), new ItemStack(Blocks.redstone_block, 1), new ItemStack(Blocks.redstone_block, 1), new ItemStack(trollchemistsStone, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.redstone_block, 2), new ItemStack(Items.emerald, 1), new ItemStack(Items.emerald, 1), new ItemStack(trollchemistsStone, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.clock, 3), new ItemStack(Items.emerald, 1), new ItemStack(trollchemistsStone, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.emerald, 1), new ItemStack(Items.clock, 1) ,new ItemStack(Items.clock, 1), new ItemStack(Items.clock, 1), new ItemStack(trollchemistsStone, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapedRecipe(new ItemStack(Items.cooked_porkchop, 8), "aaa", "asa", "aaa", 's', new ItemStack(trollchemistsStone, 1, OreDictionary.WILDCARD_VALUE), 'a', new ItemStack(DerpMod.itemAntibacon));
        //Potion is 3 min. waterbreathing
        GameRegistry.addShapelessRecipe(new ItemStack(Items.potionitem, 1, 8205), new ItemStack(Blocks.grass, 1), new ItemStack(Blocks.grass, 1), new ItemStack(Blocks.grass, 1), new ItemStack(Items.glass_bottle, 1), new ItemStack(DerpMod.trollchemistsStone, 1, OreDictionary.WILDCARD_VALUE));

		trollsDagger = new ItemTrollsDagger(trollM);
		GameRegistry.registerItem(trollsDagger, trollsDagger.getUnlocalizedName());
		GameRegistry.addShapedRecipe(new ItemStack(trollsDagger, 1), "s  ", "g  ", "g  ", 'g', new ItemStack(trollGem), 's', new ItemStack(Items.stick));
		GameRegistry.addShapedRecipe(new ItemStack(trollsDagger, 1), " s "," g ", " g ", 'g', new ItemStack(trollGem), 's', new ItemStack(Items.stick));
		GameRegistry.addShapedRecipe(new ItemStack(trollsDagger, 1), "  s","  g", "  g", 'g', new ItemStack(trollGem), 's', new ItemStack(Items.stick));

		oreFracDivPick = new ItemPickOfDividingOresByAFraction(trollM);
		GameRegistry.registerItem(oreFracDivPick, oreFracDivPick.getUnlocalizedName());
		GameRegistry.addShapedRecipe(new ItemStack(oreFracDivPick, 1), "tet", " s ", " s ", 't', tGS, 'e', new ItemStack(Items.emerald, 1), 's', new ItemStack(Items.stick, 1));

        //A food that drains hunger
		itemAntibacon = new ItemAntibacon();
		GameRegistry.registerItem(itemAntibacon, itemAntibacon.getUnlocalizedName());
		GameRegistry.addShapedRecipe(new ItemStack(itemAntibacon, 8), "ppp", "ptp", "ppp", 'p', new ItemStack(Items.cooked_porkchop), 't', tGS);

		GameRegistry.registerBlock(repeaterBomb, repeaterBomb.getUnlocalizedName());
		GameRegistry.addShapelessRecipe(new ItemStack(repeaterBomb, 1), Items.repeater, Blocks.tnt, trollGem);
		
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerModEntity(EntityDerpGrenade.class, "EntityDerpGrenade", entityId, instance, 64, 1, true);
		
		ItemUnfinishedRageIngot uri0 = new ItemUnfinishedRageIngot(0);
		ItemUnfinishedRageIngot uri1 = new ItemUnfinishedRageIngot(1);
		ItemUnfinishedRageIngot uri2 = new ItemUnfinishedRageIngot(2);
		ItemUnfinishedRageIngot uri3 = new ItemUnfinishedRageIngot(3);
		ItemUnfinishedRageIngot uri4 = new ItemUnfinishedRageIngot(4);
		ItemUnfinishedRageIngot uri5 = new ItemUnfinishedRageIngot(5);
		ItemUnfinishedRageIngot uri6 = new ItemUnfinishedRageIngot(6);
		GameRegistry.registerItem(uri0, "unfinishedRageIngotStage0");
		GameRegistry.registerItem(uri1, "unfinishedRageIngotStage1");
		GameRegistry.registerItem(uri2, "unfinishedRageIngotStage2");
		GameRegistry.registerItem(uri3, "unfinishedRageIngotStage3");
		GameRegistry.registerItem(uri4, "unfinishedRageIngotStage4");
		GameRegistry.registerItem(uri5, "unfinishedRageIngotStage5");
		GameRegistry.registerItem(uri6, "unfinishedRageIngotStage6");
		ItemStack uris0 = new ItemStack(uri0, 1);
		ItemStack uris1 = new ItemStack(uri1, 1);
		ItemStack uris2 = new ItemStack(uri2, 1);
		ItemStack uris3 = new ItemStack(uri3, 1);
		ItemStack uris4 = new ItemStack(uri4, 1);
		ItemStack uris5 = new ItemStack(uri5, 1);
		ItemStack uris6 = new ItemStack(uri6, 1);
		
		ItemCompleteRageIngot cri = new ItemCompleteRageIngot();
		GameRegistry.registerItem(cri, "completeRageIngot");
		ItemStack criStack = new ItemStack(cri,1);
        Item.ToolMaterial rageM = new EnumHelper().addToolMaterial("rageM", 6, 10000, 100F, 1F, 42);

		explosionScroll = new ItemExplosionScroll();
		GameRegistry.registerItem(explosionScroll, explosionScroll.getUnlocalizedName());
		GameRegistry.addShapedRecipe(new ItemStack(explosionScroll, 1), "spg", "rtg", "rps", 'p', Items.paper, 's', Items.stick, 'g', trollGem, 'r', cri, 't', Blocks.tnt);
		GameRegistry.addShapedRecipe(new ItemStack(explosionScroll, 1), "gps", "gtr", "spr", 'p', Items.paper, 's', Items.stick, 'g', trollGem, 'r', cri, 't', Blocks.tnt);
		GameRegistry.addShapedRecipe(new ItemStack(explosionScroll, 1), "spr", "gtr", "gps", 'p', Items.paper, 's', Items.stick, 'g', trollGem, 'r', cri, 't', Blocks.tnt);
		GameRegistry.addShapedRecipe(new ItemStack(explosionScroll, 1), "rps", "rtg", "spg", 'p', Items.paper, 's', Items.stick, 'g', trollGem, 'r', cri, 't', Blocks.tnt);
		
		GameRegistry.addSmelting(rageOre, uris0, 0F);
		GameRegistry.addSmelting(uris0, uris1, 0F);
		GameRegistry.addSmelting(uris1, uris2, 0F);
		GameRegistry.addSmelting(uris2, uris3, 0F);
		GameRegistry.addSmelting(uris3, uris4, 0F);
		GameRegistry.addSmelting(uris4, uris5, 0F);
		GameRegistry.addSmelting(uris5, uris6, 0F);
		GameRegistry.addSmelting(uris6, criStack, 100F);
		
		GameRegistry.registerBlock(rageBlock, rageBlock.getUnlocalizedName());
		GameRegistry.addShapedRecipe(new ItemStack(rageBlock, 1), "rrr", "rrr", "rrr", 'r', criStack);
		GameRegistry.addShapelessRecipe(new ItemStack(cri, 9), new ItemStack(rageBlock, 1));

        itemTrolldenApple = new ItemTrolldenApple();
        GameRegistry.registerItem(itemTrolldenApple, itemTrolldenApple.getUnlocalizedName());
        GameRegistry.addShapelessRecipe(new ItemStack(itemTrolldenApple, 1), new ItemStack(trollchemistsStone, 1), new ItemStack(Items.golden_apple, 1));

        itemSwordOfGoodbye = new ItemSwordOfGoodbye(rageM);
        GameRegistry.registerItem(itemSwordOfGoodbye, itemSwordOfGoodbye.getUnlocalizedName());
        GameRegistry.addShapedRecipe(new ItemStack(itemSwordOfGoodbye, 1), "tt ","rr ", "ss ", 't', new ItemStack(trollBlock, 1), 'r', criStack, 's', new ItemStack(Items.stick));
        GameRegistry.addShapedRecipe(new ItemStack(itemSwordOfGoodbye, 1), " tt"," rr", " ss", 't', new ItemStack(trollBlock, 1), 'r', criStack, 's', new ItemStack(Items.stick));

        rageBattlehoe = new ItemRageBattlehoe(rageM);
        GameRegistry.registerItem(rageBattlehoe, rageBattlehoe.getUnlocalizedName());
        GameRegistry.addShapedRecipe(new ItemStack(rageBattlehoe, 1), "rr ", " s ", " s ", 'r', cri, 's', Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(rageBattlehoe, 1), " rr", " s ", " s ", 'r', cri, 's', Items.stick);

        //GameRegistry.registerItem(rickRollDisc, "rickRollDisc");

        DerpWorld.mainRegistry();
        proxy.registerRenderers();
		}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
    {
        EntityRegistry.registerGlobalEntityID(EntityRageGuy.class, "rageGuy", EntityRegistry.findGlobalUniqueEntityId(), 16777215, 256);
    /*    EntityRegistry.addSpawn(EntityRageGuy.class, 20, 1, 4, EnumCreatureType.MONSTER, BiomeGenBase.swampland);
        EntityRegistry.addSpawn(EntityRageGuy.class, 20, 1, 4, EnumCreatureType.MONSTER, BiomeGenBase.mushroomIsland);
        EntityRegistry.addSpawn(EntityRageGuy.class, 20, 1, 4, EnumCreatureType.MONSTER, BiomeGenBase.mushroomIslandShore);
        EntityRegistry.addSpawn(EntityRageGuy.class, 20, 1, 4, EnumCreatureType.MONSTER, BiomeGenBase.forest);
        EntityRegistry.registerGlobalEntityID(EntityLolcat.class, "lolcat", EntityRegistry.findGlobalUniqueEntityId(), 16776041, 10066329);*/
        EntityRegistry.registerGlobalEntityID(EntityLolcat.class, "lolcat", EntityRegistry.findGlobalUniqueEntityId(), 16776041, 10066329);
        proxy.registerRenderers();
        System.out.println("Derp Mod by diamondman3 and yellowjournalism sucessfully loaded");
	}
}
