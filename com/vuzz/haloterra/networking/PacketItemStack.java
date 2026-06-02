package com.vuzz.haloterra.networking;

import java.util.function.Supplier;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketItemStack {
    private ItemStack stack;

    public PacketItemStack(ItemStack stack) {
        this.stack = stack;
    }

    public PacketItemStack(PacketBuffer buf) {
        this.stack = buf.func_150791_c();
    }

    public void toBytes(PacketBuffer buf) {
        buf.func_150788_a(this.stack);
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        System.out.println("handling itemstack");
        context.get().enqueueWork(() -> {
            System.out.println("checking player");
            if (((NetworkEvent.Context)context.get()).getSender() == null) {
                return;
            }
            System.out.println("giving stack to " + ((NetworkEvent.Context)context.get()).getSender().func_145748_c_().getString());
            System.out.println(this.stack.func_77977_a());
            ServerPlayerEntity sender = ((NetworkEvent.Context)context.get()).getSender();
            sender.func_199701_a_(this.stack);
        });
        context.get().setPacketHandled(true);
    }
}
