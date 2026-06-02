package com.vuzz.haloterra.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.vuzz.haloterra.entities.custom.OculusEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class OculusModel<T extends OculusEntity>
extends EntityModel<T> {
    private T entit;
    private final ModelRenderer DefaultFace;
    private final ModelRenderer SadFace;
    private final ModelRenderer MainBody;
    private final ModelRenderer LeftHand;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer Sword2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer Body;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer RightWing;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer LeftWing;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;
    private final ModelRenderer RightHand;
    private final ModelRenderer cube_r10;
    private final ModelRenderer cube_r11;
    private final ModelRenderer Sword;
    private final ModelRenderer cube_r12;
    private final ModelRenderer Head;
    private final ModelRenderer HappyFace;

    public OculusModel() {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        this.DefaultFace = new ModelRenderer((Model)this);
        this.DefaultFace.func_78793_a(0.0f, 32.0f, 0.5f);
        this.DefaultFace.func_78784_a(0, 70).func_228303_a_(-4.0f, -30.5f, -5.0f, 8.0f, 8.0f, 0.0f, 0.0f, false);
        this.SadFace = new ModelRenderer((Model)this);
        this.SadFace.func_78793_a(0.0f, 24.0f, 0.5f);
        this.SadFace.func_78784_a(74, 33).func_228303_a_(-4.0f, -22.5f, -5.0f, 8.0f, 8.0f, 0.0f, 0.0f, false);
        this.MainBody = new ModelRenderer((Model)this);
        this.MainBody.func_78793_a(0.0f, 24.0f, 0.0f);
        this.LeftHand = new ModelRenderer((Model)this);
        this.LeftHand.func_78793_a(5.0f, -8.5f, 2.5f);
        this.MainBody.func_78792_a(this.LeftHand);
        this.setRotationAngle(this.LeftHand, -0.2434f, -0.0222f, -0.1141f);
        this.LeftHand.func_78784_a(0, 0).func_228303_a_(1.0f, -0.5f, -1.5f, 3.0f, 3.0f, 3.0f, 0.0f, false);
        this.LeftHand.func_78784_a(29, 15).func_228303_a_(0.5f, -2.0f, -1.5f, 4.0f, 1.0f, 3.0f, 0.0f, false);
        this.LeftHand.func_78784_a(0, 22).func_228303_a_(2.0f, -2.0001f, -1.501f, 1.0f, 2.0f, 3.0f, 0.0f, false);
        this.cube_r1 = new ModelRenderer((Model)this);
        this.cube_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.LeftHand.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, 0.0f, 0.0873f);
        this.cube_r1.func_78784_a(29, 0).func_228303_a_(4.3f, -2.4f, -1.5f, 1.0f, 4.0f, 3.0f, 0.0f, false);
        this.cube_r2 = new ModelRenderer((Model)this);
        this.cube_r2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.LeftHand.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.0f, 0.0f, -0.0873f);
        this.cube_r2.func_78784_a(29, 20).func_228303_a_(-0.3f, -1.95f, -1.5f, 1.0f, 4.0f, 3.0f, 0.0f, false);
        this.Sword2 = new ModelRenderer((Model)this);
        this.Sword2.func_78793_a(3.5f, 10.197f, -0.4014f);
        this.LeftHand.func_78792_a(this.Sword2);
        this.setRotationAngle(this.Sword2, 1.3526f, 0.0f, 0.0f);
        this.cube_r3 = new ModelRenderer((Model)this);
        this.cube_r3.func_78793_a(0.0f, -0.6946f, 3.9392f);
        this.Sword2.func_78792_a(this.cube_r3);
        this.setRotationAngle(this.cube_r3, -1.3963f, 0.0f, 0.0f);
        this.cube_r3.func_78784_a(0, 0).func_228303_a_(-4.5f, -2.0f, -8.0f, 7.0f, 0.0f, 14.0f, 0.0f, false);
        this.Body = new ModelRenderer((Model)this);
        this.Body.func_78793_a(0.014f, -14.6329f, 2.1623f);
        this.MainBody.func_78792_a(this.Body);
        this.setRotationAngle(this.Body, 0.1396f, 0.0f, 0.0f);
        this.Body.func_78784_a(0, 15).func_228303_a_(-2.014f, 1.6329f, -3.1623f, 4.0f, 4.0f, 2.0f, 0.0f, false);
        this.cube_r4 = new ModelRenderer((Model)this);
        this.cube_r4.func_78793_a(-0.014f, 14.6329f, -2.1623f);
        this.Body.func_78792_a(this.cube_r4);
        this.setRotationAngle(this.cube_r4, 0.3927f, 0.0f, 0.0f);
        this.cube_r4.func_78784_a(60, 0).func_228303_a_(-3.0f, -2.9f, 3.0f, 6.0f, 4.0f, 4.0f, 0.0f, false);
        this.cube_r5 = new ModelRenderer((Model)this);
        this.cube_r5.func_78793_a(-0.014f, 14.6329f, -2.1623f);
        this.Body.func_78792_a(this.cube_r5);
        this.setRotationAngle(this.cube_r5, 0.3054f, 0.0f, 0.0f);
        this.cube_r5.func_78784_a(21, 47).func_228303_a_(3.05f, -14.99f, 2.001f, 1.0f, 12.0f, 6.0f, 0.0f, false);
        this.cube_r5.func_78784_a(36, 47).func_228303_a_(-4.0f, -15.0f, 2.001f, 1.0f, 12.0f, 6.0f, 0.0f, false);
        this.cube_r5.func_78784_a(33, 30).func_228303_a_(-3.98f, -14.999f, 3.0f, 8.0f, 12.0f, 4.0f, 0.0f, false);
        this.RightWing = new ModelRenderer((Model)this);
        this.RightWing.func_78793_a(-3.514f, 2.6329f, 1.8377f);
        this.Body.func_78792_a(this.RightWing);
        this.setRotationAngle(this.RightWing, 0.4363f, 0.6109f, 0.5236f);
        this.cube_r6 = new ModelRenderer((Model)this);
        this.cube_r6.func_78793_a(-2.2446f, 0.7102f, -0.1229f);
        this.RightWing.func_78792_a(this.cube_r6);
        this.setRotationAngle(this.cube_r6, 0.0f, 3.1416f, -0.1745f);
        this.cube_r6.func_78784_a(55, 12).func_228303_a_(-3.5f, 0.0f, -1.0f, 11.0f, 3.0f, 2.0f, 0.0f, false);
        this.cube_r7 = new ModelRenderer((Model)this);
        this.cube_r7.func_78793_a(-2.2446f, 0.7102f, -0.1229f);
        this.RightWing.func_78792_a(this.cube_r7);
        this.setRotationAngle(this.cube_r7, 0.0f, 3.1416f, 0.1745f);
        this.cube_r7.func_78784_a(58, 30).func_228303_a_(-3.5f, -4.0f, -1.0f, 11.0f, 3.0f, 2.0f, 0.0f, false);
        this.LeftWing = new ModelRenderer((Model)this);
        this.LeftWing.func_78793_a(7.486f, 4.6329f, 2.8377f);
        this.Body.func_78792_a(this.LeftWing);
        this.setRotationAngle(this.LeftWing, 0.6109f, -0.6109f, -0.5236f);
        this.cube_r8 = new ModelRenderer((Model)this);
        this.cube_r8.func_78793_a(-1.3319f, -2.2574f, 2.3533f);
        this.LeftWing.func_78792_a(this.cube_r8);
        this.setRotationAngle(this.cube_r8, 0.0f, 0.0f, 0.1745f);
        this.cube_r8.func_78784_a(51, 58).func_228303_a_(-3.5f, 0.0f, -1.0f, 11.0f, 3.0f, 2.0f, 0.0f, false);
        this.cube_r9 = new ModelRenderer((Model)this);
        this.cube_r9.func_78793_a(-1.3319f, -2.2574f, 2.3533f);
        this.LeftWing.func_78792_a(this.cube_r9);
        this.setRotationAngle(this.cube_r9, 0.0f, 0.0f, -0.1745f);
        this.cube_r9.func_78784_a(58, 36).func_228303_a_(-3.5f, -4.0f, -1.0f, 11.0f, 3.0f, 2.0f, 0.0f, false);
        this.RightHand = new ModelRenderer((Model)this);
        this.RightHand.func_78793_a(-7.496f, -8.7871f, 2.5376f);
        this.MainBody.func_78792_a(this.RightHand);
        this.setRotationAngle(this.RightHand, -0.3768f, 0.0209f, 0.1374f);
        this.RightHand.func_78784_a(0, 7).func_228303_a_(-1.504f, -0.2104f, -1.4998f, 3.0f, 3.0f, 3.0f, 0.0f, false);
        this.RightHand.func_78784_a(12, 47).func_228303_a_(-2.004f, -1.7104f, -1.4998f, 4.0f, 1.0f, 3.0f, 0.0f, false);
        this.RightHand.func_78784_a(41, 12).func_228303_a_(-0.504f, -1.7105f, -1.5008f, 1.0f, 2.0f, 3.0f, 0.0f, false);
        this.cube_r10 = new ModelRenderer((Model)this);
        this.cube_r10.func_78793_a(-2.504f, 0.2896f, 2.0E-4f);
        this.RightHand.func_78792_a(this.cube_r10);
        this.setRotationAngle(this.cube_r10, 0.0f, 0.0f, 0.0873f);
        this.cube_r10.func_78784_a(0, 47).func_228303_a_(4.3f, -2.4f, -1.5f, 1.0f, 4.0f, 3.0f, 0.0f, false);
        this.cube_r11 = new ModelRenderer((Model)this);
        this.cube_r11.func_78793_a(-2.504f, 0.2896f, 2.0E-4f);
        this.RightHand.func_78792_a(this.cube_r11);
        this.setRotationAngle(this.cube_r11, 0.0f, 0.0f, -0.0873f);
        this.cube_r11.func_78784_a(64, 18).func_228303_a_(-0.3f, -1.95f, -1.5f, 1.0f, 4.0f, 3.0f, 0.0f, false);
        this.Sword = new ModelRenderer((Model)this);
        this.Sword.func_78793_a(-2.504f, 0.2896f, 2.0E-4f);
        this.RightHand.func_78792_a(this.Sword);
        this.cube_r12 = new ModelRenderer((Model)this);
        this.cube_r12.func_78793_a(2.5f, 3.5f, -1.5f);
        this.Sword.func_78792_a(this.cube_r12);
        this.setRotationAngle(this.cube_r12, 3.1416f, -0.0436f, 1.5708f);
        this.cube_r12.func_78784_a(0, 15).func_228303_a_(-3.5f, 0.0f, -3.0f, 7.0f, 0.0f, 14.0f, 0.0f, false);
        this.Head = new ModelRenderer((Model)this);
        this.Head.func_78793_a(0.0f, -18.5f, -1.0f);
        this.MainBody.func_78792_a(this.Head);
        this.Head.func_78784_a(43, 12).func_228303_a_(4.0f, -4.5f, -4.0f, 1.0f, 8.0f, 9.0f, 0.0f, false);
        this.Head.func_78784_a(0, 47).func_228303_a_(-5.0f, -4.5f, -4.0f, 1.0f, 8.0f, 9.0f, 0.0f, false);
        this.Head.func_78784_a(29, 0).func_228303_a_(-5.0f, -6.5f, -4.0f, 10.0f, 1.0f, 10.0f, 0.0f, false);
        this.Head.func_78784_a(51, 47).func_228303_a_(-5.0f, -5.5f, 5.0f, 10.0f, 9.0f, 1.0f, 0.0f, false);
        this.Head.func_78784_a(0, 30).func_228303_a_(-4.0f, -4.5f, -3.0f, 8.0f, 8.0f, 8.0f, 0.0f, false);
        this.HappyFace = new ModelRenderer((Model)this);
        this.HappyFace.func_78793_a(0.0f, 13.0f, 0.5f);
        this.HappyFace.func_78784_a(74, 25).func_228303_a_(-4.0f, -12.5f, -5.0f, 8.0f, 8.0f, 0.0f, 0.0f, false);
    }

    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.entit = entity;
        this.setRotationAngle(this.Body, (float)((double)0.1396f + Math.sin(ageInTicks / 8.0f) / 8.0), 0.0f, 0.0f);
        this.setRotationAngle(this.DefaultFace, 0.0f, 0.0f, (float)(Math.sin(ageInTicks / 16.0f) / 24.0));
        this.setRotationAngle(this.LeftWing, 0.6109f, (float)((double)-0.6109f - Math.sin(ageInTicks / 8.0f) / 4.0), -0.5236f);
        this.setRotationAngle(this.RightWing, 0.4363f, (float)((double)0.6109f + Math.sin(ageInTicks / 8.0f) / 4.0), 0.5236f);
    }

    public void func_225598_a_(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.DefaultFace.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.MainBody.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
