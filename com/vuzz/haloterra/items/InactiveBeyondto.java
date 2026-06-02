package com.vuzz.haloterra.items;

import com.vuzz.haloterra.RayaMod;
import com.vuzz.haloterra.effects.ModEffects;
import com.vuzz.haloterra.entities.ModEntityTypes;
import com.vuzz.haloterra.entities.custom.BeyondtoEntity;
import com.vuzz.haloterra.items.marker.Implant;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Util;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class InactiveBeyondto
extends Item
implements Implant {
    public int ticks = 0;

    public InactiveBeyondto() {
        super(new Item.Properties().func_200916_a(RayaMod.MOD_GROUP).func_200915_b(30000).func_200918_c(30000).setNoRepair().func_208103_a(Rarity.EPIC));
    }

    public void func_77663_a(ItemStack stack, World world, Entity entity, int tick, boolean bool) {
        ++this.ticks;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundNBT());
        }
        stack.func_77978_p().func_74776_a("max_energy", 29998.0f);
        PlayerEntity player = (PlayerEntity)entity;
        if (player.func_71024_bL().func_75116_a() > 1 && this.ticks % 300 == 0 && stack.func_77978_p().func_74760_g("energy") < 29950.0f) {
            stack.func_77978_p().func_74776_a("energy", stack.func_77978_p().func_74760_g("energy") + 50.0f);
            player.func_71024_bL().func_75114_a(player.func_71024_bL().func_75116_a() - 1);
        }
        if (stack.func_77978_p().func_74760_g("energy") > stack.func_77978_p().func_74760_g("max_energy")) {
            stack.func_77978_p().func_74776_a("energy", stack.func_77978_p().func_74760_g("max_energy"));
        }
        if (stack.func_77978_p().func_74760_g("energy") < 0.0f) {
            stack.func_77978_p().func_74776_a("energy", 0.0f);
        }
        stack.func_196085_b(30000 - ((int)stack.func_77978_p().func_74760_g("energy") + 1));
        super.func_77663_a(stack, world, entity, tick, bool);
    }

    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        if (context.func_195991_k().field_72995_K) {
            return super.onItemUseFirst(stack, context);
        }
        if (!context.func_195999_j().func_225608_bj_()) {
            if (!stack.func_77942_o()) {
                stack.func_77982_d(new CompoundNBT());
            }
            if (!context.func_195999_j().func_184216_O().contains("uniquegen")) {
                context.func_195999_j().func_145747_a((ITextComponent)new TranslationTextComponent("message.haloterra.nogen"), Util.field_240973_b_);
            } else {
                if (context.func_195999_j().func_70644_a((Effect)ModEffects.HYBERNATION.get())) {
                    return super.onItemUseFirst(stack, context);
                }
                if (stack.func_77978_p().func_74760_g("energy") < 10.0f) {
                    context.func_195999_j().func_146105_b((ITextComponent)new TranslationTextComponent("message.haloterra.notenoughenergy"), true);
                    return super.onItemUseFirst(stack, context);
                }
                EntityType raya = (EntityType)ModEntityTypes.BEYONDTO.get();
                BeyondtoEntity rayaEntity = (BeyondtoEntity)raya.func_220331_a((ServerWorld)context.func_195991_k(), stack, context.func_195999_j(), context.func_195999_j().func_233580_cy_(), SpawnReason.DISPENSER, false, false);
                context.func_195999_j().getPersistentData().func_74757_a("hasbeyondto", true);
                rayaEntity.getPersistentData().func_74776_a("energy", stack.func_77978_p().func_74760_g("energy"));
                rayaEntity.getPersistentData().func_74776_a("max_energy", stack.func_77978_p().func_74760_g("max_energy"));
                rayaEntity.owner = context.func_195999_j();
                rayaEntity.owneruuid = context.func_195999_j().func_110124_au();
                rayaEntity.getPersistentData().func_186854_a("owneruuid", context.func_195999_j().func_110124_au());
                rayaEntity.getPersistentData().func_74757_a("canUseEnergy", true);
                stack.func_190918_g(1);
            }
        }
        return super.onItemUseFirst(stack, context);
    }

    public void func_77624_a(ItemStack stack, @Nullable World world, List<ITextComponent> text, ITooltipFlag tooltip) {
        text.add((ITextComponent)new StringTextComponent(new TranslationTextComponent("tooltip.haloterra.name").getString() + "????\n" + new TranslationTextComponent("tooltip.haloterra.beyondto").getString()));
        super.func_77624_a(stack, world, text, tooltip);
    }
}
