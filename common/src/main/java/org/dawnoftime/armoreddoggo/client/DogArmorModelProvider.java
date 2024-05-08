package org.dawnoftime.armoreddoggo.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.WolfModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Crackiness;
import net.minecraft.world.entity.animal.Wolf;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.Supplier;

import static org.dawnoftime.armoreddoggo.Constants.MOD_ID;

// Client side
public class DogArmorModelProvider {
    final Supplier<LayerDefinition> layerDefinitionSupplier;
    final DogArmorModelSupplier dogArmorModelSupplier;
    final ModelLayerLocation modelLayerLocation;
    final Map<Crackiness.Level, ResourceLocation> textureResourceLocations;
    final Map<Crackiness.Level, ResourceLocation> overlayResourceLocations;

    public DogArmorModelProvider(String armorName, Supplier<LayerDefinition> layerDefinitionSupplier, DogArmorModelSupplier modelSupplier){
        this.layerDefinitionSupplier = layerDefinitionSupplier;
        this.dogArmorModelSupplier = modelSupplier;
        this.modelLayerLocation = new ModelLayerLocation(new ResourceLocation("minecraft:wolf"), armorName);
        this.textureResourceLocations = Map.of(
                Crackiness.Level.NONE, new ResourceLocation(MOD_ID, "textures/models/armor/" + armorName + ".png"),
                Crackiness.Level.LOW, new ResourceLocation(MOD_ID, "textures/models/armor/" + armorName + "_low.png"),
                Crackiness.Level.MEDIUM, new ResourceLocation(MOD_ID, "textures/models/armor/" + armorName + "_medium.png"),
                Crackiness.Level.HIGH, new ResourceLocation(MOD_ID, "textures/models/armor/" + armorName + "_high.png"));
        this.overlayResourceLocations = Map.of(
                Crackiness.Level.NONE, new ResourceLocation(MOD_ID, "textures/models/armor/" + armorName + "_overlay.png"),
                Crackiness.Level.LOW, new ResourceLocation(MOD_ID, "textures/models/armor/" + armorName + "_low_overlay.png"),
                Crackiness.Level.MEDIUM, new ResourceLocation(MOD_ID, "textures/models/armor/" + armorName + "_medium_overlay.png"),
                Crackiness.Level.HIGH, new ResourceLocation(MOD_ID, "textures/models/armor/" + armorName + "_high_overlay.png"));
    }

    @NotNull
    public ResourceLocation getTexture(Crackiness.Level crack) {
        return this.textureResourceLocations.get(crack);
    }

    @NotNull
    public ResourceLocation getOverlayTexture(Crackiness.Level crack) {
        return this.overlayResourceLocations.get(crack);
    }

    @NotNull
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