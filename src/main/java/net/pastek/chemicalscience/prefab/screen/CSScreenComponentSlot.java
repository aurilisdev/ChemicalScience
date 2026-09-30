package net.pastek.chemicalscience.prefab.screen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.pastek.chemicalscience.ChemicalScience;
import voltaic.api.screen.ITexture;
import voltaic.api.screen.component.ISlotTexture;
import voltaic.prefab.screen.component.types.ScreenComponentSlot;

public class CSScreenComponentSlot extends ScreenComponentSlot {
    public CSScreenComponentSlot(Slot slot, ISlotTexture slotType, ITexture iconType, int x, int y) {
        super(slot, slotType, iconType, x, y);
    }

    public static enum IconType implements ITexture {
        NONE(0, 0, 0, 0, 0, 0, ""),
        CATALYST_ICON(
                0, 0,
                18, 18,
                18, 18,
                "catalyst"
        );

        private final int textureWidth;
        private final int textureHeight;
        private final int textureU;
        private final int textureV;
        private final int imageWidth;
        private final int imageHeight;
        private final ResourceLocation loc;

        private IconType(int textureWidth, int textureHeight, int textureU, int textureV, int imageWidth, int imageHeight, String name) {
            this.textureWidth = textureWidth;
            this.textureHeight = textureHeight;
            this.textureU = textureU;
            this.textureV = textureV;
            this.imageWidth = imageWidth;
            this.imageHeight = imageHeight;
            this.loc = ChemicalScience.rl("textures/screen/component/icon/" + name + ".png");
        }

        @Override
	public ResourceLocation getLocation() {
            return this.loc;
        }

        @Override
	public int imageHeight() {
            return this.imageHeight;
        }

        @Override
	public int imageWidth() {
            return this.imageWidth;
        }

        @Override
	public int textureHeight() {
            return this.textureHeight;
        }

        @Override
	public int textureU() {
            return this.textureU;
        }

        @Override
	public int textureV() {
            return this.textureV;
        }

        @Override
	public int textureWidth() {
            return this.textureWidth;
        }
    }
}
