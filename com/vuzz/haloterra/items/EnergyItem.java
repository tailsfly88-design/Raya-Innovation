package com.vuzz.haloterra.items;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.items.marker.Implant;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class EnergyItem
extends Item {
    float energyGives = 0.0f;

    public EnergyItem(float energyGives) {
        super(new Item.Properties().func_200917_a(16).func_234689_a_().func_200916_a(RayaMod.MOD_GROUP));
        this.energyGives = energyGives;
    }

    public void func_77663_a(ItemStack stack, World world, Entity player, int ticks, boolean bool) {
        ItemStack mainItem;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundNBT());
        }
        CompoundNBT nbt = stack.func_77978_p();
        nbt.func_74776_a("energyGives", this.energyGives);
        PlayerEntity playerEntity = (PlayerEntity)player;
        if (playerEntity.func_184592_cb() == stack && !world.field_72995_K && playerEntity.func_225608_bj_() && (mainItem = playerEntity.func_184614_ca()).func_77973_b() instanceof Implant) {
            float maxEnergy;
            CompoundNBT implantNbt;
            float energy;
            if (!mainItem.func_77942_o()) {
                mainItem.func_77982_d(new CompoundNBT());
            }
            if ((energy = (implantNbt = mainItem.func_77978_p()).func_74760_g("energy")) + this.energyGives <= (maxEnergy = implantNbt.func_74760_g("max_energy"))) {
                implantNbt.func_74776_a("energy", energy + this.energyGives);
                stack.func_190918_g(1);
            }
        }
        super.func_77663_a(stack, world, player, ticks, bool);
    }

    public void func_77624_a(ItemStack stack, @Nullable World world, List<ITextComponent> text, ITooltipFlag tooltip) {
        text.add((ITextComponent)new StringTextComponent(new TranslationTextComponent("tooltip.haloterra.energy").getString() + " " + this.energyGives + "\n" + new TranslationTextComponent("tooltip.haloterra.energyuse").getString()));
        super.func_77624_a(stack, world, text, tooltip);
    }
}
