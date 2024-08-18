package com.iafenvoy.netherite.registry;

import com.iafenvoy.netherite.NetheriteExtension;
import com.iafenvoy.netherite.block.NetheriteAnvilBlock;
import com.iafenvoy.netherite.block.NetheriteBeaconBlock;
import com.iafenvoy.netherite.block.NetheriteShulkerBoxBlock;
import com.iafenvoy.netherite.block.entity.NetheriteBeaconBlockEntity;
import com.iafenvoy.netherite.block.entity.NetheriteShulkerBoxBlockEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class NetheriteExtBlocks {
    public static Block NETHERITE_SHULKER_BOX = register("netherite_shulker_box", createShulkerBoxBlock(null, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.GRAY)));
    public static Block NETHERITE_WHITE_SHULKER_BOX = register("netherite_white_shulker_box", createShulkerBoxBlock(DyeColor.WHITE, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.WHITE)));
    public static Block NETHERITE_ORANGE_SHULKER_BOX = register("netherite_orange_shulker_box", createShulkerBoxBlock(DyeColor.ORANGE, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.ORANGE)));
    public static Block NETHERITE_MAGENTA_SHULKER_BOX = register("netherite_magenta_shulker_box", createShulkerBoxBlock(DyeColor.MAGENTA, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.MAGENTA)));
    public static Block NETHERITE_LIGHT_BLUE_SHULKER_BOX = register("netherite_light_blue_shulker_box", createShulkerBoxBlock(DyeColor.LIGHT_BLUE, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.LIGHT_BLUE)));
    public static Block NETHERITE_YELLOW_SHULKER_BOX = register("netherite_yellow_shulker_box", createShulkerBoxBlock(DyeColor.YELLOW, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.YELLOW)));
    public static Block NETHERITE_LIME_SHULKER_BOX = register("netherite_lime_shulker_box", createShulkerBoxBlock(DyeColor.LIME, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.LIME)));
    public static Block NETHERITE_PINK_SHULKER_BOX = register("netherite_pink_shulker_box", createShulkerBoxBlock(DyeColor.PINK, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.PINK)));
    public static Block NETHERITE_GRAY_SHULKER_BOX = register("netherite_gray_shulker_box", createShulkerBoxBlock(DyeColor.GRAY, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.GRAY)));
    public static Block NETHERITE_LIGHT_GRAY_SHULKER_BOX = register("netherite_light_gray_shulker_box", createShulkerBoxBlock(DyeColor.LIGHT_GRAY, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.LIGHT_GRAY)));
    public static Block NETHERITE_CYAN_SHULKER_BOX = register("netherite_cyan_shulker_box", createShulkerBoxBlock(DyeColor.CYAN, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.CYAN)));
    public static Block NETHERITE_PURPLE_SHULKER_BOX = register("netherite_purple_shulker_box", createShulkerBoxBlock(DyeColor.PURPLE, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.PURPLE)));
    public static Block NETHERITE_BLUE_SHULKER_BOX = register("netherite_blue_shulker_box", createShulkerBoxBlock(DyeColor.BLUE, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.BLUE)));
    public static Block NETHERITE_BROWN_SHULKER_BOX = register("netherite_brown_shulker_box", createShulkerBoxBlock(DyeColor.BROWN, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.BROWN)));
    public static Block NETHERITE_GREEN_SHULKER_BOX = register("netherite_green_shulker_box", createShulkerBoxBlock(DyeColor.GREEN, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.GREEN)));
    public static Block NETHERITE_RED_SHULKER_BOX = register("netherite_red_shulker_box", createShulkerBoxBlock(DyeColor.RED, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.RED)));
    public static Block NETHERITE_BLACK_SHULKER_BOX = register("netherite_black_shulker_box", createShulkerBoxBlock(DyeColor.BLACK, AbstractBlock.Settings.copy(Blocks.SHULKER_BOX).mapColor(MapColor.BLACK)));

    public static Block FAKE_NETHERITE_BLOCK = register("fake_netherite_block", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).mapColor(MapColor.BLACK).sounds(BlockSoundGroup.NETHERITE)));

    public static Block NETHERITE_ANVIL_BLOCK = register("netherite_anvil", new NetheriteAnvilBlock(AbstractBlock.Settings.copy(Blocks.ANVIL)));

    public static Block NETHERITE_BEACON = register("netherite_beacon", new NetheriteBeaconBlock(AbstractBlock.Settings.copy(Blocks.BEACON)));

    private static Block register(String id, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(NetheriteExtension.MOD_ID, id), block);
    }

    public static BlockEntityType<NetheriteShulkerBoxBlockEntity> NETHERITE_SHULKER_BOX_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(NetheriteExtension.MOD_ID, "netherite_shulker_box"), BlockEntityType.Builder.create(NetheriteShulkerBoxBlockEntity::new,
                    NETHERITE_SHULKER_BOX, NETHERITE_BLACK_SHULKER_BOX, NETHERITE_BLUE_SHULKER_BOX, NETHERITE_BROWN_SHULKER_BOX, NETHERITE_CYAN_SHULKER_BOX, NETHERITE_GRAY_SHULKER_BOX, NETHERITE_GREEN_SHULKER_BOX, NETHERITE_LIGHT_BLUE_SHULKER_BOX, NETHERITE_LIGHT_GRAY_SHULKER_BOX, NETHERITE_LIME_SHULKER_BOX, NETHERITE_MAGENTA_SHULKER_BOX, NETHERITE_ORANGE_SHULKER_BOX, NETHERITE_PINK_SHULKER_BOX, NETHERITE_PURPLE_SHULKER_BOX, NETHERITE_RED_SHULKER_BOX, NETHERITE_WHITE_SHULKER_BOX, NETHERITE_YELLOW_SHULKER_BOX)
            .build(null));

    private static NetheriteShulkerBoxBlock createShulkerBoxBlock(DyeColor color, AbstractBlock.Settings settings) {
        AbstractBlock.ContextPredicate contextPredicate = (state, world, pos) -> {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            return !(blockEntity instanceof NetheriteShulkerBoxBlockEntity shulkerBoxBlockEntity) || shulkerBoxBlockEntity.suffocates();
        };
        return new NetheriteShulkerBoxBlock(color, settings.strength(2.0F)
                .resistance(1200.0F)
                .dynamicBounds()
                .nonOpaque()
                .suffocates(contextPredicate)
                .blockVision(contextPredicate)
                .solidBlock(Blocks::always)
        );
    }

    public static BlockEntityType<NetheriteBeaconBlockEntity> NETHERITE_BEACON_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(NetheriteExtension.MOD_ID, "netherite_beacon"), BlockEntityType.Builder.create(NetheriteBeaconBlockEntity::new, NETHERITE_BEACON).build(null));


}
