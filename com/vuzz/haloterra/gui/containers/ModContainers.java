package com.vuzz.haloterra.gui.containers;

import com.vuzz.haloterra.gui.containers.ChargePadContainer;
import com.vuzz.haloterra.gui.containers.RayaPrimeContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class ModContainers {
    private static final String MODID = "haloterra";
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create((IForgeRegistry)ForgeRegistries.CONTAINERS, (String)"haloterra");
    public static final RegistryObject<ContainerType<RayaPrimeContainer>> RAYA_PRIME_CONTAINER = CONTAINERS.register("raya_prime_container", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.func_179259_c();
        World world = inv.field_70458_d.func_130014_f_();
        return new RayaPrimeContainer(windowId, world, pos, inv, inv.field_70458_d);
    }));
    public static final RegistryObject<ContainerType<ChargePadContainer>> CHARGE_PAD_CONTAINER = CONTAINERS.register("charge_pad_container", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.func_179259_c();
        World world = inv.field_70458_d.func_130014_f_();
        return new ChargePadContainer(windowId, world, pos, inv, inv.field_70458_d, null);
    }));

    public static void register(IEventBus eventbus) {
        CONTAINERS.register(eventbus);
    }
}
