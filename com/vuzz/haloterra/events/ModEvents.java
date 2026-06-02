package com.vuzz.haloterra.events;

import com.vuzz.haloterra.blocks.ModBlocks;
import com.vuzz.haloterra.capability.CapabilityPM;
import com.vuzz.haloterra.capability.CapabilityPMProvider;
import com.vuzz.haloterra.capability.PM;
import com.vuzz.haloterra.config.HaloTerraCommonConfig;
import com.vuzz.haloterra.effects.ModEffects;
import com.vuzz.haloterra.items.ModItems;
import com.vuzz.haloterra.world.gen.ModOreGeneration;
import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid="haloterra")
public class ModEvents {
    public static final ResourceLocation PM_ID = new ResourceLocation("haloterra", "pm");
    public static final ResourceLocation PROGRESS_ID = new ResourceLocation("haloterra", "progress");

    private static BlockState lookingAt(PlayerEntity player, boolean isFluid) {
        ArrayList list = new ArrayList();
        RayTraceResult block = player.func_213324_a(20.0, 0.0f, isFluid);
        if (block.func_216346_c() == RayTraceResult.Type.BLOCK) {
            BlockPos blockpos = ((BlockRayTraceResult)block).func_216350_a();
            BlockState blockState = player.field_70170_p.func_180495_p(blockpos);
            return blockState;
        }
        return null;
    }

    private static BlockPos lookingAtPos(PlayerEntity player, boolean isFluid) {
        ArrayList list = new ArrayList();
        RayTraceResult block = player.func_213324_a(20.0, 0.0f, isFluid);
        if (block.func_216346_c() == RayTraceResult.Type.BLOCK) {
            BlockPos blockpos = ((BlockRayTraceResult)block).func_216350_a();
            return blockpos;
        }
        return null;
    }

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        if (!event.getEntity().func_130014_f_().field_72995_K && event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)event.getEntity();
            ServerWorld world = (ServerWorld)event.getWorld();
            BlockPos blockPos = event.getPos();
            ItemStack stack = event.getItemStack();
            BlockState blockState = ModEvents.lookingAt(player, false);
            Block block = blockState.func_177230_c();
            if (block == ModBlocks.COMPUTER.get() && stack.func_77973_b() == ModItems.DECODER.get()) {
                if (((Boolean)HaloTerraCommonConfig.ENABLE_STORY.get()).booleanValue()) {
                    player.func_146105_b((ITextComponent)new TranslationTextComponent("story.haloterra.incompatible"), true);
                } else {
                    player.func_146105_b((ITextComponent)new TranslationTextComponent("story.haloterra.disabled"), true);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerChat(ServerChatEvent event) {
        String message = event.getMessage().toLowerCase();
        ServerPlayerEntity player = event.getPlayer();
        if (message.contains("ave revivus") && !player.func_184216_O().contains("averevs")) {
            player.func_184211_a("averevs");
            player.func_71019_a(new ItemStack((IItemProvider)ModItems.REVIVUS_TEA.get()), false);
            player.func_71019_a(new ItemStack((IItemProvider)ModItems.REVIVUS_TEA.get()), false);
            player.func_71019_a(new ItemStack((IItemProvider)ModItems.REVIVUS_TEA.get()), false);
            player.func_145747_a((ITextComponent)new TranslationTextComponent("message.revivus_tea.achieved"), Util.field_240973_b_);
        }
    }

    @SubscribeEvent
    public static void onLivingUpdateEvent(LivingEvent.LivingUpdateEvent event) {
        if (!event.getEntity().func_130014_f_().field_72995_K && event.getEntity() instanceof PlayerEntity) {
            CompoundNBT nbt = event.getEntity().getPersistentData();
            PlayerEntity player = (PlayerEntity)event.getEntity();
            if (event.getEntity().func_130014_f_().func_201674_k().nextFloat() < 1.0E-4f) {
                int pmToGive = Math.round(20.0f);
                LazyOptional<PM> capability = PM.get((Entity)player);
                if (capability.resolve().isPresent()) {
                    PM cap = (PM)capability.resolve().get();
                    cap.setPm(cap.getPm() + pmToGive);
                    cap.sync((ServerPlayerEntity)player);
                }
                String ablob = new TranslationTextComponent("title.haloterra.ablob").getString();
                player.func_146105_b((ITextComponent)new StringTextComponent(ablob + pmToGive + " " + new TranslationTextComponent("title.haloterra.pm").getString()), true);
            }
            Biome biome = player.func_130014_f_().func_226691_t_(player.func_233580_cy_());
            float temperaturePlayer = nbt.func_74760_g("temperature");
            float difference = biome.func_242445_k() - temperaturePlayer;
            float useDifference = difference / 200.0f;
            player.getPersistentData().func_74776_a("temperature", temperaturePlayer + useDifference);
            float temperature = temperaturePlayer + useDifference;
            if ((double)temperaturePlayer >= 1.7 || (double)temperaturePlayer <= -0.7) {
                player.func_195064_c(new EffectInstance((Effect)ModEffects.HYBERNATION.get(), 2, 0, false, false, false, player.func_70660_b((Effect)ModEffects.HYBERNATION.get())));
            }
        }
    }

    @SubscribeEvent
    public static void onFMLCommonSetup(FMLCommonSetupEvent event) {
        CapabilityPM.register();
    }

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity) {
            event.addCapability(PM_ID, (ICapabilityProvider)new CapabilityPMProvider());
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (event.getPlayer().func_130014_f_().field_72995_K) {
            return;
        }
        PlayerEntity old = event.getOriginal();
        PlayerEntity newP = event.getPlayer();
        old.revive();
        System.out.println(String.format("Player is cloning! Old present: %s,New present: %s", PM.get((Entity)old).isPresent(), PM.get((Entity)newP).isPresent()));
        PM.get((Entity)old).ifPresent(oldPm -> PM.get((Entity)newP).ifPresent(newPm -> {
            newPm.setPm(oldPm.getPm());
            newPm.setProgress(oldPm.getProgress());
        }));
    }

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        ModEvents.sync(event.getPlayer());
    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        ModEvents.sync(event.getPlayer());
    }

    @SubscribeEvent
    public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        ModEvents.sync(event.getPlayer());
    }

    private static void sync(PlayerEntity player) {
        if (player instanceof ServerPlayerEntity) {
            PM.get((Entity)player).ifPresent(cap -> {
                cap.setPm(cap.getPm());
                cap.setProgress(cap.getProgress());
                cap.sync((ServerPlayerEntity)player);
            });
        }
    }

    @SubscribeEvent
    public static void biomeLoadingEvent(BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);
    }

    @SubscribeEvent
    public static void onPlayerWakeUpEvent(PlayerWakeUpEvent event) {
        PlayerEntity player;
        if (!event.getEntity().func_130014_f_().field_72995_K && (player = (PlayerEntity)event.getEntity()).getPersistentData().func_74767_n("hasraya")) {
            player.func_145747_a((ITextComponent)new TranslationTextComponent("message.haloterra.wakeup"), Util.field_240973_b_);
        }
    }

    @SubscribeEvent
    public static void onPlayerDestroyItemEvent(PlayerDestroyItemEvent event) {
        PlayerEntity player;
        if (event.getEntity().func_130014_f_().field_72995_K || (player = (PlayerEntity)event.getEntity()).getPersistentData().func_74767_n("hasraya")) {
            // empty if block
        }
    }

    @SubscribeEvent
    public static void onLivingDeathEvent(LivingDeathEvent event) {
        Entity killer;
        event.getEntityLiving().func_110138_aP();
        if (!event.getEntity().func_130014_f_().field_72995_K && (killer = event.getSource().func_76346_g()) != null && killer instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)killer;
            if (player.getPersistentData().func_74762_e("try") <= 3) {
                player.getPersistentData().func_74768_a("try", player.getPersistentData().func_74762_e("try") + 1);
                return;
            }
            player.getPersistentData().func_74768_a("try", 0);
            float killedHp = event.getEntityLiving().func_110138_aP();
            float pmRaw = (float)((double)killedHp / 2.25 * (double)(event.getEntity().func_130014_f_().func_201674_k().nextFloat() + 0.5f));
            int pmToGive = (int)pmRaw;
            LazyOptional<PM> capability = PM.get((Entity)player);
            if (capability.resolve().isPresent()) {
                PM cap = (PM)capability.resolve().get();
                cap.setPm(cap.getPm() + pmToGive);
                cap.sync((ServerPlayerEntity)player);
            }
            String ablob = new TranslationTextComponent("title.haloterra.ablob").getString();
            player.func_146105_b((ITextComponent)new StringTextComponent(ablob + pmToGive + " " + new TranslationTextComponent("title.haloterra.pm").getString()), true);
        }
    }
}
