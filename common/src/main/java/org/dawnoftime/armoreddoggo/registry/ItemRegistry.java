package org.dawnoftime.armoreddoggo.registry;

import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import org.dawnoftime.armoreddoggo.item.DogArmorItem;

import static org.dawnoftime.armoreddoggo.registry.ModelProviderRegistry.RAIJIN_DOG_ARMOR_MODEL_PROVIDER;

public final class ItemRegistry {
	public static final Item RAIJIN_DOG_ARMOR = new DogArmorItem(RAIJIN_DOG_ARMOR_MODEL_PROVIDER, ArmorMaterials.ARMADILLO, 4);

}
