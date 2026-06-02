package com.vuzz.haloterra.blocks;

import javax.annotation.Nullable;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;

public class RotateableBlock
extends Block {
    private static final DirectionProperty FACING = HorizontalBlock.field_185512_D;

    public RotateableBlock(AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)this.func_176223_P().func_206870_a((Property)HorizontalBlock.field_185512_D, (Comparable)Direction.NORTH));
    }

    @Nullable
    public BlockState func_196258_a(BlockItemUseContext ctx) {
        return (BlockState)this.func_176223_P().func_206870_a((Property)FACING, (Comparable)ctx.func_195992_f().func_176734_d());
    }

    public BlockState func_185499_a(BlockState state, Rotation rot) {
        return (BlockState)state.func_206870_a((Property)FACING, (Comparable)rot.func_185831_a((Direction)state.func_177229_b((Property)FACING)));
    }

    public BlockState func_185471_a(BlockState state, Mirror mirror) {
        return state.func_185907_a(mirror.func_185800_a((Direction)state.func_177229_b((Property)FACING)));
    }

    protected void func_206840_a(StateContainer.Builder<Block, BlockState> builder) {
        builder.func_206894_a(new Property[]{FACING});
    }
}
