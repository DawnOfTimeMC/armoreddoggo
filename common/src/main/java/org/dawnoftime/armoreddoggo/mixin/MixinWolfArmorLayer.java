package org.dawnoftime.armoreddoggo.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.WolfModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.layers.WolfArmorLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.animal.Wolf;
import org.dawnoftime.armoreddoggo.client.DogArmorModelProvider;
import org.dawnoftime.armoreddoggo.item.DogArmorItem;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WolfArmorLayer.class)
public abstract class MixinWolfArmorLayer extends RenderLayer<Wolf, WolfModel<Wolf>> {
    @Unique
    private DogArmorModelProvider armoreddoggo$dogModelProvider;
    //@Unique
    //private WolfModel<Wolf> armoreddoggo$coloredModel;
    @Unique
    private WolfModel<Wolf> armoreddoggo$uncoloredModel;

    public MixinWolfArmorLayer(RenderLayerParent<Wolf, WolfModel<Wolf>> parentLayer) {
        super(parentLayer);
    }

    /**
     * Since there is only one armor model in MC, they put the WoldArmorLayer directly in all wolf renderers in {@link WolfArmorLayer}#model, and renders it only if needed.
     * There are several models depending on the armor equipped in this mod. I will create my own model fields (colored and uncolored), and render them if one of this mod's item is equipped.
     * I will have to cancel {@link WolfArmorLayer}#model rendering in this case.<br>
     */
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void onRender(PoseStack poseStack, MultiBufferSource buffer, int light, Wolf pLivingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if(pLivingEntity instanceof Wolf wolf){
            if (wolf.hasArmor()) {
                if(wolf.getBodyArmorItem().getItem() instanceof DogArmorItem dogArmorItem){
                    // If the wolf has a different armor, we change the model.
                    if(dogArmorItem.getModelProvider() != this.armoreddoggo$dogModelProvider){
                        this.armoreddoggo$dogModelProvider = dogArmorItem.getModelProvider();
                        //this.armoreddoggo$coloredModel;
                        this.armoreddoggo$uncoloredModel = this.armoreddoggo$dogModelProvider.createModel();
                    }
                    // Now we will animate the models !
                    this.getParentModel().copyPropertiesTo(this.armoreddoggo$uncoloredModel);
                    this.armoreddoggo$uncoloredModel.prepareMobModel(wolf, limbSwing, limbSwingAmount, partialTicks);
                    this.armoreddoggo$uncoloredModel.setupAnim(wolf, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                    VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(dogArmorItem.getTexture()));
                    this.armoreddoggo$uncoloredModel.renderToBuffer(poseStack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
                    //this.maybeRenderColoredLayer(poseStack, buffer, light, itemstack, animalarmoritem);
                    //.maybeRenderCracks(poseStack, buffer, light, itemstack);
                    ci.cancel();
                }
            }
        }
    }
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