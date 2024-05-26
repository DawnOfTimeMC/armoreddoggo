package org.dawnoftime.armoreddoggo.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String modID) {
        super(output, registries, modID);
    }

    @Override
    protected void start() {
        this.add("dog_armors_from_mineshaft",new LootTableModifier.AddItemsModifier(new LootItemCondition[]{
            new LootTableIdCondition.Builder(new ResourceLocation("minecraft:chests/abandoned_mineshaft")).build()
        }, 0.5F));
    }
}
