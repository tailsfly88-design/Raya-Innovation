package com.vuzz.haloterra.blocks.crops;

import com.vuzz.haloterra.items.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class GrapeBlock
extends CropsBlock {
    public GrapeBlock() {
        super(AbstractBlock.Properties.func_200950_a((AbstractBlock)Blocks.field_150459_bM));
    }

    protected IItemProvider func_199772_f() {
        return (IItemProvider)ModItems.GRAPE_SEEDS.get();
    }

    public VoxelShape func_220053_a(BlockState bs, IBlockReader br, BlockPos bp, ISelectionContext ctx) {
        return Block.func_208617_a((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0);
    }

    public int func_185526_g() {
        return 3;
    }

    protected int func_185529_b(World worldIn) {
        return 1;
    }
}
