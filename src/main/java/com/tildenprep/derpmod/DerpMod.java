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
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

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
        //TODO: Update texture settings
        //todo: Block textures
        /*todo: "Unable to load definition derpmod:tile.derpmod_reversePiston#extended=true,facing=west"
        java.lang.RuntimeException: Encountered an exception when loading model definition of model
        derpmod:blockstates/tile.derpmod_reversePiston.json*/
{
    public static final String MODID = "derpmod";
    public static final String VERSION = "0.0.4";
    public static final String NAME = "derpmod";

    public final static CreativeTabs tabDerpMod = new CreativeTabs("derpMod") {

        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return DerpMod.derpIngot;
        }
    };

    public static ItemDerpIngot derpIngot;
    public static ItemDerpSword derpSword;
    public static ItemDerpShovel derpShovel;
    public static ItemDerpPickaxe derpPickaxe;
    public static ItemDerpAxe derpAxe;
    public static ItemDerpHoe derpHoe;
    public static ItemDerpGrenade derpGrenade;
    public static ItemDerpArmor derpHelmet;
    public static ItemDerpArmor derpShirt;
    public static ItemDerpArmor derpPants;
    public static ItemDerpArmor derpBoots;

    public static ItemTrollGem trollGem;
    public static ItemTrollsDagger trollsDagger;
    public static ItemPickOfDividingOresByAFraction pickOfDividingOresByAFraction;
    public static ItemExplosionScroll explosionScroll;

    public static ItemTrollchemistsStone trollchemistsStone;

    public static ItemUnfinishedRageIngot itemUnfinishedRageIngot;
    public static ItemCompleteRageIngot completeRageIngot;

    public static ItemSwordOfGoodbye itemSwordOfGoodbye;
    public static ItemRageBattlehoe rageBattlehoe;

    public static ItemAntibacon itemAntibacon;
    public static ItemBurger itemBurger;
    public static ItemCheese itemCheese;
    public static ItemCheeseburger itemCheeseburger;
    public static ItemTrolldenApple itemTrolldenApple;

    public static ItemUnfinishedRageIngot uri0 = new ItemUnfinishedRageIngot(0);
    public static ItemUnfinishedRageIngot uri1 = new ItemUnfinishedRageIngot(1);
    public static ItemUnfinishedRageIngot uri2 = new ItemUnfinishedRageIngot(2);
    public static ItemUnfinishedRageIngot uri3 = new ItemUnfinishedRageIngot(3);
    public static ItemUnfinishedRageIngot uri4 = new ItemUnfinishedRageIngot(4);
    public static ItemUnfinishedRageIngot uri5 = new ItemUnfinishedRageIngot(5);
    public static ItemUnfinishedRageIngot uri6 = new ItemUnfinishedRageIngot(6);

    @Mod.Instance(value = "DerpMod")
    public static DerpMod instance;

    @SidedProxy(clientSide ="com.tildenprep.derpmod.client.ClientProxy", serverSide = "com.tildenprep.derpmod.CommonProxy")
    public static ClientProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        EntityManager.mainRegistry();
        DerpModRegistrar registry = new DerpModRegistrar();
        registry.registerBlocks();

        registry.registerOresBlock();

        itemBurger = new ItemBurger();
        itemCheese = new ItemCheese();
        itemCheeseburger = new ItemCheeseburger();
        GameRegistry.addShapedRecipe(new ItemStack(itemBurger, 1), "b  ", "s  ", "b  ", 'b', Items.bread, 's', Items.cooked_beef);
        GameRegistry.addShapedRecipe(new ItemStack(itemBurger, 1), " b ", " s ", " b ", 'b', Items.bread, 's', Items.cooked_beef);
        GameRegistry.addShapedRecipe(new ItemStack(itemBurger, 1), "  b", "  s", "  b", 'b', Items.bread, 's', Items.cooked_beef);
        GameRegistry.addShapelessRecipe(new ItemStack(itemCheese, 1), new ItemStack(Items.milk_bucket), new ItemStack(Items.sugar));
        GameRegistry.addShapelessRecipe(new ItemStack(itemCheeseburger, 1), new ItemStack(itemBurger, 1), new ItemStack(itemCheese, 1));

        derpIngot = new ItemDerpIngot();
        ItemStack dIS = new ItemStack(derpIngot, 1);
        GameRegistry.addSmelting(DerpModRegistrar.derpOre, dIS, 1F);
        Item.ToolMaterial derpM = new EnumHelper().addToolMaterial("Derp", 5, 251, 100F, 2F, 30);
        final ArmorMaterial derpArmorMat = new EnumHelper().addArmorMaterial("derp", "textures/models/armor/derpArmorLayer1", 259, new int[]{2, 6, 5, 2}, 15);

        GameRegistry.addShapedRecipe(new ItemStack(DerpModRegistrar.derpBlock, 1), "ddd", "ddd", "ddd", 'd', dIS);
        GameRegistry.addShapelessRecipe(new ItemStack(derpIngot, 9), new ItemStack(DerpModRegistrar.derpBlock));

        derpSword = new ItemDerpSword(derpM);
        GameRegistry.addShapedRecipe(new ItemStack(derpSword, 1), "d  ", "d  ", "s  ", 'd', dIS, 's', new ItemStack(Items.stick));
        GameRegistry.addShapedRecipe(new ItemStack(derpSword, 1), " d ", " d ", " s ", 'd', dIS, 's', new ItemStack(Items.stick));
        GameRegistry.addShapedRecipe(new ItemStack(derpSword, 1), "  d", "  d", "  s", 'd', dIS, 's', new ItemStack(Items.stick));

        derpShovel = new ItemDerpShovel(derpM);
        GameRegistry.addShapedRecipe(new ItemStack(derpShovel, 1), "d  ", "s  ", "s  ", 'd', dIS, 's', new ItemStack(Items.stick));
        GameRegistry.addShapedRecipe(new ItemStack(derpShovel, 1), " d ", " s ", " s ", 'd', dIS, 's', new ItemStack(Items.stick));
        GameRegistry.addShapedRecipe(new ItemStack(derpShovel, 1), "  d", "  s", "  s", 'd', dIS, 's', new ItemStack(Items.stick));

        derpPickaxe = new ItemDerpPickaxe(derpM);
        GameRegistry.addShapedRecipe(new ItemStack(derpPickaxe, 1), "ddd", " s ", " s ", 'd', dIS, 's', new ItemStack(Items.stick));


        derpAxe = new ItemDerpAxe(derpM);
        GameRegistry.addShapedRecipe(new ItemStack(derpAxe, 1), "dd ", "ds ", " s ", 'd', dIS, 's', new ItemStack(Items.stick));
        GameRegistry.addShapedRecipe(new ItemStack(derpAxe, 1), " dd", " sd", " s ", 'd', dIS, 's', new ItemStack(Items.stick));

        derpHoe = new ItemDerpHoe(derpM);
        GameRegistry.addShapedRecipe(new ItemStack(derpHoe, 1), "dd ", " s ", " s ", 'd', dIS, 's', new ItemStack(Items.stick));
        GameRegistry.addShapedRecipe(new ItemStack(derpHoe, 1), " dd", " s ", " s ", 'd', dIS, 's', new ItemStack(Items.stick));


        //TODO: ItemDerpArmor.setNameBySlot not showing up
        derpHelmet = new ItemDerpArmor(derpArmorMat, this.proxy.addArmor("DerpHelmet"), 0);
            derpHelmet.setNameBySlot(0);
            derpHelmet.setUnlocalizedName(DerpMod.MODID + "_" + derpHelmet.getName());
            derpHelmet.setCreativeTab(DerpMod.tabDerpMod);
            GameRegistry.addShapedRecipe(new ItemStack(derpHelmet, 1), "ddd", "d d", "   ", 'd', dIS);
            GameRegistry.addShapedRecipe(new ItemStack(derpHelmet, 1), "   ", "ddd", "d d", 'd', dIS);

        derpShirt = new ItemDerpArmor(derpArmorMat, this.proxy.addArmor("DerpShirt"), 1);
            derpShirt.setNameBySlot(1);
            derpShirt.setUnlocalizedName(DerpMod.MODID + "_" + derpShirt.getName());
            derpShirt.setCreativeTab(DerpMod.tabDerpMod);
            GameRegistry.addShapedRecipe(new ItemStack(derpShirt, 1), "d d", "ddd", "ddd", 'd', dIS);

        derpPants = new ItemDerpArmor(derpArmorMat, this.proxy.addArmor("DerpPants"), 2);
            derpPants.setNameBySlot(2);
            derpPants.setUnlocalizedName(DerpMod.MODID + "_" + derpPants.getName());
            derpPants.setCreativeTab(DerpMod.tabDerpMod);
            GameRegistry.addShapedRecipe(new ItemStack(derpPants, 1), "ddd", "d d", "d d", 'd', dIS);

        derpBoots = new ItemDerpArmor(derpArmorMat, this.proxy.addArmor("DerpBoots"), 3);
            derpBoots.setNameBySlot(3);
            derpBoots.setUnlocalizedName(DerpMod.MODID + "_" + derpBoots.getName());
            derpBoots.setCreativeTab(DerpMod.tabDerpMod);
            GameRegistry.addShapedRecipe(new ItemStack(derpBoots, 1), "d d", "d d", "   ", 'd', dIS);
            GameRegistry.addShapedRecipe(new ItemStack(derpBoots, 1), "   ", "d d", "d d", 'd', dIS);

        derpGrenade = new ItemDerpGrenade();
        GameRegistry.addShapedRecipe(new ItemStack(derpGrenade, 4), " d ", "dtd", " d ", 'd', dIS, 't', new ItemStack(Blocks.tnt));

        trollGem = new ItemTrollGem();
        ItemStack tGS = new ItemStack(trollGem);
        GameRegistry.addShapedRecipe(new ItemStack(trollGem, 8), "ooo", "oco", "ooo", 'o', new ItemStack(DerpModRegistrar.trollOre), 'c', new ItemStack(Items.coal));
        Item.ToolMaterial trollM = new EnumHelper().addToolMaterial("Troll", 5, 1337, 100F, 1F, 30);

        GameRegistry.addShapedRecipe(new ItemStack(DerpModRegistrar.trollBlock, 1), "ttt", "ttt", "ttt", 't', new ItemStack(trollGem));
        GameRegistry.addShapelessRecipe(new ItemStack(trollGem, 9), new ItemStack(DerpModRegistrar.trollBlock, 1));

        trollchemistsStone = new ItemTrollchemistsStone();

        GameRegistry.addShapelessRecipe(new ItemStack(Items.emerald, 2), new ItemStack(Blocks.redstone_block, 1), new ItemStack(Blocks.redstone_block, 1), new ItemStack(trollchemistsStone, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.redstone_block, 2), new ItemStack(Items.emerald, 1), new ItemStack(Items.emerald, 1), new ItemStack(trollchemistsStone, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.clock, 3), new ItemStack(Items.emerald, 1), new ItemStack(trollchemistsStone, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.emerald, 1), new ItemStack(Items.clock, 1) ,new ItemStack(Items.clock, 1), new ItemStack(Items.clock, 1), new ItemStack(trollchemistsStone, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapedRecipe(new ItemStack(Items.cooked_porkchop, 8), "aaa", "asa", "aaa", 's', new ItemStack(trollchemistsStone, 1, OreDictionary.WILDCARD_VALUE), 'a', new ItemStack(DerpMod.itemAntibacon));
        //Potion is 3 min. waterbreathing
        GameRegistry.addShapelessRecipe(new ItemStack(Items.potionitem, 1, 8205), new ItemStack(Blocks.grass, 1), new ItemStack(Blocks.grass, 1), new ItemStack(Blocks.grass, 1), new ItemStack(Items.glass_bottle, 1), new ItemStack(DerpMod.trollchemistsStone, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 1), new ItemStack(Blocks.coal_block), new ItemStack(Items.lava_bucket), new ItemStack(trollchemistsStone, OreDictionary.WILDCARD_VALUE));


        trollsDagger = new ItemTrollsDagger(trollM);
        GameRegistry.addShapedRecipe(new ItemStack(trollsDagger, 1), "s  ", "g  ", "g  ", 'g', new ItemStack(trollGem), 's', new ItemStack(Items.stick));
        GameRegistry.addShapedRecipe(new ItemStack(trollsDagger, 1), " s "," g ", " g ", 'g', new ItemStack(trollGem), 's', new ItemStack(Items.stick));
        GameRegistry.addShapedRecipe(new ItemStack(trollsDagger, 1), "  s","  g", "  g", 'g', new ItemStack(trollGem), 's', new ItemStack(Items.stick));

        pickOfDividingOresByAFraction = new ItemPickOfDividingOresByAFraction(trollM);
        GameRegistry.addShapedRecipe(new ItemStack(pickOfDividingOresByAFraction, 1), "tet", " s ", " s ", 't', tGS, 'e', new ItemStack(Items.emerald, 1), 's', new ItemStack(Items.stick, 1));

        //A food that drains hunger
        itemAntibacon = new ItemAntibacon();
        GameRegistry.addShapedRecipe(new ItemStack(itemAntibacon, 8), "ppp", "ptp", "ppp", 'p', new ItemStack(Items.cooked_porkchop), 't', tGS);

        //TODO: explodes when powered from any side. Not intended.
        GameRegistry.addShapelessRecipe(new ItemStack(DerpModRegistrar.repeaterBomb, 1), Items.repeater, Blocks.tnt, trollGem);

        int entityId = EntityRegistry.findGlobalUniqueEntityId();
//		EntityRegistry.registerModEntity(EntityDerpGrenade.class, "EntityDerpGrenade", entityId, instance, 64, 1, true);


        //unfinished rage ingot
        ItemStack uris0 = new ItemStack(uri0, 1);
        ItemStack uris1 = new ItemStack(uri1, 1);
        ItemStack uris2 = new ItemStack(uri2, 1);
        ItemStack uris3 = new ItemStack(uri3, 1);
        ItemStack uris4 = new ItemStack(uri4, 1);
        ItemStack uris5 = new ItemStack(uri5, 1);
        ItemStack uris6 = new ItemStack(uri6, 1);

        ItemCompleteRageIngot completeRageIngot = new ItemCompleteRageIngot();
        ItemStack completeRageIngotStack = new ItemStack(completeRageIngot,1);
        Item.ToolMaterial rageM = new EnumHelper().addToolMaterial("rageM", 6, 10000, 100F, 1F, 42);

        explosionScroll = new ItemExplosionScroll();
        GameRegistry.addShapedRecipe(new ItemStack(explosionScroll, 1), "spg", "rtg", "rps", 'p', Items.paper, 's', Items.stick, 'g', trollGem, 'r', completeRageIngot, 't', Blocks.tnt);
        GameRegistry.addShapedRecipe(new ItemStack(explosionScroll, 1), "gps", "gtr", "spr", 'p', Items.paper, 's', Items.stick, 'g', trollGem, 'r', completeRageIngot, 't', Blocks.tnt);
        GameRegistry.addShapedRecipe(new ItemStack(explosionScroll, 1), "spr", "gtr", "gps", 'p', Items.paper, 's', Items.stick, 'g', trollGem, 'r', completeRageIngot, 't', Blocks.tnt);
        GameRegistry.addShapedRecipe(new ItemStack(explosionScroll, 1), "rps", "rtg", "spg", 'p', Items.paper, 's', Items.stick, 'g', trollGem, 'r', completeRageIngot, 't', Blocks.tnt);

        GameRegistry.addSmelting(DerpModRegistrar.rageOre, uris0, 0F);
        GameRegistry.addSmelting(uris0, uris1, 0F);
        GameRegistry.addSmelting(uris1, uris2, 0F);
        GameRegistry.addSmelting(uris2, uris3, 0F);
        GameRegistry.addSmelting(uris3, uris4, 0F);
        GameRegistry.addSmelting(uris4, uris5, 0F);
        GameRegistry.addSmelting(uris5, uris6, 0F);
        GameRegistry.addSmelting(uris6, completeRageIngotStack, 100F);

        GameRegistry.addShapedRecipe(new ItemStack(DerpModRegistrar.rageBlock, 1), "rrr", "rrr", "rrr", 'r', completeRageIngotStack);
        GameRegistry.addShapelessRecipe(new ItemStack(completeRageIngot, 9), new ItemStack(DerpModRegistrar.rageBlock, 1));

        itemTrolldenApple = new ItemTrolldenApple();
        GameRegistry.addShapelessRecipe(new ItemStack(itemTrolldenApple, 1), new ItemStack(trollchemistsStone, 1), new ItemStack(Items.golden_apple, 1));

        itemSwordOfGoodbye = new ItemSwordOfGoodbye(rageM);
        GameRegistry.addShapedRecipe(new ItemStack(itemSwordOfGoodbye, 1), "tt ","rr ", "ss ", 't', new ItemStack(DerpModRegistrar.trollBlock, 1), 'r', completeRageIngotStack, 's', new ItemStack(Items.stick));
        GameRegistry.addShapedRecipe(new ItemStack(itemSwordOfGoodbye, 1), " tt"," rr", " ss", 't', new ItemStack(DerpModRegistrar.trollBlock, 1), 'r', completeRageIngotStack, 's', new ItemStack(Items.stick));

        rageBattlehoe = new ItemRageBattlehoe(rageM);
        GameRegistry.addShapedRecipe(new ItemStack(rageBattlehoe, 1), "rr ", " s ", " s ", 'r', completeRageIngot, 's', Items.stick);
        GameRegistry.addShapedRecipe(new ItemStack(rageBattlehoe, 1), " rr", " s ", " s ", 'r', completeRageIngot, 's', Items.stick);

        //GameRegistry.registerItem(rickRollDisc, "rickRollDisc");

        DerpWorld.mainRegistry();
        proxy.registerRenderers();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        if(event.getSide() == Side.CLIENT) {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

            //blocks
            renderItem.getItemModelMesher().register(Item.getItemFromBlock(DerpModRegistrar.derpBlock), 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((DerpBlock)DerpModRegistrar.derpBlock).getName(), "inventory"));

            //items
            renderItem.getItemModelMesher().register(DerpMod.derpIngot, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemDerpIngot) derpIngot).getName(), "inventory"));
            renderItem.getItemModelMesher().register(DerpMod.derpSword, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemDerpSword) derpSword).getName(), "inventory"));
            renderItem.getItemModelMesher().register(DerpMod.derpShovel, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemDerpShovel) derpShovel).getName(), "inventory"));
            renderItem.getItemModelMesher().register(DerpMod.derpAxe, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemDerpAxe) derpAxe).getName(), "inventory"));
            renderItem.getItemModelMesher().register(DerpMod.derpPickaxe, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemDerpPickaxe) derpPickaxe).getName(), "inventory"));
            renderItem.getItemModelMesher().register(DerpMod.derpHoe, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemDerpHoe) derpHoe).getName(), "inventory"));

            renderItem.getItemModelMesher().register(DerpMod.trollGem, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemTrollGem) trollGem).getName(), "inventory"));
            renderItem.getItemModelMesher().register(DerpMod.trollchemistsStone, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemTrollchemistsStone) trollchemistsStone).getName(), "inventory"));
            renderItem.getItemModelMesher().register(DerpMod.trollsDagger, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemTrollsDagger) trollsDagger).getName(), "inventory"));
            renderItem.getItemModelMesher().register(DerpMod.pickOfDividingOresByAFraction, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemPickOfDividingOresByAFraction) pickOfDividingOresByAFraction).getName(), "inventory"));

            renderItem.getItemModelMesher().register(DerpMod.uri0, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemUnfinishedRageIngot) uri0).getName(), "inventory"));            //NullPointerException next line
            // renderItem.getItemModelMesher().register(DerpMod.completeRageIngot, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemCompleteRageIngot) completeRageIngot).getName(), "inventory"));

            renderItem.getItemModelMesher().register(DerpMod.rageBattlehoe, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemRageBattlehoe) rageBattlehoe).getName(), "inventory"));
            renderItem.getItemModelMesher().register(DerpMod.itemSwordOfGoodbye, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemSwordOfGoodbye) itemSwordOfGoodbye).getName(), "inventory"));

            renderItem.getItemModelMesher().register(DerpMod.itemCheese, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemCheese) itemCheese).getName(), "inventory"));
            renderItem.getItemModelMesher().register(DerpMod.itemBurger, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemBurger) itemBurger).getName(), "inventory"));
            renderItem.getItemModelMesher().register(DerpMod.itemCheeseburger, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemCheeseburger) itemCheeseburger).getName(), "inventory"));
            renderItem.getItemModelMesher().register(DerpMod.itemAntibacon, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemAntibacon) itemAntibacon).getName(), "inventory"));
            renderItem.getItemModelMesher().register(DerpMod.itemTrolldenApple, 0, new ModelResourceLocation(DerpMod.MODID + ":" + ((ItemTrolldenApple) itemTrolldenApple).getName(), "inventory"));

        }

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
