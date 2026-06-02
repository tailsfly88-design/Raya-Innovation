package com.vuzz.haloterra.gui.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
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

public class RayaPrimeScreen
extends ContainerScreen<RayaPrimeContainer> {
    private final ResourceLocation GUI = new ResourceLocation("haloterra", "textures/gui/rayaprime/shop_fullt.png");
    public final ArrayList<ItemStack> shopItems = ShopItems.getItems();
    public final ArrayList<Number> shopPrices = ShopItems.getPrices();
    private final ArrayList<ShopButton> shopButtons = new ArrayList();
    private int page = 1;

    public RayaPrimeScreen(RayaPrimeContainer container, PlayerInventory playerInventory, ITextComponent p_i51105_3_) {
        super((Container)container, playerInventory, p_i51105_3_);
    }

    protected void func_231160_c_() {
        this.field_147003_i = this.field_230708_k_ / 2;
        this.field_147009_r = this.field_230709_l_ / 2;
        int b = this.field_147003_i - 88;
        int j = this.field_147009_r - 83;
        Minecraft mc = Minecraft.func_71410_x();
        ClientPlayerEntity player = mc.field_71439_g;
        int pagesMax = (int)Math.ceil(this.shopItems.size() / 16);
        PageButton pageBtnLeft = new PageButton(24, 21, b + 6 - 40 - 5 + 192 - 1, j + 6 - 5 + 146 - 1, (PlayerEntity)player, $ -> {
            if (this.page - 1 > 0) {
                --this.page;
            }
        }, 0, true);
        PageButton pageBtnRight = new PageButton(24, 21, b + 6 - 40 - 5 + 219 - 1, j + 6 - 5 + 146 - 1, (PlayerEntity)player, $ -> {
            if (this.page - 1 < pagesMax) {
                ++this.page;
            }
        }, 1, false);
        this.func_230480_a_((Widget)pageBtnLeft);
        this.func_230480_a_((Widget)pageBtnRight);
        int i = 0;
        while (i < 15) {
            int xBox = i % 5;
            int yBox = (int)Math.floor(i / 5);
            int e = i++;
            ShopButton btn = new ShopButton(46, 44, b + 6 + (xBox *= 47) - 40, j + 6 + (yBox *= 46), (PlayerEntity)player, $ -> {
                Minecraft mca = Minecraft.func_71410_x();
                int a = e;
                ClientPlayerEntity playera = mca.field_71439_g;
                int pageMultiplier = 15 * (this.page - 1);
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
            RayaPrimeScreen.func_238476_c_((MatrixStack)matrixStack, (FontRenderer)Minecraft.func_71410_x().field_71466_p, (String)(new TranslationTextComponent("title.haloterra.pm").getString() + ": " + price), (int)((xBox *= 47) - 40 + 9), (int)((yBox *= 46) + 38), (int)Integer.parseInt("FFFFFF", 16));
        }
        LazyOptional<PM> capability = PM.get((Entity)player);
        if (capability.resolve().isPresent()) {
            PM cap = (PM)capability.resolve().get();
            RayaPrimeScreen.func_238476_c_((MatrixStack)matrixStack, (FontRenderer)Minecraft.func_71410_x().field_71466_p, (String)(new TranslationTextComponent("title.haloterra.pm").getString() + ": " + cap.getPm()), (int)-34, (int)144, (int)Integer.parseInt("FFFFFF", 16));
        }
        int pagesMax = (int)Math.ceil(this.shopItems.size() / 16);
        RayaPrimeScreen.func_238475_b_((MatrixStack)matrixStack, (FontRenderer)Minecraft.func_71410_x().field_71466_p, (ITextComponent)new StringTextComponent(this.page + "/" + (pagesMax + 1)), (int)-34, (int)154, (int)Integer.parseInt("FFFFFF", 16));
    }

    protected void func_230450_a_(MatrixStack arg0, float arg1, int arg2, int arg3) {
        RenderSystem.color4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.field_230706_i_.func_110434_K().func_110577_a(this.GUI);
        int i = this.field_147003_i;
        int j = this.field_147009_r;
        this.func_238474_b_(arg0, i - 40, j, 0, 0, 256, 168);
        for (int q = 0; q < 15; ++q) {
            int xBox = q % 5;
            int yBox = (int)Math.floor(q / 5);
            this.func_238474_b_(arg0, i + 6 + (xBox *= 47) - 40, j + 6 + (yBox *= 46), 0, 170, 46, 44);
        }
    }
}
