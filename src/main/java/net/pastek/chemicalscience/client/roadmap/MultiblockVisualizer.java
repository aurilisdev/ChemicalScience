package net.pastek.chemicalscience.client.roadmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.joml.Quaternionf;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LevelLightEngine;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.client.model.data.ModelData;

public class MultiblockVisualizer {

    private final Map<BlockPos, BlockState> blocks = new HashMap<>();
    private final List<BlockPos> sortedPositions = new ArrayList<>();
    private final FakeBlockAccess fakeWorld;

    private long lastStepTime = 0;
    private int visibleBlocks = 0;
    private boolean isFinished = false;

    private final long stepDelayMs = 250;
    private float rotationY = 45f;
    private float rotationX = 30f;

    public MultiblockVisualizer() {
        this.fakeWorld = new FakeBlockAccess(this.blocks);
    }

    public MultiblockVisualizer addBlock(int x, int y, int z, BlockState state) {
        BlockPos pos = new BlockPos(x, y, z);
        blocks.put(pos, state);

        if (!sortedPositions.contains(pos)) {
            sortedPositions.add(pos);
        }

        sortedPositions.sort(Comparator.comparingInt((BlockPos p) -> p.getY())
                .thenComparingInt(p -> p.getX())
                .thenComparingInt(p -> p.getZ()));

        return this;
    }

    public void resetAnimation() {
        this.visibleBlocks = 0;
        this.isFinished = false;
        this.lastStepTime = System.currentTimeMillis();
    }

    public void render(GuiGraphics g, int x, int y, float scale) {
        if (blocks.isEmpty()) return;

        long now = System.currentTimeMillis();
        if (now - lastStepTime > stepDelayMs && !isFinished) {
            visibleBlocks++;
            lastStepTime = now;
            if (visibleBlocks >= sortedPositions.size()) {
                isFinished = true;
                visibleBlocks = sortedPositions.size();
            }
        }

        PoseStack pose = g.pose();
        pose.pushPose();

        pose.translate(x, y, 100);
        pose.scale(scale, -scale, scale);

        pose.mulPose(new Quaternionf().rotateX((float) Math.toRadians(rotationX)));
        pose.mulPose(new Quaternionf().rotateY((float) Math.toRadians(rotationY)));

        BlockPos center = getCenter();
        pose.translate(-center.getX() - 0.5f, -center.getY() - 0.5f, -center.getZ() - 0.5f);

        var blockRenderer = Minecraft.getInstance().getBlockRenderer();
        var bufferSource = g.bufferSource();

        for (int i = 0; i < visibleBlocks; i++) {
            BlockPos pos = sortedPositions.get(i);
            BlockState state = blocks.get(pos);

            pose.pushPose();
            pose.translate(pos.getX(), pos.getY(), pos.getZ());

            var model = blockRenderer.getBlockModel(state);
            var rand = net.minecraft.util.RandomSource.create();

            for (RenderType type : model.getRenderTypes(state, rand, ModelData.EMPTY)) {
                VertexConsumer consumer = bufferSource.getBuffer(type);

                blockRenderer.getModelRenderer().tesselateBlock(
                        fakeWorld,
                        model,
                        state,
                        pos,
                        pose,
                        consumer,
                        false,
                        rand,
                        state.getSeed(pos),
                        OverlayTexture.NO_OVERLAY,
                        ModelData.EMPTY,
                        type
                );
            }

            pose.popPose();
        }

        bufferSource.endBatch();
        
        pose.popPose();
    }
    
    private BlockPos getCenter() {
        if (sortedPositions.isEmpty()) return BlockPos.ZERO;
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, minZ = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE, maxZ = Integer.MIN_VALUE;
        
        for (BlockPos p : sortedPositions) {
            if (p.getX() < minX) minX = p.getX();
            if (p.getY() < minY) minY = p.getY();
            if (p.getZ() < minZ) minZ = p.getZ();
            if (p.getX() > maxX) maxX = p.getX();
            if (p.getY() > maxY) maxY = p.getY();
            if (p.getZ() > maxZ) maxZ = p.getZ();
        }
        return new BlockPos((minX + maxX) / 2, (minY + maxY) / 2, (minZ + maxZ) / 2);
    }

    private static class FakeBlockAccess implements BlockAndTintGetter {
        private final Map<BlockPos, BlockState> data;

        public FakeBlockAccess(Map<BlockPos, BlockState> data) { this.data = data; }

        @Override public BlockState getBlockState(BlockPos pos) { return data.getOrDefault(pos, Blocks.AIR.defaultBlockState()); }
        @Override public FluidState getFluidState(BlockPos pos) { return Fluids.EMPTY.defaultFluidState(); }
        @Override public @Nullable LevelLightEngine getLightEngine() { return null; }
        @Override public int getBlockTint(BlockPos pos, ColorResolver colorResolver) { return -1; }
        @Override public @Nullable BlockEntity getBlockEntity(BlockPos pos) { return null; }
        @Override public int getBrightness(LightLayer layer, BlockPos pos) { return 15; }
        @Override public int getRawBrightness(BlockPos pos, int amount) { return 15; }
        @Override public int getHeight() { return 256; }
        @Override public int getMinBuildHeight() { return 0; }

        @Override
        public float getShade(Direction direction, boolean shaded) {
            return switch (direction) {
                case DOWN -> 0.5F;
                case UP -> 1.0F;
                case NORTH, SOUTH -> 0.8F;
                case WEST, EAST -> 0.6F;
            };
        }
    }
}