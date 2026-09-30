package net.pastek.chemicalscience.client.render.tile;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.common.tile.TileLabStorage;
import net.pastek.chemicalscience.registers.CSTags;
import voltaic.client.render.AbstractTileRenderer;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentInventory;
import voltaic.prefab.utilities.math.MathUtils;

public class RenderLabStorage extends AbstractTileRenderer<TileLabStorage> {

    public RenderLabStorage(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(TileLabStorage tile, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        if (tile.getCount() <= 0) {
            return;
        }
        ItemStack stack1 = tile.<ComponentInventory>requireComponent(IComponentType.Inventory).getItem(27);
        ItemStack stack2 = tile.<ComponentInventory>requireComponent(IComponentType.Inventory).getItem(28);
        ItemStack stack3 = tile.<ComponentInventory>requireComponent(IComponentType.Inventory).getItem(29);
        if (stack1.getTags().noneMatch(tag -> tag == CSTags.Items.HAZARD_SYMBOL) && stack2.getTags().noneMatch(tag -> tag == CSTags.Items.HAZARD_SYMBOL) && stack3.getTags().noneMatch(tag -> tag == CSTags.Items.HAZARD_SYMBOL) ) {
            return;
        }

                matrixStackIn.pushPose();
                matrixStackIn.translate(0.5 + tile.getFacing().getStepX() / 1.999, 0.3 + tile.getFacing().getStepY() / 2.0, 0.5 + tile.getFacing().getStepZ() / 1.999);
                switch (tile.getFacing()) {
                    case EAST:
                        matrixStackIn.mulPose(MathUtils.rotQuaternionDeg(0, -90, 0));
                        break;
                    case NORTH:
                        break;
                    case SOUTH:
                        matrixStackIn.mulPose(MathUtils.rotQuaternionDeg(0, 180, 0));
                        break;
                    case WEST:
                        matrixStackIn.mulPose(MathUtils.rotQuaternionDeg(0, 90, 0));
                        break;
                    default:
                        break;
                }

                matrixStackIn.popPose();

                matrixStackIn.pushPose();

                matrixStackIn.mulPose(MathUtils.rotVectorQuaternionDeg(-180, MathUtils.YP));

                if (tile.getFacing() == Direction.NORTH) {
                    matrixStackIn.translate(-1, 0, 0);
                }

                if (tile.getFacing() == Direction.EAST) {
                    matrixStackIn.translate(-1, 0, -1);
                    matrixStackIn.mulPose(MathUtils.rotVectorQuaternionDeg(-90, MathUtils.YP));
                }

                if (tile.getFacing() == Direction.SOUTH) {
                    matrixStackIn.translate(0, 0, -1);
                    matrixStackIn.mulPose(MathUtils.rotVectorQuaternionDeg(-180, MathUtils.YP));
                }

                if (tile.getFacing() == Direction.WEST) {
                    matrixStackIn.mulPose(MathUtils.rotVectorQuaternionDeg(90, MathUtils.YP));
                }

                ItemDisplayContext display = ItemDisplayContext.GUI;



                matrixStackIn.translate(0.439f, 0.248f, 0.0345f);
                matrixStackIn.scale(0.18f, 0.18f, 0.1f);
                if (stack1.getTags().anyMatch(tag -> tag == CSTags.Items.HAZARD_SYMBOL)) {
                    Minecraft.getInstance().getItemRenderer().renderStatic(stack1, display, 0xF000F0, combinedOverlayIn, matrixStackIn, bufferIn, tile.getLevel(), 0);
                }
                matrixStackIn.translate(1.039f, 0.0f, 0.0f);
                if (stack2.getTags().anyMatch(tag -> tag == CSTags.Items.HAZARD_SYMBOL)) {
                    Minecraft.getInstance().getItemRenderer().renderStatic(stack2, display, 0xF000F0, combinedOverlayIn, matrixStackIn, bufferIn, tile.getLevel(), 0);
                }
                matrixStackIn.translate(1.039f, 0.0f, 0.0f);
                if (stack3.getTags().anyMatch(tag -> tag == CSTags.Items.HAZARD_SYMBOL)) {
                    Minecraft.getInstance().getItemRenderer().renderStatic(stack3, display, 0xF000F0, combinedOverlayIn, matrixStackIn, bufferIn, tile.getLevel(), 0);
                }

                matrixStackIn.popPose();
    }
}