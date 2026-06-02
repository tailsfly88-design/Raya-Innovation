package com.vuzz.haloterra.items;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.items.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class SimpleEffectDrink
extends Item {
    public int time = 0;
    public Effect effect;
    public int power = 0;

    public SimpleEffectDrink(Effect effect, int time, int power, boolean isSecret) {
        super(new Item.Properties().func_221540_a(new Food.Builder().func_221455_b().func_221456_a(0).func_221454_a(3.0f).func_221453_d()).func_200917_a(1).func_200916_a(isSecret ? null : RayaMod.MOD_GROUP));
        this.effect = effect;
        this.time = time;
        this.power = power;
    }

    public SimpleEffectDrink(Effect effect, int time, int power) {
        super(new Item.Properties().func_221540_a(new Food.Builder().func_221455_b().func_221456_a(0).func_221454_a(3.0f).func_221453_d()).func_200917_a(1).func_200916_a(RayaMod.MOD_GROUP));
        this.effect = effect;
        this.time = time;
        this.power = power;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.field_187664_bz;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.field_187664_bz;
    }

    public ItemStack func_77654_b(ItemStack stack, World world, LivingEntity entity) {
        entity.func_195064_c(new EffectInstance(this.effect, this.time, this.power));
        stack.func_190918_g(1);
        return stack.func_190926_b() ? new ItemStack((IItemProvider)ModItems.CUP.get()) : stack;
    }

    public int func_77626_a(ItemStack pStack) {
        return 25;
    }

    public UseAction func_77661_b(ItemStack p_77661_1_) {
        return UseAction.DRINK;
    }
}
