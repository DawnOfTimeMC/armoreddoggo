package org.dawnoftime.armoreddoggo.client.models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Wolf;
import org.jetbrains.annotations.NotNull;

public class HolyDogArmorModel<T extends Wolf> extends DogArmorModel<T> {
	protected final ModelPart ring;
	protected final ModelPart bigRightWing;
	protected final ModelPart bigLeftWing;
	protected final ModelPart rightFrontWing;
	protected final ModelPart rightBackWing;
	protected final ModelPart leftFrontWing;
	protected final ModelPart leftBackWing;
	public HolyDogArmorModel(ModelPart root) {
		super(root);
		this.ring = root.getChild("body").getChild("ring_holder").getChild("ring");
		this.bigRightWing = root.getChild("upper_body").getChild("wingRight");
		this.bigLeftWing = root.getChild("upper_body").getChild("wingLeft");
		this.rightFrontWing = root.getChild("right_front_leg").getChild("right_front_wing");
		this.rightBackWing = root.getChild("right_hind_leg").getChild("right_hind_wing");
		this.leftFrontWing = root.getChild("left_front_leg").getChild("left_front_wing");
		this.leftBackWing = root.getChild("left_hind_leg").getChild("left_hind_wing");
	}

	@Override
	public DogArmorModel<Wolf> create(ModelPart root) {
		return new HolyDogArmorModel<>(root);
	}

	public static LayerDefinition createLayerDefinition() {
		MeshDefinition meshdefinition = templateLayerDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition real_head = partdefinition.getChild("head").addOrReplaceChild("real_head", CubeListBuilder.create()
					.texOffs(0, 12).addBox(-2.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F))
					.texOffs(0, 15).addBox(2.0F, -5.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.1F))
					.texOffs(0, 0).addBox(-2.5F, -3.5F, -2.5F, 7.0F, 7.0F, 5.0F, new CubeDeformation(-0.3F)),
				PartPose.ZERO);

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create()
					.texOffs(0, 12).addBox(-3.0F, 3.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.3F))
					.texOffs(24, 13).addBox(-3.F, 0.6F, -2.11F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)),
				PartPose.offsetAndRotation(0.0F, 14.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition armor_r1 = body.addOrReplaceChild("armor_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-3.0F, 0.1F, -4.65F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -2.0F, 3.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition ringHolder = body.addOrReplaceChild("ring_holder", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.0F, 5.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition ring = ringHolder.addOrReplaceChild("ring", CubeListBuilder.create().texOffs(47, 0).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
		PartDefinition subring = ring.addOrReplaceChild("subring", CubeListBuilder.create().texOffs(47, 0).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition upper_body = partdefinition.addOrReplaceChild("upper_body", CubeListBuilder.create()
					.texOffs(24, 0).addBox(-3.0F, -3.0F, -3.0F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.1F))
					.texOffs(0, 30).addBox(-3.5F, -1.0F, 1.0F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)),
				PartPose.offsetAndRotation(-1.0F, 14.0F, -3.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition wingRight = upper_body.addOrReplaceChild("wingRight", CubeListBuilder.create().texOffs(54, 9).addBox(0.0F, -2.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4F, -0.5F, 1.5F, 0.5236F, 0.0F, 0.1309F));

		PartDefinition wingLeft = upper_body.addOrReplaceChild("wingLeft", CubeListBuilder.create().texOffs(54, 3).mirror().addBox(0.0F, -2.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.4F, -0.5F, 1.5F, 0.5236F, 0.0F, -0.1309F));

		PartDefinition right_hind_leg = partdefinition.addOrReplaceChild("right_hind_leg", CubeListBuilder.create()
					.texOffs(46, 20).addBox(0.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F))
					.texOffs(28, 28).mirror().addBox(0.0F, 6.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false)
					.texOffs(52, 20).addBox(-0.75F, 6.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)),
				PartPose.offset(-2.5F, 16.0F, 7.0F));
		PartDefinition wingRight3 = right_hind_leg.addOrReplaceChild("right_hind_wing", CubeListBuilder.create().texOffs(48, 12).addBox(0.0F, -1.0F, -0.75F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 6.75F, 0.0F, 0.2182F, -0.1309F, 0.0F));

		PartDefinition left_hind_leg = partdefinition.addOrReplaceChild("left_hind_leg", CubeListBuilder.create()
					.texOffs(38, 20).addBox(0.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F))
					.texOffs(44, 28).addBox(0.0F, 6.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.3F))
					.texOffs(36, 20).mirror().addBox(1.75F, 6.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false),
				PartPose.offset(0.5F, 16.0F, 7.0F));
		PartDefinition wingLeft3 = left_hind_leg.addOrReplaceChild("left_hind_wing", CubeListBuilder.create().texOffs(48, 10).mirror().addBox(0.0F, -1.0F, -0.75F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 6.75F, 0.0F, 0.2182F, 0.1309F, 0.0F));

		PartDefinition right_front_leg = partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create()
					.texOffs(54, 20).addBox(0.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F))
					.texOffs(20, 28).mirror().addBox(0.0F, 6.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)).mirror(false)
					.texOffs(28, 20).addBox(-0.75F, 6.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)),
				PartPose.offset(-2.5F, 16.0F, -4.0F));
		PartDefinition wingRight2 = right_front_leg.addOrReplaceChild("right_front_wing", CubeListBuilder.create().texOffs(42, 10).addBox(0.0F, -1.0F, -0.75F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 6.75F, 0.0F, 0.2182F, -0.1309F, 0.0F));

		PartDefinition left_front_leg = partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create()
					.texOffs(30, 20).addBox(0.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F))
					.texOffs(36, 28).addBox(0.0F, 6.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.3F))
					.texOffs(44, 20).mirror().addBox(1.75F, 6.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false),
				PartPose.offset(0.5F, 16.0F, -4.0F));
		PartDefinition wingLeft2 = left_front_leg.addOrReplaceChild("left_front_wing", CubeListBuilder.create().texOffs(42, 12).mirror().addBox(0.0F, -1.0F, -0.75F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 6.75F, 0.0F, 0.2182F, 0.1309F, 0.0F));

		PartDefinition real_tail = partdefinition.getChild("tail").addOrReplaceChild("real_tail", CubeListBuilder.create().texOffs(22, 20).addBox(0.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.ZERO);

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void prepareMobModel(@NotNull T wolf, float limbSwing, float limbSwingAmount, float partialTicks) {
		super.prepareMobModel(wolf, limbSwing, limbSwingAmount, partialTicks);
		float ageInTicks = wolf.tickCount + partialTicks;
		float animationProgress = (ageInTicks / 60) % 1;
		this.ring.zRot = ((ageInTicks / 160) % 1) * 2 * Mth.PI;
		this.bigRightWing.xRot = 0.5236F + 0.2F * Mth.sin(animationProgress * 2 * Mth.PI);
		this.bigLeftWing.xRot = 0.5236F + 0.2F * Mth.sin(animationProgress * 2 * Mth.PI);
		this.rightBackWing.xRot = 0.2182F + 0.1F * Mth.sin(animationProgress * 2 * Mth.PI);
		this.rightFrontWing.xRot = 0.2182F + 0.1F * Mth.sin(animationProgress * 2 * Mth.PI);
		this.leftBackWing.xRot = 0.2182F + 0.1F * Mth.sin(animationProgress * 2 * Mth.PI);
		this.leftFrontWing.xRot = 0.2182F + 0.1F * Mth.sin(animationProgress * 2 * Mth.PI);
	}
}