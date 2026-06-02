package com.vuzz.haloterra.entities;

import com.vuzz.haloterra.entities.custom.BeyondtoEntity;
import com.vuzz.haloterra.entities.custom.OcubladeEntity;
import com.vuzz.haloterra.entities.custom.OculusEntity;
import com.vuzz.haloterra.entities.custom.PlauntEntity;
import com.vuzz.haloterra.entities.custom.RayaPrimeEntity;
import com.vuzz.haloterra.entities.custom.RehoboamEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create((IForgeRegistry)ForgeRegistries.ENTITIES, (String)"haloterra");
    public static final RegistryObject<EntityType<RayaPrimeEntity>> RAYA_PRIME = ENTITY_TYPES.register("raya_prime", () -> EntityType.Builder.func_220322_a(RayaPrimeEntity::new, (EntityClassification)EntityClassification.AMBIENT).func_220321_a(0.75f, 0.75f).func_206830_a(new ResourceLocation("haloterra", "raya_prime").toString()));
    public static final RegistryObject<EntityType<OculusEntity>> OCULUS = ENTITY_TYPES.register("oculus", () -> EntityType.Builder.func_220322_a(OculusEntity::new, (EntityClassification)EntityClassification.AMBIENT).func_220321_a(0.8f, 1.3f).func_206830_a(new ResourceLocation("haloterra", "oculus").toString()));
    public static final RegistryObject<EntityType<RehoboamEntity>> REHOBOAM = ENTITY_TYPES.register("rehoboam", () -> EntityType.Builder.func_220322_a(RehoboamEntity::new, (EntityClassification)EntityClassification.AMBIENT).func_220321_a(1.3f, 1.3f).func_206830_a(new ResourceLocation("haloterra", "rehoboam").toString()));
    public static final RegistryObject<EntityType<PlauntEntity>> PLAUNT = ENTITY_TYPES.register("plaunt", () -> EntityType.Builder.func_220322_a(PlauntEntity::new, (EntityClassification)EntityClassification.AMBIENT).func_220321_a(0.8f, 1.3f).func_206830_a(new ResourceLocation("haloterra", "plaunt").toString()));
    public static final RegistryObject<EntityType<BeyondtoEntity>> BEYONDTO = ENTITY_TYPES.register("beyondto", () -> EntityType.Builder.func_220322_a(BeyondtoEntity::new, (EntityClassification)EntityClassification.AMBIENT).func_220321_a(0.55f, 1.5f).func_206830_a(new ResourceLocation("haloterra", "beyondto").toString()));
    public static final RegistryObject<EntityType<OcubladeEntity>> OCUBLADE = ENTITY_TYPES.register("ocublade", () -> EntityType.Builder.func_220322_a(OcubladeEntity::new, (EntityClassification)EntityClassification.MISC).func_220321_a(0.1f, 0.1f).func_206830_a(new ResourceLocation("haloterra", "ocublade").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
