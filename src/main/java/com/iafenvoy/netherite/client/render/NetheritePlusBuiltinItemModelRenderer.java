package com.iafenvoy.netherite.client.render;

import com.iafenvoy.netherite.NetheriteExtension;
import com.iafenvoy.netherite.block.NetheriteShulkerBoxBlock;
import com.iafenvoy.netherite.block.entity.NetheriteShulkerBoxBlockEntity;
import com.iafenvoy.netherite.registry.NetheriteExtBlocks;
import com.iafenvoy.netherite.registry.NetheriteExtItems;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.Arrays;
import java.util.Comparator;

public class NetheritePlusBuiltinItemModelRenderer implements SimpleSynchronousResourceReloadListener {
    private static final NetheriteShulkerBoxBlockEntity RENDER_NETHERITE_SHULKER_BOX = new NetheriteShulkerBoxBlockEntity(BlockPos.ORIGIN, NetheriteExtBlocks.NETHERITE_SHULKER_BOX.getDefaultState());
    private static final NetheriteShulkerBoxBlockEntity[] RENDER_NETHERITE_SHULKER_BOX_DYED = Arrays.stream(DyeColor.values()).sorted(Comparator.comparingInt(DyeColor::getId)).map(dyeColor -> new NetheriteShulkerBoxBlockEntity(dyeColor, BlockPos.ORIGIN, NetheriteExtBlocks.NETHERITE_SHULKER_BOX.getDefaultState())).toArray(NetheriteShulkerBoxBlockEntity[]::new);
    private final EntityModelLoader entityModelLoader;
    private final BlockEntityRenderDispatcher blockEntityRenderDispatcher;
    private TridentEntityModel modelTrident;

    public NetheritePlusBuiltinItemModelRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher, EntityModelLoader entityModelLoader) {
        this.blockEntityRenderDispatcher = blockEntityRenderDispatcher;
        this.entityModelLoader = entityModelLoader;
    }

    public static void renderTrident(TridentEntityModel model, ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer2 = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, model.getLayer(new Identifier(NetheriteExtension.MOD_ID, "textures/" + (mode == ModelTransformationMode.GUI ? "item" : "entity") + "/netherite_trident.png")), false, stack.hasGlint());
        model.render(matrices, vertexConsumer2, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }

    @Override
    public void reload(ResourceManager manager) {
        this.modelTrident = new TridentEntityModel(this.entityModelLoader.getModelPart(EntityModelLayers.TRIDENT));
    }

    public void render(ItemStack itemStack, ModelTransformationMode transformType, MatrixStack matrices, VertexConsumerProvider vertices, int light, int overlay) {
        if (itemStack.isOf(NetheriteExtItems.NETHERITE_TRIDENT))
            renderTrident(this.modelTrident, itemStack, transformType, matrices, vertices, light, overlay);
        else if (itemStack.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof NetheriteShulkerBoxBlock block) {
            NetheriteShulkerBoxBlockEntity entity;
            DyeColor dyecolor = block.getColor();
            if (dyecolor == null) entity = RENDER_NETHERITE_SHULKER_BOX;
            else entity = RENDER_NETHERITE_SHULKER_BOX_DYED[dyecolor.getId()];
            this.blockEntityRenderDispatcher.renderEntity(entity, matrices, vertices, light, overlay);
        }
    }

    @Override
    public Identifier getFabricId() {
        return new Identifier(NetheriteExtension.MOD_ID, "netherite_ext_builtin_item_model_reloader");
    }
}
