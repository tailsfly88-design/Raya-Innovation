package com.vuzz.haloterra.items;

import com.vuzz.haloterra.RayaMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;

public class Gcu
extends Item {
    public int ticks = 0;

    public Gcu() {
        super(new Item.Properties().func_200916_a(RayaMod.MOD_GROUP).func_208103_a(Rarity.EPIC));
    }

    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        if (context.func_195991_k().field_72995_K) {
            return super.onItemUseFirst(stack, context);
        }
        if (!context.func_195999_j().func_184216_O().contains("uniquegen")) {
            context.func_195999_j().func_184211_a("uniquegen");
            context.func_195999_j().func_195064_c(new EffectInstance(Effects.field_76440_q, 200, 1));
            stack.func_190918_g(1);
        }
        return super.onItemUseFirst(stack, context);
    }
}
