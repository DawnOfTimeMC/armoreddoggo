package org.dawnoftime.armoreddoggo.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Crackiness;
import net.minecraft.world.item.*;
import org.dawnoftime.armoreddoggo.client.DogArmorModelProvider;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

import static org.dawnoftime.armoreddoggo.Constants.MOD_ID;

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

	public @NotNull ResourceLocation getTexture(Crackiness.Level crack) {
		return this.modelProvider.getTexture(crack);
	}

	@Override
	public @NotNull ResourceLocation getTexture() {
		return this.getTexture(Crackiness.Level.NONE);
	}

	public ResourceLocation getOverlayTexture(Crackiness.Level crack) {
		return this.modelProvider.getOverlayTexture(crack);
	}

	@Override
	@Nullable
	public ResourceLocation getOverlayTexture() {
		return this.getOverlayTexture(Crackiness.Level.NONE);
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltips, @NotNull TooltipFlag flagIn) {
		super.appendHoverText(stack, context, tooltips, flagIn);
		tooltips.add(Component.translatable("tooltip." + MOD_ID + ".dog_armor").withStyle(ChatFormatting.GRAY));
	}
}
