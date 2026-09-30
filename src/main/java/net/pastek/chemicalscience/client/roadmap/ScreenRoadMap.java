package net.pastek.chemicalscience.client.roadmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.joml.Matrix4f;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.common.inventory.container.ContainerRoadMap;
import voltaic.prefab.screen.GenericScreen;

public class ScreenRoadMap extends GenericScreen<ContainerRoadMap> {

    private static final ResourceLocation TEXTURE_BG = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/roadmap/background.png");
    private static final ResourceLocation TEXTURE_NODE_FRAME = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/roadmap/node_frame.png");
    private static final ResourceLocation TEXTURE_OVERLAY = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/roadmap/node_overlay.png");
    private static final ResourceLocation TEXTURE_IMAGE_FRAME = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/roadmap/node_image_frame.png");
    private static final ResourceLocation TEXTURE_WINDOW_FRAME = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/roadmap/window_frame.png");

    private static final ResourceLocation ICON_CHECK = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/roadmap/icon/check.png");
    private static final ResourceLocation ICON_DOT = ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "textures/screen/roadmap/icon/dot.png");

    private static final Map<ResourceLocation, NodeStatus> NODE_PROGRESS = new HashMap<>();

    private double scrollX = 0;
    private double scrollY = 0;
    private double zoom = 1.0;
    private static final double MIN_ZOOM = 0.5;
    private static final double MAX_ZOOM = 3.0;
    private static final int PAN_PADDING = 100;

    private boolean isDragging = false;
    private static final int NODE_SIZE = 32;

    private int winX, winY, winW, winH;
    private static final float ASPECT_RATIO = 4f / 3f;

    private Map<ResourceLocation, MultiblockVisualizer> VISUALIZERS = new HashMap<>();
    private @Nullable RoadmapNode selectedNode = null;

    public ScreenRoadMap(ContainerRoadMap container, Inventory inv, Component title) {
        super(container, inv, title);
    }

    @Override
    protected void init() {
        if (this.VISUALIZERS.isEmpty()) {
            loadVisualizers();
        }

        this.winW = (int) (this.width * 0.8f);
        this.winH = (int) (this.winW / ASPECT_RATIO);
        if (this.winH > this.height * 0.85f) {
            this.winH = (int) (this.height * 0.85f);
            this.winW = (int) (this.winH * ASPECT_RATIO);
        }
        this.winX = (this.width - this.winW) / 2;
        this.winY = (this.height - this.winH) / 2;
        this.imageWidth = this.winW;
        this.imageHeight = this.winH;

        clampScroll();
        super.init();
    }

    @Override
    protected void initializeComponents() {
        for (net.minecraft.world.inventory.Slot slot : this.menu.slots) {
            this.addComponent(this.createScreenSlot(slot));
        }
        this.guiTitle = new voltaic.prefab.screen.component.types.ScreenComponentSimpleLabel(0, 0, 0, voltaic.prefab.utilities.math.Color.BLACK, Component.empty());
        this.playerInvLabel = new voltaic.prefab.screen.component.types.ScreenComponentSimpleLabel(0, 0, 0, voltaic.prefab.utilities.math.Color.BLACK, Component.empty());
    }

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float partialTick) {
        g.fill(0, 0, this.width, this.height, 0x11000000);
        g.fill(winX, winY, winX + winW, winY + winH, 0xEE101010);

        g.enableScissor(winX, winY, winX + winW, winY + winH);
        g.pose().pushPose();

        double winCenterX = winX + (winW / 2.0);
        double winCenterY = winY + (winH / 2.0);

        g.pose().translate(winCenterX, winCenterY, 0);
        g.pose().scale((float) zoom, (float) zoom, 1f);
        g.pose().translate(scrollX, scrollY, 0);

        double worldMouseX = (mouseX - winCenterX) / zoom - scrollX;
        double worldMouseY = (mouseY - winCenterY) / zoom - scrollY;

        renderInfiniteBackground(g);

        for (RoadmapNode node : RoadMapNodes.NODES) {
            for (ResourceLocation parentId : node.parents()) {
                RoadmapNode parent = RoadMapNodes.NODE_MAP.get(parentId);
                if (parent != null) {
                    renderConnection(g, parent, node, node.lineColor());
                }
            }
        }

        for (RoadmapNode node : RoadMapNodes.NODES) {
            renderNode(g, node, worldMouseX, worldMouseY);
        }

        g.pose().popPose();
        g.disableScissor();

        renderWindowFrame(g);

        renderControlsLegend(g);

        if (selectedNode != null) {
            renderDetailOverlay(g);
        } else {
            renderNodeTooltips(g, mouseX, mouseY, worldMouseX, worldMouseY);
        }

        super.render(g, mouseX, mouseY, partialTick);
    }

    private void renderInfiniteBackground(GuiGraphics g) {
        RenderSystem.setShader(net.minecraft.client.renderer.GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, TEXTURE_BG);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        double left = (-winW / 2.0) / zoom - scrollX;
        double top = (-winH / 2.0) / zoom - scrollY;
        double right = (winW / 2.0) / zoom - scrollX;
        double bottom = (winH / 2.0) / zoom - scrollY;

        float u0 = (float) (left / 32.0f);
        float u1 = (float) (right / 32.0f);
        float v0 = (float) (top / 32.0f);
        float v1 = (float) (bottom / 32.0f);

        Matrix4f matrix = g.pose().last().pose();

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder buffer = tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);

        buffer.addVertex(matrix, (float)left, (float)bottom, 0).setUv(u0, v1);
        buffer.addVertex(matrix, (float)right, (float)bottom, 0).setUv(u1, v1);
        buffer.addVertex(matrix, (float)right, (float)top, 0).setUv(u1, v0);
        buffer.addVertex(matrix, (float)left, (float)top, 0).setUv(u0, v0);

        BufferUploader.drawWithShader(buffer.buildOrThrow());
    }

    private void clampScroll() {
        if (RoadMapNodes.NODES.isEmpty()) return;

        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for (RoadmapNode node : RoadMapNodes.NODES) {
            minX = Math.min(minX, node.x());
            minY = Math.min(minY, node.y());
            maxX = Math.max(maxX, node.x() + NODE_SIZE);
            maxY = Math.max(maxY, node.y() + NODE_SIZE);
        }

        scrollX = Mth.clamp(scrollX, -maxX - PAN_PADDING, -minX + PAN_PADDING);
        scrollY = Mth.clamp(scrollY, -maxY - PAN_PADDING, -minY + PAN_PADDING);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dx, double dy) {
        if (isDragging) {
            scrollX += dx / zoom;
            scrollY += dy / zoom;
            clampScroll();
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, dx, dy);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        double zoomFactor = 0.1;
        if (scrollY > 0) zoom += zoomFactor;
        else zoom -= zoomFactor;

        zoom = Mth.clamp(zoom, MIN_ZOOM, MAX_ZOOM);

        clampScroll();

        return true;
    }

    @Override protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {}
    @Override public void renderBackground(GuiGraphics g, int mouseX, int mouseY, float partialTick) {}
    @Override protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {}

    private void renderWindowFrame(GuiGraphics g) {
        RenderSystem.enableBlend();
        g.blit(TEXTURE_WINDOW_FRAME, winX - 2, winY - 2, 0, 0, winW + 4, winH + 4, winW + 4, winH + 4);
    }

    private void renderConnection(GuiGraphics g, RoadmapNode parent, RoadmapNode child, int color) {
        drawLine(g,
                parent.x() + NODE_SIZE / 2f, parent.y() + NODE_SIZE / 2f,
                child.x() + NODE_SIZE / 2f, child.y() + NODE_SIZE / 2f,
                color);
    }

    @SuppressWarnings("static-method")
    private void drawLine(GuiGraphics g, float x1, float y1, float x2, float y2, int color) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        float length = (float) Math.sqrt(dx * dx + dy * dy);
        float angle = (float) Math.atan2(dy, dx);
        g.pose().pushPose();
        g.pose().translate(x1, y1, 0);
        g.pose().mulPose(com.mojang.math.Axis.ZP.rotation(angle));
        g.fill(0, 0, (int)length, 1, color);
        g.pose().popPose();
    }

    private void renderNode(GuiGraphics g, RoadmapNode node, double mx, double my) {
        boolean hovered = isMouseOverNode(node, mx, my);

        g.pose().pushPose();
        g.pose().translate(node.x() + NODE_SIZE/2f, node.y() + NODE_SIZE/2f, 0);
        if (hovered) {
            float scale = 1.1f + (float)Math.sin(System.currentTimeMillis() / 100.0) * 0.05f;
            g.pose().scale(scale, scale, 1f);
        }
        g.pose().translate(-NODE_SIZE/2f, -NODE_SIZE/2f, 0);

        g.blit(TEXTURE_NODE_FRAME, 0, 0, 0, 0, NODE_SIZE, NODE_SIZE, 32, 32);

        int offset = (NODE_SIZE - 16) / 2;
        g.renderItem(node.icon(), offset, offset);

        NodeStatus status = NODE_PROGRESS.getOrDefault(node.id(), NodeStatus.NONE);
        if (status == NodeStatus.DONE) {
            g.pose().pushPose();
            g.pose().translate(NODE_SIZE - 10, -4, 200);
            RenderSystem.enableBlend();
            g.blit(ICON_CHECK, 0, 0, 0, 0, 12, 12, 12, 12);
            g.pose().popPose();
        } else if (status == NodeStatus.IN_PROGRESS) {
            g.pose().pushPose();
            g.pose().translate(NODE_SIZE - 10, -4, 200);
            RenderSystem.enableBlend();
            g.blit(ICON_DOT, 0, 0, 0, 0, 12, 12, 12, 12);
            g.pose().popPose();
        }

        g.pose().popPose();
    }

    private void renderControlsLegend(GuiGraphics g) {
        int padding = 6;
        int lineSpacing = 10;

        String[] lines = {
                Component.translatable("roadmap.chemicalscience.controls.clickleft").getString(),
                Component.translatable("roadmap.chemicalscience.controls.clickright").getString(),
                Component.translatable("roadmap.chemicalscience.controls.escape").getString()
        };

        int boxW = 150;
        int boxH = (lines.length * lineSpacing) + (padding * 2);

        int lx = winX + 5;
        int ly = (winY + winH) - boxH - 5;

        g.fill(lx, ly, lx + boxW, ly + boxH, 0xAA000000);
        g.renderOutline(lx, ly, boxW, boxH, 0xFF444444);

        for (int i = 0; i < lines.length; i++) {
            g.drawString(font, lines[i], lx + padding, ly + padding + (i * lineSpacing), 0xFFFFFF, false);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        boolean insideWindow = mouseX >= winX && mouseX <= winX + winW &&
                mouseY >= winY && mouseY <= winY + winH;

        if (selectedNode != null) {
            selectedNode = null;
            return true;
        }

        if (!insideWindow) return super.mouseClicked(mouseX, mouseY, button);

        double winCenterX = winX + (winW / 2.0);
        double winCenterY = winY + (winH / 2.0);
        double worldX = (mouseX - winCenterX) / zoom - scrollX;
        double worldY = (mouseY - winCenterY) / zoom - scrollY;

        for (RoadmapNode node : RoadMapNodes.NODES) {
            if (isMouseOverNode(node, worldX, worldY)) {
                if (button == 0) {
                    selectedNode = node;
                    MultiblockVisualizer visualizer = node.visualizer();
		    if (visualizer != null) {visualizer.resetAnimation();}
                    Minecraft.getInstance().getSoundManager().play(net.minecraft.client.resources.sounds.SimpleSoundInstance.forUI(net.minecraft.sounds.SoundEvents.UI_BUTTON_CLICK, 1.0F));
                    return true;
                } else if (button == 1) {
                    toggleNodeStatus(node);
                    Minecraft.getInstance().getSoundManager().play(net.minecraft.client.resources.sounds.SimpleSoundInstance.forUI(net.minecraft.sounds.SoundEvents.UI_BUTTON_CLICK, 1.0F));
                    return true;
                }
            }
        }

        if (button == 0) {
            isDragging = true;
            return true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @SuppressWarnings("static-method")
    private void toggleNodeStatus(RoadmapNode node) {
        NodeStatus current = NODE_PROGRESS.getOrDefault(node.id(), NodeStatus.NONE);
        NodeStatus next = switch (current) {
            case NONE -> NodeStatus.IN_PROGRESS;
            case IN_PROGRESS -> NodeStatus.DONE;
            case DONE -> NodeStatus.NONE;
        };
        NODE_PROGRESS.put(node.id(), next);
    }

    @SuppressWarnings("static-method")
    private void blitCustom(GuiGraphics g, int x1, int x2, int y1, int y2, float u0, float u1, float v0, float v1) {
        Matrix4f matrix = g.pose().last().pose();
        BufferBuilder bufferbuilder = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.addVertex(matrix, x1, y2, 0).setUv(u0, v1);
        bufferbuilder.addVertex(matrix, x2, y2, 0).setUv(u1, v1);
        bufferbuilder.addVertex(matrix, x2, y1, 0).setUv(u1, v0);
        bufferbuilder.addVertex(matrix, x1, y1, 0).setUv(u0, v0);
        BufferUploader.drawWithShader(bufferbuilder.buildOrThrow());
    }

    private void renderNodeTooltips(GuiGraphics g, int screenX, int screenY, double worldX, double worldY) {
        for (RoadmapNode node : RoadMapNodes.NODES) {
            if (isMouseOverNode(node, worldX, worldY)) {
                g.renderTooltip(font, node.title(), screenX, screenY);
                break;
            }
        }
    }

    @SuppressWarnings("static-method")
    private boolean isMouseOverNode(RoadmapNode node, double wx, double wy) {
        return wx >= node.x() && wx <= node.x() + NODE_SIZE &&
                wy >= node.y() && wy <= node.y() + NODE_SIZE;
    }

    private void renderDetailOverlay(GuiGraphics g) {
        g.pose().pushPose();
        g.pose().translate(0, 0, 400);

        g.fillGradient(0, 0, width, height, 0x33000000, 0x33000000);

        int panelSize = 128;
        int px = (width - panelSize) / 2;
        int py = (height - panelSize) / 2;

        g.blit(TEXTURE_OVERLAY, px, py, 0, 0, panelSize, panelSize, 128, 128);

        RoadmapNode pSelectedNode = selectedNode;
        if(pSelectedNode == null) return;
        
	if (VISUALIZERS.containsKey(pSelectedNode.id())) {
            int renderX = px + pSelectedNode.overlayImageX() + (pSelectedNode.overlayImageSize() / 2);
            int renderY = py + pSelectedNode.overlayImageY() + (pSelectedNode.overlayImageSize() / 2) + 20;

            VISUALIZERS.get(pSelectedNode.id()).render(g, renderX, renderY, 20.0f);

            RenderSystem.enableBlend();
            if (pSelectedNode.overlayImageFrame()) {
                g.pose().pushPose();
                g.pose().translate(0, 0, 100);
                g.blit(TEXTURE_IMAGE_FRAME, px + pSelectedNode.overlayImageX(), py + pSelectedNode.overlayImageY(), 0, 0, 96, 96, 96, 96);
                g.pose().popPose();
            }
        }
        else if (pSelectedNode.image() != null) {
            renderNodeImage(g, pSelectedNode, px + pSelectedNode.overlayImageX(), py + pSelectedNode.overlayImageY());

            RenderSystem.enableBlend();
            if (pSelectedNode.overlayImageFrame()) {
                g.blit(TEXTURE_IMAGE_FRAME, px + pSelectedNode.overlayImageX(), py + pSelectedNode.overlayImageY(), 0, 0, 96, 96, 96, 96);
            }
        }

        MultiblockVisualizer visualizer = pSelectedNode.visualizer();
	if (visualizer != null) {
            int renderX = px + pSelectedNode.overlayImageX() + (pSelectedNode.overlayImageSize() / 2);
            int renderY = py + pSelectedNode.overlayImageY() + (pSelectedNode.overlayImageSize() / 2) + 10;

            visualizer.render(g, renderX, renderY, 25.0f);
        } else if (pSelectedNode.image() != null) {
            renderNodeImage(g, pSelectedNode, px + pSelectedNode.overlayImageX(), py + pSelectedNode.overlayImageY());
        }

        g.drawWordWrap(font, pSelectedNode.title(),
                px + pSelectedNode.overlayTitleX(),
                py + pSelectedNode.overlayTitleY(),
                pSelectedNode.overlayTextWidth(),
                0xFFFFFF);

        g.drawWordWrap(font, pSelectedNode.description(),
                px + pSelectedNode.overlayDescX(),
                py + pSelectedNode.overlayDescY(),
                pSelectedNode.overlayTextWidth(),
                0xDDDDDD);

        g.pose().popPose();
    }

    private void renderNodeImage(GuiGraphics g, RoadmapNode node, int x, int y) {
        ResourceLocation image = node.image();
	if (image == null) return;
        int imgSize = node.overlayImageSize();

        if (node.animationFrames() > 1) {
            ClientLevel level = Minecraft.getInstance().level;
            if (level == null) return;
            long tick = level.getGameTime();
            int frame = (int) ((tick / 2) % node.animationFrames());
            RenderSystem.setShaderTexture(0, image);
            float u0 = 0;
            float u1 = 1;
            float v0 = (float) frame / node.animationFrames();
            float v1 = (float) (frame + 1) / node.animationFrames();
            blitCustom(g, x, x + imgSize, y, y + imgSize, u0, u1, v0, v1);
        } else {
            g.blit(image, x, y, 0, 0, imgSize, imgSize, imgSize, imgSize);
        }
    }

    private void loadVisualizers() {
        MultiblockVisualizer blastFurnace = new MultiblockVisualizer();

        for(int x=0; x<3; x++) for(int z=0; z<3; z++)
            blastFurnace.addBlock(x, 0, z, Blocks.BRICKS.defaultBlockState());

        blastFurnace.addBlock(0, 1, 0, Blocks.BRICKS.defaultBlockState());
        blastFurnace.addBlock(2, 1, 0, Blocks.BRICKS.defaultBlockState());
        blastFurnace.addBlock(0, 1, 2, Blocks.BRICKS.defaultBlockState());
        blastFurnace.addBlock(2, 1, 2, Blocks.BRICKS.defaultBlockState());

        for(int x=0; x<3; x++) for(int z=0; z<3; z++)
            blastFurnace.addBlock(x, 2, z, Blocks.BRICKS.defaultBlockState());

        VISUALIZERS.put(ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID, "node_blast_furnace"), blastFurnace);
    }

    @Override public boolean mouseReleased(double mouseX, double mouseY, int button) { isDragging = false; return super.mouseReleased(mouseX, mouseY, button); }

    public enum NodeStatus {
        NONE,
        IN_PROGRESS,
        DONE
    }

    public record RoadmapNode(
            ResourceLocation id,
            int x, int y,
            ItemStack icon,
            Component title,
            Component description,
            @Nullable ResourceLocation image,
            int animationFrames,
            List<ResourceLocation> parents,
            int lineColor,
            boolean overlayImageFrame,
            int overlayImageSize,
            int overlayImageX,
            int overlayImageY,
            int overlayTitleX,
            int overlayTitleY,
            int overlayDescX,
            int overlayDescY,
            int overlayTextWidth,
            @Nullable MultiblockVisualizer visualizer
    ) {}
}