package com.vuzz.haloterra.entities.render;

import com.vuzz.haloterra.entities.custom.RayaPrimeEntity;
import com.vuzz.haloterra.entities.model.RayaPrimeModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RayaPrimeRenderer
extends MobRenderer<RayaPrimeEntity, RayaPrimeModel<RayaPrimeEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation("haloterra", "textures/entity/raya.png");

    public RayaPrimeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new RayaPrimeModel(), 0.75f);
    }

    public ResourceLocation getEntityTexture(RayaPrimeEntity entity) {
        return TEXTURE;
    }
}
