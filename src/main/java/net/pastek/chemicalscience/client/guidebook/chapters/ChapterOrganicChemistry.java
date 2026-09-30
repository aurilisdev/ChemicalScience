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


public class ChapterOrganicChemistry extends Chapter {

    private static final ItemWrapperObject LOGO = new ItemWrapperObject(7, 10, 32, 32, 32, 2.0F, CSItems.DPPDTT_POLYMER.get());

    public ChapterOrganicChemistry(Module module) {
        super(module);
    }

    @Override
    public ItemWrapperObject getLogo() {
        return LOGO;
    }

    @Override
    public MutableComponent getTitle() {
        return CSTextUtils.guidebook("chapter.organicchemistry");
    }

    @Override
    public void addData() {
        pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.organicchemistry.l1")).setIndentions(1).setSeparateStart());
        pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.organicchemistry.l2")).setIndentions(1).setNewPage());
        pageData.add(new ImageWrapperObject(0, 0, 0, 0, 150, 65, 150, 65, ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/organicchemistry_g1.png")));
        pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.organicchemistry.l3")).setIndentions(1).setSeparateStart());
        pageData.add(new ImageWrapperObject(0, 0, 0, 0, 150, 65, 150, 65, ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/organicchemistry_g2.png")));
        pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.organicchemistry.l4")).setIndentions(1).setSeparateStart());
        pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.organicchemistry.l5")).setIndentions(1).setSeparateStart());
        pageData.add(new ImageWrapperObject(0, 0, 0, 0, 150, 75, 150, 75, ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/organicchemistry_g3.png")));
        pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.organicchemistry.l6")).setIndentions(1).setSeparateStart());
        pageData.add(new ImageWrapperObject(0, 0, 0, 0, 150, 65, 150, 65, ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/organicchemistry_g4.png")));
        pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.organicchemistry.l7")).setIndentions(1).setSeparateStart().setNewPage());
        pageData.add(new ImageWrapperObject(0, 0, 0, 0, 150, 40, 150, 40, ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/organicchemistry_g5.png")));
        pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.organicchemistry.l8")).setIndentions(1).setSeparateStart());
        pageData.add(new ImageWrapperObject(10, 0, 0, 0, 100, 75, 100, 75, ResourceLocation.fromNamespaceAndPath(ChemicalScience.MOD_ID,"textures/screen/guidebook/organicchemistry_g6.png")));
        pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.organicchemistry.l9")).setIndentions(1).setSeparateStart().setNewPage());
    }

}