package com.tildenprep.derpmod.world;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.tildenprep.derpmod.DerpMod;
import net.minecraftforge.fml.common.IWorldGenerator;


public class WorldGenDerp implements IWorldGenerator {
	
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		int dimID = world.provider.getDimensionId();
        switch(dimID){
		case 0:
			generateOverworld(world, rand, chunkX*16, chunkZ*16);
            break;
		}		
	}
	
	private void generateOverworld(World world, Random rand, int chunkX, int chunkZ){
	//Derp Ore gen
		for(int i = 0; i < 35; i++){ 
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(40);
			int randPosZ = chunkZ + rand.nextInt(16);
            BlockPos randPos = new BlockPos(randPosX, randPosY, randPosZ);
			
			(new WorldGenMinable(DerpMod.derpOre.getDefaultState() ,10)).generate(world, rand, randPos);
			
		}
	//Troll Ore gen	
		for(int i = 0; i < 22; i++){ 
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(23);
			int randPosZ = chunkZ + rand.nextInt(16);
            BlockPos randPos = new BlockPos(randPosX, randPosY, randPosZ);

			(new WorldGenMinable(DerpMod.trollOre.getDefaultState() ,10)).generate(world, rand, randPos);
		}
	//Rage Ore gen
		for(int i = 0; i < 16; i++){ 
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(16);
			int randPosZ = chunkZ + rand.nextInt(16);
            BlockPos randPos = new BlockPos(randPosX, randPosY, randPosZ);
			
			(new WorldGenMinable(DerpMod.rageOre.getDefaultState(), 10)).generate(world, rand, randPos);
		}
	}
}
