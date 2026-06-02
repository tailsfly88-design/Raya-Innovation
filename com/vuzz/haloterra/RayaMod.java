package com.vuzz.haloterra;

import com.vuzz.haloterra.blocks.ModBlocks;
import com.vuzz.haloterra.config.HaloTerraCommonConfig;
import com.vuzz.haloterra.effects.ModEffects;
import com.vuzz.haloterra.entities.ModEntityTypes;
import com.vuzz.haloterra.entities.render.BeyondtoRenderer;
import com.vuzz.haloterra.entities.render.OcubladeRenderer;
import com.vuzz.haloterra.entities.render.OculusRender;
import com.vuzz.haloterra.entities.render.PlauntRenderer;
import com.vuzz.haloterra.entities.render.RayaPrimeRenderer;
import com.vuzz.haloterra.entities.render.RehoboamRenderer;
import com.vuzz.haloterra.gui.containers.ModContainers;
import com.vuzz.haloterra.gui.screens.ChargePadScreen;
import com.vuzz.haloterra.gui.screens.ShopScreen;
import com.vuzz.haloterra.items.ModItems;
import com.vuzz.haloterra.networking.ClientProxy;
import com.vuzz.haloterra.networking.IProxy;
import com.vuzz.haloterra.networking.Networking;
import com.vuzz.haloterra.networking.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(value="haloterra")
public class RayaMod {
    public static final String MOD_ID = "haloterra";
    public static final IProxy PROXY = (IProxy)DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
    public static final ItemGroup MOD_GROUP = new ItemGroup("haloterra"){

        public ItemStack func_78016_d() {
            return new ItemStack((IItemProvider)ModItems.INACTIVE_IMPLANT.get());
        }
    };

    public RayaMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Networking.register();
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModContainers.register(eventBus);
        ModEffects.register(eventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, HaloTerraCommonConfig.SPEC, "haloterra-common.toml");
        eventBus.addListener(this::doClientStuff);
    }

    private void doClientStuff(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler((EntityType)((EntityType)ModEntityTypes.RAYA_PRIME.get()), RayaPrimeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler((EntityType)((EntityType)ModEntityTypes.BEYONDTO.get()), BeyondtoRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler((EntityType)((EntityType)ModEntityTypes.OCULUS.get()), OculusRender::new);
        RenderingRegistry.registerEntityRenderingHandler((EntityType)((EntityType)ModEntityTypes.OCUBLADE.get()), OcubladeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler((EntityType)((EntityType)ModEntityTypes.PLAUNT.get()), PlauntRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler((EntityType)((EntityType)ModEntityTypes.REHOBOAM.get()), RehoboamRenderer::new);
        event.enqueueWork(() -> {
            this.clientSetup(event);
            ScreenManager.func_216911_a((ContainerType)((ContainerType)ModContainers.RAYA_PRIME_CONTAINER.get()), ShopScreen::new);
            ScreenManager.func_216911_a((ContainerType)((ContainerType)ModContainers.CHARGE_PAD_CONTAINER.get()), ChargePadScreen::new);
        });
    }

    private void clientSetup(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer((Block)((Block)ModBlocks.MR_TOMATO.get()), (RenderType)RenderType.func_228643_e_());
        RenderTypeLookup.setRenderLayer((Block)((Block)ModBlocks.MR_TOMATO_GOLD.get()), (RenderType)RenderType.func_228643_e_());
        RenderTypeLookup.setRenderLayer((Block)((Block)ModBlocks.COMPUTER.get()), (RenderType)RenderType.func_228643_e_());
        RenderTypeLookup.setRenderLayer((Block)((Block)ModBlocks.GRAPES.get()), (RenderType)RenderType.func_228643_e_());
    }
}
