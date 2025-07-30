package com.testek.projects.testscript;

import com.testek.annotations.FrameAnnotation;
import com.testek.consts.AuthorType;
import com.testek.consts.FrameConst;
import com.testek.projects.common.TestBase;
import com.testek.projects.dataprovider.model.HCreateProductModel;
import com.testek.projects.dataprovider.providers.HCreateProductProvider;
import com.testek.projects.pages.pages.HomePage;
import com.testek.projects.pages.pages.ProductPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HCreateProductTest extends TestBase {
    ProductPage productPage;
    HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        productPage = homePage.gotoProductPage();   // Access to Product page
    }

    @FrameAnnotation(category = {FrameConst.CategoryType.REGRESSION}, author = {AuthorType.HuongPham}, reviewer = {AuthorType.Vincent})
    @Test(description = "Verify creating products", dataProvider = "HuongPham_CreateProduct_001_Valid", dataProviderClass = HCreateProductProvider.class)
    public void HuongPham_CreateProduct_001_Valid(HCreateProductModel data) {
        productPage.verifyProductPageDisplay(); // Verify product page hien thi

        productPage.clickToCreateProduct()      // Click button Create Product
                .fillProductInfo(data)
                .clickToCreateProduct();

        productPage.verifyProductCreation(data);        // Verify popup success hien thi
    }
}
