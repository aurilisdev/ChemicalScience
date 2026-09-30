package net.pastek.chemicalscience.client.render.tile;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.pastek.chemicalscience.common.tile.TileRackM;
import net.pastek.chemicalscience.registers.CSTags;
import voltaic.client.render.AbstractTileRenderer;
import voltaic.prefab.tile.components.IComponentType;
import voltaic.prefab.tile.components.type.ComponentInventory;
import voltaic.prefab.utilities.math.MathUtils;

public class RenderRackM extends AbstractTileRenderer<TileRackM> {

    public RenderRackM(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(TileRackM tileRack, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        if (tileRack.getCount() <= 0) {
            return;
        }
                matrixStackIn.pushPose();
                matrixStackIn.translate(0.5 + tileRack.getFacing().getStepX() / 1.999, 0.3 + tileRack.getFacing().getStepY() / 2.0, 0.5 + tileRack.getFacing().getStepZ() / 1.999);
                switch (tileRack.getFacing()) {
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

                ItemStack stack = tileRack.<ComponentInventory>requireComponent(IComponentType.Inventory).getItem(0);

                matrixStackIn.pushPose();

                matrixStackIn.mulPose(MathUtils.rotVectorQuaternionDeg(-180, MathUtils.YP));

                if (tileRack.getFacing() == Direction.NORTH) {
                    matrixStackIn.translate(-1, 0, 0);
                }

                if (tileRack.getFacing() == Direction.EAST) {
                    matrixStackIn.translate(-1, 0, -1);
                    matrixStackIn.mulPose(MathUtils.rotVectorQuaternionDeg(-90, MathUtils.YP));
                }

                if (tileRack.getFacing() == Direction.SOUTH) {
                    matrixStackIn.translate(0, 0, -1);
                    matrixStackIn.mulPose(MathUtils.rotVectorQuaternionDeg(-180, MathUtils.YP));
                }

                if (tileRack.getFacing() == Direction.WEST) {
                    matrixStackIn.mulPose(MathUtils.rotVectorQuaternionDeg(90, MathUtils.YP));
                }




                matrixStackIn.translate(0.5, 0.76, 0);
                if (stack.getItem() instanceof BlockItem) {
                        matrixStackIn.scale(0.75f, 0.75f, 0.1f);
                        matrixStackIn.translate(0, -0.11f, 0);
                } else {
                    matrixStackIn.scale(0.35f, 0.35f, 0.35f);
                }

                ItemDisplayContext display = ItemDisplayContext.GROUND;
                if (stack.getTags().anyMatch(tag -> tag == CSTags.Items.HAZARD_SYMBOL)) {
                    display = ItemDisplayContext.GUI;
                    matrixStackIn.translate(0, 0.1675f, 0.18f);
                    matrixStackIn.scale(0.5f, 0.5f, 0.5f);
                }

                Minecraft.getInstance().getItemRenderer().renderStatic(stack, display, 0xF000F0, combinedOverlayIn, matrixStackIn, bufferIn, tileRack.getLevel(), 0);

                matrixStackIn.popPose();
            }
}