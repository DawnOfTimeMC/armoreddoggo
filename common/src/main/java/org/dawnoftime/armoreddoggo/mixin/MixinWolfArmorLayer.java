package org.dawnoftime.armoreddoggo.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderLayer.class)
public abstract class MixinWolfArmorLayer<T extends Entity, M extends EntityModel<T>> {
    /*
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void onRender(PoseStack poseStack, MultiBufferSource buffer, int light, T pLivingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if(pLivingEntity instanceof Wolf wolf){
            if (wolf.hasArmor()) {
                System.out.println("It works !!!!!");

                ItemStack itemstack = wolf.getBodyArmorItem();
                if (itemstack.getItem() instanceof AnimalArmorItem animalarmoritem && animalarmoritem.getBodyType() == AnimalArmorItem.BodyType.CANINE) {


                this.getParentModel().copyPropertiesTo(this.model);
                this.model.prepareMobModel(wolf, limbSwing, limbSwingAmount, partialTicks);
                this.model.setupAnim(wolf, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(animalarmoritem.getTexture()));
                this.model.renderToBuffer(poseStack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
                this.maybeRenderColoredLayer(poseStack, buffer, light, itemstack, animalarmoritem);
                this.maybeRenderCracks(poseStack, buffer, light, itemstack);
                return;
                }
            }
        }
    }
    */
}

/* TODO
 * Insérer du code entre la ligne 55 et 56, se concluant par un return pour éviter l'execution de la suite.
 * Pour réussir à charger le model, il faut obtenir l'item stack de l'armure avec :
 *      ItemStack itemstack = pLivingEntity.getItemBySlot(EquipmentSlot.CHEST);
 * Ensuite, on regarde si itemstack#getItem() est instance de ma class WolfArmorItem().
 * Si oui, on caste et on récupère le nouveau model avec une fonction getModel() définie dans WorlArmorItem().
 * On applique les proprités de l'ancien model au nouveau comme dans ClientHooks.copyModelProperties(original, replacement).
 * A voir si les fonctions suivantes doivent être inclues :
 *      - WolfArmorLayer#maybeRenderColoredLayer(...)
 *      - WolfArmorLayer#maybeRenderCracks(...)
 * Ensuite on return pour finir l'exécution de la fonction.
 */