package com.vuzz.haloterra.entities.custom;

import java.util.List;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class OcubladeEntity
extends ShoulderRidingEntity
implements IFlyingAnimal {
    private int ticksPast = 0;
    public double targetX = 0.0;
    public double targetY = 0.0;
    public double targetZ = 0.0;
    public double startX = 0.0;
    public double startY = 0.0;
    public double startZ = 0.0;

    public OcubladeEntity(EntityType<? extends ShoulderRidingEntity> entity, World world) {
        super(entity, world);
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

    protected void func_184651_r() {
        super.func_184651_r();
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.ticksPast > 40) {
            this.func_70106_y();
        }
        List targetList = this.field_70170_p.func_217357_a(LivingEntity.class, new AxisAlignedBB(this.func_226277_ct_() - 0.8, this.func_226278_cu_() - 0.1, this.func_226281_cx_() - 0.8, this.func_226277_ct_() + 0.8, this.func_226278_cu_() + 0.1, this.func_226281_cx_() + 0.8));
        List followList = this.field_70170_p.func_217357_a(LivingEntity.class, new AxisAlignedBB(this.func_226277_ct_() - 10.0, this.func_226278_cu_() - 10.0, this.func_226281_cx_() - 10.0, this.func_226277_ct_() + 10.0, this.func_226278_cu_() + 10.0, this.func_226281_cx_() + 10.0));
        followList.forEach(f -> {
            if (f.getClassification(true) == EntityClassification.MONSTER) {
                double distanceX = this.func_226277_ct_() - f.func_226277_ct_();
                double distanceY = this.func_226278_cu_() - (f.func_226280_cw_() - 0.2);
                double distanceZ = this.func_226281_cx_() - f.func_226281_cx_();
                this.func_213317_d(new Vector3d(-this.clamp(distanceX, -0.3, 0.3), -this.clamp(distanceY, -0.3, 0.3), -this.clamp(distanceZ, -0.3, 0.3)));
            }
        });
        targetList.forEach(e -> {
            if (e.getClassification(true) == EntityClassification.MONSTER) {
                e.func_195064_c(new EffectInstance(Effects.field_82731_v, 20, 2));
                e.func_70097_a(DamageSource.field_76377_j, 2.0f);
                e.func_70652_k((Entity)this);
            }
        });
        ++this.ticksPast;
        super.func_70071_h_();
    }

    public boolean func_70097_a(DamageSource damageSource, float damage) {
        return false;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 100.0).func_233815_a_(Attributes.field_233822_e_, 0.0).func_233815_a_(Attributes.field_233826_i_, 5000000.0).func_233815_a_(Attributes.field_233827_j_, 5000000.0).func_233815_a_(Attributes.field_233821_d_, 0.0);
    }

    protected double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }
}
