package org.dawnoftime.armoreddoggo;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.component.DyedItemColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.dawnoftime.armoreddoggo.item.DogArmorItem;
import org.dawnoftime.armoreddoggo.registry.ModelProviderRegistry;
import org.jline.utils.Log;

import static org.dawnoftime.armoreddoggo.registry.ItemModRegistry.*;

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
                .icon(TAB_ICON::toStack)
                .displayItems((params, output) -> output.acceptAll(ITEMS.getEntries().stream().filter(holder -> holder != TAB_ICON).map((itemDeferredHolder) -> itemDeferredHolder.get().getDefaultInstance()).toList()))
                .build());

        // Armor models init
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(ArmoredDoggo::registerLayerDefinitions);
            modEventBus.addListener(ArmoredDoggo::registerColorHandlersEvent);
        }

        Log.error("CODE COULEUR" + FastColor.ARGB32.color(255, 255, 255));

        CommonClass.init();
    }

    /**
     * Registers the LayerDefinitions. Must be client side only !
     * @param event Event called.
     */
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
        ModelProviderRegistry.REGISTRY.forEach((name, provider) -> event.registerLayerDefinition(provider.getLayerLocation(), provider::createLayer));
    }

    public static void registerColorHandlersEvent(RegisterColorHandlersEvent.Item event){
        ITEMS.getEntries().stream().filter(holder -> holder.get() instanceof DogArmorItem).forEach(holder -> event.register((stack, layer) -> layer != 1 ? -1 : DyedItemColor.getOrDefault(stack, -1), holder.get()));
    }
}