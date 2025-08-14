package com.testek.projects.pages.pages;

import com.testek.projects.common.BasePage;
import com.testek.projects.pages.objects.CategoryObjects;

public class CategoryPage extends BasePage {
    final CategoryObjects categoryObjects = new CategoryObjects();

    public void verifyCategoryPageDisplayed() {
        categoryObjects.verifyAddCategoryButtonDisplay();
    }

    public void clickToExportButton(){
        categoryObjects.clickExportButton();
    }

    public void clickToPrintAndVerifyPrintPageDisplay(){
        categoryObjects.clickPrintButton()
                .verifyPrintPageDisplay();
    }


}
