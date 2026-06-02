package com.vuzz.haloterra.gui.containers;

import com.vuzz.haloterra.gui.SlotLocked;
import com.vuzz.haloterra.gui.containers.ModContainers;
import com.vuzz.haloterra.shop.ShopItems;
import java.util.ArrayList;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RayaPrimeContainer
extends Container {
    public final PlayerEntity playerEntity;
    private final PlayerInventory playerInventory;
    private final IInventory shopInv = new Inventory(30);
    public final ArrayList<ItemStack> shopItems = ShopItems.getItems();
    public final ArrayList<Number> shopPrices = ShopItems.getPrices();

    public RayaPrimeContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player) {
        super((ContainerType)ModContainers.RAYA_PRIME_CONTAINER.get(), windowId);
        this.playerEntity = player;
        this.playerInventory = playerInventory;
        for (int i = 0; i < 30; ++i) {
            int xBox = i % 6;
            int yBox = (int)Math.floor(i / 6);
            SlotLocked slot = new SlotLocked(this.shopInv, i, (xBox *= 40) + 5 - 53 + 2, (yBox *= 38) + 5 - 22 + 18);
            if (i < this.shopItems.size()) {
                ItemStack stackForShop = this.shopItems.get(i);
                slot.func_75215_d(stackForShop);
            }
            this.func_75146_a(slot);
        }
    }

    public boolean func_75145_c(PlayerEntity arg0) {
        return true;
    }
}
