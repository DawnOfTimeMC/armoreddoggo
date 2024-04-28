package com.dotteam.dogwardrobe.set;

import static com.dotteam.dogwardrobe.DogWardrobe.MOD_ID;
import java.util.Optional;
import javax.annotation.Nonnull;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;

public abstract class ArmorSet {

    private final String name;

    public ArmorSet(String name) { this.name = name; }

    public String getName() { return this.name; }

    @OnlyIn(Dist.CLIENT)
    public ModelLayerLocation getLayerId(EquipmentSlot slot) {
        return new ModelLayerLocation(new ResourceLocation("minecraft:player"), this.name + "_" + slot.name().toLowerCase());
    }

    @OnlyIn(Dist.CLIENT)
    public abstract Model getModel(ModelPart root, LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel);

    @OnlyIn(Dist.CLIENT)
    public Optional<MeshDefinition> getMesh(EquipmentSlot slot) {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        return Optional.of(mesh);
    }

    @OnlyIn(Dist.CLIENT)
    public abstract LayerDefinition getLayer(MeshDefinition mesh, EquipmentSlot slot);

    @OnlyIn(Dist.CLIENT)
    public Model getModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel) {
        return this.getModel(Minecraft.getInstance().getEntityModels().bakeLayer(this.getLayerId(slot)), living, stack, slot, defaultModel);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        if (isSlimPlayerEntity(entity)) {
            return MOD_ID + ":textures/models/armor/" + this.name + "_slim.png";
        } else {
            return MOD_ID + ":textures/models/armor/" + this.name + ".png";
        }

    }

    @OnlyIn(Dist.CLIENT)
    public void registerMesh(EntityRenderersEvent.RegisterLayerDefinitions event) {
        for (EquipmentSlot slot : EquipmentSlot.values()) {

            this.getMesh(slot).ifPresent(mesh -> event.registerLayerDefinition(this.getLayerId(slot), () -> this.getLayer(mesh, slot)));
        }
    }

    /**
     * Checks if the entity in parameter has Alex model or not.
     * 
     * @param entity is the entity to study.
     * @return True if the entity has Alex model, False if it has Steve model.
     */
    protected boolean isSlimPlayerEntity(Entity entity) {
        return entity instanceof AbstractClientPlayer player && "slim".equals(player.getModelName());
    }

    @OnlyIn(Dist.CLIENT)
    public static class Model extends HumanoidModel<LivingEntity> {
        protected final EquipmentSlot slot;

        public Model(ModelPart root, EquipmentSlot slot) {
            super(root);
            this.slot = slot;
        }

        protected void setupArmorPartAnim(LivingEntity entity, float ageInTicks) {

        }

        @Override
        public void setupAnim(@Nonnull LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                float headPitch) {
            // Fix the "breathing" and wrong head rotation on ArmorStands
            if (entity instanceof ArmorStand entityAS) {
                float f = (float) Math.PI / 180F;
                this.head.xRot = f * entityAS.getHeadPose().getX();
                this.head.yRot = f * entityAS.getHeadPose().getY();
                this.head.zRot = f * entityAS.getHeadPose().getZ();
                this.body.xRot = f * entityAS.getBodyPose().getX();
                this.body.yRot = f * entityAS.getBodyPose().getY();
                this.body.zRot = f * entityAS.getBodyPose().getZ();
                this.leftArm.xRot = f * entityAS.getLeftArmPose().getX();
                this.leftArm.yRot = f * entityAS.getLeftArmPose().getY();
                this.leftArm.zRot = f * entityAS.getLeftArmPose().getZ();
                this.rightArm.xRot = f * entityAS.getRightArmPose().getX();
                this.rightArm.yRot = f * entityAS.getRightArmPose().getY();
                this.rightArm.zRot = f * entityAS.getRightArmPose().getZ();
                this.leftLeg.xRot = f * entityAS.getLeftLegPose().getX();
                this.leftLeg.yRot = f * entityAS.getLeftLegPose().getY();
                this.leftLeg.zRot = f * entityAS.getLeftLegPose().getZ();
                this.rightLeg.xRot = f * entityAS.getRightLegPose().getX();
                this.rightLeg.yRot = f * entityAS.getRightLegPose().getY();
                this.rightLeg.zRot = f * entityAS.getRightLegPose().getZ();
            } else {
                this.setupArmorPartAnim(entity, ageInTicks);
            }
        }

        public static float sinPI(float f) { return Mth.sin(f * (float) Math.PI); }

        public static float cosPI(float f) { return Mth.cos(f * (float) Math.PI); }
    }

}
