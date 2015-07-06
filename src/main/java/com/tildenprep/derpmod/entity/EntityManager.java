package com.tildenprep.derpmod.entity;

import net.minecraft.entity.EntityList;

public class EntityManager {
	
	public static void mainRegistry(){
		registerEntity();
	}
	
	public static void registerEntity(){
		//createEntity(EntityRageGuy.class, "EntityRageGuy", 0xF0C0C0, 0x107A7A);
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor){
		/*int entityId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, entityId);
		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, solidColor, spotColor));*/
		
	}

}
