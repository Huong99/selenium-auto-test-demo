package com.testek.projects.testscript;

import com.testek.annotations.FrameAnnotation;
import com.testek.consts.AuthorType;
import com.testek.consts.FrameConst;
import com.testek.projects.common.TestBase;
import com.testek.projects.pages.pages.CategoryPage;
import com.testek.projects.pages.pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CategoryTest extends TestBase {
    HomePage homePage;
    CategoryPage categoryPage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        categoryPage = homePage.gotoCategoryPage();
    }

    @FrameAnnotation(category = {FrameConst.CategoryType.REGRESSION}, author = {AuthorType.HuongPham}, reviewer = {AuthorType.Vincent})
    @Test(description = "Verify category")
    public void TK_CategoryTest_001() {
        // Verify Category page display
        categoryPage.verifyCategoryPageDisplayed();

        // Click export
        categoryPage.clickToExportButton();

        // Click print and Verify Print page display
        // categoryPage.clickToPrintAndVerifyPrintPageDisplay();

    }
}
