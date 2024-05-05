package org.dawnoftime.armoreddoggo.item;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import org.dawnoftime.armoreddoggo.UtilsMod;
import org.dawnoftime.armoreddoggo.client.DogArmorModelProvider;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.system.NativeType;

import java.util.List;

public class DogArmorItem extends AnimalArmorItem {

	private final DogArmorModelProvider modelProvider;

	/**
	 * Constructor to create a new DogArmorItem
	 * @param modelProvider Class that contains the model generator, the texture and layerLocation.
	 * @param material Material that defines the item used to repair the armor.
	 * @param durabilityFactor Factor that defines the number of HP that the armor has. This factor is multiplied by 16. Vanilla armor has a factor 4 for a total of 64 durability.
	 */
	public DogArmorItem(DogArmorModelProvider modelProvider, Holder<ArmorMaterial> material, int durabilityFactor) {
		super(material, AnimalArmorItem.BodyType.CANINE, false, new Item.Properties().durability(ArmorItem.Type.BODY.getDurability(durabilityFactor)));
		this.modelProvider = modelProvider;
	}

	public @NotNull DogArmorModelProvider getModelProvider(){
		return this.modelProvider;
	}

	@Override
	public @NotNull ResourceLocation getTexture() {
		return this.modelProvider.getTexture();
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, TooltipContext context, @NotNull List<Component> tooltips, @NotNull TooltipFlag flagIn) {
		super.appendHoverText(stack, context, tooltips, flagIn);
		UtilsMod.addTooltip(tooltips, this);
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
}
