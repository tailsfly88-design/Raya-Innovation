package com.vuzz.haloterra.networking;

import com.vuzz.haloterra.networking.PMUpdatePacket;
import com.vuzz.haloterra.networking.PMUpdatePacketClient;
import com.vuzz.haloterra.networking.PacketItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class Networking {
    public static SimpleChannel CHANNEL;
    public static int ID;

    public static int nextID() {
        return ID++;
    }

    public static void register() {
        CHANNEL = NetworkRegistry.newSimpleChannel((ResourceLocation)new ResourceLocation("haloterra", "network"), () -> "1.0", s -> true, s -> true);
        CHANNEL.registerMessage(Networking.nextID(), PacketItemStack.class, PacketItemStack::toBytes, PacketItemStack::new, PacketItemStack::handle);
        CHANNEL.registerMessage(Networking.nextID(), PMUpdatePacket.class, PMUpdatePacket::encode, PMUpdatePacket::new, PMUpdatePacket::handle);
        CHANNEL.registerMessage(Networking.nextID(), PMUpdatePacketClient.class, PMUpdatePacketClient::encode, PMUpdatePacketClient::new, PMUpdatePacketClient::handle);
    }
}
