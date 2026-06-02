package com.vuzz.haloterra.gui.containers;

import com.vuzz.haloterra.entities.custom.PlauntEntity;
import com.vuzz.haloterra.gui.containers.ModContainers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class ChargePadContainer
extends Container {
    public final PlayerEntity playerEntity;
    private final IItemHandler playerInventory;
    public final PlauntEntity plauntEntity;
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = 27;
    private static final int VANILLA_SLOT_COUNT = 36;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = 36;
    private static final int TE_INVENTORY_SLOT_COUNT = 2;

    public ChargePadContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player, PlauntEntity plaunt) {
        super((ContainerType)ModContainers.CHARGE_PAD_CONTAINER.get(), windowId);
        this.plauntEntity = (PlauntEntity)world.func_225318_b(PlauntEntity.class, null, (LivingEntity)player, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), AxisAlignedBB.func_241549_a_((Vector3d)new Vector3d(1.0, 1.0, 1.0)));
        this.playerEntity = player;
        this.playerInventory = new InvWrapper((IInventory)playerInventory);
        this.layoutPlayerInventorySlots(8, 72);
        System.out.println(pos.toString());
        if (plaunt != null) {
            plaunt.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
                this.func_75146_a((Slot)new SlotItemHandler(h, 0, 25, 28));
                this.func_75146_a((Slot)new SlotItemHandler(h, 1, 26, 46));
                this.func_75146_a((Slot)new SlotItemHandler(h, 2, 62, 28));
                this.func_75146_a((Slot)new SlotItemHandler(h, 3, 63, 46));
                this.func_75146_a((Slot)new SlotItemHandler(h, 4, 98, 28));
                this.func_75146_a((Slot)new SlotItemHandler(h, 5, 99, 46));
                this.func_75146_a((Slot)new SlotItemHandler(h, 6, 134, 28));
                this.func_75146_a((Slot)new SlotItemHandler(h, 7, 135, 46));
            });
        }
    }

    public boolean func_75145_c(PlayerEntity arg0) {
        return true;
    }

    private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
        for (int i = 0; i < amount; ++i) {
            this.func_75146_a((Slot)new SlotItemHandler(handler, index, x, y));
            x += dx;
            ++index;
        }
        return index;
    }

    private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0; j < verAmount; ++j) {
            index = this.addSlotRange(handler, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }

    private void layoutPlayerInventorySlots(int leftCol, int topRow) {
        this.addSlotBox(this.playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);
        this.addSlotRange(this.playerInventory, 0, leftCol, topRow += 58, 9, 18);
    }

    public ItemStack func_82846_b(PlayerEntity playerIn, int index) {
        Slot sourceSlot = (Slot)this.field_75151_b.get(index);
        if (sourceSlot == null || !sourceSlot.func_75216_d()) {
            return ItemStack.field_190927_a;
        }
        ItemStack sourceStack = sourceSlot.func_75211_c();
        ItemStack copyOfSourceStack = sourceStack.func_77946_l();
        if (index < 36) {
            if (!this.func_75135_a(sourceStack, 36, 38, false)) {
                return ItemStack.field_190927_a;
            }
        } else if (index < 38) {
            if (!this.func_75135_a(sourceStack, 0, 36, false)) {
                return ItemStack.field_190927_a;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.field_190927_a;
        }
        if (sourceStack.func_190916_E() == 0) {
            sourceSlot.func_75215_d(ItemStack.field_190927_a);
        } else {
            sourceSlot.func_75218_e();
        }
        sourceSlot.func_190901_a(this.playerEntity, sourceStack);
        return copyOfSourceStack;
    }
}
