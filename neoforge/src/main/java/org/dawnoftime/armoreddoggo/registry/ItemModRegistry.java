package org.dawnoftime.armoreddoggo.registry;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.dawnoftime.armoreddoggo.Constants;

import static org.dawnoftime.armoreddoggo.Constants.RAIJIN_DOG_ARMOR_NAME;

public class ItemModRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);

    public static final DeferredItem<Item> RAIJIN_DOG_ARMOR = ITEMS.register(RAIJIN_DOG_ARMOR_NAME, () -> ItemRegistry.RAIJIN_DOG_ARMOR);
}
