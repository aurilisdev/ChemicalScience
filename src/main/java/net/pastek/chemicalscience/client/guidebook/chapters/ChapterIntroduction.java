package net.pastek.chemicalscience.client.guidebook.chapters;

import net.minecraft.network.chat.MutableComponent;
import net.pastek.chemicalscience.prefab.utils.CSTextUtils;
import net.pastek.chemicalscience.registers.CSBlocks;
import voltaic.client.guidebook.utils.components.Chapter;
import voltaic.client.guidebook.utils.components.Module;
import voltaic.client.guidebook.utils.pagedata.graphics.ItemWrapperObject;
import voltaic.client.guidebook.utils.pagedata.text.TextWrapperObject;


public class ChapterIntroduction extends Chapter {

    private static final ItemWrapperObject LOGO = new ItemWrapperObject(7, 10, 32, 32, 32, 2.0F, CSBlocks.ELEMENT_MG.asItem());

    public ChapterIntroduction(Module module) {
        super(module);
    }

    @Override
    public ItemWrapperObject getLogo() {
        return LOGO;
    }

    @Override
    public MutableComponent getTitle() {
        return CSTextUtils.guidebook("chapter.introduction");
    }

    @Override
    public void addData() {
        pageData.add(new TextWrapperObject(CSTextUtils.guidebook("chapter.introduction.l1.1")).setIndentions(1).setSeparateStart());
    }

}