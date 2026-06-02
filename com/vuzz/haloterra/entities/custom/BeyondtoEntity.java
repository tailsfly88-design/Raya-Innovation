package com.vuzz.haloterra.entities.custom;

import com.vuzz.haloterra.effects.ModEffects;
import com.vuzz.haloterra.items.ModItems;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.Util;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class BeyondtoEntity
extends FlyingEntity {
    public static int animation = 0;
    public static final float speed = 0.2f;
    private float energy = 0.0f;
    private int ticks = 0;
    private int lastHungerCheck = 0;
    public LivingEntity owner;
    public UUID owneruuid;

    public BeyondtoEntity(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 100.0).func_233815_a_(Attributes.field_233822_e_, 0.35).func_233815_a_(Attributes.field_233826_i_, 5000000.0).func_233815_a_(Attributes.field_233827_j_, 5000000.0).func_233815_a_(Attributes.field_233821_d_, 0.35);
    }

    public void func_184651_r() {
        super.func_184651_r();
    }

    public boolean func_70097_a(DamageSource damageSource, float damage) {
        if (damageSource == DamageSource.field_76380_i) {
            return true;
        }
        CompoundNBT nbt = this.getPersistentData();
        this.energy = nbt.func_74760_g("energy");
        if (this.energy > damage) {
            nbt.func_74776_a("energy", this.energy - damage);
            return false;
        }
        return true;
    }

    protected double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }

    protected ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        if (player.func_225608_bj_()) {
            CompoundNBT nbt = this.getPersistentData();
            if (this.owner == player) {
                ItemStack item = new ItemStack((IItemProvider)ModItems.INACTIVE_BEYONDTO.get());
                if (player.func_213365_e(item)) {
                    item.func_77982_d(nbt);
                    player.func_191521_c(item);
                    player.getPersistentData().func_74757_a("hasbeyondto", false);
                    this.func_70106_y();
                } else {
                    this.func_70106_y();
                    item.func_77982_d(nbt);
                    player.func_71019_a(item, false);
                    player.getPersistentData().func_74757_a("hasbeyondto", false);
                }
            }
        } else {
            CompoundNBT nbt = this.getPersistentData();
            this.energy = nbt.func_74760_g("energy");
            if (this.owner != player || !(this.energy >= 0.0f) || nbt.func_74767_n("canUseEnergy")) {
                // empty if block
            }
        }
        return super.func_230254_b_(player, hand);
    }

    public boolean func_213397_c(double p_153397_1_) {
        return false;
    }

    public void onRemovedFromWorld() {
        if (this.owner != null) {
            this.func_70029_a(this.owner.func_130014_f_());
        }
    }

    public void func_70071_h_() {
        ItemStack item;
        PlayerEntity player;
        super.func_70071_h_();
        this.func_184210_p();
        CompoundNBT nbt = this.getPersistentData();
        this.energy = nbt.func_74760_g("energy");
        if (nbt.func_74767_n("canUseEnergy")) {
            this.owneruuid = nbt.func_186857_a("owneruuid");
        }
        if (this.energy <= 0.0f && nbt.func_74767_n("canUseEnergy") && this.owner instanceof PlayerEntity) {
            player = (PlayerEntity)this.owner;
            item = new ItemStack((IItemProvider)ModItems.INACTIVE_BEYONDTO.get());
            if (player.func_213365_e(item)) {
                this.func_70106_y();
                item.func_77982_d(nbt);
                player.func_191521_c(item);
                player.getPersistentData().func_74757_a("hasbeyondto", false);
            } else {
                this.func_70106_y();
                item.func_77982_d(nbt);
                player.func_71019_a(item, false);
                player.getPersistentData().func_74757_a("hasbeyondto", false);
            }
        }
        if (this.owneruuid instanceof UUID && this.func_130014_f_().func_217371_b(this.owneruuid) instanceof PlayerEntity) {
            this.owner = this.func_130014_f_().func_217371_b(this.owneruuid);
        }
        if (this.owner != null) {
            if (this.owner instanceof PlayerEntity && this.owner.func_70644_a((Effect)ModEffects.HYBERNATION.get())) {
                player = (PlayerEntity)this.owner;
                item = new ItemStack((IItemProvider)ModItems.INACTIVE_BEYONDTO.get());
                this.owner.func_145747_a((ITextComponent)new TranslationTextComponent("message.beyondto.disabling"), Util.field_240973_b_);
                if (player.func_213365_e(item)) {
                    this.func_70106_y();
                    item.func_77982_d(nbt);
                    player.func_191521_c(item);
                    player.getPersistentData().func_74757_a("hasbeyondto", false);
                } else {
                    this.func_70106_y();
                    item.func_77982_d(nbt);
                    player.func_71019_a(item, false);
                    player.getPersistentData().func_74757_a("hasbeyondto", false);
                }
            }
            if (this.owner.func_130014_f_() != this.func_130014_f_()) {
                this.func_70029_a(this.owner.func_130014_f_());
            }
            if (this.func_130014_f_().field_72995_K) {
                player = Minecraft.func_71410_x().field_71439_g;
            }
            double distance = this.func_70068_e((Entity)this.owner);
            this.func_200602_a(EntityAnchorArgument.Type.EYES, this.owner.func_213303_ch());
            PlayerEntity player2 = (PlayerEntity)this.owner;
            if (this.ticks - this.lastHungerCheck >= 1200 && player2.func_71024_bL().func_75116_a() < 10) {
                this.owner.func_145747_a((ITextComponent)new TranslationTextComponent("message.beyondto.lowfood"), Util.field_240973_b_);
                this.lastHungerCheck = this.ticks;
            }
            if (this.energy <= 0.0f && nbt.func_74767_n("canUseEnergy")) {
                return;
            }
            if (player2.func_110143_aJ() <= 10.0f && nbt.func_74762_e("phase") == 0) {
                nbt.func_74768_a("phase", 1);
                this.owner.func_145747_a((ITextComponent)new TranslationTextComponent("message.beyondto.shieldphase"), Util.field_240973_b_);
            }
            if (player2.func_110143_aJ() > 10.0f && nbt.func_74762_e("phase") == 1) {
                nbt.func_74768_a("phase", 0);
                this.owner.func_145747_a((ITextComponent)new TranslationTextComponent("message.beyondto.normalphase"), Util.field_240973_b_);
            }
            if (player2.func_110143_aJ() <= 10.0f) {
                double step = 18.0;
                double angle = this.ticks % 20;
                double x = this.owner.func_226277_ct_() + Math.sin(Math.toRadians(angle * step)) * 1.2;
                double z = this.owner.func_226281_cx_() + Math.cos(Math.toRadians(angle * step)) * 1.2;
                this.func_70107_b(x, this.owner.func_226278_cu_() + 0.7, z);
            }
            if (player2.func_110143_aJ() <= 15.0f && player2.func_110143_aJ() > 0.0f) {
                if (this.ticks % 80 == 79) {
                    player2.func_70606_j(player2.func_110143_aJ() + 1.0f);
                    this.energy -= 500.0f;
                }
            } else {
                nbt.func_74768_a("phase", 0);
                if (distance >= 60.0) {
                    this.func_70107_b(this.owner.func_226277_ct_(), this.owner.func_226278_cu_() + 1.1, this.owner.func_226281_cx_());
                } else if (distance >= 20.0) {
                    this.func_213317_d(new Vector3d(-this.clamp(this.func_226277_ct_() - this.owner.func_226277_ct_(), -0.2f, 0.2f), -this.clamp(this.func_226278_cu_() - this.owner.func_226280_cw_(), -0.2f, 0.2f), -this.clamp(this.func_226281_cx_() - this.owner.func_226281_cx_(), -0.2f, 0.2f)));
                }
            }
            if (this.ticks % 6000 == 5999) {
                this.energy -= 1500.0f;
                player2.func_195064_c(new EffectInstance(Effects.field_76444_x, 5000, 5, false, false, false, player2.func_70660_b(Effects.field_76444_x)));
            }
        }
        if (this.energy >= 0.0f && nbt.func_74767_n("canUseEnergy")) {
            this.energy -= 0.125f;
        }
        nbt.func_74776_a("energy", this.energy);
        ++this.ticks;
    }
}
