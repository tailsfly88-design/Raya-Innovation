package com.vuzz.haloterra.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.vuzz.haloterra.entities.custom.RayaPrimeEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class RayaPrimeModel<T extends RayaPrimeEntity>
extends EntityModel<T> {
    public int anim;
    public int ticks;
    private final ModelRenderer MainBody;
    private final ModelRenderer UpperAC_r1;
    private final ModelRenderer LeftEar;
    private final ModelRenderer RightEar;
    private final ModelRenderer BackJet;
    private final ModelRenderer BackJettyFire_r1;
    private final ModelRenderer BottomJet;
    private final ModelRenderer BottJetFire_r1;
    private final ModelRenderer UwUFace;
    private final ModelRenderer ErrorFace;
    private final ModelRenderer errorface_r1;
    private final ModelRenderer errorface_r2;
    private final ModelRenderer DoneFace;
    private final ModelRenderer doneeye_r1;
    private final ModelRenderer doneeye_r2;
    private final ModelRenderer LoadingFace;
    private final ModelRenderer AttentionFace;
    private final ModelRenderer SadFace;
    private final ModelRenderer eyebrow2_r1;
    private final ModelRenderer eyebrow2_r2;
    private final ModelRenderer SmugFace;
    private final ModelRenderer RedAngryFace;
    private final ModelRenderer eyebrow2_r3;
    private final ModelRenderer eyebrow2_r4;
    private final ModelRenderer AngryFace;
    private final ModelRenderer eyebrow2_r5;
    private final ModelRenderer eyebrow2_r6;
    private final ModelRenderer WTFFace;
    private final ModelRenderer HeartFace;
    private final ModelRenderer Um2Face;
    private final ModelRenderer HappyFace;
    private final ModelRenderer DefFace;
    private final ModelRenderer LeftEye;
    private final ModelRenderer lefteye1;
    private final ModelRenderer lefteye2;
    private final ModelRenderer lefteye3;
    private final ModelRenderer lefteye4;
    private final ModelRenderer RightEye;
    private final ModelRenderer righteye1;
    private final ModelRenderer righteye2;
    private final ModelRenderer righteye3;
    private final ModelRenderer righteye4;
    private final ModelRenderer RightWing;
    private final ModelRenderer BottomWingR;
    private final ModelRenderer UpperWingR;
    private final ModelRenderer LeftWing;
    private final ModelRenderer BottomWingL;
    private final ModelRenderer UpperWingL;
    private final ModelRenderer SadFace2;
    private final ModelRenderer eyebrow3_r1;
    private final ModelRenderer eyebrow3_r2;
    private final ModelRenderer StruggleFace;
    private final ModelRenderer eyebrow3_r3;
    private final ModelRenderer RedHappyFace;
    private final ModelRenderer SillyFace;
    private T entit;

    public RayaPrimeModel() {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        this.MainBody = new ModelRenderer((Model)this);
        this.MainBody.func_78793_a(0.0f, 14.2929f, -1.0779f);
        this.MainBody.func_78784_a(81, 39).func_228303_a_(-2.0f, -5.2929f, -4.9221f, 4.0f, 1.0f, 5.0f, 0.0f, false);
        this.MainBody.func_78784_a(0, 0).func_228303_a_(-5.0f, -3.2929f, -4.7221f, 10.0f, 10.0f, 11.0f, 0.0f, false);
        this.MainBody.func_78784_a(44, 7).func_228303_a_(-6.0f, 6.7071f, -6.9221f, 12.0f, 1.0f, 13.0f, 0.0f, false);
        this.MainBody.func_78784_a(39, 0).func_228303_a_(-2.0f, 7.7071f, -5.9221f, 4.0f, 1.0f, 5.0f, 0.0f, false);
        this.MainBody.func_78784_a(98, 1).func_228303_a_(-6.0f, -3.2929f, -6.9221f, 1.0f, 10.0f, 13.0f, 0.0f, false);
        this.MainBody.func_78784_a(100, 27).func_228303_a_(5.0f, -3.2929f, -6.9221f, 1.0f, 10.0f, 13.0f, 0.0f, false);
        this.MainBody.func_78784_a(28, 30).func_228303_a_(-6.0f, -4.2929f, -6.9221f, 12.0f, 1.0f, 13.0f, 0.0f, false);
        this.UpperAC_r1 = new ModelRenderer((Model)this);
        this.UpperAC_r1.func_78793_a(0.0f, -5.7929f, 1.0779f);
        this.MainBody.func_78792_a(this.UpperAC_r1);
        this.setRotationAngle(this.UpperAC_r1, 0.2182f, 0.0f, 0.0f);
        this.UpperAC_r1.func_78784_a(92, 71).func_228303_a_(-5.0f, 0.6f, -4.0f, 10.0f, 3.0f, 8.0f, 0.0f, false);
        this.LeftEar = new ModelRenderer((Model)this);
        this.LeftEar.func_78793_a(3.0f, -3.9929f, -2.9721f);
        this.MainBody.func_78792_a(this.LeftEar);
        this.setRotationAngle(this.LeftEar, -0.8612f, 0.5216f, 0.5452f);
        this.LeftEar.func_78784_a(6, 27).func_228303_a_(-1.0f, -6.3f, 0.05f, 4.0f, 6.0f, 2.0f, 0.0f, false);
        this.LeftEar.func_78784_a(0, 28).func_228303_a_(-1.0f, -10.3f, 1.05f, 2.0f, 4.0f, 1.0f, 0.0f, false);
        this.RightEar = new ModelRenderer((Model)this);
        this.RightEar.func_78793_a(-3.0f, -4.2929f, -2.9221f);
        this.MainBody.func_78792_a(this.RightEar);
        this.setRotationAngle(this.RightEar, -0.8117f, -0.4476f, -0.7334f);
        this.RightEar.func_78784_a(6, 37).func_228303_a_(-3.0f, -6.0f, 0.0f, 4.0f, 6.0f, 2.0f, 0.0f, false);
        this.RightEar.func_78784_a(0, 36).func_228303_a_(-1.0f, -10.0f, 1.0f, 2.0f, 4.0f, 1.0f, 0.0f, false);
        this.BackJet = new ModelRenderer((Model)this);
        this.BackJet.func_78793_a(0.0f, -1.2929f, 6.0779f);
        this.MainBody.func_78792_a(this.BackJet);
        this.BackJettyFire_r1 = new ModelRenderer((Model)this);
        this.BackJettyFire_r1.func_78793_a(0.0f, 3.0f, 1.0f);
        this.BackJet.func_78792_a(this.BackJettyFire_r1);
        this.setRotationAngle(this.BackJettyFire_r1, 0.2618f, 0.0f, 0.0f);
        this.BackJettyFire_r1.func_78784_a(111, 56).func_228303_a_(-3.25f, 4.0f, -1.4f, 6.0f, 3.0f, 1.0f, 0.0f, false);
        this.BackJettyFire_r1.func_78784_a(108, 60).func_228303_a_(-4.0f, -4.0f, -1.9f, 8.0f, 8.0f, 2.0f, 0.0f, false);
        this.BottomJet = new ModelRenderer((Model)this);
        this.BottomJet.func_78793_a(0.0f, 8.6071f, -0.9221f);
        this.MainBody.func_78792_a(this.BottomJet);
        this.setRotationAngle(this.BottomJet, 0.5672f, 0.0f, 0.0f);
        this.BottomJet.func_78784_a(75, 61).func_228303_a_(-2.0f, -1.0f, -1.0f, 4.0f, 4.0f, 4.0f, 0.0f, false);
        this.BottJetFire_r1 = new ModelRenderer((Model)this);
        this.BottJetFire_r1.func_78793_a(-1.0f, 1.0f, 2.0f);
        this.BottomJet.func_78792_a(this.BottJetFire_r1);
        this.setRotationAngle(this.BottJetFire_r1, 0.0873f, 0.0f, 0.0f);
        this.BottJetFire_r1.func_78784_a(91, 62).func_228303_a_(-0.5f, 1.0f, -2.7f, 3.0f, 4.0f, 3.0f, 0.0f, false);
        this.UwUFace = new ModelRenderer((Model)this);
        this.UwUFace.func_78793_a(0.0f, 16.0f, -10.0f);
        this.UwUFace.func_78784_a(60, 108).func_228303_a_(-5.0f, -5.05f, 3.999f, 10.0f, 10.0f, 0.0f, 0.0f, false);
        this.UwUFace.func_78784_a(60, 101).func_228303_a_(-2.5f, 1.2f, 3.999f, 5.0f, 2.0f, 0.0f, 0.0f, false);
        this.ErrorFace = new ModelRenderer((Model)this);
        this.ErrorFace.func_78793_a(0.0f, 16.0f, -10.0f);
        this.errorface_r1 = new ModelRenderer((Model)this);
        this.errorface_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.ErrorFace.func_78792_a(this.errorface_r1);
        this.setRotationAngle(this.errorface_r1, 0.0f, 0.0f, -0.7854f);
        this.errorface_r1.func_78784_a(60, 118).func_228303_a_(-1.0f, -4.0f, 3.999f, 2.0f, 8.0f, 0.0f, 0.0f, false);
        this.errorface_r2 = new ModelRenderer((Model)this);
        this.errorface_r2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.ErrorFace.func_78792_a(this.errorface_r2);
        this.setRotationAngle(this.errorface_r2, 0.0f, 0.0f, 0.7854f);
        this.errorface_r2.func_78784_a(60, 118).func_228303_a_(-1.0f, -4.0f, 3.999f, 2.0f, 8.0f, 0.0f, 0.0f, false);
        this.DoneFace = new ModelRenderer((Model)this);
        this.DoneFace.func_78793_a(0.0f, 16.25f, -10.0f);
        this.doneeye_r1 = new ModelRenderer((Model)this);
        this.doneeye_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.DoneFace.func_78792_a(this.doneeye_r1);
        this.setRotationAngle(this.doneeye_r1, 0.0f, 0.0f, 0.5236f);
        this.doneeye_r1.func_78784_a(60, 118).func_228303_a_(-0.4f, -4.15f, 3.999f, 2.0f, 5.0f, 0.0f, 0.0f, false);
        this.doneeye_r2 = new ModelRenderer((Model)this);
        this.doneeye_r2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.DoneFace.func_78792_a(this.doneeye_r2);
        this.setRotationAngle(this.doneeye_r2, 0.0f, 0.0f, -1.0472f);
        this.doneeye_r2.func_78784_a(60, 118).func_228303_a_(-2.8f, -2.4f, 3.999f, 2.0f, 4.0f, 0.0f, 0.0f, false);
        this.LoadingFace = new ModelRenderer((Model)this);
        this.LoadingFace.func_78793_a(0.0f, 16.0f, -10.0f);
        this.LoadingFace.func_78784_a(80, 118).func_228303_a_(-5.0f, -5.0f, 3.999f, 10.0f, 10.0f, 0.0f, 0.0f, false);
        this.AttentionFace = new ModelRenderer((Model)this);
        this.AttentionFace.func_78793_a(0.0f, 16.0f, -10.0f);
        this.AttentionFace.func_78784_a(40, 108).func_228303_a_(-4.0f, -5.85f, 3.999f, 10.0f, 10.0f, 0.0f, 0.0f, false);
        this.SadFace = new ModelRenderer((Model)this);
        this.SadFace.func_78793_a(0.0f, 16.0f, -10.0f);
        this.SadFace.func_78784_a(40, 118).func_228303_a_(-5.4f, -4.75f, 3.999f, 10.0f, 10.0f, 0.0f, 0.0f, false);
        this.eyebrow2_r1 = new ModelRenderer((Model)this);
        this.eyebrow2_r1.func_78793_a(0.0f, -1.6987f, 3.998f);
        this.SadFace.func_78792_a(this.eyebrow2_r1);
        this.setRotationAngle(this.eyebrow2_r1, 3.1416f, 0.0f, -2.8362f);
        this.eyebrow2_r1.func_78784_a(122, 96).func_228303_a_(-3.8878f, -0.3f, 0.0f, 3.0f, 1.0f, 0.0f, 0.0f, false);
        this.eyebrow2_r1.func_78784_a(122, 96).func_228303_a_(-5.2878f, -1.3f, 0.0f, 3.0f, 2.0f, 0.0f, 0.0f, false);
        this.eyebrow2_r2 = new ModelRenderer((Model)this);
        this.eyebrow2_r2.func_78793_a(-2.4f, -2.1f, 3.998f);
        this.SadFace.func_78792_a(this.eyebrow2_r2);
        this.setRotationAngle(this.eyebrow2_r2, 0.0f, 0.0f, -0.2182f);
        this.eyebrow2_r2.func_78784_a(122, 96).func_228303_a_(-1.3f, 0.8f, 0.0f, 3.0f, 1.0f, 0.0f, 0.0f, false);
        this.eyebrow2_r2.func_78784_a(122, 96).func_228303_a_(-2.7f, 0.8f, 0.0f, 3.0f, 1.0f, 0.0f, 0.0f, false);
        this.SmugFace = new ModelRenderer((Model)this);
        this.SmugFace.func_78793_a(0.0f, 16.0f, -10.0f);
        this.SmugFace.func_78784_a(30, 98).func_228303_a_(-5.0f, -4.95f, 3.999f, 10.0f, 10.0f, 0.0f, 0.0f, false);
        this.RedAngryFace = new ModelRenderer((Model)this);
        this.RedAngryFace.func_78793_a(0.0f, 16.0f, -10.0f);
        this.RedAngryFace.func_78784_a(21, 82).func_228303_a_(-4.9f, -4.75f, 3.999f, 10.0f, 10.0f, 0.0f, 0.0f, false);
        this.RedAngryFace.func_78784_a(85, 87).func_228303_a_(-5.0f, -5.05f, 4.099f, 10.0f, 10.0f, 0.0f, 0.0f, false);
        this.RedAngryFace.func_78784_a(1, 9).func_228303_a_(-0.9f, 0.7f, 3.999f, 2.0f, 1.0f, 0.0f, 0.0f, false);
        this.eyebrow2_r3 = new ModelRenderer((Model)this);
        this.eyebrow2_r3.func_78793_a(0.0f, -1.6987f, 3.998f);
        this.RedAngryFace.func_78792_a(this.eyebrow2_r3);
        this.setRotationAngle(this.eyebrow2_r3, 3.1416f, 0.0f, 2.8362f);
        this.eyebrow2_r3.func_78784_a(86, 91).func_228303_a_(-4.0878f, 0.2f, 0.092f, 3.0f, 1.0f, 0.0f, 0.0f, false);
        this.eyebrow2_r3.func_78784_a(88, 91).func_228303_a_(-3.7878f, 0.2f, 0.092f, 3.0f, 1.0f, 0.0f, 0.0f, false);
        this.eyebrow2_r4 = new ModelRenderer((Model)this);
        this.eyebrow2_r4.func_78793_a(-2.4f, -2.1f, 3.998f);
        this.RedAngryFace.func_78792_a(this.eyebrow2_r4);
        this.setRotationAngle(this.eyebrow2_r4, 0.0f, 0.0f, 0.2182f);
        this.eyebrow2_r4.func_78784_a(86, 92).func_228303_a_(-1.6f, -0.1f, -0.008f, 3.0f, 1.0f, 0.0f, 0.0f, false);
        this.eyebrow2_r4.func_78784_a(87, 92).func_228303_a_(-1.2f, -0.1f, -0.008f, 3.0f, 1.0f, 0.0f, 0.0f, false);
        this.AngryFace = new ModelRenderer((Model)this);
        this.AngryFace.func_78793_a(0.0f, 16.0f, -10.0f);
        this.AngryFace.func_78784_a(20, 118).func_228303_a_(-4.9f, -4.75f, 3.999f, 10.0f, 10.0f, 0.0f, 0.0f, false);
        this.AngryFace.func_78784_a(1, 7).func_228303_a_(-0.9f, 0.7f, 3.999f, 2.0f, 1.0f, 0.0f, 0.0f, false);
        this.eyebrow2_r5 = new ModelRenderer((Model)this);
        this.eyebrow2_r5.func_78793_a(0.0f, -1.6987f, 3.998f);
        this.AngryFace.func_78792_a(this.eyebrow2_r5);
        this.setRotationAngle(this.eyebrow2_r5, 3.1416f, 0.0f, 2.8362f);
        this.eyebrow2_r5.func_78784_a(120, 96).func_228303_a_(-4.0878f, 0.2f, 0.0f, 3.0f, 1.0f, 0.0f, 0.0f, false);
        this.eyebrow2_r5.func_78784_a(121, 95).func_228303_a_(-3.7878f, 0.2f, 0.0f, 3.0f, 1.0f, 0.0f, 0.0f, false);
        this.eyebrow2_r6 = new ModelRenderer((Model)this);
        this.eyebrow2_r6.func_78793_a(-2.4f, -2.1f, 3.998f);
        this.AngryFace.func_78792_a(this.eyebrow2_r6);
        this.setRotationAngle(this.eyebrow2_r6, 0.0f, 0.0f, 0.2182f);
        this.eyebrow2_r6.func_78784_a(120, 96).func_228303_a_(-1.6f, -0.1f, 0.0f, 3.0f, 1.0f, 0.0f, 0.0f, false);
        this.eyebrow2_r6.func_78784_a(120, 97).func_228303_a_(-1.3f, -0.1f, 0.0f, 3.0f, 1.0f, 0.0f, 0.0f, false);
        this.WTFFace = new ModelRenderer((Model)this);
        this.WTFFace.func_78793_a(0.0f, 16.0f, -10.0f);
        this.WTFFace.func_78784_a(0, 118).func_228303_a_(-5.0f, -5.0f, 3.999f, 10.0f, 10.0f, 0.0f, 0.0f, false);
        this.WTFFace.func_78784_a(1, 1).func_228303_a_(-0.5f, 1.5f, 3.999f, 1.0f, 1.0f, 0.0f, 0.0f, false);
        this.HeartFace = new ModelRenderer((Model)this);
        this.HeartFace.func_78793_a(0.0f, 16.0f, -10.0f);
        this.HeartFace.func_78784_a(106, 118).func_228303_a_(-5.5f, -4.0f, 3.999f, 11.0f, 10.0f, 0.0f, 0.0f, false);
        this.HeartFace.func_78784_a(121, 96).func_228303_a_(-0.95f, -2.45f, 3.998f, 2.0f, 3.0f, 0.0f, 0.0f, false);
        this.Um2Face = new ModelRenderer((Model)this);
        this.Um2Face.func_78793_a(0.0f, 16.0f, -10.0f);
        this.Um2Face.func_78784_a(0, 75).func_228303_a_(-5.0f, -5.0f, 3.999f, 10.0f, 10.0f, 0.0f, 0.0f, false);
        this.HappyFace = new ModelRenderer((Model)this);
        this.HappyFace.func_78793_a(0.0f, 16.0f, -10.0f);
        this.HappyFace.func_78784_a(10, 108).func_228303_a_(-5.0f, -5.0f, 3.999f, 10.0f, 10.0f, 0.0f, 0.0f, false);
        this.DefFace = new ModelRenderer((Model)this);
        this.DefFace.func_78793_a(0.0f, 24.0f, 0.0f);
        this.LeftEye = new ModelRenderer((Model)this);
        this.LeftEye.func_78793_a(-0.5f, -1.0f, 0.0f);
        this.DefFace.func_78792_a(this.LeftEye);
        this.lefteye1 = new ModelRenderer((Model)this);
        this.lefteye1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.LeftEye.func_78792_a(this.lefteye1);
        this.lefteye1.func_78784_a(0, 0).func_228303_a_(-3.0f, -9.0f, -6.001f, 2.0f, 2.0f, 1.0f, 0.0f, false);
        this.lefteye2 = new ModelRenderer((Model)this);
        this.lefteye2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.LeftEye.func_78792_a(this.lefteye2);
        this.lefteye2.func_78784_a(0, 0).func_228303_a_(-3.0f, -9.0f, -5.001f, 2.0f, 2.0f, 1.0f, 0.0f, false);
        this.lefteye3 = new ModelRenderer((Model)this);
        this.lefteye3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.LeftEye.func_78792_a(this.lefteye3);
        this.lefteye3.func_78784_a(0, 0).func_228303_a_(-3.0f, -9.0f, -5.001f, 2.0f, 2.0f, 1.0f, 0.0f, false);
        this.lefteye4 = new ModelRenderer((Model)this);
        this.lefteye4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.LeftEye.func_78792_a(this.lefteye4);
        this.lefteye4.func_78784_a(0, 0).func_228303_a_(-3.0f, -9.0f, -5.001f, 2.0f, 2.0f, 1.0f, 0.0f, false);
        this.RightEye = new ModelRenderer((Model)this);
        this.RightEye.func_78793_a(4.5f, -1.0f, -1.0f);
        this.DefFace.func_78792_a(this.RightEye);
        this.righteye1 = new ModelRenderer((Model)this);
        this.righteye1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.RightEye.func_78792_a(this.righteye1);
        this.righteye1.func_78784_a(0, 0).func_228303_a_(-3.0f, -9.0f, -5.001f, 2.0f, 2.0f, 1.0f, 0.0f, false);
        this.righteye2 = new ModelRenderer((Model)this);
        this.righteye2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.RightEye.func_78792_a(this.righteye2);
        this.righteye2.func_78784_a(0, 0).func_228303_a_(-3.0f, -9.0f, -4.001f, 2.0f, 2.0f, 1.0f, 0.0f, false);
        this.righteye3 = new ModelRenderer((Model)this);
        this.righteye3.func_78793_a(0.0f, 0.0f, 0.0f);
        this.RightEye.func_78792_a(this.righteye3);
        this.righteye3.func_78784_a(0, 0).func_228303_a_(-3.0f, -9.0f, -4.001f, 2.0f, 2.0f, 1.0f, 0.0f, false);
        this.righteye4 = new ModelRenderer((Model)this);
        this.righteye4.func_78793_a(0.0f, 0.0f, 0.0f);
        this.RightEye.func_78792_a(this.righteye4);
        this.righteye4.func_78784_a(0, 0).func_228303_a_(-3.0f, -9.0f, -4.001f, 2.0f, 2.0f, 1.0f, 0.0f, false);
        this.RightWing = new ModelRenderer((Model)this);
        this.RightWing.func_78793_a(-6.0f, 16.0f, -4.0f);
        this.setRotationAngle(this.RightWing, -0.3927f, -0.3491f, 0.0f);
        this.BottomWingR = new ModelRenderer((Model)this);
        this.BottomWingR.func_78793_a(0.1f, -1.0f, 0.0f);
        this.RightWing.func_78792_a(this.BottomWingR);
        this.setRotationAngle(this.BottomWingR, -0.3927f, 0.0f, 0.0f);
        this.BottomWingR.func_78784_a(6, 49).func_228303_a_(-1.0f, 0.0f, -1.0f, 1.0f, 2.0f, 6.0f, 0.0f, false);
        this.UpperWingR = new ModelRenderer((Model)this);
        this.UpperWingR.func_78793_a(0.5f, -0.5f, 0.0f);
        this.RightWing.func_78792_a(this.UpperWingR);
        this.setRotationAngle(this.UpperWingR, 0.3491f, 0.0f, 0.0f);
        this.UpperWingR.func_78784_a(2, 57).func_228303_a_(-2.0f, -2.5f, -1.0f, 2.0f, 3.0f, 8.0f, 0.0f, false);
        this.UpperWingR.func_78784_a(24, 63).func_228303_a_(-2.0f, -2.0f, 7.0f, 2.0f, 2.0f, 3.0f, 0.0f, false);
        this.LeftWing = new ModelRenderer((Model)this);
        this.LeftWing.func_78793_a(6.0f, 16.0f, -4.0f);
        this.setRotationAngle(this.LeftWing, -0.3927f, 0.3491f, 0.0f);
        this.BottomWingL = new ModelRenderer((Model)this);
        this.BottomWingL.func_78793_a(-0.1f, -1.0f, 0.0f);
        this.LeftWing.func_78792_a(this.BottomWingL);
        this.setRotationAngle(this.BottomWingL, -0.3927f, 0.0f, 0.0f);
        this.BottomWingL.func_78784_a(43, 49).func_228303_a_(0.0f, 0.0f, -1.0f, 1.0f, 2.0f, 6.0f, 0.0f, false);
        this.UpperWingL = new ModelRenderer((Model)this);
        this.UpperWingL.func_78793_a(-0.5f, 0.0f, 0.0f);
        this.LeftWing.func_78792_a(this.UpperWingL);
        this.setRotationAngle(this.UpperWingL, 0.3491f, 0.0f, 0.0f);
        this.UpperWingL.func_78784_a(40, 57).func_228303_a_(0.0f, -3.0f, -1.0f, 2.0f, 3.0f, 8.0f, 0.0f, false);
        this.UpperWingL.func_78784_a(62, 63).func_228303_a_(0.0f, -2.5f, 7.0f, 2.0f, 2.0f, 3.0f, 0.0f, false);
        this.SadFace2 = new ModelRenderer((Model)this);
        this.SadFace2.func_78793_a(0.0f, 16.0f, -10.0f);
        this.SadFace2.func_78784_a(45, 76).func_228303_a_(-5.4f, -4.75f, 3.999f, 10.0f, 10.0f, 0.0f, 0.0f, false);
        this.eyebrow3_r1 = new ModelRenderer((Model)this);
        this.eyebrow3_r1.func_78793_a(0.0f, -1.6987f, 3.998f);
        this.SadFace2.func_78792_a(this.eyebrow3_r1);
        this.setRotationAngle(this.eyebrow3_r1, 3.1416f, 0.0f, -2.8362f);
        this.eyebrow3_r1.func_78784_a(122, 96).func_228303_a_(-3.8878f, -0.3f, 0.0f, 3.0f, 1.0f, 0.0f, 0.0f, false);
        this.eyebrow3_r1.func_78784_a(122, 96).func_228303_a_(-5.2878f, -1.3f, 0.0f, 3.0f, 2.0f, 0.0f, 0.0f, false);
        this.eyebrow3_r2 = new ModelRenderer((Model)this);
        this.eyebrow3_r2.func_78793_a(-2.4f, -2.1f, 3.998f);
        this.SadFace2.func_78792_a(this.eyebrow3_r2);
        this.setRotationAngle(this.eyebrow3_r2, 0.0f, 0.0f, -0.2182f);
        this.eyebrow3_r2.func_78784_a(122, 96).func_228303_a_(-1.3f, 0.8f, 0.0f, 3.0f, 1.0f, 0.0f, 0.0f, false);
        this.eyebrow3_r2.func_78784_a(122, 96).func_228303_a_(-2.7f, 0.8f, 0.0f, 3.0f, 1.0f, 0.0f, 0.0f, false);
        this.StruggleFace = new ModelRenderer((Model)this);
        this.StruggleFace.func_78793_a(0.5f, 16.0f, -10.0f);
        this.StruggleFace.func_78784_a(107, 103).func_228303_a_(-5.0f, -5.0f, 3.999f, 10.0f, 10.0f, 0.0f, 0.0f, false);
        this.eyebrow3_r3 = new ModelRenderer((Model)this);
        this.eyebrow3_r3.func_78793_a(0.0f, -1.6987f, 3.998f);
        this.StruggleFace.func_78792_a(this.eyebrow3_r3);
        this.setRotationAngle(this.eyebrow3_r3, -3.1416f, 0.0f, 3.1416f);
        this.eyebrow3_r3.func_78784_a(121, 95).func_228303_a_(2.5122f, 0.7f, 0.0f, 2.0f, 2.0f, 0.0f, 0.0f, false);
        this.eyebrow3_r3.func_78784_a(121, 95).func_228303_a_(-2.4878f, 0.7f, 0.0f, 2.0f, 2.0f, 0.0f, 0.0f, false);
        this.RedHappyFace = new ModelRenderer((Model)this);
        this.RedHappyFace.func_78793_a(0.0f, 16.0f, -10.0f);
        this.RedHappyFace.func_78784_a(21, 70).func_228303_a_(-5.0f, -5.05f, 3.999f, 10.0f, 10.0f, 0.0f, 0.0f, false);
        this.RedHappyFace.func_78784_a(85, 87).func_228303_a_(-5.0f, -5.05f, 4.099f, 10.0f, 10.0f, 0.0f, 0.0f, false);
        this.SillyFace = new ModelRenderer((Model)this);
        this.SillyFace.func_78793_a(0.0f, 16.0f, -10.0f);
        this.SillyFace.func_78784_a(77, 102).func_228303_a_(-5.0f, -5.0f, 3.999f, 10.0f, 10.0f, 0.0f, 0.0f, false);
    }

    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.entit = entity;
        this.anim = entity.getPersistentData().func_74762_e("anim");
        this.ticks = (int)ageInTicks;
        this.setRotationAngle(this.BottomWingR, -0.393f, 0.0f, 0.0f);
        this.setRotationAngle(this.UpperWingR, 0.349f, 0.0f, 0.0f);
        this.setRotationAngle(this.RightWing, (float)((double)0.26f + ((double)-0.349f + Math.sin(ageInTicks / 5.0f) / 24.0)), (float)((double)-0.349f - Math.sin(ageInTicks / 5.0f) / 6.0), 0.0f);
        this.setRotationAngle(this.BottomWingL, -0.393f, 0.0f, 0.0f);
        this.setRotationAngle(this.UpperWingL, 0.349f, 0.0f, 0.0f);
        this.setRotationAngle(this.LeftWing, (float)((double)0.26f + ((double)-0.349f + Math.sin(ageInTicks / 5.0f) / 24.0)), (float)((double)0.349f + Math.sin(ageInTicks / 5.0f) / 6.0), 0.0f);
        this.setRotationAngle(this.BottomJet, (float)((double)0.654f - Math.sin(ageInTicks / 5.0f) / 6.0), 0.0f, 0.0f);
        this.setRotationAngle(this.LeftEar, (float)((double)-0.749f + Math.sin(ageInTicks / 5.0f) / 16.0), (float)((double)-0.26f + ((double)0.349f + Math.sin(ageInTicks / 5.0f) / 24.0)), 0.26f);
        this.setRotationAngle(this.RightEar, (float)((double)-0.749f + Math.sin(ageInTicks / 5.0f) / 16.0), (float)((double)0.26f + ((double)-0.349f + Math.sin(ageInTicks / 5.0f) / 24.0)), -0.26f);
    }

    public void func_225598_a_(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.MainBody.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        ModelRenderer[] faces = new ModelRenderer[]{this.DefFace, this.UwUFace, this.ErrorFace, this.DoneFace, this.LoadingFace, this.AttentionFace, this.SadFace, this.SmugFace, this.AngryFace, this.WTFFace, this.HappyFace, this.StruggleFace, this.SadFace2, this.RedAngryFace, this.HeartFace, this.Um2Face, this.RedHappyFace, this.SillyFace};
        int curAnim = this.entit.getPersistentData().func_74762_e("anim");
        this.RightWing.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.LeftWing.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        matrixStack.func_227860_a_();
        switch (this.ticks % 100) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                matrixStack.func_227861_a_(0.0, (double)0.01f, 0.0);
                break;
            }
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: {
                matrixStack.func_227861_a_((double)0.01f, 0.0, 0.0);
                break;
            }
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: {
                matrixStack.func_227861_a_((double)-0.01f, 0.0, 0.0);
                break;
            }
            case 75: 
            case 76: 
            case 77: 
            case 78: 
            case 79: 
            case 80: {
                matrixStack.func_227861_a_(0.0, (double)-0.01f, 0.0);
            }
        }
        if (this.ticks % 60 > 3) {
            faces[this.anim].func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        }
        matrixStack.func_227865_b_();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
