package com.vuzz.haloterra.items.armor;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class ModArmors {
    private static final String MODID = "haloterra";
    public static final DeferredRegister<Item> ARMOR = DeferredRegister.create((IForgeRegistry)ForgeRegistries.ITEMS, (String)"haloterra");

    public static void register(IEventBus eventbus) {
        ARMOR.register(eventbus);
    }
}
