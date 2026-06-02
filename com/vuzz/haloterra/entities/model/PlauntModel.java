package com.vuzz.haloterra.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.vuzz.haloterra.entities.custom.PlauntEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class PlauntModel<T extends PlauntEntity>
extends EntityModel<T> {
    private final ModelRenderer Body;
    private final ModelRenderer RightWheel;
    private final ModelRenderer LeftWheel;
    private final ModelRenderer Flower;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer DefaultFace;

    public PlauntModel() {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        this.Body = new ModelRenderer((Model)this);
        this.Body.func_78793_a(0.0f, 24.0f, 0.0f);
        this.Body.func_78784_a(0, 22).func_228303_a_(-5.0f, -12.0f, -5.0f, 10.0f, 9.0f, 10.0f, 0.0f, false);
        this.Body.func_78784_a(0, 0).func_228303_a_(-5.5f, -12.5f, -5.5f, 11.0f, 10.0f, 11.0f, 0.0f, false);
        this.Body.func_78784_a(31, 22).func_228303_a_(-3.0f, -9.0f, 5.0f, 6.0f, 5.0f, 2.0f, 0.0f, false);
        this.Body.func_78784_a(49, 8).func_228303_a_(-2.99f, -7.1f, 3.9f, 6.0f, 3.0f, 3.0f, 0.0f, false);
        this.Body.func_78784_a(32, 33).func_228303_a_(-4.5f, -19.0f, -4.5f, 9.0f, 7.0f, 9.0f, 0.0f, false);
        this.RightWheel = new ModelRenderer((Model)this);
        this.RightWheel.func_78793_a(-3.0f, -1.5f, 0.0f);
        this.Body.func_78792_a(this.RightWheel);
        this.RightWheel.func_78784_a(0, 0).func_228303_a_(-1.0f, -1.5f, -1.5f, 2.0f, 3.0f, 3.0f, 0.0f, false);
        this.LeftWheel = new ModelRenderer((Model)this);
        this.LeftWheel.func_78793_a(3.0f, -1.5f, 0.0f);
        this.Body.func_78792_a(this.LeftWheel);
        this.LeftWheel.func_78784_a(0, 0).func_228303_a_(-1.0f, -1.5f, -1.5f, 2.0f, 3.0f, 3.0f, 0.0f, false);
        this.Flower = new ModelRenderer((Model)this);
        this.Flower.func_78793_a(-0.3536f, -12.0f, 0.0f);
        this.Body.func_78792_a(this.Flower);
        this.cube_r1 = new ModelRenderer((Model)this);
        this.cube_r1.func_78793_a(0.3536f, 12.0f, 0.0f);
        this.Flower.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, -0.7854f, 0.0f);
        this.cube_r1.func_78784_a(34, 64).func_228303_a_(-3.5f, -18.0f, 0.0f, 6.0f, 6.0f, 0.0f, 0.0f, false);
        this.cube_r2 = new ModelRenderer((Model)this);
        this.cube_r2.func_78793_a(0.3536f, 12.0f, 0.0f);
        this.Flower.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.0f, 0.7854f, 0.0f);
        this.cube_r2.func_78784_a(34, 64).func_228303_a_(-3.5f, -18.0f, 0.0f, 6.0f, 6.0f, 0.0f, 0.0f, false);
        this.DefaultFace = new ModelRenderer((Model)this);
        this.DefaultFace.func_78793_a(0.0f, 16.5f, -5.01f);
        this.DefaultFace.func_78784_a(0, 54).func_228303_a_(-4.0f, -2.5f, 0.0f, 8.0f, 5.0f, 0.0f, 0.0f, false);
    }

    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotationAngle(this.DefaultFace, 0.0f, 0.0f, (float)(Math.sin(ageInTicks / 16.0f) / 18.0));
        this.setRotationAngle(this.Flower, (float)(Math.sin(ageInTicks / 16.0f) / 34.0), 0.0f, (float)(Math.sin(ageInTicks / 16.0f) / 44.0));
        this.setRotationAngle(this.RightWheel, ageInTicks / 14.0f, 0.0f, 0.0f);
        this.setRotationAngle(this.LeftWheel, ageInTicks / 14.0f, 0.0f, 0.0f);
    }

    public void func_225598_a_(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.Body.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.DefaultFace.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
