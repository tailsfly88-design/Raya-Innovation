package com.vuzz.haloterra.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class PageButton
extends Button {
    public PlayerEntity playerEntity;
    private final Button.IPressable onPress;
    private int widthIn;
    private int heightIn;
    public int ind;
    private final ResourceLocation GUI = new ResourceLocation("haloterra", "textures/gui/rayaprime/shop_fullt.png");
    private int xIn;
    private int yIn;
    private boolean isLeft;

    public PageButton(int widthIn, int heightIn, int xIn, int yIn, PlayerEntity player, Button.IPressable onPress, int index, boolean isLeft) {
        super(xIn, yIn, widthIn, heightIn, (ITextComponent)new StringTextComponent(""), onPress);
        this.onPress = onPress;
        this.widthIn = widthIn;
        this.heightIn = heightIn;
        this.ind = index;
        this.xIn = xIn;
        this.yIn = yIn;
        this.isLeft = isLeft;
    }

    public void func_230930_b_() {
        this.onPress.onPress((Button)this);
    }

    public void func_230431_b_(MatrixStack ms, int a, int b, float c) {
        Minecraft mc = Minecraft.func_71410_x();
    }
}
