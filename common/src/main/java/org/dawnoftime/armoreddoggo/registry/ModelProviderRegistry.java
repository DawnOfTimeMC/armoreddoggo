package org.dawnoftime.armoreddoggo.registry;

import net.minecraft.client.model.geom.builders.LayerDefinition;
import org.dawnoftime.armoreddoggo.client.DogArmorModelProvider;
import org.dawnoftime.armoreddoggo.client.DogArmorModelSupplier;
import org.dawnoftime.armoreddoggo.client.models.HolyDogArmorModel;
import org.dawnoftime.armoreddoggo.client.models.QuetzalDogArmorModel;
import org.dawnoftime.armoreddoggo.client.models.RaijinDogArmorModel;

import java.util.HashMap;
import java.util.function.Supplier;

import static org.dawnoftime.armoreddoggo.Constants.*;

// Client side
public class ModelProviderRegistry {

    public static final HashMap<String, DogArmorModelProvider> REGISTRY = new HashMap<>();
    static {
        register(RAIJIN_DOG_ARMOR_NAME, RaijinDogArmorModel::createLayerDefinition, RaijinDogArmorModel::new);
        register(HOLY_DOG_ARMOR_NAME, HolyDogArmorModel::createLayerDefinition, HolyDogArmorModel::new);
        register(QUETZAL_DOG_ARMOR_NAME, QuetzalDogArmorModel::createLayerDefinition, QuetzalDogArmorModel::new);
    }

    private static void register(String armorName, Supplier<LayerDefinition> layerDefinition, DogArmorModelSupplier dogArmorModelSupplier){
        DogArmorModelProvider provider = new DogArmorModelProvider(armorName, layerDefinition, dogArmorModelSupplier);
        REGISTRY.put(armorName, provider);
    }
}
