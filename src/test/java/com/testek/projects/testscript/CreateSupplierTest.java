package com.testek.projects.testscript;

import com.testek.annotations.FrameAnnotation;
import com.testek.consts.AuthorType;
import com.testek.consts.FrameConst;
import com.testek.projects.common.TestBase;
import com.testek.projects.pages.pages.CreatePage;
import com.testek.projects.pages.pages.HomePage;
import com.testek.projects.pages.pages.SupplierPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class CreateSupplierTest extends TestBase {
    CreatePage createPage;
    SupplierPage supplierPage;
    HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        createPage = homePage.clickToCreateSupplierPage();
    }

    @FrameAnnotation(category = {FrameConst.CategoryType.REGRESSION}, author = {AuthorType.HuongPham}, reviewer = {AuthorType.HuongPham})
    @Test(description = "Verify creating a new order")
    public void TK_CreateSupplier_001_Valid() {
        createPage.verifyCreateSupplierPageDisplay(); // Verify Create supplier page display

        Map<String, String> supplierInfo = createPage.fillSupplierInfo(); // Input supplier info
        createPage.clickToCreateMoreSupplier(); // Click Add More Supplier

        createPage.verifySupplierCreation(supplierInfo); // Verify info of Created supplier

        // Go to Supplier Page to search and verify Supplier Info
        supplierPage = createPage.gotoSupplierPage();
        supplierPage.searchAndVerify(supplierInfo);


    }


}
