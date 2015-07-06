package com.tildenprep.derpmod.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.tildenprep.derpmod.DerpMod;

public class RenderRageGuy extends RenderBiped {

    public RenderRageGuy(RenderManager manager, ModelBiped model, float p_i46168_3_)
    {
        super(manager, model, p_i46168_3_, 1.0F);
        this.addLayer(new LayerHeldItem(this));
    }


	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
        //get Rage Guy's texture
       return new ResourceLocation(DerpMod.MODID + ":/textures/entity/rageGuy1point7.png");
	}

}
