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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.Crackiness;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
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
                ItemStack stack = wolf.getBodyArmorItem();
                if(stack.getItem() instanceof DogArmorItem dogArmorItem){
                    // If the wolf has a different armor, we change the model.
                    if(dogArmorItem.getModelProvider() != this.armoreddoggo$dogModelProvider){
                        this.armoreddoggo$dogModelProvider = dogArmorItem.getModelProvider();
                        this.armoreddoggo$uncoloredModel = this.armoreddoggo$dogModelProvider.createModel();
                    }
                    Crackiness.Level crack = Crackiness.WOLF_ARMOR.byDamage(stack);
                    // Now we will animate the models !
                    this.getParentModel().copyPropertiesTo(this.armoreddoggo$uncoloredModel);
                    this.armoreddoggo$uncoloredModel.prepareMobModel(wolf, limbSwing, limbSwingAmount, partialTicks);
                    this.armoreddoggo$uncoloredModel.setupAnim(wolf, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                    VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityTranslucent(dogArmorItem.getTexture(crack)));
                    this.armoreddoggo$uncoloredModel.renderToBuffer(poseStack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
                    if (stack.is(ItemTags.DYEABLE)) {
                        int colorARGB32 = DyedItemColor.getOrDefault(stack, 0);
                        ResourceLocation overlayTexture = dogArmorItem.getOverlayTexture(crack);
                        if (FastColor.ARGB32.alpha(colorARGB32) != 0 && overlayTexture != null) {
                            float red = (float)FastColor.ARGB32.red(colorARGB32) / 255.0F;
                            float green = (float)FastColor.ARGB32.green(colorARGB32) / 255.0F;
                            float blue = (float)FastColor.ARGB32.blue(colorARGB32) / 255.0F;
                            this.armoreddoggo$uncoloredModel.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityTranslucent(overlayTexture)), light, OverlayTexture.NO_OVERLAY, red, green, blue, 1.0F);
                        }
                    }
                    ci.cancel();
                }
            }
        }
    }
}