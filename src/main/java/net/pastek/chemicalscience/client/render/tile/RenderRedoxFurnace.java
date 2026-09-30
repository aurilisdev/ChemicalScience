package net.pastek.chemicalscience.client.render.tile;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.pastek.chemicalscience.client.CSClientRegister;
import net.pastek.chemicalscience.common.tile.TileRedoxFurnace;

@OnlyIn(Dist.CLIENT)
public class RenderRedoxFurnace implements BlockEntityRenderer<TileRedoxFurnace> {

    public RenderRedoxFurnace(BlockEntityRendererProvider.Context context) {}

    private @Nullable BakedModel cachedModel = null;
    private boolean modelLoadAttempted = false;

    @Override
    public void render(TileRedoxFurnace tile, float partialTicks, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight, int packedOverlay) {

        if (tile.isFormed.getValue() == true) {

            BakedModel parCachedModel = cachedModel;
	    if (!modelLoadAttempted) {
                parCachedModel = cachedModel = Minecraft.getInstance().getModelManager().getModel(CSClientRegister.REDOXFURNACE_MODEL);
                modelLoadAttempted = true;

                if (parCachedModel == Minecraft.getInstance().getModelManager().getMissingModel()) {
                    System.err.println("ERROR: Missing Multiblock Model at: " + CSClientRegister.REDOXFURNACE_MODEL);
                    parCachedModel = cachedModel = null;
                    return;
                }
            }

            if (parCachedModel == null) return;

            poseStack.pushPose();

            Vec3 offset = getOffset(tile.getFacing());
            poseStack.translate(offset.x, 0, offset.z);

            poseStack.mulPose(Axis.YP.rotationDegrees(getFixedRotation(tile.getFacing())));

            BlockState state = tile.getBlockState();


            Minecraft.getInstance().getBlockRenderer().getModelRenderer().renderModel(
                    poseStack.last(),
                    buffer.getBuffer(RenderType.cutout()),
                    state,
                    parCachedModel,
                    1f, 1f, 1f,
                    packedLight,
                    packedOverlay
            );

            poseStack.popPose();
        }
    }

    private static Vec3 getOffset(Direction facing) {
        return switch (facing) {
            case SOUTH -> new Vec3( -0.5, 0,  0.5);
            case WEST  -> new Vec3( 0.5, 0, -0.5);
            case EAST  -> new Vec3( 0.5, 0, 1.5);
            case NORTH -> new Vec3( 1.5, 0,  0.5);
            default -> Vec3.ZERO;
        };
    }

    private static float getFixedRotation(Direction facing) {
        return switch (facing) {
            case NORTH -> 0f;
            case SOUTH -> 180f;
            case WEST  -> 90f;
            case EAST  -> -90f;
            default -> 0f;
        };
    }
}