package com.dotteam.dogwardrobe;

import static com.dotteam.dogwardrobe.DogWardrobe.MOD_ID;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HandlerCommon {

    public static CreativeModeTab DOT_TAB;
    public static boolean DOT_SELECTED = false;

    @SubscribeEvent
    public static void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public static void registerCreativeModeTabs(BuildCreativeModeTabContentsEvent event) {
        //TODO
        // DOT_TAB = event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "dot_tab"),
        //         builder -> builder.icon(
        //                 () -> new ItemStack(DoTAWItemsRegistry.GENERAL.get()))
        //                 .title(Component.translatable("item_group." + MOD_ID + ".dottab")).withSearchBar().build());
        DOT_TAB = event.getTab();
    }

    @SubscribeEvent
    public static void setDotTab(BuildCreativeModeTabContentsEvent event) {
        DOT_SELECTED = event.getTab() == DOT_TAB;
    }

    public static boolean isDotSelected() {
        return DOT_SELECTED;
    }
}
