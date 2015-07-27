package com.tildenprep.derpmod;

import net.minecraft.potion.Potion;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by student on 7/8/2015.
 */
public class PotionRegistry {
   /* public void setup()
    {
        Potion[] potionTypes = null;
        for(Field f: Potion.class.getDeclaredFields()){
            f.setAccessible(true);
            try {
                if(f.getName().equals("potionTypes")|| f.getName().equals("field_76425_a")){
                    Field modfield = Field.class.getDeclaredField("modifiers");
                    modfield.setAccessible(true);
                    modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);
            }
        }
    }*/
}
