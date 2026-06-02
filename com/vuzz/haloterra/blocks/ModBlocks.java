package com.vuzz.haloterra.blocks;

import com.vuzz.haloterra.blocks.HaloComputer;
import com.vuzz.haloterra.blocks.RotateableBlock;
import com.vuzz.haloterra.blocks.crops.GrapeBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
    private static final String MODID = "haloterra";
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create((IForgeRegistry)ForgeRegistries.BLOCKS, (String)"haloterra");
    public static final RegistryObject<Block> LEAD_ORE = BLOCKS.register("lead_ore", () -> new Block(AbstractBlock.Properties.func_200945_a((Material)Material.field_151576_e).harvestLevel(2).harvestTool(ToolType.PICKAXE).func_235861_h_().func_200943_b(2.0f)));
    public static final RegistryObject<Block> LITHIUM_ORE = BLOCKS.register("lithium_ore", () -> new Block(AbstractBlock.Properties.func_200945_a((Material)Material.field_151576_e).harvestLevel(2).harvestTool(ToolType.PICKAXE).func_235861_h_().func_200943_b(2.0f)));
    public static final RegistryObject<Block> ENERGY_ORE = BLOCKS.register("energy_ore", () -> new Block(AbstractBlock.Properties.func_200945_a((Material)Material.field_151576_e).harvestLevel(2).harvestTool(ToolType.PICKAXE).func_235861_h_().func_200943_b(2.0f)));
    public static final RegistryObject<Block> MR_TOMATO = BLOCKS.register("mrtomato", () -> new Block(AbstractBlock.Properties.func_200945_a((Material)Material.field_215713_z).func_200943_b(2.0f).func_226896_b_().func_200942_a()));
    public static final RegistryObject<Block> MR_TOMATO_GOLD = BLOCKS.register("mrtomato_gold", () -> new Block(AbstractBlock.Properties.func_200945_a((Material)Material.field_215713_z).func_200943_b(2.0f).func_226896_b_().func_200942_a()));
    public static final RegistryObject<Block> COMPUTER = BLOCKS.register("computer", HaloComputer::new);
    public static final RegistryObject<Block> LABORATORY_BRICK = BLOCKS.register("laboratory_brick", () -> new Block(AbstractBlock.Properties.func_200945_a((Material)Material.field_151576_e).harvestLevel(3).harvestTool(ToolType.PICKAXE).func_235861_h_().func_200943_b(10.0f)));
    public static final RegistryObject<Block> LABORATORY_FLOOR = BLOCKS.register("laboratory_floor", () -> new Block(AbstractBlock.Properties.func_200945_a((Material)Material.field_151576_e).harvestLevel(3).harvestTool(ToolType.PICKAXE).func_235861_h_().func_200943_b(10.0f)));
    public static final RegistryObject<Block> PLUSH_VUZZ = BLOCKS.register("plush_vuzz", () -> new RotateableBlock(AbstractBlock.Properties.func_200945_a((Material)Material.field_215713_z).func_200943_b(2.0f).func_226896_b_().func_200942_a()));
    public static final RegistryObject<Block> PLUSH_BLACK = BLOCKS.register("plush_black", () -> new RotateableBlock(AbstractBlock.Properties.func_200945_a((Material)Material.field_215713_z).func_200943_b(2.0f).func_226896_b_().func_200942_a()));
    public static final RegistryObject<Block> PLUSH_TIMA = BLOCKS.register("plush_tima", () -> new RotateableBlock(AbstractBlock.Properties.func_200945_a((Material)Material.field_215713_z).func_200943_b(2.0f).func_226896_b_().func_200942_a()));
    public static final RegistryObject<Block> PLUSH_HUNTER = BLOCKS.register("plush_hunter", () -> new RotateableBlock(AbstractBlock.Properties.func_200945_a((Material)Material.field_215713_z).func_200943_b(2.0f).func_226896_b_().func_200942_a()));
    public static final RegistryObject<Block> PLUSH_LADDEP = BLOCKS.register("plush_laddep", () -> new RotateableBlock(AbstractBlock.Properties.func_200945_a((Material)Material.field_215713_z).func_200943_b(2.0f).func_226896_b_().func_200942_a()));
    public static final RegistryObject<Block> GRAPES = BLOCKS.register("grapes_crop", GrapeBlock::new);

    public static void register(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }
}
