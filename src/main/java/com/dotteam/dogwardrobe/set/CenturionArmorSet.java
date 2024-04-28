package com.dotteam.dogwardrobe.set;

import java.util.Optional;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class CenturionArmorSet extends ArmorSet {
	private LivingEntity living;

	public CenturionArmorSet(String id) { super(id); }

	@Override
	public Model getModel(ModelPart root, LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel) {
		this.living = living;
		return new Model(root, slot);
	}


	@Override
	public Optional<MeshDefinition> getMesh(EquipmentSlot slot) {
		MeshDefinition mesh = super.getMesh(slot).orElseThrow();
		PartDefinition root = mesh.getRoot();

		// Not working for now.
		// boolean isSteve = !isSlimPlayerEntity(living);
		boolean isSteve = false;

		switch (slot) {
			//@formatter:off
			case HEAD: {
				PartDefinition head = root.addOrReplaceChild("head",
						CubeListBuilder.create()
								.texOffs(0, 0).addBox(-4.5F, -8.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.25F))
								.texOffs(75, 0).addBox(-5.0F, -6.0F, -5.25F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
								.texOffs(24, 6).addBox(-1.0F, -14.25F, -2.75F, 2.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
								.texOffs(40, 17).addBox(-1.0F, -14.25F, -3.75F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
								.texOffs(0, 0).addBox(-1.0F, -14.25F, -3.75F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
								.texOffs(0, 59).addBox(-1.0F, -14.25F, -3.75F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 0.0F, 0.0F));
				head.addOrReplaceChild("jow",
						CubeListBuilder.create().texOffs(75, -4).addBox(4.65F, -26.0F, 4.75F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
								.addBox(-4.65F, -26.0F, 4.75F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.3927F, 0.0F, 0.0F));


				break;
			}
			case CHEST: {
				PartDefinition body = root.addOrReplaceChild("body",
						CubeListBuilder.create()
								.texOffs(0, 18).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.3F))
								.texOffs(0, 34).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.55F))
								.texOffs(0, 50).addBox(2.1768F, 5.8232F, -3.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 0.0F, 0.0F));

				body.addOrReplaceChild("chestBelt",
						CubeListBuilder.create()
								.texOffs(24, 29).addBox(0.0F, -1.0F, 0.0F, 2.0F, 10.0F, 5.0F, new CubeDeformation(0.2F)),
						PartPose.offsetAndRotation(-4.0F, 1.0F, -2.5F, 0.0F, 0.0F, -0.7854F));

				PartDefinition rightArm = root.addOrReplaceChild("right_arm",
						CubeListBuilder.create()
								.texOffs(19, 47).addBox(isSteve ? -3.5F : -2.5F, -2.5F, -2.5F, isSteve ? 5.0F : 4.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
								.texOffs(isSteve ? 39 : 37, 47).addBox(isSteve ? -3.5F : -2.5F, -2.5F, -2.5F, isSteve ? 5.0F : 4.0F, 12.0F, 5.0F, new CubeDeformation(0.25F)),
						PartPose.offset(-5.0F, 2.0F, 0.0F));


				rightArm.addOrReplaceChild("rightShoulder",
						CubeListBuilder.create()
								.texOffs(56, 17).addBox(isSteve ? -3.2726F : -2.2726F, -3.4043F, -3.0F, isSteve ? 5.0F : 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
								.texOffs(74, 11).addBox(0.0F, -3.5F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.25F)),
						PartPose.offset(-0.25F, -0.25F, 0.0F));

				PartDefinition leftArm = root.addOrReplaceChild("left_arm",
						CubeListBuilder.create()
								.texOffs(19, 47).addBox(-1.5F, -2.5F, -2.5F, isSteve ? 5.0F : 4.0F, 12.0F, 5.0F, new CubeDeformation(0.0F))
								.texOffs(isSteve ? 39 : 37, 47).addBox(-1.5F, -2.5F, -2.5F, isSteve ? 5.0F : 4.0F, 12.0F, 5.0F, new CubeDeformation(0.25F)),
						PartPose.offset(5.0F, 2.0F, 0.0F));

				leftArm.addOrReplaceChild("leftShoulder",
						CubeListBuilder.create()
								.texOffs(56, 17).addBox(-1.7274F, -3.4043F, -3.0F, isSteve ? 5.0F : 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
								.texOffs(74, 11).addBox(0.0F, -3.5F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.25F)),
						PartPose.offset(0.25F, -0.25F, 0.0F));


				// TODO add chestBreast for non-steve
				break;
			}

			case LEGS: {
				root.addOrReplaceChild("right_leg",
						CubeListBuilder.create()
								.texOffs(40, 0).addBox(-2.6F, 0.3F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
								.texOffs(60, 0).addBox(-2.6F, 0.25F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.15F)),
						PartPose.offset(-1.9F, 12.0F, 0.0F));

				root.addOrReplaceChild("left_leg",
						CubeListBuilder.create()
								.texOffs(40, 0).addBox(-2.4F, 0.3F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
								.texOffs(60, 0).addBox(-2.4F, 0.25F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.15F)),
						PartPose.offset(1.9F, 12.0F, 0.0F));
				break;
			}

			case FEET: {
				root.addOrReplaceChild("right_leg",
						CubeListBuilder.create()
								.texOffs(59, 48).addBox(-2.6F, 9.25F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.15F))
								.texOffs(59, 56).addBox(-2.6F, 9.3F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
						PartPose.offset(-1.9F, 12.0F, 0.0F));
				
				root.addOrReplaceChild("left_leg",
						CubeListBuilder.create()
								.texOffs(59, 48).addBox(-2.4F, 9.25F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.15F))
								.texOffs(59, 56).addBox(-2.4F, 9.3F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
						PartPose.offset(1.9F, 12.0F, 0.0F));
				break;
			}
			//@formatter:on
			default: {
				return Optional.empty();
			}
		}
		return Optional.of(mesh);
	}

	@Override
	public LayerDefinition getLayer(MeshDefinition mesh, EquipmentSlot slot) { return LayerDefinition.create(mesh, 128, 64); }
}