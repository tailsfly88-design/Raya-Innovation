package com.vuzz.haloterra.events;

import com.vuzz.haloterra.entities.ModEntityTypes;
import com.vuzz.haloterra.entities.custom.BeyondtoEntity;
import com.vuzz.haloterra.entities.custom.OcubladeEntity;
import com.vuzz.haloterra.entities.custom.OculusEntity;
import com.vuzz.haloterra.entities.custom.PlauntEntity;
import com.vuzz.haloterra.entities.custom.RayaPrimeEntity;
import com.vuzz.haloterra.entities.custom.RehoboamEntity;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid="haloterra", bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put((EntityType)ModEntityTypes.RAYA_PRIME.get(), RayaPrimeEntity.setCustomAttributes().func_233813_a_());
        event.put((EntityType)ModEntityTypes.BEYONDTO.get(), BeyondtoEntity.setCustomAttributes().func_233813_a_());
        event.put((EntityType)ModEntityTypes.OCULUS.get(), OculusEntity.setCustomAttributes().func_233813_a_());
        event.put((EntityType)ModEntityTypes.OCUBLADE.get(), OcubladeEntity.setCustomAttributes().func_233813_a_());
        event.put((EntityType)ModEntityTypes.PLAUNT.get(), PlauntEntity.setCustomAttributes().func_233813_a_());
        event.put((EntityType)ModEntityTypes.REHOBOAM.get(), RehoboamEntity.setCustomAttributes().func_233813_a_());
    }
}
