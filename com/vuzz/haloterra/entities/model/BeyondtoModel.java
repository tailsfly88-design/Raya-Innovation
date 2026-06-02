package com.vuzz.haloterra.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.vuzz.haloterra.entities.custom.BeyondtoEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BeyondtoModel<T extends BeyondtoEntity>
extends EntityModel<T> {
    private final ModelRenderer LEar;
    private final ModelRenderer REar;
    private final ModelRenderer LWing;
    private final ModelRenderer RWing;
    private final ModelRenderer Body;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer bone;
    private final ModelRenderer bone2;
    private T entit;

    public BeyondtoModel() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.LEar = new ModelRenderer((Model)this);
        this.LEar.func_78793_a(2.0f, 14.25f, -1.75f);
        this.setRotationAngle(this.LEar, 0.0f, 0.0f, 0.4363f);
        this.LEar.func_78784_a(7, 13).func_228303_a_(-1.25f, -2.75f, -1.25f, 3.0f, 2.0f, 3.0f, 0.0f, false);
        this.LEar.func_78784_a(0, 0).func_228303_a_(-1.25f, -5.75f, -1.25f, 2.0f, 3.0f, 2.0f, 0.0f, false);
        this.REar = new ModelRenderer((Model)this);
        this.REar.func_78793_a(-2.5f, 13.25f, -1.75f);
        this.setRotationAngle(this.REar, 0.0f, 0.0f, -0.4363f);
        this.REar.func_78784_a(17, 37).func_228303_a_(-1.75f, -1.75f, -1.25f, 3.0f, 2.0f, 3.0f, 0.0f, false);
        this.REar.func_78784_a(42, 9).func_228303_a_(-0.75f, -4.75f, -1.25f, 2.0f, 3.0f, 2.0f, 0.0f, false);
        this.LWing = new ModelRenderer((Model)this);
        this.LWing.func_78793_a(5.0f, 17.0f, -2.0f);
        this.setRotationAngle(this.LWing, 0.3927f, 0.3054f, 0.0f);
        this.LWing.func_78784_a(28, 0).func_228303_a_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 6.0f, 0.0f, false);
        this.RWing = new ModelRenderer((Model)this);
        this.RWing.func_78793_a(-5.0f, 17.0f, -2.0f);
        this.setRotationAngle(this.RWing, 0.3054f, -0.3927f, 0.0f);
        this.RWing.func_78784_a(28, 0).func_228303_a_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 6.0f, 0.0f, false);
        this.Body = new ModelRenderer((Model)this);
        this.Body.func_78793_a(0.0f, 24.0f, 0.0f);
        this.Body.func_78784_a(0, 19).func_228303_a_(-4.0f, -11.0f, -4.0f, 8.0f, 8.0f, 8.0f, 0.0f, false);
        this.Body.func_78784_a(24, 44).func_228303_a_(-5.0f, -12.0f, -4.9f, 10.0f, 10.0f, 10.0f, 0.0f, false);
        this.Body.func_78784_a(33, 22).func_228303_a_(-1.5f, -13.0f, -3.0f, 3.0f, 2.0f, 4.0f, 0.0f, false);
        this.Body.func_78784_a(39, 0).func_228303_a_(-3.0f, -9.0f, 4.0f, 6.0f, 4.0f, 1.0f, 0.0f, false);
        this.Body.func_78784_a(0, 36).func_228303_a_(-3.5f, -10.5f, -5.0f, 7.0f, 7.0f, 1.0f, 0.0f, false);
        this.cube_r1 = new ModelRenderer((Model)this);
        this.cube_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Body.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.3054f, 0.0f, 0.0f);
        this.cube_r1.func_78784_a(27, 30).func_228303_a_(-3.0f, -3.8f, -2.0f, 6.0f, 3.0f, 6.0f, 0.0f, false);
        this.cube_r2 = new ModelRenderer((Model)this);
        this.cube_r2.func_78793_a(0.0f, -12.0f, -2.0f);
        this.Body.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, -0.3491f, 0.0f, 0.0f);
        this.cube_r2.func_78784_a(23, 12).func_228303_a_(-1.49f, -2.0f, 2.5f, 3.0f, 2.0f, 2.0f, 0.0f, false);
        this.bone = new ModelRenderer((Model)this);
        this.bone.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Body.func_78792_a(this.bone);
        this.bone.func_78784_a(10, 30).func_228303_a_(-1.6f, -8.0f, -5.01f, 1.0f, 2.0f, 0.0f, 0.0f, false);
        this.bone.func_78784_a(10, 30).func_228303_a_(-1.6f, -7.7f, -5.01f, 1.0f, 2.0f, 0.0f, 0.0f, false);
        this.bone.func_78784_a(10, 30).func_228303_a_(-1.9f, -7.7f, -5.01f, 1.0f, 2.0f, 0.0f, 0.0f, false);
        this.bone.func_78784_a(10, 30).func_228303_a_(-1.9f, -8.0f, -5.01f, 1.0f, 2.0f, 0.0f, 0.0f, false);
        this.bone2 = new ModelRenderer((Model)this);
        this.bone2.func_78793_a(2.5f, 0.0f, 0.0f);
        this.Body.func_78792_a(this.bone2);
        this.bone2.func_78784_a(10, 30).func_228303_a_(-1.6f, -8.0f, -5.01f, 1.0f, 2.0f, 0.0f, 0.0f, false);
        this.bone2.func_78784_a(10, 30).func_228303_a_(-1.6f, -7.7f, -5.01f, 1.0f, 2.0f, 0.0f, 0.0f, false);
        this.bone2.func_78784_a(10, 30).func_228303_a_(-1.9f, -7.7f, -5.01f, 1.0f, 2.0f, 0.0f, 0.0f, false);
        this.bone2.func_78784_a(10, 30).func_228303_a_(-1.9f, -8.0f, -5.01f, 1.0f, 2.0f, 0.0f, 0.0f, false);
    }

    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.entit = entity;
        int anim = this.entit.getPersistentData().func_74762_e("anim");
        this.setRotationAngle(this.RWing, 0.0f, (float)((double)-0.349f - Math.sin(ageInTicks / 4.0f) / 5.0), 0.0f);
        this.setRotationAngle(this.LWing, 0.0f, (float)((double)0.349f + Math.sin(ageInTicks / 4.0f) / 5.0), 0.0f);
        this.setRotationAngle(this.REar, 0.0f, 0.0f, (float)((double)-0.349f - Math.sin(ageInTicks / 4.0f) / 5.0));
        this.setRotationAngle(this.LEar, 0.0f, 0.0f, (float)((double)0.349f - Math.sin(ageInTicks / 4.0f) / 5.0));
    }

    public void func_225598_a_(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.LEar.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.REar.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.LWing.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.RWing.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.Body.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
