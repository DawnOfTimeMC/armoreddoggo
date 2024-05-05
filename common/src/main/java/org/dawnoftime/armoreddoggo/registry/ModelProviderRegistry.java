package org.dawnoftime.armoreddoggo.registry;

import net.minecraft.client.model.geom.builders.LayerDefinition;
import org.dawnoftime.armoreddoggo.client.DogArmorModelProvider;
import org.dawnoftime.armoreddoggo.client.DogArmorModelSupplier;
import org.dawnoftime.armoreddoggo.client.models.RaijinDogArmorModel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
public class ModelProviderRegistry {

    public static final List<DogArmorModelProvider> REGISTRY = new ArrayList<>();

    public static final DogArmorModelProvider RAIJIN_DOG_ARMOR_MODEL_PROVIDER = register("raijin_dog_armor", RaijinDogArmorModel::createLayerDefinition, RaijinDogArmorModel::new);

    private static DogArmorModelProvider register(String armorName, Supplier<LayerDefinition> layerDefinition, DogArmorModelSupplier dogArmorModelSupplier){
        DogArmorModelProvider provider = new DogArmorModelProvider(armorName, layerDefinition, dogArmorModelSupplier);
        REGISTRY.add(provider);
        return provider;
    }
}
