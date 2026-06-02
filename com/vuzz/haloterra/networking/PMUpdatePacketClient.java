package com.vuzz.haloterra.networking;

import com.vuzz.haloterra.capability.PM;
import java.util.function.Supplier;
import net.minecraft.entity.Entity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PMUpdatePacketClient {
    public int pm;
    public int progress;

    public PMUpdatePacketClient(int pm, int progress) {
        this.pm = pm;
        this.progress = progress;
    }

    public PMUpdatePacketClient(PM cap) {
        this.pm = cap.getPm();
        this.progress = cap.getProgress();
    }

    public PMUpdatePacketClient(PacketBuffer buffer) {
        this.pm = buffer.readInt();
        this.progress = buffer.readInt();
    }

    public void encode(PacketBuffer buffer) {
        buffer.writeInt(this.pm);
        buffer.writeInt(this.progress);
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            System.out.println("checking player");
            if (((NetworkEvent.Context)context.get()).getSender() == null) {
                return;
            }
            PM.get((Entity)((NetworkEvent.Context)context.get()).getSender()).ifPresent(cap -> {
                cap.setPm(this.pm);
                cap.setProgress(this.progress);
            });
            ((NetworkEvent.Context)context.get()).setPacketHandled(true);
        });
    }
}
