package org.dawnoftime.armoreddoggo;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.dawnoftime.armoreddoggo.item.DogArmorItem;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static org.dawnoftime.armoreddoggo.ItemModRegistry.ITEMS;

public class LootTableModifier {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Constants.MOD_ID);
    private static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<AddItemsModifier>> MINESHAFT_LOOT = GLOBAL_LOOT_MODIFIER.register("armored_doggo_loot", AddItemsModifier.CODEC);

    private static class AddItemsModifier extends LootModifier {
        public static final Supplier<MapCodec<LootTableModifier.AddItemsModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(inst -> codecStart(inst)
                .and(ExtraCodecs.POSITIVE_FLOAT.optionalFieldOf("loot_probability", 0.5F).forGetter(p -> p.probability))
                .apply(inst, LootTableModifier.AddItemsModifier::new)));
        private final float probability;

        public AddItemsModifier(LootItemCondition[] conditionsIn, float loot_probability) {
            super(conditionsIn);
            this.probability = loot_probability;
        }

        @Override
        protected @NotNull ObjectArrayList<ItemStack> doApply(@NotNull ObjectArrayList<ItemStack> generatedLoot, @NotNull LootContext context) {
            ITEMS.getEntries().stream().map((DeferredHolder::get)).filter((item) -> item instanceof DogArmorItem).map(Item::getDefaultInstance).forEach(generatedLoot::add);
            return generatedLoot;
        }

        @Override
        public @NotNull MapCodec<? extends IGlobalLootModifier> codec() {
            return CODEC.get();
        }
    }
}
