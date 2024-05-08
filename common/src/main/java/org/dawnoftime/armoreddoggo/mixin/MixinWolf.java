package org.dawnoftime.armoreddoggo.mixin;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.VariantHolder;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.WolfVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.dawnoftime.armoreddoggo.Constants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Wolf.class)
public abstract class MixinWolf extends TamableAnimal implements NeutralMob, VariantHolder<Holder<WolfVariant>> {
    protected MixinWolf(EntityType<? extends TamableAnimal> type, Level level) {
        super(type, level);
    }
    /**
    Minecraft code is hideous and doesn't even check if the armor can be repaired with armadillo for example.
    I will clean this up : if the wolf has an armor, we check if the item in hand can repair it or if we must drop the armor.
    If the wolf doesn't have an armor and the item in hand is and armor, we equip the wolf with the armor.
    In each case, we return SUCCESS.
     */
    @Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
    private void onMobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {

        Constants.LOG.info("Interact with wolf !");
        if(!this.level().isClientSide() && !this.isBaby() && this.isTame() && this.isOwnedBy(player)) {
            ItemStack stack = player.getItemInHand(hand);
            Item item = stack.getItem();
            if(!this.getBodyArmorItem().isEmpty()){
                // The doggo has an armor !
                ItemStack armorStack = this.getBodyArmorItem();
                if(stack.is(Items.SHEARS) && (!EnchantmentHelper.hasBindingCurse(armorStack) || player.isCreative())){
                    // We must drop it if the player has SHEARS in hand.
                    stack.hurtAndBreak(1, player, getSlotForHand(hand));
                    this.playSound(SoundEvents.ARMOR_UNEQUIP_WOLF);
                    this.setBodyArmorItem(ItemStack.EMPTY);
                    this.spawnAtLocation(armorStack);
                    cir.setReturnValue(InteractionResult.SUCCESS);
                }else if(this.isInSittingPose() && armorStack.isDamaged() && armorStack.getItem() instanceof AnimalArmorItem armorItem){
                    if(armorItem.getMaterial().value().repairIngredient().get().test(stack)){
                        // We must repair the armor since the wolf is sitting and the repair material is in hand.
                        stack.shrink(1);
                        this.playSound(SoundEvents.WOLF_ARMOR_REPAIR);
                        armorStack.setDamageValue(Math.max(0, armorStack.getDamageValue() - (int)((float)armorStack.getMaxDamage() * 0.125F)));
                        cir.setReturnValue(InteractionResult.SUCCESS);
                    }
                }
            }else if (item instanceof AnimalArmorItem animalArmorItem){
                // The doggo doesn't have an armor. We try to give in our armor.
                if(animalArmorItem.getBodyType() == AnimalArmorItem.BodyType.CANINE){
                    this.setBodyArmorItem(stack.copyWithCount(1));
                    stack.consume(1, player);
                    cir.setReturnValue(InteractionResult.SUCCESS);
                }
            }
        }
    }
}