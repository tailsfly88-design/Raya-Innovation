package com.vuzz.haloterra.entities.custom;

import com.vuzz.haloterra.effects.ModEffects;
import com.vuzz.haloterra.items.ModItems;
import com.vuzz.haloterra.shop.PlauntItems;
import java.util.ArrayList;
import java.util.UUID;
import javax.annotation.Nonnull;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.Util;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.items.ItemStackHandler;

public class PlauntEntity
extends ShoulderRidingEntity {
    private int ticksPast;
    private float curEnergy = 1.0f;
    private LivingEntity owner;
    private UUID ownerUuid;
    private static float energyConsumtion = 0.01f;
    private static float walkingConsumtion = 0.01f;
    private static float flySpeed = 0.5f;
    private static final int STAY_DISTANCE = 15;
    private static final int TELEPORT_DISTANCE = 60;
    private int lastHungerCheck = 0;
    private int lastDurabilityCheck = 0;
    ArrayList<Item> inputItems = PlauntItems.getInputItems();
    ArrayList<Item> outputItems = PlauntItems.getOutputItems();

    public LivingEntity func_70902_q() {
        return this.owner;
    }

    public PlauntEntity(EntityType<? extends ShoulderRidingEntity> entity, World world) {
        super(entity, world);
        this.field_70765_h = new FlyingMovementController((MobEntity)this, 1, false);
    }

    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        if (player == this.owner && player.func_225608_bj_()) {
            System.out.println("at clicking");
            this.returnAsImplant();
        }
        return super.func_230254_b_(player, hand);
    }

    private void returnAsImplant() {
        CompoundNBT nbt = this.getPersistentData();
        if (this.owner instanceof PlayerEntity) {
            System.out.println("at return");
            PlayerEntity player = (PlayerEntity)this.owner;
            ItemStack item = new ItemStack((IItemProvider)ModItems.INACTIVE_PLAUNT.get());
            if (player.func_213365_e(item)) {
                item.func_77982_d(nbt);
                player.func_191521_c(item);
                player.getPersistentData().func_74757_a("hasplaunt", false);
                this.func_70106_y();
            } else {
                this.func_70106_y();
                item.func_77982_d(nbt);
                player.func_71019_a(item, false);
                player.getPersistentData().func_74757_a("hasplaunt", false);
            }
        }
    }

    public boolean func_184222_aU() {
        return true;
    }

    public boolean func_213397_c(double a) {
        return false;
    }

    public boolean func_184652_a(PlayerEntity player) {
        return false;
    }

    public AgeableEntity func_241840_a(ServerWorld world, AgeableEntity arg1) {
        return null;
    }

    public boolean func_104002_bU() {
        return true;
    }

    protected boolean func_230282_cS_() {
        return true;
    }

    public void setOwnerUUID(UUID ownerUuid) {
        this.ownerUuid = ownerUuid;
    }

    public void setOwner(LivingEntity owner) {
        this.owner = owner;
    }

    public void setEnergy(float cuEnergy) {
        this.curEnergy = cuEnergy;
    }

    public float getEnergy() {
        return this.curEnergy;
    }

    private void performTalks(int tick) {
        if (tick % 40 != 0 || this.owner instanceof PlayerEntity) {
            // empty if block
        }
    }

    protected void func_184651_r() {
        super.func_184651_r();
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(8){

            protected void onContentsChanged(int slot) {
                PlauntEntity.this.func_233578_ci_();
            }

            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                if (slot % 2 != 0) {
                    return PlauntEntity.this.inputItems.contains(new ItemStack((IItemProvider)stack.func_77973_b()));
                }
                return false;
            }

            public int getSlotLimit(int slot) {
                if (slot % 2 == 0) {
                    return 128;
                }
                return 1;
            }

            @Nonnull
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (!this.isItemValid(slot, stack)) {
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        CompoundNBT nbt = this.getPersistentData();
        if (nbt.func_74767_n("canUseEnergy")) {
            this.setOwnerUUID(nbt.func_186857_a("owneruuid"));
        }
        if (this.getOwnerUUID() instanceof UUID) {
            this.setOwner((LivingEntity)this.field_70170_p.func_217371_b(this.getOwnerUUID()));
        }
        if (!(this.owner instanceof PlayerEntity)) {
            return;
        }
        if (this.owner.func_70644_a((Effect)ModEffects.HYBERNATION.get())) {
            PlayerEntity player = (PlayerEntity)this.owner;
            this.owner.func_145747_a((ITextComponent)new TranslationTextComponent("message.plaunt.disabling"), Util.field_240973_b_);
            System.out.println("at hybernation");
            this.returnAsImplant();
        }
        if (nbt.func_74767_n("canUseEnergy") && this.curEnergy <= 0.0f) {
            this.returnAsImplant();
        }
        this.curEnergy = nbt.func_74760_g("energy");
        this.func_200602_a(EntityAnchorArgument.Type.EYES, new Vector3d(this.owner.func_226277_ct_(), this.owner.func_226280_cw_(), this.owner.func_226281_cx_()));
        double distanceBetween = this.func_70068_e((Entity)this.func_70902_q());
        if (distanceBetween > 60.0) {
            this.func_70107_b(this.owner.func_226277_ct_(), this.owner.func_226278_cu_(), this.owner.func_226281_cx_());
        } else if (distanceBetween > 15.0) {
            this.curEnergy -= walkingConsumtion;
            this.func_70661_as().func_75492_a(this.func_70902_q().func_226277_ct_(), this.func_70902_q().func_226278_cu_(), this.func_70902_q().func_226281_cx_(), 1.4);
        } else {
            this.func_70661_as().func_75499_g();
        }
        PlayerEntity player = (PlayerEntity)this.owner;
        if (this.ticksPast - this.lastHungerCheck >= 600 && player.func_71024_bL().func_75116_a() < 10) {
            this.owner.func_145747_a((ITextComponent)new TranslationTextComponent("message.plaunt.lowfood"), Util.field_240973_b_);
            this.lastHungerCheck = this.ticksPast;
        }
        if (this.ticksPast % 1200 == 1199) {
            PlayerInventory playerInv = player.field_71071_by;
            int invSize = playerInv.func_70302_i_();
            for (int i = 0; i < invSize; ++i) {
                Item slotStack = playerInv.func_70301_a(i).func_77973_b();
                ItemStack slotStacka = playerInv.func_70301_a(i);
                int indexOf = this.inputItems.indexOf(slotStack);
                if (!this.inputItems.contains(slotStack)) continue;
                ItemStack slotToGive = new ItemStack((IItemProvider)this.outputItems.get(indexOf));
                slotToGive.func_190920_e(Math.min((int)Math.ceil(slotStacka.func_190916_E() / 4), 8));
                player.func_71019_a(slotToGive, false);
            }
        }
        if (this.ticksPast % 6000 == 5999) {
            this.owner.func_145747_a((ITextComponent)new TranslationTextComponent("message.plaunt.found"), Util.field_240973_b_);
            int random = (int)Math.ceil(this.field_70146_Z.nextFloat() * 100.0f);
            int randomCount = (int)Math.ceil(this.field_70146_Z.nextFloat() * 12.0f);
            Item it = Item.func_150899_d((int)random);
            if (it == Items.field_221598_z) {
                it = Items.field_221590_r;
            }
            ItemStack stack = new ItemStack((IItemProvider)Item.func_150899_d((int)random));
            stack.func_190920_e(randomCount);
            player.func_71019_a(stack, false);
        }
        this.performTalks(this.ticksPast);
        this.curEnergy -= energyConsumtion;
        nbt.func_74776_a("energy", this.curEnergy);
        ++this.ticksPast;
    }

    private UUID getOwnerUUID() {
        return this.ownerUuid;
    }

    public boolean func_70097_a(DamageSource damageSource, float damage) {
        if (damageSource != DamageSource.field_76380_i) {
            CompoundNBT nbt = this.getPersistentData();
            this.curEnergy = nbt.func_74760_g("energy");
            if (this.curEnergy > damage * 2.0f) {
                this.curEnergy -= damage * 2.0f;
                System.out.println("at damage");
                return false;
            }
        }
        return true;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 100.0).func_233815_a_(Attributes.field_233822_e_, (double)flySpeed).func_233815_a_(Attributes.field_233826_i_, 5000000.0).func_233815_a_(Attributes.field_233827_j_, 5000000.0).func_233815_a_(Attributes.field_233821_d_, (double)flySpeed);
    }

    protected double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }
}
