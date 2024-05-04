package org.dawnoftime.armoreddoggo.item;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import org.dawnoftime.armoreddoggo.util.UtilsMod;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class WolfArmorItem extends AnimalArmorItem {
	public WolfArmorItem(Holder<ArmorMaterial> material, Item.Properties properties) {
		super(material, AnimalArmorItem.BodyType.CANINE, false, properties);
	}

	/*
	@Override
	public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Override
			public @NotNull Model getGenericArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				return IClientItemExtensions.super.getGenericArmorModel(livingEntity, itemStack, equipmentSlot, original);
			}

			@Override
			public @NotNull HumanoidModel<?> getHumanoidArmorModel(@NotNull LivingEntity living, @NotNull ItemStack stack, @NotNull EquipmentSlot slot, @NotNull HumanoidModel<?> defaultModel) {
				HumanoidModel<?> model = WolfArmorItem.this.set.getModel(living, stack, slot, defaultModel);
				model.young = living.isBaby();
				model.crouching = living.isShiftKeyDown();
				model.riding = defaultModel.riding;
				return model;
			}
		});
	}
	*/

	@Override
	public void appendHoverText(@NotNull ItemStack stack, TooltipContext context, @NotNull List<Component> tooltips, @NotNull TooltipFlag flagIn) {
		super.appendHoverText(stack, context, tooltips, flagIn);
		UtilsMod.addTooltip(tooltips, this);
	}
}
