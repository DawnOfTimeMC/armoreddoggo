package org.dawnoftime.armoreddoggo.registry;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.dawnoftime.armoreddoggo.Constants;

public class ItemModRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);

    public static final DeferredItem<Item> RAIJIN_DOG_ARMOR = ITEMS.register("raijin_dog_armor", () -> ItemRegistry.RAIJIN_DOG_ARMOR);
}
