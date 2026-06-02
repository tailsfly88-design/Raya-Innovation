package com.vuzz.haloterra.entities.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.vuzz.haloterra.entities.custom.OcubladeEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class OcubladeModel<T extends OcubladeEntity>
extends EntityModel<T> {
    private final ModelRenderer bb_main;

    public OcubladeModel() {
        this.field_78090_t = 128;
        this.field_78089_u = 128;
        this.bb_main = new ModelRenderer((Model)this);
        this.bb_main.func_78793_a(0.0f, 24.0f, 0.0f);
        this.bb_main.func_78784_a(-3, 0).func_228303_a_(-13.5f, 0.0f, -13.5f, 27.0f, 0.0f, 27.0f, 0.0f, false);
    }

    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotationAngle(this.bb_main, 0.0f, ageInTicks % 360.0f, 0.0f);
    }

    public void func_225598_a_(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.bb_main.func_228309_a_(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        System.out.println(packedLight);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
