package org.dawnoftime.armoreddoggo.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.WolfModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Wolf;

import java.util.function.Supplier;

import static org.dawnoftime.armoreddoggo.Constants.MOD_ID;

public class DogArmorModelProvider {
    final Supplier<LayerDefinition> layerDefinitionSupplier;
    final DogArmorModelSupplier dogArmorModelSupplier;
    final ModelLayerLocation modelLayerLocation;
    final ResourceLocation modelResourceLocation;
    public DogArmorModelProvider(String armorName, Supplier<LayerDefinition> layerDefinitionSupplier, DogArmorModelSupplier modelSupplier){
        this.layerDefinitionSupplier = layerDefinitionSupplier;
        this.dogArmorModelSupplier = modelSupplier;
        this.modelLayerLocation = new ModelLayerLocation(new ResourceLocation("minecraft:wolf"), armorName);
        this.modelResourceLocation = new ResourceLocation(MOD_ID, "textures/models/armor/" + armorName + ".png");
    }

    public ResourceLocation getTexture() {
        return this.modelResourceLocation;
    }

    public ModelLayerLocation getLayerLocation() {
        return this.modelLayerLocation;
    }

    public LayerDefinition createLayer(){
        return this.layerDefinitionSupplier.get();
    }

    public WolfModel<Wolf> createModel(){
        return this.dogArmorModelSupplier.create(Minecraft.getInstance().getEntityModels().bakeLayer(this.modelLayerLocation));
    }
}