package com.tildenprep.derpmod.client;

import com.tildenprep.derpmod.entity.EntityLolcat;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelOcelot;
import net.minecraft.client.renderer.entity.RenderOcelot;
import net.minecraft.client.renderer.entity.RenderSnowball;

import com.tildenprep.derpmod.CommonProxy;
import com.tildenprep.derpmod.DerpMod;
import com.tildenprep.derpmod.entity.EntityDerpGrenade;
import com.tildenprep.derpmod.entity.EntityRageGuy;
import com.tildenprep.derpmod.entity.ScrollSpellEntity;
import com.tildenprep.derpmod.render.RenderRageGuy;

import javax.swing.text.html.parser.Entity;

/**
 * Created by kenny on 5/21/14.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenderers() {
    //	RenderingRegistry.registerEntityRenderingHandler(EntityDerpGrenade.class, new RenderSnowball(DerpMod.derpGrenade));
    //	RenderingRegistry.registerEntityRenderingHandler(ScrollSpellEntity.class, new RenderSnowball(DerpMod.explosionScroll));
    //	RenderingRegistry.registerEntityRenderingHandler(EntityRageGuy.class, new RenderRageGuy(new ModelBiped(), 0.5F));
    //  RenderingRegistry.registerEntityRenderingHandler(EntityLolcat.class, new RenderOcelot(new ModelOcelot(), 0.5F));
    }

    public void registerSound(){

    }


    public int addArmor(String armor){
    	return 0;
    }
}
