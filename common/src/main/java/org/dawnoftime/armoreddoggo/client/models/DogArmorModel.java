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

import java.util.NoSuchElementException;

public abstract class DogArmorModel<T extends Wolf> extends WolfModel<T> implements DogArmorModelSupplier {
    protected final ModelPart head;
    protected final ModelPart realHead;
    protected final ModelPart body;
    protected final ModelPart upperBody;
    protected final ModelPart rightHindLeg;
    protected final ModelPart leftHindLeg;
    protected final ModelPart rightFrontLeg;
    protected final ModelPart leftFrontLeg;
    protected final ModelPart tail;
    protected final ModelPart realTail;

    public DogArmorModel(ModelPart root) {
        super(root);
        try {
            this.head = root.getChild("head");
            this.realHead = this.head.getChild("real_head");
            this.body = root.getChild("body");
            this.upperBody = root.getChild("upper_body");
            this.rightHindLeg = root.getChild("right_hind_leg");
            this.leftHindLeg = root.getChild("left_hind_leg");
            this.rightFrontLeg = root.getChild("right_front_leg");
            this.leftFrontLeg = root.getChild("left_front_leg");
            this.tail = root.getChild("tail");
            this.realTail = this.tail.getChild("real_tail");
        } catch (NoSuchElementException e) {
            Constants.LOG.error("Impossible to find one of the Vanilla Wolf ModelPart. Either this model was modified, or you probably forgot to call DogArmorModel.templateLayerDefinition() to get the MeshDefinition of the model.");
            throw new RuntimeException(e);
        }
    }

    /**
     * This function must be called before adding the parts in the other models !!!
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
}
