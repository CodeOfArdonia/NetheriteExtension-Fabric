package com.iafenvoy.netherite.registry;

import com.iafenvoy.netherite.NetheriteExtension;
import com.iafenvoy.netherite.block.NetheriteShulkerBoxBlock;
import com.iafenvoy.netherite.config.NetheriteExtensionConfig;
import com.iafenvoy.netherite.item.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.block.dispenser.ShearsDispenserBehavior;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public final class NetheriteExtItems {
    public static final Item.Settings NETHERITE_SHULKER_BOX_ITEM_SETTINGS = new Item.Settings().maxCount(1).fireproof();
    public static final CauldronBehavior CLEAN_NETHERITE_BOX = (state, world, pos, player, hand, stack) -> {
        Block block = Block.getBlockFromItem(stack.getItem());
        if (!(block instanceof NetheriteShulkerBoxBlock)) return ActionResult.PASS;
        else {
            if (!world.isClient) {
                ItemStack itemStack = new ItemStack(NetheriteExtBlocks.NETHERITE_SHULKER_BOX);
                if (stack.hasNbt()) itemStack.setNbt(stack.getOrCreateNbt().copy());
                player.setStackInHand(hand, itemStack);
                player.incrementStat(Stats.CLEAN_SHULKER_BOX);
                LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
            }
            return ActionResult.success(world.isClient);
        }
    };
    public static Item NETHERITE_ELYTRA = register(new Identifier(NetheriteExtension.MOD_ID, "netherite_elytra"), new NetheriteElytraItem(new Item.Settings().maxDamage(NetheriteExtensionConfig.getInstance().durability.elytra).rarity(Rarity.UNCOMMON).fireproof()));
    public static Item NETHERITE_FISHING_ROD = register(new Identifier(NetheriteExtension.MOD_ID, "netherite_fishing_rod"), new NetheriteFishingRodItem(new Item.Settings().maxDamage(NetheriteExtensionConfig.getInstance().durability.fishing_rod).fireproof()));
    public static Item NETHERITE_BOW = register(new Identifier(NetheriteExtension.MOD_ID, "netherite_bow"), new NetheriteBowItem(new Item.Settings().maxDamage(NetheriteExtensionConfig.getInstance().durability.bow).fireproof()));
    public static Item NETHERITE_CROSSBOW = register(new Identifier(NetheriteExtension.MOD_ID, "netherite_crossbow"), new CrossbowItem(new Item.Settings().maxDamage(NetheriteExtensionConfig.getInstance().durability.crossbow).fireproof()));
    public static Item NETHERITE_TRIDENT = register(new Identifier(NetheriteExtension.MOD_ID, "netherite_trident"), new NetheriteTridentItem(new Item.Settings().maxDamage(NetheriteExtensionConfig.getInstance().durability.trident).fireproof()));
    public static Item NETHERITE_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_WHITE_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_WHITE_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_WHITE_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_ORANGE_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_ORANGE_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_ORANGE_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_MAGENTA_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_MAGENTA_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_MAGENTA_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_LIGHT_BLUE_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_LIGHT_BLUE_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_LIGHT_BLUE_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_YELLOW_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_YELLOW_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_YELLOW_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_LIME_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_LIME_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_LIME_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_PINK_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_PINK_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_PINK_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_GRAY_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_GRAY_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_GRAY_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_LIGHT_GRAY_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_LIGHT_GRAY_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_LIGHT_GRAY_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_CYAN_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_CYAN_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_CYAN_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_PURPLE_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_PURPLE_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_PURPLE_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_BLUE_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_BLUE_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_BLUE_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_BROWN_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_BROWN_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_BROWN_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_GREEN_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_GREEN_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_GREEN_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_RED_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_RED_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_RED_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_BLACK_SHULKER_BOX = register(NetheriteExtBlocks.NETHERITE_BLACK_SHULKER_BOX, new BlockItem(NetheriteExtBlocks.NETHERITE_BLACK_SHULKER_BOX, NETHERITE_SHULKER_BOX_ITEM_SETTINGS));
    public static Item NETHERITE_BEACON = register(NetheriteExtBlocks.NETHERITE_BEACON, new BlockItem(NetheriteExtBlocks.NETHERITE_BEACON, new Item.Settings().maxCount(64).fireproof()));
    public static Item NETHERITE_HORSE_ARMOR = register(new Identifier(NetheriteExtension.MOD_ID, "netherite_horse_armor"), new NetheriteHorseArmorItem(15, new Item.Settings().maxCount(1).fireproof()));
    public static Item FAKE_NETHERITE_BLOCK = register(NetheriteExtBlocks.FAKE_NETHERITE_BLOCK, new BlockItem(NetheriteExtBlocks.FAKE_NETHERITE_BLOCK, new Item.Settings().fireproof()));
    public static Item NETHERITE_ANVIL_ITEM = register(NetheriteExtBlocks.NETHERITE_ANVIL_BLOCK, new BlockItem(NetheriteExtBlocks.NETHERITE_ANVIL_BLOCK, new Item.Settings().fireproof()));
    public static Item NETHERITE_SHEARS = register(new Identifier(NetheriteExtension.MOD_ID, "netherite_shears"), new ShearsItem(new Item.Settings().fireproof().maxDamage(NetheriteExtensionConfig.getInstance().durability.shears)));

    private static Item register(Block block, BlockItem item) {
        if (block instanceof NetheriteShulkerBoxBlock)
            CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(item, CLEAN_NETHERITE_BOX);
        return register(Registries.BLOCK.getId(block), item);
    }

    private static Item register(Identifier id, Item item) {
        if (item instanceof BlockItem blockItem) blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        return Registry.register(Registries.ITEM, id, item);
    }

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.PINK_SHULKER_BOX, NETHERITE_SHULKER_BOX, NETHERITE_WHITE_SHULKER_BOX, NETHERITE_LIGHT_GRAY_SHULKER_BOX, NETHERITE_GRAY_SHULKER_BOX, NETHERITE_BLACK_SHULKER_BOX, NETHERITE_BROWN_SHULKER_BOX, NETHERITE_RED_SHULKER_BOX, NETHERITE_ORANGE_SHULKER_BOX, NETHERITE_YELLOW_SHULKER_BOX, NETHERITE_LIME_SHULKER_BOX, NETHERITE_GREEN_SHULKER_BOX, NETHERITE_CYAN_SHULKER_BOX, NETHERITE_LIGHT_BLUE_SHULKER_BOX, NETHERITE_BLUE_SHULKER_BOX, NETHERITE_PURPLE_SHULKER_BOX, NETHERITE_MAGENTA_SHULKER_BOX, NETHERITE_PINK_SHULKER_BOX);
            entries.addAfter(Items.DAMAGED_ANVIL, NETHERITE_ANVIL_ITEM);
            entries.addAfter(Items.BEACON, NETHERITE_BEACON);
            entries.addAfter(Items.SHEARS, NETHERITE_SHEARS);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.addAfter(Items.PINK_SHULKER_BOX, NETHERITE_SHULKER_BOX, NETHERITE_WHITE_SHULKER_BOX, NETHERITE_LIGHT_GRAY_SHULKER_BOX, NETHERITE_GRAY_SHULKER_BOX, NETHERITE_BLACK_SHULKER_BOX, NETHERITE_BROWN_SHULKER_BOX, NETHERITE_RED_SHULKER_BOX, NETHERITE_ORANGE_SHULKER_BOX, NETHERITE_YELLOW_SHULKER_BOX, NETHERITE_LIME_SHULKER_BOX, NETHERITE_GREEN_SHULKER_BOX, NETHERITE_CYAN_SHULKER_BOX, NETHERITE_LIGHT_BLUE_SHULKER_BOX, NETHERITE_BLUE_SHULKER_BOX, NETHERITE_PURPLE_SHULKER_BOX, NETHERITE_MAGENTA_SHULKER_BOX, NETHERITE_PINK_SHULKER_BOX);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries1 -> {
            entries1.addAfter(Items.ELYTRA, NETHERITE_ELYTRA);
            entries1.addAfter(Items.FISHING_ROD, NETHERITE_FISHING_ROD);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries1 -> {
            entries1.addAfter(Items.BOW, NETHERITE_BOW);
            entries1.addAfter(Items.CROSSBOW, NETHERITE_CROSSBOW);
            entries1.addAfter(Items.DIAMOND_HORSE_ARMOR, NETHERITE_HORSE_ARMOR);
            entries1.addAfter(Items.TRIDENT, NETHERITE_TRIDENT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addBefore(Items.IRON_BLOCK, FAKE_NETHERITE_BLOCK);
        });
        DispenserBlock.registerBehavior(NETHERITE_SHEARS, new ShearsDispenserBehavior());
    }
}
