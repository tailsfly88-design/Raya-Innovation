package com.vuzz.haloterra.gui.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.vuzz.haloterra.capability.PM;
import com.vuzz.haloterra.gui.PageButton;
import com.vuzz.haloterra.gui.ShopButton;
import com.vuzz.haloterra.gui.containers.RayaPrimeContainer;
import com.vuzz.haloterra.networking.Networking;
import com.vuzz.haloterra.networking.PacketItemStack;
import com.vuzz.haloterra.shop.ShopItems;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.renderer.RenderState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.PacketDistributor;

public class ShopScreen
extends ContainerScreen<RayaPrimeContainer> {
    private final ResourceLocation GUI = new ResourceLocation("haloterra", "textures/gui/rayaprime/lololoshkashop.png");
    private final ResourceLocation GUI_2 = new ResourceLocation("haloterra", "textures/gui/rayaprime/lololoshkashop_2.png");
    public final ArrayList<ItemStack> shopItems = ShopItems.getItems();
    public final ArrayList<Number> shopPrices = ShopItems.getPrices();
    private final ArrayList<ShopButton> shopButtons = new ArrayList();
    private int page = 1;
    public int guiXOffset = -53;
    public int guiYOffset = -22;
    private static final RenderState.TransparencyState TRANSLUCENT_TRANSPARENCY = new RenderState.TransparencyState("translucent_transparency", () -> {
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
    }, () -> {
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    });

    public ShopScreen(RayaPrimeContainer container, PlayerInventory playerInventory, ITextComponent p_i51105_3_) {
        super((Container)container, playerInventory, p_i51105_3_);
    }

    protected void func_231160_c_() {
        this.field_147003_i = this.field_230708_k_ / 2;
        this.field_147009_r = this.field_230709_l_ / 2;
        int b = this.field_147003_i - 88;
        int j = this.field_147009_r - 83;
        Minecraft mc = Minecraft.func_71410_x();
        ClientPlayerEntity player = mc.field_71439_g;
        int pagesMax = (int)Math.ceil(this.shopItems.size() / 31);
        PageButton pageBtnLeft = new PageButton(9, 10, b + this.guiXOffset + 91, j + this.guiYOffset + 208, (PlayerEntity)player, $ -> {
            if (this.page - 1 > 0) {
                --this.page;
            }
        }, 0, true);
        PageButton pageBtnRight = new PageButton(9, 10, b + this.guiXOffset + 191, j + this.guiYOffset + 208, (PlayerEntity)player, $ -> {
            if (this.page - 1 < pagesMax) {
                ++this.page;
            }
        }, 1, false);
        this.func_230480_a_((Widget)pageBtnLeft);
        this.func_230480_a_((Widget)pageBtnRight);
        int i = 0;
        while (i < 30) {
            int xBox = i % 6;
            int yBox = (int)Math.floor(i / 6);
            int e = i++;
            ShopButton btn = new ShopButton(39, 37, b + (xBox *= 40) + this.guiXOffset + 3, j + (yBox *= 38) + this.guiYOffset + 19, (PlayerEntity)player, $ -> {
                Minecraft mca = Minecraft.func_71410_x();
                int a = e;
                ClientPlayerEntity playera = mca.field_71439_g;
                int pageMultiplier = 30 * (this.page - 1);
                if (this.shopItems.size() > pageMultiplier + a) {
                    PM cap;
                    int pm;
                    ItemStack stack = this.shopItems.get(pageMultiplier + a);
                    int price = (Integer)this.shopPrices.get(pageMultiplier + a);
                    LazyOptional<PM> capability = PM.get((Entity)playera);
                    if (capability.resolve().isPresent() && (pm = (cap = (PM)capability.resolve().get()).getPm()) >= price) {
                        cap.setPm(pm - price);
                        cap.sync(player);
                        ItemStack stcopy = stack.func_77946_l();
                        Networking.CHANNEL.send(PacketDistributor.SERVER.noArg(), (Object)new PacketItemStack(stcopy));
                    }
                }
            }, e);
            this.func_230480_a_((Widget)btn);
        }
        super.func_231160_c_();
    }

    public void func_230430_a_(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.func_230446_a_(matrixStack);
        super.func_230430_a_(matrixStack, mouseX, mouseY, partialTicks);
        this.func_230459_a_(matrixStack, mouseX, mouseY);
        Minecraft mc = Minecraft.func_71410_x();
        for (int i = 0; i < 30; ++i) {
            int a = i;
            int pageMultiplier = 30 * (this.page - 1);
            if (this.shopItems.size() > pageMultiplier + a) {
                ItemStack stack = this.shopItems.get(pageMultiplier + a);
                ((RayaPrimeContainer)this.field_147002_h).func_75141_a(a, stack);
                continue;
            }
            ((RayaPrimeContainer)this.field_147002_h).func_75141_a(a, new ItemStack((IItemProvider)Items.field_190931_a));
        }
    }

    protected void func_230451_b_(MatrixStack matrixStack, int x, int y) {
        Minecraft mc = Minecraft.func_71410_x();
        ClientPlayerEntity player = mc.field_71439_g;
        int i = 0;
        while (i < Math.min(this.shopItems.size() - 30 * (this.page - 1), 30)) {
            int b = this.field_230708_k_ / 2;
            int j = this.field_230709_l_ / 2;
            int xBox = i % 6;
            int yBox = (int)Math.floor(i / 6);
            int pageMultiplier = 30 * (this.page - 1);
            int a = i++;
            int price = (Integer)this.shopPrices.get(pageMultiplier + a);
            ShopScreen.func_238476_c_((MatrixStack)matrixStack, (FontRenderer)Minecraft.func_71410_x().field_71466_p, (String)(new TranslationTextComponent("title.haloterra.pm").getString() + ": " + price), (int)((xBox *= 40) + 5 - 53 + 2 - 5 + 2), (int)((yBox *= 38) + 5 - 22 + 18 + 20 + 2), (int)Integer.parseInt("FFFFFF", 16));
        }
        LazyOptional<PM> capability = PM.get((Entity)player);
        if (capability.resolve().isPresent()) {
            PM cap = (PM)capability.resolve().get();
            ShopScreen.func_238476_c_((MatrixStack)matrixStack, (FontRenderer)Minecraft.func_71410_x().field_71466_p, (String)(new TranslationTextComponent("title.haloterra.pm").getString() + ": " + cap.getPm()), (int)170, (int)-20, (int)Integer.parseInt("FFFFFF", 16));
        }
        int pagesMax = (int)Math.ceil(this.shopItems.size() / 31);
        ShopScreen.func_238475_b_((MatrixStack)matrixStack, (FontRenderer)Minecraft.func_71410_x().field_71466_p, (ITextComponent)new StringTextComponent(this.page + "/" + (pagesMax + 1)), (int)56, (int)188, (int)Integer.parseInt("FFFFFF", 16));
        ShopScreen.func_238475_b_((MatrixStack)matrixStack, (FontRenderer)Minecraft.func_71410_x().field_71466_p, (ITextComponent)new StringTextComponent("https://haloterra.shop/@" + player.func_145748_c_().getString().toLowerCase() + "/"), (int)-49, (int)-20, (int)Integer.parseInt("FFFFFF", 16));
    }

    protected void func_230450_a_(MatrixStack arg0, float arg1, int arg2, int arg3) {
        TRANSLUCENT_TRANSPARENCY.func_228547_a_();
        RenderSystem.color4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int i = this.field_147003_i;
        int j = this.field_147009_r;
        this.field_230706_i_.func_110434_K().func_110577_a(this.GUI);
        this.func_238474_b_(arg0, i + this.guiXOffset, j + this.guiYOffset, 0, 0, 256, 219);
        this.field_230706_i_.func_110434_K().func_110577_a(this.GUI_2);
        this.func_238474_b_(arg0, i + this.guiXOffset + 256, j + this.guiYOffset, 0, 0, 256, 219);
        for (int q = 0; q < 30; ++q) {
            int xBox = q % 6;
            int yBox = (int)Math.floor(q / 6);
            xBox *= 40;
            yBox *= 38;
        }
        TRANSLUCENT_TRANSPARENCY.func_228549_b_();
    }
}
