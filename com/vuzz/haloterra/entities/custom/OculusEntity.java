package com.vuzz.haloterra.entities.custom;

import com.vuzz.haloterra.effects.ModEffects;
import com.vuzz.haloterra.entities.ModEntityTypes;
import com.vuzz.haloterra.entities.custom.OcubladeEntity;
import com.vuzz.haloterra.items.ModItems;
import java.util.List;
import java.util.UUID;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.passive.ShoulderRidingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.FlyingPathNavigator;
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

public class OculusEntity
extends ShoulderRidingEntity
implements IFlyingAnimal {
    private int ticksPast;
    private float curEnergy = 1.0f;
    private LivingEntity owner;
    private UUID ownerUuid;
    private static float energyConsumtion = 0.01f;
    private static float walkingConsumtion = 0.02f;
    private static float flySpeed = 0.4f;
    private static final int STAY_DISTANCE = 30;
    private static final int TELEPORT_DISTANCE = 100;
    private int lastHungerCheck = 0;
    private int lastDurabilityCheck = 0;

    public LivingEntity func_70902_q() {
        return this.owner;
    }

    public OculusEntity(EntityType<? extends ShoulderRidingEntity> entity, World world) {
        super(entity, world);
        this.field_70765_h = new FlyingMovementController((MobEntity)this, 2, false);
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
            ItemStack item = new ItemStack((IItemProvider)ModItems.INACTIVE_OCULUS.get());
            if (player.func_213365_e(item)) {
                item.func_77982_d(nbt);
                player.func_191521_c(item);
                player.getPersistentData().func_74757_a("hasoculus", false);
                this.func_70106_y();
            } else {
                this.func_70106_y();
                item.func_77982_d(nbt);
                player.func_71019_a(item, false);
                player.getPersistentData().func_74757_a("hasoculus", false);
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
            this.owner.func_145747_a((ITextComponent)new TranslationTextComponent("message.oculus.disabling"), Util.field_240973_b_);
            System.out.println("at hybernation");
            this.returnAsImplant();
        }
        if (nbt.func_74767_n("canUseEnergy") && this.curEnergy <= 0.0f) {
            this.returnAsImplant();
        }
        this.curEnergy = nbt.func_74760_g("energy");
        this.func_200602_a(EntityAnchorArgument.Type.EYES, new Vector3d(this.owner.func_226277_ct_(), this.owner.func_226280_cw_(), this.owner.func_226281_cx_()));
        double distanceBetween = this.func_70068_e((Entity)this.func_70902_q());
        ((FlyingPathNavigator)this.func_70661_as()).func_212239_d(false);
        ((FlyingPathNavigator)this.func_70661_as()).func_192878_b(true);
        ((FlyingPathNavigator)this.func_70661_as()).func_192879_a(true);
        this.func_189654_d(true);
        if (distanceBetween > 100.0) {
            this.func_70107_b(this.owner.func_226277_ct_(), this.owner.func_226278_cu_(), this.owner.func_226281_cx_());
        } else if (distanceBetween > 30.0) {
            this.curEnergy -= walkingConsumtion;
            this.func_70661_as().func_75492_a(this.func_70902_q().func_226277_ct_() - 2.0, this.func_70902_q().func_226280_cw_(), this.func_70902_q().func_226281_cx_() - 2.0, 2.0);
        } else {
            this.func_213293_j(0.0, this.clamp(this.func_70902_q().func_226280_cw_() - this.func_226278_cu_(), -0.2, 0.2), 0.0);
            this.func_70661_as().func_75499_g();
        }
        if (this.ticksPast % 50 == 49) {
            List entitiesClose = this.field_70170_p.func_72839_b((Entity)this, this.func_174813_aQ().func_72314_b(20.0, 20.0, 20.0));
            for (int i = 0; i < entitiesClose.size(); ++i) {
                LivingEntity entityToBeat;
                if (!(entitiesClose.get(i) instanceof LivingEntity) || (entityToBeat = (LivingEntity)entitiesClose.get(i)).getClassification(true) != EntityClassification.MONSTER) continue;
                EntityType raya = (EntityType)ModEntityTypes.OCUBLADE.get();
                OcubladeEntity rayaEntity = (OcubladeEntity)raya.func_220331_a((ServerWorld)this.func_130014_f_(), null, null, this.func_233580_cy_(), SpawnReason.DISPENSER, false, false);
                rayaEntity.targetX = entityToBeat.func_226277_ct_();
                rayaEntity.targetY = entityToBeat.func_226278_cu_();
                rayaEntity.targetZ = entityToBeat.func_226281_cx_();
                break;
            }
        }
        PlayerEntity player = (PlayerEntity)this.owner;
        if (this.ticksPast - this.lastHungerCheck >= 600 && player.func_71024_bL().func_75116_a() < 10) {
            this.owner.func_145747_a((ITextComponent)new TranslationTextComponent("message.oculus.lowfood"), Util.field_240973_b_);
            this.lastHungerCheck = this.ticksPast;
        }
        this.performTalks(this.ticksPast);
        this.curEnergy -= energyConsumtion;
        nbt.func_74776_a("energy", this.curEnergy);
        ++this.ticksPast;
    }

    private UUID getOwnerUUID() {
        return this.ownerUuid;
    }

    protected FlyingPathNavigator createNavigator(World worldIn) {
        return new FlyingPathNavigator((MobEntity)this, worldIn);
    }

    public boolean func_70097_a(DamageSource damageSource, float damage) {
        if (damageSource != DamageSource.field_76380_i) {
            CompoundNBT nbt = this.getPersistentData();
            this.curEnergy = nbt.func_74760_g("energy");
            if (this.curEnergy > damage / 4.0f) {
                this.curEnergy -= damage / 4.0f;
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
