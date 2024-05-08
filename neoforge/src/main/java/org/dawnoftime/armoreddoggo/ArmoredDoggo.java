package org.dawnoftime.armoreddoggo;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.dawnoftime.armoreddoggo.registry.ModelProviderRegistry;

import static org.dawnoftime.armoreddoggo.registry.ItemModRegistry.ITEMS;
import static org.dawnoftime.armoreddoggo.registry.ItemModRegistry.RAIJIN_DOG_ARMOR;

@Mod(Constants.MOD_ID)
public class ArmoredDoggo {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public ArmoredDoggo(IEventBus modEventBus, ModContainer modContainer) {
        // Items init
        ITEMS.register(modEventBus);

        // Creative inventory init
        CREATIVE_MODE_TAB.register(modEventBus);
        CREATIVE_MODE_TAB.register(Constants.MOD_ID, () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup." + Constants.MOD_ID))
                .icon(RAIJIN_DOG_ARMOR::toStack)
                .displayItems((params, output) -> output.acceptAll(ITEMS.getEntries().stream().map((itemDeferredHolder) -> itemDeferredHolder.get().asItem().getDefaultInstance()).toList()))
                .build());

        // Armor models init
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(ArmoredDoggo::registerLayerDefinitions);
        }

        CommonClass.init();
    }

    /**
     * Registers the LayerDefinitions. Must be client side only !
     * @param event Event called.
     */
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
        ModelProviderRegistry.REGISTRY.forEach((name, provider) -> event.registerLayerDefinition(provider.getLayerLocation(), provider::createLayer));
    }
}