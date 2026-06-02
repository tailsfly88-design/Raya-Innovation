package com.vuzz.haloterra.items.armor;

import java.util.function.Supplier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ModArmorMaterials implements IArmorMaterial
{
    CLOTH_DOCUMENTARY("cloth_documentary", 7, new int[]{1, 4, 5, 1}, 12, SoundEvents.field_187728_s, 1.0f, 0.0f, () -> Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151116_aA}));

    private static final int[] MAX_DAMAGE_ARRAY;
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairMaterial;

    private ModArmorMaterials(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = new LazyValue(repairMaterial);
    }

    public int func_200896_a(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.func_188454_b()] * this.maxDamageFactor;
    }

    public int func_200902_b(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.func_188454_b()];
    }

    public int func_200900_a() {
        return this.enchantability;
    }

    public SoundEvent func_200899_b() {
        return this.soundEvent;
    }

    public Ingredient func_200898_c() {
        return (Ingredient)this.repairMaterial.func_179281_c();
    }

    @OnlyIn(value=Dist.CLIENT)
    public String func_200897_d() {
        return "haloterra:" + this.name;
    }

    public float func_200901_e() {
        return this.toughness;
    }

    public float func_230304_f_() {
        return this.knockbackResistance;
    }

    static {
        MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    }
}
