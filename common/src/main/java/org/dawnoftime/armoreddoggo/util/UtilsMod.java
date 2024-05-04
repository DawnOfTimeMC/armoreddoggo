package org.dawnoftime.armoreddoggo.util;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import javax.annotation.Nonnull;
import java.util.List;

import static org.dawnoftime.armoreddoggo.Constants.MOD_ID;

public class UtilsMod {

	public static final Component TOOLTIP_HOLD_SHIFT = Component.translatable("tooltip." + MOD_ID + ".hold_key").withStyle(ChatFormatting.GRAY).append(Component.translatable("tooltip." + MOD_ID + ".shift").withStyle(ChatFormatting.AQUA));

	public static void addTooltip(final List<Component> tooltip, @Nonnull final Item item, final String... tooltipNames) {
		final ResourceLocation itemName = BuiltInRegistries.ITEM.getKey(item);
		String[] tts = new String[tooltipNames.length + 1];
		System.arraycopy(tooltipNames, 0, tts, 0, tooltipNames.length);
		tts[tooltipNames.length] = itemName.getPath();
		UtilsMod.addTooltip(tooltip, tts);
	}

	public static void addTooltip(final List<Component> tooltip, final String... tooltipNames) {
		if (Screen.hasShiftDown()) {
			for (final String tooltipName : tooltipNames) {
				tooltip.add(Component.translatable("tooltip." + MOD_ID + "." + tooltipName).withStyle(ChatFormatting.GRAY));
			}
		} else {
			tooltip.add(UtilsMod.TOOLTIP_HOLD_SHIFT);
		}
	}
}