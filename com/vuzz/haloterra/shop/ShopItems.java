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

public class ShopItems {
    public static ArrayList<ItemStack> getItems() {
        ArrayList config = (ArrayList)HaloTerraCommonConfig.RAYAPRIME_SHOP.get();
        ArrayList<ItemStack> shopItems = ShopItems.parseItems(config);
        return shopItems;
    }

    public static ArrayList<ItemStack> parseItems(ArrayList<ArrayList<String>> configArray) {
        ArrayList<ItemStack> shopItems = new ArrayList<ItemStack>();
        configArray.forEach((Consumer<ArrayList<String>>)((Consumer<ArrayList>)e -> {
            String id = (String)e.get(0);
            String modId = "minecraft";
            String name = "";
            if (id.indexOf(":") != -1) {
                modId = id.substring(0, id.indexOf(":"));
            }
            name = id.substring(id.indexOf(":") + 1);
            Item itemReg = (Item)ForgeRegistries.ITEMS.getValue(new ResourceLocation(modId, name));
            ItemStack stack = new ItemStack((IItemProvider)itemReg);
            stack.func_190920_e(Integer.parseInt((String)e.get(1)));
            shopItems.add(stack);
        }));
        return shopItems;
    }

    public static ArrayList<Number> parsePrices(ArrayList<ArrayList<String>> configArray) {
        ArrayList<Number> shopItems = new ArrayList<Number>();
        configArray.forEach((Consumer<ArrayList<String>>)((Consumer<ArrayList>)e -> {
            int price = Integer.parseInt((String)e.get(2));
            price = price < 0 ? 0 : price;
            shopItems.add(price);
        }));
        return shopItems;
    }

    public static ArrayList<Number> getPrices() {
        ArrayList config = (ArrayList)HaloTerraCommonConfig.RAYAPRIME_SHOP.get();
        ArrayList<Number> shopPrices = ShopItems.parsePrices(config);
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
