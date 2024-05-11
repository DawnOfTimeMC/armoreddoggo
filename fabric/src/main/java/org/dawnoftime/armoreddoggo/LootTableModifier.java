package org.dawnoftime.armoreddoggo;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.dawnoftime.armoreddoggo.ItemModRegistry;
import org.dawnoftime.armoreddoggo.item.DogArmorItem;

public class LootTableModifier {

    private static final ResourceLocation REWARD_COMMON = new ResourceLocation("minecraft", "chests/abandoned_mineshaft");

    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if(REWARD_COMMON.equals(key.location())){
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.5F));
                tableBuilder.pool(addAllArmors(poolBuilder).build());
            }
        });
    }

    private static LootPool.Builder addAllArmors(LootPool.Builder builder){
        for (Item item : ItemModRegistry.ITEMS) {
            if(item instanceof DogArmorItem){
                builder = builder.add(LootItem.lootTableItem(item));
            }
        }
        return builder;
    }
}
