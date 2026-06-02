package com.vuzz.haloterra.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.vuzz.haloterra.entities.custom.RehoboamEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class RehoboamModel<T extends RehoboamEntity>
extends EntityModel<T> {
    private final ModelRenderer Body;
    private final ModelRenderer Screen;

    public RehoboamModel() {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        this.Body = new ModelRenderer((Model)this);
        this.Body.func_78793_a(0.0f, 24.0f, 0.0f);
        this.Body.func_78784_a(0, 33).func_228303_a_(-9.0f, -15.0f, -9.0f, 18.0f, 5.0f, 18.0f, 0.0f, false);
        this.Body.func_78784_a(0, 0).func_228303_a_(-8.0f, -20.0f, -8.0f, 16.0f, 16.0f, 16.0f, 0.0f, false);
        this.Body.func_78784_a(55, 16).func_228303_a_(-2.0f, -20.5f, -8.5f, 4.0f, 17.0f, 17.0f, 0.0f, false);
        this.Screen = new ModelRenderer((Model)this);
        this.Screen.func_78793_a(0.0f, 12.175f, -0.5f);
        this.Screen.func_78784_a(0, 77).func_228303_a_(-8.0f, -22.175f, -0.5f, 16.0f, 9.0f, 1.0f, 0.0f, false);
        this.Screen.func_78784_a(0, 95).func_228303_a_(-8.0f, -12.825f, -0.5f, 16.0f, 1.0f, 1.0f, 0.0f, false);
    }

    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotationAngle(this.Body, 0.0f, ageInTicks / 20.0f / 10.0f, 0.0f);
    }

    public void func_225598_a_(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.Body.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        this.Screen.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
