package com.vuzz.haloterra.gui.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.vuzz.haloterra.gui.containers.ChargePadContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ChargePadScreen
extends ContainerScreen<ChargePadContainer> {
    private final ResourceLocation GUI = new ResourceLocation("haloterra", "textures/gui/plaunt.png");

    public ChargePadScreen(ChargePadContainer container, PlayerInventory playerInventory, ITextComponent p_i51105_3_) {
        super((Container)container, playerInventory, p_i51105_3_);
    }

    protected void func_231160_c_() {
        this.field_147003_i = this.field_230708_k_ / 2;
        this.field_147009_r = this.field_230709_l_ / 2;
        int b = this.field_147003_i - 88;
        int j = this.field_147009_r - 83;
        super.func_231160_c_();
    }

    protected void func_230451_b_(MatrixStack matrixStack, int x, int y) {
    }

    protected void func_230450_a_(MatrixStack arg0, float arg1, int arg2, int arg3) {
        RenderSystem.color4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.field_230706_i_.func_110434_K().func_110577_a(this.GUI);
        int i = this.field_147003_i;
        int j = this.field_147009_r;
        this.func_238474_b_(arg0, i, j, 0, 0, 176, 168);
    }
}
