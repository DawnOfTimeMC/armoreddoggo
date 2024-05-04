package org.dawnoftime.armoreddoggo.registry;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.dawnoftime.armoreddoggo.Constants;
import org.dawnoftime.armoreddoggo.item.ItemsMod;

public class ItemModRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);

    public static final DeferredItem<Item> RAIJIN_DOG_ARMOR = ITEMS.register("raijin_wolf_armor", () -> ItemsMod.RAIJIN_DOG_ARMOR);
}
