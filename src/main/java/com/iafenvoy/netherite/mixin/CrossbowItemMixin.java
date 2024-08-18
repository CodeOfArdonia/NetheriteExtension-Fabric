package com.iafenvoy.netherite.mixin;

import com.iafenvoy.netherite.config.NetheriteExtensionConfig;
import com.iafenvoy.netherite.registry.NetheriteExtItems;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CrossbowItem.class)
public class CrossbowItemMixin {
    @Inject(method = "getSpeed", at = @At("RETURN"), cancellable = true)
    private static void addCustomSpeed(ItemStack stack, CallbackInfoReturnable<Float> cir) {
        if (stack.isOf(NetheriteExtItems.NETHERITE_CROSSBOW))
            cir.setReturnValue((float) (cir.getReturnValue() * NetheriteExtensionConfig.getInstance().damage.crossbow_damage_multiplier + NetheriteExtensionConfig.getInstance().damage.crossbow_damage_addition));
    }
}
