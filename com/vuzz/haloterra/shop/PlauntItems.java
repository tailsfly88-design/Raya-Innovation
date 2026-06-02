package com.vuzz.haloterra.shop;

import com.vuzz.haloterra.config.HaloTerraCommonConfig;
import java.util.ArrayList;
import java.util.function.Consumer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class PlauntItems {
    public static ArrayList<Item> getInputItems() {
        ArrayList config = (ArrayList)HaloTerraCommonConfig.PLAUNT_PLANTS.get();
        ArrayList<Item> shopItems = PlauntItems.parseItems(config);
        return shopItems;
    }

    public static ArrayList<Item> parseItems(ArrayList<ArrayList<String>> configArray) {
        ArrayList<Item> shopItems = new ArrayList<Item>();
        configArray.forEach((Consumer<ArrayList<String>>)((Consumer<ArrayList>)e -> {
            String id = (String)e.get(0);
            String modId = "minecraft";
            String name = "";
            if (id.indexOf(":") != -1) {
                modId = id.substring(0, id.indexOf(":"));
            }
            name = id.substring(id.indexOf(":") + 1);
            Item itemReg = (Item)ForgeRegistries.ITEMS.getValue(new ResourceLocation(modId, name));
            shopItems.add(itemReg);
        }));
        return shopItems;
    }

    public static ArrayList<Item> parseOutputItems(ArrayList<ArrayList<String>> configArray) {
        ArrayList<Item> shopItems = new ArrayList<Item>();
        configArray.forEach((Consumer<ArrayList<String>>)((Consumer<ArrayList>)e -> {
            String id = (String)e.get(1);
            String modId = "minecraft";
            String name = "";
            if (id.indexOf(":") != -1) {
                modId = id.substring(0, id.indexOf(":"));
            }
            name = id.substring(id.indexOf(":") + 1);
            Item itemReg = (Item)ForgeRegistries.ITEMS.getValue(new ResourceLocation(modId, name));
            shopItems.add(itemReg);
        }));
        return shopItems;
    }

    public static ArrayList<Item> getOutputItems() {
        ArrayList config = (ArrayList)HaloTerraCommonConfig.PLAUNT_PLANTS.get();
        ArrayList<Item> shopPrices = PlauntItems.parseOutputItems(config);
        return shopPrices;
    }

    public static void addItem(ArrayList<ItemStack> array, Item itemRegistry, int count) {
        ItemStack stack = new ItemStack((IItemProvider)itemRegistry);
        stack.func_190920_e(count);
        array.add(stack);
    }

    public static void addItem(ArrayList<ItemStack> array, RegistryObject<Item> itemRegistry, int count) {
        ItemStack stack = new ItemStack((IItemProvider)itemRegistry.get());
        stack.func_190920_e(count);
        array.add(stack);
    }

    public static void addPrice(ArrayList<Number> array, int price) {
        array.add(price);
    }
}
