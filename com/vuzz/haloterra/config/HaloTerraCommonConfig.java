package com.vuzz.haloterra.config;

import java.util.ArrayList;
import net.minecraftforge.common.ForgeConfigSpec;

public class HaloTerraCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.ConfigValue<ArrayList<ArrayList<String>>> RAYAPRIME_SHOP;
    public static final ForgeConfigSpec.ConfigValue<ArrayList<ArrayList<String>>> PLAUNT_PLANTS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_STORY;

    static void addItem(ArrayList<ArrayList<String>> array, String id, String count, String price) {
        array.add(HaloTerraCommonConfig.createItem(id, count, price));
    }

    static ArrayList<String> createItem(String id, String count, String price) {
        ArrayList<String> a = new ArrayList<String>();
        a.add(id);
        a.add(count);
        a.add(price);
        return a;
    }

    static ArrayList<String> createPlant(String seedId, String outputId) {
        ArrayList<String> a = new ArrayList<String>();
        a.add(seedId);
        a.add(outputId);
        return a;
    }

    static ArrayList<String> createPlant(String seedId) {
        return HaloTerraCommonConfig.createPlant(seedId, seedId);
    }

    static {
        ArrayList<ArrayList<String>> items = new ArrayList<ArrayList<String>>();
        HaloTerraCommonConfig.addItem(items, "minecraft:carrot", "5", "5");
        HaloTerraCommonConfig.addItem(items, "minecraft:iron_ore", "10", "20");
        HaloTerraCommonConfig.addItem(items, "haloterra:lead_ore", "15", "20");
        HaloTerraCommonConfig.addItem(items, "haloterra:lithium_ore", "8", "20");
        HaloTerraCommonConfig.addItem(items, "minecraft:wheat_seeds", "16", "5");
        HaloTerraCommonConfig.addItem(items, "minecraft:bone", "4", "8");
        HaloTerraCommonConfig.addItem(items, "minecraft:oak_log", "16", "10");
        HaloTerraCommonConfig.addItem(items, "minecraft:dark_oak_log", "16", "10");
        HaloTerraCommonConfig.addItem(items, "minecraft:birch_log", "16", "10");
        HaloTerraCommonConfig.addItem(items, "minecraft:acacia_log", "16", "12");
        HaloTerraCommonConfig.addItem(items, "minecraft:sand", "16", "12");
        HaloTerraCommonConfig.addItem(items, "minecraft:diamond", "1", "50");
        HaloTerraCommonConfig.addItem(items, "minecraft:cactus", "4", "8");
        HaloTerraCommonConfig.addItem(items, "minecraft:lava_bucket", "1", "12");
        HaloTerraCommonConfig.addItem(items, "minecraft:dirt", "32", "12");
        HaloTerraCommonConfig.addItem(items, "minecraft:coal", "8", "8");
        HaloTerraCommonConfig.addItem(items, "minecraft:spawner", "1", "1200");
        HaloTerraCommonConfig.addItem(items, "minecraft:clay", "8", "14");
        HaloTerraCommonConfig.addItem(items, "haloterra:transistor", "9", "20");
        HaloTerraCommonConfig.addItem(items, "haloterra:condensator", "8", "18");
        HaloTerraCommonConfig.addItem(items, "minecraft:white_wool", "10", "15");
        HaloTerraCommonConfig.addItem(items, "minecraft:redstone", "5", "8");
        HaloTerraCommonConfig.addItem(items, "minecraft:cobblestone", "20", "12");
        HaloTerraCommonConfig.addItem(items, "minecraft:obsidian", "2", "20");
        HaloTerraCommonConfig.addItem(items, "minecraft:netherite_scrap", "1", "200");
        HaloTerraCommonConfig.addItem(items, "minecraft:andesite", "15", "10");
        HaloTerraCommonConfig.addItem(items, "haloterra:mrtomato", "1", "60");
        HaloTerraCommonConfig.addItem(items, "haloterra:mrtomato_gold", "1", "120");
        ArrayList<ArrayList<String>> plants = new ArrayList<ArrayList<String>>();
        plants.add(HaloTerraCommonConfig.createPlant("minecraft:wheat_seeds", "minecraft:wheat"));
        plants.add(HaloTerraCommonConfig.createPlant("minecraft:sugar_cane"));
        plants.add(HaloTerraCommonConfig.createPlant("minecraft:carrot"));
        plants.add(HaloTerraCommonConfig.createPlant("minecraft:potato"));
        plants.add(HaloTerraCommonConfig.createPlant("minecraft:cactus"));
        plants.add(HaloTerraCommonConfig.createPlant("minecraft:sweet_berries"));
        plants.add(HaloTerraCommonConfig.createPlant("minecraft:bamboo"));
        plants.add(HaloTerraCommonConfig.createPlant("minecraft:beetroot_seeds", "minecraft:beetroot"));
        plants.add(HaloTerraCommonConfig.createPlant("haloterra:grape_seeds", "haloterra:grapes"));
        BUILDER.push("HaloterraConfigs");
        RAYAPRIME_SHOP = BUILDER.comment("RayaPrime").define("Items", items);
        PLAUNT_PLANTS = BUILDER.comment("Plaunt").define("Plants", plants);
        ENABLE_STORY = BUILDER.comment("Enable Story?").define("Enable_Story", false);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
