package com.dotteam.dogwardrobe.item;

import java.util.function.Consumer;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;
import com.dotteam.dogwardrobe.set.ArmorSet;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Vanishable;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class HumanoidArmorItem extends ArmorItem implements Vanishable {

	private final ArmorSet set;

	public HumanoidArmorItem(ArmorSet set, ArmorMaterial material, Type slot) {
		super(material, slot, new Properties().stacksTo(1));
		this.set = set;
	}

	@Override
	public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return this.set.getArmorTexture(stack, entity, slot, type);
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel) {
				HumanoidModel<?> model = HumanoidArmorItem.this.set.getModel(living, stack, slot, defaultModel);
				model.young = living.isBaby();
				model.crouching = living.isShiftKeyDown();
				model.riding = defaultModel.riding;
				return model;
			}
		});
	}

	@Override
	public EquipmentSlot getEquipmentSlot(ItemStack stackIn) {
		if(stackIn.getItem() instanceof HumanoidArmorItem) {
			return this.getType().getSlot();
		}

		return null;
	}

	@Override
	public int getMaxDamage(ItemStack stackIn) {
		return this.material.getDurabilityForType(this.type);
	}

}
