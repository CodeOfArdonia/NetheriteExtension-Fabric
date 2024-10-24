package com.iafenvoy.netherite.config;

import com.iafenvoy.netherite.NetheriteExtension;
import com.iafenvoy.netherite.network.LavaVisionUpdatePacket;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public final class NetheriteExtensionConfig {
    private static NetheriteExtensionConfig INSTANCE = null;
    public final AnvilConfigs anvil = new AnvilConfigs();
    public final DamageConfigs damage = new DamageConfigs();
    public final DurabilityConfigs durability = new DurabilityConfigs();
    public final GraphicsConfigs graphics = new GraphicsConfigs();

    public static NetheriteExtensionConfig getInstance() {
        if (INSTANCE == null) {
            INSTANCE = ConfigLoader.load(NetheriteExtensionConfig.class, "./config/netherite_ext/config.json", new NetheriteExtensionConfig());
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeDouble(INSTANCE.graphics.lava_vision_distance);
            for (ServerPlayerEntity player : NetheriteExtension.CONNECTED_CLIENTS)
                ServerPlayNetworking.send(player, LavaVisionUpdatePacket.ID, buf);
        }
        return INSTANCE;
    }

    public static class AnvilConfigs {
        private final double anvilConfigValue = ConfigJSONReader.GetConfigJsonData("anvil","xp_reduction");
        public final double xp_reduction = anvilConfigValue != -1.0? anvilConfigValue:0.5;
    }

    public static class DamageConfigs {

        private final double getBow_damage_addition = ConfigJSONReader.GetConfigJsonData("damage","bow_damage_addition");
        private final double getBow_damage_multiplier = ConfigJSONReader.GetConfigJsonData("damage","bow_damage_multiplier");
        private final double getCrossbow_damage_addition = ConfigJSONReader.GetConfigJsonData("damage","crossbow_damage_addition");
        private final double getCrossbow_damage_multiplier = ConfigJSONReader.GetConfigJsonData("damage","crossbow_damage_multiplier");
        private final double getTrident_damage_addition = ConfigJSONReader.GetConfigJsonData("damage","trident_damage_addition");
        private final double getTrident_damage_multiplier = ConfigJSONReader.GetConfigJsonData("damage","trident_damage_multiplier");
        private final int getElytra_armor_points = (int)ConfigJSONReader.GetConfigJsonData("damage","elytra_armor_points");
        public final double bow_damage_addition = getBow_damage_addition != -1.0?getBow_damage_addition:0.0;
        public final double bow_damage_multiplier = getBow_damage_multiplier != -1.0?getBow_damage_multiplier:1.0;
        public final double crossbow_damage_addition = getCrossbow_damage_addition != -1.0? getCrossbow_damage_addition:0.0;
        public final double crossbow_damage_multiplier = getCrossbow_damage_multiplier != -1.0?getCrossbow_damage_multiplier:1.0;
        public final double trident_damage_addition = getTrident_damage_addition != -1.0? getTrident_damage_addition:0.0;
        public final double trident_damage_multiplier = getTrident_damage_multiplier != -1.0?getTrident_damage_multiplier:1.0;
        public final int elytra_armor_points = getElytra_armor_points != -1?getElytra_armor_points:4;
    }

    public static class DurabilityConfigs {
        private final int  getBow = (int)ConfigJSONReader.GetConfigJsonData("durability","bow");
        private final int getCrossbow = (int)ConfigJSONReader.GetConfigJsonData("durability","crossbow");
        private final int getElytra = (int)ConfigJSONReader.GetConfigJsonData("durability","elytra");
        private final int getFishing_rod = (int)ConfigJSONReader.GetConfigJsonData("durability","fishing_rod");
        private final int getTrident = (int)ConfigJSONReader.GetConfigJsonData("durability","trident");
        private final int getShears = (int)ConfigJSONReader.GetConfigJsonData("durability","shears");
        public final int bow = getBow != -1?getBow:768;
        public final int crossbow = getCrossbow != -1?getCrossbow:562;
        public final int elytra = getElytra != -1?getElytra:864;
        public final int fishing_rod = getFishing_rod != -1? getFishing_rod:128;
        public final int trident = getTrident != -1?getTrident:500;
        public final int shears = getShears != -1?getShears:476;
    }

    public static class GraphicsConfigs {
        private final double getLava_vision_distance = ConfigJSONReader.GetConfigJsonData("graphics","lava_vision_distance");
        public final double lava_vision_distance = getLava_vision_distance != -1.0?getLava_vision_distance:0.25;
    }
}
