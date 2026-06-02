package com.vuzz.haloterra.effects;

import com.vuzz.haloterra.effects.EffectHybernation;
import net.minecraft.potion.Effect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class ModEffects {
    private static final String MODID = "haloterra";
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create((IForgeRegistry)ForgeRegistries.POTIONS, (String)"haloterra");
    public static final RegistryObject<Effect> HYBERNATION = EFFECTS.register("hybernation", () -> new EffectHybernation());

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}
