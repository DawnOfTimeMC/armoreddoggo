package org.dawnoftime.armoreddoggo.registry;

import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import org.dawnoftime.armoreddoggo.item.DogArmorItem;

import static org.dawnoftime.armoreddoggo.Constants.HOLY_DOG_ARMOR_NAME;
import static org.dawnoftime.armoreddoggo.Constants.RAIJIN_DOG_ARMOR_NAME;

public final class ItemRegistry {
	public static final Item TAB_ICON = new Item(new Item.Properties());
	public static final Item RAIJIN_DOG_ARMOR = new DogArmorItem(RAIJIN_DOG_ARMOR_NAME, ArmorMaterials.ARMADILLO, 4);
	public static final Item HOLY_DOG_ARMOR = new DogArmorItem(HOLY_DOG_ARMOR_NAME, ArmorMaterials.ARMADILLO, 4);
}
