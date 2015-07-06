package com.tildenprep.derpmod.render;

import com.tildenprep.derpmod.DerpMod;
import net.minecraft.client.model.ModelOcelot;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderOcelot;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * Created by diamondman3 on 10/29/2014.
 */
public class RenderLolcat extends RenderOcelot{

    public RenderLolcat(RenderManager renderManager, ModelOcelot model, Float f){
        super(renderManager, model, f);
    }


    @Override
    protected ResourceLocation getEntityTexture(Entity var1) {
        return new ResourceLocation(DerpMod.MODID + "src/main/resources/assets/derpmod/textures/entity/lolcat.png");
    }
}
