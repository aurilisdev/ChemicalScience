package net.pastek.chemicalscience.client.guidebook.chapters;

import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.pastek.chemicalscience.ChemicalScience;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.CSItems;
import voltaic.client.guidebook.utils.components.Chapter;
import voltaic.client.guidebook.utils.components.Module;
import voltaic.client.guidebook.utils.pagedata.graphics.ImageWrapperObject;
import voltaic.client.guidebook.utils.pagedata.graphics.ItemWrapperObject;
import voltaic.client.guidebook.utils.pagedata.text.TextWrapperObject;


public class ChapterGeneralChemistry extends Chapter {

    private static final ItemWrapperObject LOGO = new ItemWrapperObject(7, 10, 32, 32, 32, 2.0F, CSItems.IMPURE_DUST_TUNGSTEN.get());

    public ChapterGeneralChemistry(Module module) {
        super(module);
    }

    @Override
    public ItemWrapperObject getLogo() {
        return LOGO;
    }

    @Override
    public MutableComponent getTitle() {
        return CSTextUtils.guidebook("chapter.generalchemistry");
    }

    @Override
    public void addData() {
        pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.generalchemistry.l1")).setIndentions(1).setSeparateStart());
        pageData.add(new ImageWrapperObject(0, 0, 0, 0, 150, 75, 150, 75, ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/generalchemistry_g1.png")));
        pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.generalchemistry.l2")).setIndentions(1).setSeparateStart());
        pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.generalchemistry.l3")).setIndentions(1).setSeparateStart());
        pageData.add(new ImageWrapperObject(0, 0, 0, 0, 150, 86, 150, 86, ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/generalchemistry_g2.png")));
        pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.generalchemistry.l4")).setIndentions(1).setSeparateStart());
    }

}