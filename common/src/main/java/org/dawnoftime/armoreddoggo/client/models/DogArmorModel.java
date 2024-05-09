package org.dawnoftime.armoreddoggo.client.models;

import net.minecraft.client.model.WolfModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.animal.Wolf;
import org.dawnoftime.armoreddoggo.Constants;
import org.dawnoftime.armoreddoggo.client.DogArmorModelSupplier;
import org.jetbrains.annotations.NotNull;

import java.util.NoSuchElementException;

public abstract class DogArmorModel<T extends Wolf> extends WolfModel<T> implements DogArmorModelSupplier {

    public DogArmorModel(ModelPart root) {
        super(root);
    }

    /**
     * This function must be called before adding the parts in the other models !!!
     *
     * @return A minimal mesh with all the part of the wolf model and their appropriate rotation positions.
     */
    public static MeshDefinition templateLayerDefinition() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(-1.0F, 13.5F, -7.0F));
        head.addOrReplaceChild("real_head", CubeListBuilder.create(), PartPose.ZERO);
        root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 14.0F, 2.0F, (float) (Math.PI / 2), 0.0F, 0.0F));
        root.addOrReplaceChild("upper_body", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 14.0F, -3.0F, (float) (Math.PI / 2), 0.0F, 0.0F));
        CubeListBuilder leg = CubeListBuilder.create();
        root.addOrReplaceChild("right_hind_leg", leg, PartPose.offset(-2.5F, 16.0F, 7.0F));
        root.addOrReplaceChild("right_front_leg", leg, PartPose.offset(-2.5F, 16.0F, -4.0F));
        root.addOrReplaceChild("left_hind_leg", leg, PartPose.offset(0.5F, 16.0F, 7.0F));
        root.addOrReplaceChild("left_front_leg", leg, PartPose.offset(0.5F, 16.0F, -4.0F));
        PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 12.0F, 8.0F, (float) (Math.PI / 5), 0.0F, 0.0F));
        tail.addOrReplaceChild("real_tail", CubeListBuilder.create(), PartPose.ZERO);
        return mesh;
    }

    /**
     * Be careful ! Minecraft's devs decided to pass the angle of the tail in the field "ageInTicks" instead of the actual ageInTicks.
     * To get the actual ageInTicks, you have to use wolf#tickCount + partialTicks (which is not accessible in this function ^^).
     * Use the function {@link DogArmorModel#prepareMobModel} instead.
     */
    @Deprecated
    @Override
    public void setupAnim(@NotNull T wolf, float limbSwing, float limbSwingAmount, float tailRotation, float netHeadYaw, float headPitch) {
        super.setupAnim(wolf, limbSwing, limbSwingAmount, tailRotation, netHeadYaw, headPitch);
    }

    /**
     * Override this function to animate the model.
     */
    @Override
    public void prepareMobModel(@NotNull T wolf, float limbSwing, float limbSwingAmount, float partialTicks) {
        super.prepareMobModel(wolf, limbSwing, limbSwingAmount, partialTicks);
    }
}
