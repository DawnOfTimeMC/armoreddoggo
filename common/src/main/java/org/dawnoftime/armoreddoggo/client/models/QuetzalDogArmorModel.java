package org.dawnoftime.armoreddoggo.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Wolf;
import org.jetbrains.annotations.NotNull;

public class QuetzalDogArmorModel<T extends Wolf> extends DogArmorModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart leafCenter;
	private final ModelPart leafTopLeft;
	private final ModelPart leafMiddleLeft;
	private final ModelPart leafBottomLeft;
	private final ModelPart leafTopRight;
	private final ModelPart leafMiddleRight;
	private final ModelPart leafBottomRight;

	public QuetzalDogArmorModel(ModelPart root) {
		super(root);
		ModelPart realHead = root.getChild("head").getChild("real_head");
		this.leafCenter = realHead.getChild("leaf_r1");
		this.leafTopLeft = realHead.getChild("bone").getChild("leaf_r2");
		this.leafTopRight = realHead.getChild("bone4").getChild("leaf_r3");
		this.leafMiddleLeft = realHead.getChild("bone2").getChild("leaf_r4");
		this.leafMiddleRight = realHead.getChild("bone5").getChild("leaf_r5");
		this.leafBottomLeft = realHead.getChild("bone3").getChild("leaf_r6");
		this.leafBottomRight = realHead.getChild("bone6").getChild("leaf_r7");
	}

	@Override
	public DogArmorModel<Wolf> create(ModelPart root) {
		return new QuetzalDogArmorModel<>(root);
	}

	public static LayerDefinition createLayerDefinition() {
		MeshDefinition meshdefinition = templateLayerDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(-1.0F, 13.5F, -7.0F));

		PartDefinition real_head = head.addOrReplaceChild("real_head", CubeListBuilder.create().texOffs(0, 14).addBox(-2.5F, -3.5F, -2.5F, 7.0F, 7.0F, 4.0F, new CubeDeformation(-0.3F))
		.texOffs(49, 8).addBox(-0.5F, -0.001F, -5.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leaf_r1 = real_head.addOrReplaceChild("leaf_r1", CubeListBuilder.create().texOffs(28, 21).addBox(-1.5F, -7.0F, 0.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.0F, 0.25F, -0.3491F, 0.0F, 0.0F));

		PartDefinition bone = real_head.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, -3.0F, 0.25F, 0.0F, 0.0F, -0.4363F));

		PartDefinition leaf_r2 = bone.addOrReplaceChild("leaf_r2", CubeListBuilder.create().texOffs(34, 21).addBox(-1.5F, -6.0F, 0.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition bone4 = real_head.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -3.0F, 0.25F, 0.0F, 0.0F, 0.4363F));

		PartDefinition leaf_r3 = bone4.addOrReplaceChild("leaf_r3", CubeListBuilder.create().texOffs(34, 21).mirror().addBox(-1.5F, -6.0F, 0.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition bone2 = real_head.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, -2.0F, 0.25F, 0.0F, 0.0F, -1.1345F));

		PartDefinition leaf_r4 = bone2.addOrReplaceChild("leaf_r4", CubeListBuilder.create().texOffs(34, 27).addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition bone5 = real_head.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, -2.0F, 0.25F, 0.0F, 0.0F, 1.1345F));

		PartDefinition leaf_r5 = bone5.addOrReplaceChild("leaf_r5", CubeListBuilder.create().texOffs(34, 27).mirror().addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition bone3 = real_head.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.25F, 0.0F, 0.0F, -1.7453F));

		PartDefinition leaf_r6 = bone3.addOrReplaceChild("leaf_r6", CubeListBuilder.create().texOffs(28, 28).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition bone6 = real_head.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, 0.0F, 0.25F, 0.0F, 0.0F, 1.7453F));

		PartDefinition leaf_r7 = bone6.addOrReplaceChild("leaf_r7", CubeListBuilder.create().texOffs(28, 28).mirror().addBox(-1.5F, -4.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 3).addBox(-1.5F, 3.0F, 2.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(20, 21).mirror().addBox(0.0F, -1.0F, 3.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 14.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition fur_r1 = body.addOrReplaceChild("fur_r1", CubeListBuilder.create().texOffs(10, 20).addBox(0.0F, -3.5F, 0.0F, 0.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.5F, 3.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition fur_r2 = body.addOrReplaceChild("fur_r2", CubeListBuilder.create().texOffs(10, 20).mirror().addBox(0.0F, -3.5F, 0.0F, 0.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -0.5F, 3.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition back_r1 = body.addOrReplaceChild("back_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 1.0F, -2.0F, 7.0F, 4.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.5F, 0.75F, 3.75F, 0.0436F, 0.0F, 0.0F));

		PartDefinition back_r2 = body.addOrReplaceChild("back_r2", CubeListBuilder.create().texOffs(22, 14).addBox(-3.0F, 2.0F, -2.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, -4.0F, 3.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition back_r3 = body.addOrReplaceChild("back_r3", CubeListBuilder.create().texOffs(42, 0).addBox(-3.0F, 0.0F, -4.0F, 7.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -5.0F, 4.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition upper_body = partdefinition.addOrReplaceChild("upper_body", CubeListBuilder.create().texOffs(19, 1).addBox(-3.0F, -3.0F, -3.0F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.0F, 14.0F, -3.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition back_r4 = upper_body.addOrReplaceChild("back_r4", CubeListBuilder.create().texOffs(0, 6).addBox(-2.0F, 0.0F, -4.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -3.0F, 4.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition fur_r3 = upper_body.addOrReplaceChild("fur_r3", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, -3.5F, 0.0F, 0.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.5F, 4.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition fur_r4 = upper_body.addOrReplaceChild("fur_r4", CubeListBuilder.create().texOffs(0, 20).addBox(0.0F, -3.5F, 0.0F, 0.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 4.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition right_hind_leg = partdefinition.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(56, 14).addBox(0.0F, 3.0F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.2F))
		.texOffs(40, 29).addBox(0.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offset(-2.5F, 16.0F, 7.0F));

		PartDefinition left_hind_leg = partdefinition.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(50, 14).addBox(0.0F, 3.0F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.2F))
		.texOffs(40, 26).addBox(0.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offset(0.5F, 16.0F, 7.0F));

		PartDefinition right_front_leg = partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(44, 14).addBox(0.0F, 3.0F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.2F))
		.texOffs(40, 23).addBox(0.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offset(-2.5F, 16.0F, -4.0F));

		PartDefinition left_front_leg = partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(38, 14).addBox(0.0F, 3.0F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.2F))
		.texOffs(40, 20).addBox(0.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offset(0.5F, 16.0F, -4.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 12.0F, 8.0F, 0.6283F, 0.0F, 0.0F));

		PartDefinition real_tail = tail.addOrReplaceChild("real_tail", CubeListBuilder.create().texOffs(56, 18).addBox(-0.5F, 0.0F, 0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void prepareMobModel(@NotNull T wolf, float limbSwing, float limbSwingAmount, float partialTicks) {
		super.prepareMobModel(wolf, limbSwing, limbSwingAmount, partialTicks);
		float animationProgress = ((wolf.tickCount + partialTicks) / 120) % 1;
		this.leafCenter.xRot = -0.3491F + 0.1F * Mth.sin(animationProgress * 2 * Mth.PI);
		this.leafTopLeft.xRot = -0.48F + 0.1F * Mth.sin(animationProgress * 2 * Mth.PI);
		this.leafTopRight.xRot = -0.48F + 0.1F * Mth.sin(animationProgress * 2 * Mth.PI);
		this.leafMiddleLeft.xRot = -0.3491F + 0.1F * Mth.sin(animationProgress * 2 * Mth.PI);
		this.leafMiddleRight.xRot = -0.3491F + 0.1F * Mth.sin(animationProgress * 2 * Mth.PI);
		this.leafBottomLeft.xRot = -0.4363F + 0.1F * Mth.sin(animationProgress * 2 * Mth.PI);
		this.leafBottomRight.xRot = -0.4363F + 0.1F * Mth.sin(animationProgress * 2 * Mth.PI);
	}
}