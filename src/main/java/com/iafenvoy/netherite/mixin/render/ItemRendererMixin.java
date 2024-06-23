package com.iafenvoy.netherite.mixin.render;

import com.iafenvoy.netherite.registry.NetheriteExtItems;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import static com.iafenvoy.netherite.NetheriteExtension.MOD_ID;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/BakedModelManager;getModel(Lnet/minecraft/client/util/ModelIdentifier;)Lnet/minecraft/client/render/model/BakedModel;", shift = At.Shift.BY, by = 2, ordinal = 0),
            index = 8, argsOnly = true)
    public BakedModel useNetheriteTridentModel(BakedModel value, ItemStack stack) {
        if (stack.isOf(NetheriteExtItems.NETHERITE_TRIDENT))
            return ((ItemRendererAccessor) this).netherite_ext$getModels().getModelManager().getModel(new ModelIdentifier(MOD_ID, "netherite_trident", "inventory"));
        return value;
    }

    @ModifyVariable(method = "getModel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemModels;getModel(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/client/render/model/BakedModel;", shift = At.Shift.BY, by = 2), index = 5)
    public BakedModel getHeldNetheriteTridentModel(BakedModel value, ItemStack stack) {
        if (stack.isOf(NetheriteExtItems.NETHERITE_TRIDENT))
            return ((ItemRendererAccessor) this).netherite_ext$getModels().getModelManager().getModel(new ModelIdentifier(MOD_ID, "netherite_trident_in_hand", "inventory"));
        return value;
    }
}
