package com.vuzz.haloterra.entities.render;

import com.vuzz.haloterra.entities.custom.OcubladeEntity;
import com.vuzz.haloterra.entities.model.OcubladeModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class OcubladeRenderer
extends MobRenderer<OcubladeEntity, OcubladeModel<OcubladeEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation("haloterra", "textures/entity/ocublade.png");

    public OcubladeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new OcubladeModel(), 0.1f);
    }

    public ResourceLocation getEntityTexture(OcubladeEntity entity) {
        return TEXTURE;
    }
}
