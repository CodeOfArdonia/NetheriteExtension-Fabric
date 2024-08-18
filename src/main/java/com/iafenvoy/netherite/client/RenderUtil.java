package com.iafenvoy.netherite.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.*;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;

public class RenderUtil {
//    public static void fill(MatrixStack matrices, RenderLayer layer, int x1, int y1, int x2, int y2, int z, int color) {
//        Matrix4f matrix4f = matrices.peek().getPositionMatrix();
//        int i;
//        if (x1 < x2) {
//            i = x1;
//            x1 = x2;
//            x2 = i;
//        }
//
//        if (y1 < y2) {
//            i = y1;
//            y1 = y2;
//            y2 = i;
//        }
//
//        float f = (float) ColorHelper.Argb.getAlpha(color) / 255.0F;
//        float g = (float) ColorHelper.Argb.getRed(color) / 255.0F;
//        float h = (float) ColorHelper.Argb.getGreen(color) / 255.0F;
//        float j = (float) ColorHelper.Argb.getBlue(color) / 255.0F;
//        VertexConsumer vertexConsumer = this.vertexConsumers.getBuffer(layer);
//        vertexConsumer.vertex(matrix4f, (float)x1, (float)y1, (float)z).color(g, h, j, f).next();
//        vertexConsumer.vertex(matrix4f, (float)x1, (float)y2, (float)z).color(g, h, j, f).next();
//        vertexConsumer.vertex(matrix4f, (float)x2, (float)y2, (float)z).color(g, h, j, f).next();
//        vertexConsumer.vertex(matrix4f, (float)x2, (float)y1, (float)z).color(g, h, j, f).next();
//        this.tryDraw();
//    }

    public static void drawSprite(MatrixStack matrices, int x, int y, int z, int width, int height, Sprite sprite) {
        drawTexture(matrices, sprite.getAtlasId(), x, x + width, y, y + height, z, sprite.getMinU(), sprite.getMaxU(), sprite.getMinV(), sprite.getMaxV());
    }

    public static void drawTexture(MatrixStack matrices, Identifier texture, int x, int y, int u, int v, int width, int height) {
        drawTexture(matrices, texture, x, y, 0, (float) u, (float) v, width, height, 256, 256);
    }

    public static void drawTexture(MatrixStack matrices, Identifier texture, int x, int y, int z, float u, float v, int width, int height, int textureWidth, int textureHeight) {
        drawTexture(matrices, texture, x, x + width, y, y + height, z, width, height, u, v, textureWidth, textureHeight);
    }

    public static void drawTexture(MatrixStack matrices, Identifier texture, int x, int y, int width, int height, float u, float v, int regionWidth, int regionHeight, int textureWidth, int textureHeight) {
        drawTexture(matrices, texture, x, x + width, y, y + height, 0, regionWidth, regionHeight, u, v, textureWidth, textureHeight);
    }

    public static void drawTexture(MatrixStack matrices, Identifier texture, int x, int y, float u, float v, int width, int height, int textureWidth, int textureHeight) {
        drawTexture(matrices, texture, x, y, width, height, u, v, width, height, textureWidth, textureHeight);
    }

    public static void drawTexture(MatrixStack matrices, Identifier texture, int x1, int x2, int y1, int y2, int z, int regionWidth, int regionHeight, float u, float v, int textureWidth, int textureHeight) {
        drawTexture(matrices, texture, x1, x2, y1, y2, z, (u + 0.0F) / (float) textureWidth, (u + (float) regionWidth) / (float) textureWidth, (v + 0.0F) / (float) textureHeight, (v + (float) regionHeight) / (float) textureHeight);
    }

    public static void drawTexture(MatrixStack matrices, Identifier texture, int x1, int x2, int y1, int y2, int z, float u1, float u2, float v1, float v2) {
        RenderSystem.setShaderTexture(0, texture);
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        Matrix4f matrix4f = matrices.peek().getPositionMatrix();
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
        bufferBuilder.vertex(matrix4f, (float) x1, (float) y1, (float) z).texture(u1, v1).next();
        bufferBuilder.vertex(matrix4f, (float) x1, (float) y2, (float) z).texture(u1, v2).next();
        bufferBuilder.vertex(matrix4f, (float) x2, (float) y2, (float) z).texture(u2, v2).next();
        bufferBuilder.vertex(matrix4f, (float) x2, (float) y1, (float) z).texture(u2, v1).next();
        BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());
    }
}
