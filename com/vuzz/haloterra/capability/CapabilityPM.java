package com.vuzz.haloterra.capability;

import com.vuzz.haloterra.capability.PM;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityPM {
    @CapabilityInject(value=PM.class)
    public static Capability<PM> INSTANCE;

    public static void register() {
        CapabilityManager.INSTANCE.register(PM.class, (Capability.IStorage)new PM.PMStorage(), PM::new);
    }
}
