package org.dawnoftime.armoreddoggo.set;
// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ModelArmorDogRaijin<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "modelarmordograijin"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart mane;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;

	public ModelArmorDogRaijin(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.mane = root.getChild("mane");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(-1.0F, 13.5F, -7.0F));

		PartDefinition headHornLeftC_r1 = head.addOrReplaceChild("headHornLeftC_r1", CubeListBuilder.create().texOffs(4, 25).mirror().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.75F, -2.134F, -1.683F, 0.0F, 0.0F, -0.3927F));

		PartDefinition headHornRightC_r1 = head.addOrReplaceChild("headHornRightC_r1", CubeListBuilder.create().texOffs(4, 25).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, -2.134F, -1.683F, 0.0F, 0.0F, 0.3927F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 6).addBox(-4.0F, -1.75F, 0.0F, 8.0F, 3.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offset(0.0F, 14.0F, 2.0F));

		PartDefinition body_rotation = body.addOrReplaceChild("body_rotation", CubeListBuilder.create().texOffs(22, 15).addBox(-3.0F, 1.0F, -3.0F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.1F))
		.texOffs(0, 12).addBox(-3.5F, -2.25F, -0.5F, 7.0F, 7.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition headHornLeftA3 = body_rotation.addOrReplaceChild("headHornLeftA3", CubeListBuilder.create().texOffs(22, 19).addBox(-0.5F, -2.884F, 0.067F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.75F, 3.0F, -2.618F, 0.0F, 0.0F));

		PartDefinition mane = partdefinition.addOrReplaceChild("mane", CubeListBuilder.create(), PartPose.offset(-1.0F, 14.0F, 2.0F));

		PartDefinition mane_rotation = mane.addOrReplaceChild("mane_rotation", CubeListBuilder.create().texOffs(18, 12).addBox(-4.0F, -1.5F, -0.5F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.1F))
		.texOffs(22, 0).addBox(-4.5F, -5.0F, 1.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(-0.2F))
		.texOffs(0, 0).addBox(-5.0F, -2.5F, 0.25F, 10.0F, 3.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(1.0F, 2.5F, -2.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition chestScarfFront_r1 = mane_rotation.addOrReplaceChild("chestScarfFront_r1", CubeListBuilder.create().texOffs(49, 18).addBox(-2.4221F, -13.3005F, -1.4812F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.5F, 0.5F, 0.0F, 0.0F, 0.0F));

		PartDefinition headHornLeftA = mane_rotation.addOrReplaceChild("headHornLeftA", CubeListBuilder.create().texOffs(0, 23).addBox(-0.5F, -1.884F, 0.067F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 6.5F, -1.6144F, 0.0F, 0.0F));

		PartDefinition headHornRightB = headHornLeftA.addOrReplaceChild("headHornRightB", CubeListBuilder.create().texOffs(8, 23).addBox(-0.5F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.116F, 0.067F, -1.2217F, 0.0F, 0.0F));

		PartDefinition headHornRightC = headHornLeftA.addOrReplaceChild("headHornRightC", CubeListBuilder.create().texOffs(4, 23).addBox(-0.5F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.116F, 0.067F, 1.0472F, 0.0F, 0.0F));

		PartDefinition headHornRightD = headHornLeftA.addOrReplaceChild("headHornRightD", CubeListBuilder.create().texOffs(12, 23).addBox(-0.5F, -6.3498F, 0.0391F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.116F, 0.067F, -0.5236F, 0.0F, 0.0F));

		PartDefinition headHornLeftA2 = mane_rotation.addOrReplaceChild("headHornLeftA2", CubeListBuilder.create().texOffs(16, 23).addBox(-0.5F, -1.884F, 0.067F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 6.5F, -2.138F, 0.0F, 0.0F));

		PartDefinition headHornRightB2 = headHornLeftA2.addOrReplaceChild("headHornRightB2", CubeListBuilder.create().texOffs(20, 23).addBox(-0.5F, -3.9284F, -2.2981F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.116F, 0.067F, -0.8727F, 0.0F, 0.0F));

		PartDefinition headHornRightD2 = headHornLeftA2.addOrReplaceChild("headHornRightD2", CubeListBuilder.create().texOffs(24, 23).addBox(-0.5F, -5.9068F, 0.3616F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.116F, 0.067F, -0.2182F, 0.0F, 0.0F));

		PartDefinition chestScarfLeftA = mane_rotation.addOrReplaceChild("chestScarfLeftA", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.4221F, -5.3005F, -0.4812F, 0.0F, 1.1345F, 0.0F));

		PartDefinition chestScarfTopRight_r1 = chestScarfLeftA.addOrReplaceChild("chestScarfTopRight_r1", CubeListBuilder.create().texOffs(49, 18).addBox(-7.4221F, -13.3005F, -1.4812F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4221F, 12.8005F, 0.9812F, 0.0F, 0.0F, 0.0F));

		PartDefinition bone = chestScarfLeftA.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(50, 12).mirror().addBox(-0.5779F, 0.0505F, -0.5188F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition chestScarfLeftB = bone.addOrReplaceChild("chestScarfLeftB", CubeListBuilder.create().texOffs(40, 12).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0176F, 4.9222F, 0.1054F, -0.8788F, 1.185F, -1.5534F));

		PartDefinition chestScarfLeftC = chestScarfLeftB.addOrReplaceChild("chestScarfLeftC", CubeListBuilder.create().texOffs(44, 12).mirror().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -2.2818F, 0.8634F, -1.6786F));

		PartDefinition chestScarfRightA = mane_rotation.addOrReplaceChild("chestScarfRightA", CubeListBuilder.create(), PartPose.offsetAndRotation(2.4221F, -5.3005F, -0.4812F, 0.0F, -1.1345F, 0.0F));

		PartDefinition chestScarfTopLeft_r1 = chestScarfRightA.addOrReplaceChild("chestScarfTopLeft_r1", CubeListBuilder.create().texOffs(49, 18).mirror().addBox(2.4221F, -13.3005F, -1.4812F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.4221F, 12.8005F, 0.9812F, 0.0F, 0.0F, 0.0F));

		PartDefinition bone2 = chestScarfRightA.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(50, 12).addBox(-0.4221F, 0.0505F, -0.5188F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition chestScarfRightB = bone2.addOrReplaceChild("chestScarfRightB", CubeListBuilder.create().texOffs(40, 12).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0176F, 4.9222F, 0.1054F, -0.8788F, -1.185F, 1.5534F));

		PartDefinition chestScarfRightC = chestScarfRightB.addOrReplaceChild("chestScarfRightC", CubeListBuilder.create().texOffs(44, 12).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -2.2818F, -0.8634F, 1.6786F));

		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(54, 0).mirror().addBox(-1.0F, 4.0F, -12.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false)
		.texOffs(46, 0).mirror().addBox(-1.0F, 6.0F, -12.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(-1.5F, 16.0F, 7.0F));

		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(46, 0).addBox(0.0F, 6.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.1F))
		.texOffs(54, 0).addBox(0.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offset(0.5F, 16.0F, 7.0F));

		PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(54, 0).mirror().addBox(0.0F, 4.0F, 10.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false)
		.texOffs(54, 0).mirror().addBox(0.0F, 6.0F, 10.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(-2.5F, 16.0F, -4.0F));

		PartDefinition leg4 = partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(46, 0).addBox(0.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.1F))
		.texOffs(54, 0).addBox(0.0F, 6.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offset(0.5F, 16.0F, -4.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mane.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}