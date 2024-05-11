package org.dawnoftime.armoreddoggo;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import org.dawnoftime.armoreddoggo.item.DogArmorItem;
import org.dawnoftime.armoreddoggo.registry.ModelProviderRegistry;

import static org.dawnoftime.armoreddoggo.Constants.MOD_ID;
import static org.dawnoftime.armoreddoggo.ItemModRegistry.ITEMS;
import static org.dawnoftime.armoreddoggo.registry.ItemRegistry.TAB_ICON;

public class ArmoredDoggo implements ModInitializer {

    private static final CreativeModeTab CREATIVE_MODE_TAB = FabricItemGroup.builder()
            .title(Component.translatable("itemGroup." + MOD_ID))
            .icon(() -> new ItemStack(TAB_ICON))
            .displayItems((params, output) -> output.acceptAll(ITEMS.stream().filter(holder -> holder != TAB_ICON).map(Item::getDefaultInstance).toList()))
            .build();

    @Override
    public void onInitialize() {
        // Items init
        ItemModRegistry.init();

        // Creative inventory init
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(MOD_ID, MOD_ID), CREATIVE_MODE_TAB);

        // Loot tables
        LootTableModifier.modifyLootTables();

        // Client Side init
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            registerLayerDefinitions();
            registerColorHandlersEvent();
        }

        CommonClass.init();
    }

    /**
     * Registers the LayerDefinitions. Must be client side only !
     */
    public static void registerLayerDefinitions(){
        ModelProviderRegistry.REGISTRY.forEach((name, provider) -> EntityModelLayerRegistry.registerModelLayer(provider.getLayerLocation(), provider::createLayer));
    }

    public static void registerColorHandlersEvent(){
        ITEMS.stream().filter(item -> item instanceof DogArmorItem).forEach(item -> ColorProviderRegistry.ITEM.register((stack, layer) -> layer != 1 ? -1 : DyedItemColor.getOrDefault(stack, -1), item));
    }
}
