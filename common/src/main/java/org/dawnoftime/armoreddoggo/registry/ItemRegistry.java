package org.dawnoftime.armoreddoggo.registry;

import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import org.dawnoftime.armoreddoggo.item.DogArmorItem;

import static org.dawnoftime.armoreddoggo.Constants.RAIJIN_DOG_ARMOR_NAME;

public final class ItemRegistry {
	public static final Item RAIJIN_DOG_ARMOR = new DogArmorItem(RAIJIN_DOG_ARMOR_NAME, ArmorMaterials.ARMADILLO, 4);

}
