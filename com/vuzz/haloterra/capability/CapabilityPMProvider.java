package com.vuzz.haloterra.capability;

import com.vuzz.haloterra.capability.CapabilityPM;
import com.vuzz.haloterra.capability.PM;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class CapabilityPMProvider
implements ICapabilitySerializable<INBT> {
    private static final PM.PMStorage STORAGE = new PM.PMStorage();
    private final PM pm = new PM();
    private final LazyOptional<PM> lazyOptional = LazyOptional.of(() -> this.pm);

    @Nonnull
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityPM.INSTANCE) {
            return LazyOptional.of(() -> this.pm);
        }
        return LazyOptional.empty();
    }

    public INBT serializeNBT() {
        CompoundNBT nbt = new CompoundNBT();
        INBT pmNBT = STORAGE.writeNBT(null, this.pm, null);
        nbt.func_218657_a("pm", pmNBT);
        return nbt;
    }

    public void deserializeNBT(INBT nbt) {
        if (!(nbt instanceof CompoundNBT)) {
            return;
        }
        CompoundNBT compound = (CompoundNBT)nbt;
        STORAGE.readNBT(null, this.pm, null, compound.func_74781_a("pm"));
    }
}
