package com.vuzz.haloterra.networking;

import com.vuzz.haloterra.networking.IProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientProxy
implements IProxy {
    @Override
    public Minecraft getMinecraft() {
        return Minecraft.func_71410_x();
    }

    @Override
    public PlayerEntity getPlayer() {
        return this.getMinecraft().field_71439_g;
    }

    @Override
    public World getWorld() {
        return this.getMinecraft().field_71441_e;
    }
}
