package com.iafenvoy.netherite.config;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigJSONReader {
    public static double GetConfigJsonData(String configType,String configValue) {
        try {
            double durability = 0.0;
            String content = new String(Files.readAllBytes(Paths.get("./config/netherite_ext/config.json")));

            JsonObject jsonObject = JsonParser.parseString(content).getAsJsonObject();

            durability = jsonObject.getAsJsonObject(configType).get(configValue).getAsDouble();
            return durability;

        } catch (Exception e) {
            return -1.0;
        }
    }
}
