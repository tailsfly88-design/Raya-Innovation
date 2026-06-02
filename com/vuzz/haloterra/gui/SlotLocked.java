package com.vuzz.haloterra.gui;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class SlotLocked
extends Slot {
    public SlotLocked(IInventory inv, int index, int xPos, int yPos) {
        super(inv, index, xPos, yPos);
    }

    public boolean func_82869_a(PlayerEntity player) {
        return false;
    }

    public boolean func_75214_a(ItemStack stack) {
        return false;
    }
}
