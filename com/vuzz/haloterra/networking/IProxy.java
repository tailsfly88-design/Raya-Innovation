package com.vuzz.haloterra.networking;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public interface IProxy {
    public Minecraft getMinecraft();

    public PlayerEntity getPlayer();

    public World getWorld();
}
