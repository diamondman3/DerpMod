package com.tildenprep.derpmod.world;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.*;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class NondamagingExplosion extends Explosion {


    private int field_77289_h = 16;
    private World worldObj;
    private Map field_77288_k = new HashMap();
    private Random explosionRNG = new Random();
    private Entity exploder;
    private double explosionX;
    private double explosionY;
    private double explosionZ;

    public NondamagingExplosion(World world, Entity exploder, double x, double y, double z, float size) {

        super(world, exploder, x, y, z, size, false, false);
        this.worldObj = world;
        this.exploder = exploder;
        explosionX = x;
        explosionY = y;
        explosionZ = z;
    }

    @Override
    public void doExplosionA() {
        //nothing
    }

    public void doExplosionB(boolean p_77279_1_) {
        this.worldObj.playSoundEffect(exploder.posX, exploder.posY, exploder.posZ, "random.explode", 4.0F, (1.0F + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2F) * 0.7F);
        this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.explosionX, this.explosionY, this.explosionZ, 1.0D, 0.0D, 0.0D, new int[0]);
        }
}