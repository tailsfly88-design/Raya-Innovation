package com.vuzz.haloterra.capability;

import com.vuzz.haloterra.capability.CapabilityPM;
import com.vuzz.haloterra.networking.Networking;
import com.vuzz.haloterra.networking.PMUpdatePacket;
import com.vuzz.haloterra.networking.PMUpdatePacketClient;
import javax.annotation.Nonnull;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.PacketDistributor;

public class PM {
    private int pm;
    private int progress;

    public static LazyOptional<PM> get(Entity entity) {
        return entity.getCapability(CapabilityPM.INSTANCE);
    }

    public void sync(ServerPlayerEntity player) {
        Networking.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), (Object)new PMUpdatePacket(this));
    }

    public void sync(ClientPlayerEntity player) {
        Networking.CHANNEL.send(PacketDistributor.SERVER.with(() -> null), (Object)new PMUpdatePacketClient(this));
    }

    public int getPm() {
        return this.pm;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setPm(int pm) {
        this.pm = pm;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean hasPm() {
        return this.pm > 0;
    }

    public boolean hasProgress() {
        return this.progress > 0;
    }

    public static final class PMStorage
    implements Capability.IStorage<PM> {
        @Nonnull
        public INBT writeNBT(Capability<PM> capability, PM instance, Direction side) {
            CompoundNBT nbt = new CompoundNBT();
            nbt.func_74768_a("pm", instance.pm);
            nbt.func_74768_a("progress", instance.progress);
            System.out.println(nbt.func_74762_e("pm"));
            return nbt;
        }

        public void readNBT(Capability<PM> capability, PM instance, Direction side, INBT nbt) {
            if (!(nbt instanceof CompoundNBT)) {
                return;
            }
            CompoundNBT compound = (CompoundNBT)nbt;
            instance.pm = compound.func_74762_e("pm");
            instance.progress = compound.func_74762_e("progress");
            System.out.println(instance.pm);
        }
    }
}
