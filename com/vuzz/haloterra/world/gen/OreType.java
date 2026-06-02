package com.vuzz.haloterra.world.gen;

import com.vuzz.haloterra.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {
    LEAD((Lazy<Block>)Lazy.of(ModBlocks.LEAD_ORE), 7, 10, 50),
    LITHIUM((Lazy<Block>)Lazy.of(ModBlocks.LITHIUM_ORE), 4, 5, 40),
    ENERGY((Lazy<Block>)Lazy.of(ModBlocks.ENERGY_ORE), 3, 5, 30);

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;

    private OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public Lazy<Block> getBlock() {
        return this.block;
    }

    public int getMaxVeinSize() {
        return this.maxVeinSize;
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public static OreType get(Block block) {
        for (OreType ore : OreType.values()) {
            if (block != ore.block) continue;
            return ore;
        }
        return null;
    }
}
