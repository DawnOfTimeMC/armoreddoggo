package org.dawnoftime.armoreddoggo.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;

public final class ItemsMod {
	public static final Item RAIJIN_DOG_ARMOR = new WolfArmorItem(ArmorMaterials.ARMADILLO, new Item.Properties().durability(ArmorItem.Type.BODY.getDurability(4)));

}
