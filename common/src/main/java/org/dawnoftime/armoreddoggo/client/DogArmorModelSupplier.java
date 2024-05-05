package org.dawnoftime.armoreddoggo.client;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.animal.Wolf;
import org.dawnoftime.armoreddoggo.client.models.DogArmorModel;

public interface DogArmorModelSupplier {
    DogArmorModel<Wolf> create(ModelPart root);
}