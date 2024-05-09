package org.dawnoftime.armoreddoggo;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.dawnoftime.armoreddoggo.registry.ItemRegistry;

import java.util.ArrayList;
import java.util.List;

import static org.dawnoftime.armoreddoggo.Constants.*;

public class ItemModRegistry {

    public static final List<Item> ITEMS = new ArrayList<>();

    public static void init(){
        registerItem(MOD_ID, ItemRegistry.TAB_ICON);
        registerItem(RAIJIN_DOG_ARMOR_NAME, ItemRegistry.RAIJIN_DOG_ARMOR);
        registerItem(HOLY_DOG_ARMOR_NAME, ItemRegistry.HOLY_DOG_ARMOR);
    }

    public static void registerItem(String name, Item item){
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, name), item);
        ITEMS.add(item);
    }
}
