package org.dawnoftime.armoreddoggo.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.dawnoftime.armoreddoggo.Constants;

import java.util.ArrayList;
import java.util.List;

import static org.dawnoftime.armoreddoggo.Constants.RAIJIN_DOG_ARMOR_NAME;

public class ItemModRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);
    public static final DeferredItem<Item> TAB_ICON = ITEMS.register(Constants.MOD_ID, () -> ItemRegistry.TAB_ICON);
    public static final DeferredItem<Item> RAIJIN_DOG_ARMOR = ITEMS.register(RAIJIN_DOG_ARMOR_NAME, () -> ItemRegistry.RAIJIN_DOG_ARMOR);
}
