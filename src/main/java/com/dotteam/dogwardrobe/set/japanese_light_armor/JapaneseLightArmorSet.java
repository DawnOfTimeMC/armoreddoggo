package com.dotteam.dogwardrobe.set.japanese_light_armor;

import com.dotteam.dogwardrobe.set.ArmorSet;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

public class JapaneseLightArmorSet extends ArmorSet {

    public JapaneseLightArmorSet(String id) {
        super(id);
    }

    @Override
    public Model getModel(ModelPart root, LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel) {
        return switch(slot) {
            case HEAD -> new HeadModel(root, slot);
            default -> new Model(root, slot);
        };
    }

    @Override
    public Optional<MeshDefinition> getMesh(EquipmentSlot slot) {
        MeshDefinition mesh = super.getMesh(slot).orElseThrow();
        PartDefinition root = mesh.getRoot();

        if(slot == EquipmentSlot.HEAD) {
            PartDefinition head = root.addOrReplaceChild(
                    "head",
                    CubeListBuilder.create()
                            .texOffs(26, 16).addBox(-4.0F, -6.5F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.4F)),
                    PartPose.offset(0.0F, 0.0F, 0.0F));
            head.addOrReplaceChild(
                    "knotBase",
                    CubeListBuilder.create()
                            .texOffs(56, 9).addBox(2.9F, -4.9F, 3.7F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.4F)),
                    PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.785F));
            head.addOrReplaceChild(
                    "ribbonA",
                    CubeListBuilder.create()
                            .texOffs(56, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
                    PartPose.offsetAndRotation(0.0F, -5.0F, 4.2F, 0.35F, 0.0F, 0.0F));
            head.addOrReplaceChild(
                    "ribbonB",
                    CubeListBuilder.create()
                            .texOffs(60, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
                    PartPose.offsetAndRotation(0.0F, -5.0F, 4.2F, 0.175F, 0.0F, 0.0F));
        } else if(slot == EquipmentSlot.CHEST) {
            //TODO: add chest mesh
        } else {
            return Optional.empty();
        }

        return Optional.of(mesh);
    }

    @Override
    public LayerDefinition getLayer(MeshDefinition mesh, EquipmentSlot slot) {
        return LayerDefinition.create(mesh, 64, 32);
    }

    public static class HeadModel extends Model {
        private final ModelPart ribbonA;
        private final ModelPart ribbonB;

        public HeadModel(ModelPart root, EquipmentSlot slot) {
            super(root, slot);
            this.ribbonA = root.getChild("head").getChild("ribbonA");
            this.ribbonB = root.getChild("head").getChild("ribbonB");
        }

        @Override
        protected void setupArmorPartAnim(LivingEntity entity, float ageInTicks) {
            float f = 0.3F * sinPI(ageInTicks / 60.0F + 1.0F) + Math.abs(this.rightLeg.xRot);
            this.ribbonA.xRot = Math.max(0.35F + f * 0.15F - this.head.xRot, 0.2F);
            this.ribbonA.zRot = -0.1F + f * 0.2F;
            this.ribbonB.xRot = Math.max(0.175F + f * 0.1F - this.head.xRot, 0.075F);
            this.ribbonB.zRot = -f * 0.2F;
        }
    }

}
