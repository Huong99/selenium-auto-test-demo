package com.testek.projects.testscript;

import com.testek.annotations.FrameAnnotation;
import com.testek.consts.AuthorType;
import com.testek.consts.FrameConst;
import com.testek.projects.common.TestBase;
import com.testek.projects.dataprovider.model.CreateCustomerModel;
import com.testek.projects.dataprovider.providers.CreateCustomerProvider;
import com.testek.projects.pages.pages.CreateCustomerPage;
import com.testek.projects.pages.pages.CustomerPage;
import com.testek.projects.pages.pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCustomerTest extends TestBase {
    HomePage homePage;
    CustomerPage customerPage;
    CreateCustomerPage createCustomerPage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        customerPage = homePage.gotoCustomerPage();
    }

    @FrameAnnotation(category = {FrameConst.CategoryType.REGRESSION}, author = {AuthorType.HuongPham}, reviewer = {AuthorType.Vincent})
    @Test(description = "Verify creating customer", dataProvider = "TK_CreateCustomer_001_Valid", dataProviderClass = CreateCustomerProvider.class)
    public void TK_CreateCustomer_001_Valid(CreateCustomerModel data) {
        // Verify Customer page display
        customerPage.verifyCustomerPageDisplayed();

        createCustomerPage = customerPage.clickToCreateCustomer();       // Click Create Customer button

        createCustomerPage.verifyCreateCustomerPageDisplay();     // Verify Create customer Page display

        // Fill info to create customer
        createCustomerPage.fillCustomerInfoAndClickAdd(data)
                .verifyCustomerCreationSuccess(data);  // Verify create successfully

        // Access customer page
        customerPage = createCustomerPage.gotoCustomerPage();

        // Search and verify info
        customerPage.searchCustomer(data)
                .verifyCustomerInfo(data);


    }

    @FrameAnnotation(category = {FrameConst.CategoryType.REGRESSION}, author = {AuthorType.HuongPham}, reviewer = {AuthorType.Vincent})
    @Test(description = "Verify creating customer with invalid phone number", dataProvider = "TK_CreateCustomer_002_InvalidPhone", dataProviderClass = CreateCustomerProvider.class)
    public void TK_CreateCustomer_002_InvalidPhone(CreateCustomerModel data) {
        // Verify Customer page display
        customerPage.verifyCustomerPageDisplayed();

        createCustomerPage = customerPage.clickToCreateCustomer();       // Click Create Customer button

        createCustomerPage.verifyCreateCustomerPageDisplay();     // Verify Create customer Page display

        // Fill info to create customer
        createCustomerPage.fillCustomerInfoAndClickAdd(data)
                .verifyCustomerCreationFailedWithInvalidPhone();

    }
}
