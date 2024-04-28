package com.dotteam.dogwardrobe;

import java.util.Map;
import com.dotteam.dogwardrobe.registry.DoTAWArmorSetsRegistry;
import com.dotteam.dogwardrobe.registry.DoTAWItemsRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(DogWardrobe.MOD_ID)
public class DogWardrobe {
    public static final String MOD_ID = "dogwardrobe";

    public DogWardrobe() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DoTAWItemsRegistry.register(modEventBus);

        modEventBus.addListener(HandlerCommon::commonSetup);
        // modEventBus.addListener(HandlerClient::clientSetup);

        modEventBus.addListener(HandlerCommon::registerCreativeModeTabs);
        modEventBus.addListener(HandlerCommon::setDotTab);
        // modEventBus.addListener(HandlerClient::entityRenderers);
        modEventBus.addListener(this::createCreativeTab);

        DoTAWArmorSetsRegistry.register();

        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(DoTAWArmorSetsRegistry::onLayerRegister);
        }
    }

    public void createCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == HandlerCommon.DOT_TAB) {
            ForgeRegistries.ITEMS.getEntries().stream().filter(
                    entry -> entry
                            .getKey()
                            .location()
                            .getNamespace()
                            .equalsIgnoreCase(MOD_ID))
                            .map(Map.Entry::getValue)
                            .forEachOrdered(event::accept);
        }
    }
}
