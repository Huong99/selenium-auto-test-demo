package com.testek.projects.pages.objects;

import com.testek.consts.FrameConst;
import com.testek.projects.pages.locator.CategoryLocator;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class CategoryObjects extends BaseObjects {
    final CategoryLocator categoryLocator = new CategoryLocator();

    public CategoryObjects() {
    }

    // Find element
    public WebElement findAddCategoryEle() {
        return findWebElement(categoryLocator.getBtnAddCategory());
    }

    public WebElement findBtnExportEle() {
        return findWebElement(categoryLocator.getBtnExport());
    }

    public WebElement findBtnPrintEle() {
        return findWebElement(categoryLocator.getBtnPrint());
    }

    public WebElement findPrintPageEle() {
        return findWebElement(categoryLocator.getPrintPage());
    }

    // Verify display
    public void verifyAddCategoryButtonDisplay() {
        WebElement btnAddCus = findAddCategoryEle();
        assertEqualCondition(btnAddCus, btnAddCus.getText(), "Thêm danh mục", FrameConst.FailureHandling.STOP_ON_FAILURE, "Verify add category button:");
    }

    public void verifyPrintPageDisplay() {
        WebElement printPageEle = findPrintPageEle();
        webDriver.switchTo().frame(printPageEle);
        assertTrueCondition(printPageEle, printPageEle.isDisplayed(), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify print page display: ");
    }

    // Click button
    public CategoryObjects clickExportButton() {
        clickTo(findBtnExportEle(), "Export");
        return this;
    }

    public CategoryObjects clickPrintButton() {
        clickTo(findBtnPrintEle(), "Export");
        return this;
    }


}
