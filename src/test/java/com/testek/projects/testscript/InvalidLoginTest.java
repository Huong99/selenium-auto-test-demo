package com.testek.projects.testscript;

import com.testek.annotations.FrameAnnotation;
import com.testek.consts.AuthorType;
import com.testek.consts.FrameConst;
import com.testek.projects.common.TestBase;
import com.testek.projects.dataprovider.model.TLoginModel;
import com.testek.projects.dataprovider.providers.TLoginProvider;
import com.testek.projects.pages.pages.VLoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvalidLoginTest extends TestBase {
    VLoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        super.beforeClass();
        loginPage = new VLoginPage();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage.goToLoginPage();
    }

    @FrameAnnotation(category = {FrameConst.CategoryType.REGRESSION}, author = {AuthorType.HuongPham}, reviewer = {AuthorType.HuongPham})
    @Test(description = "Verify invalid login", dataProvider = "Testek_Login_002_Login_Invalid", dataProviderClass = TLoginProvider.class)
    public void Testek_Login_002_Login_Invalid(TLoginModel data) {
        System.out.println("UserName: " + data.getUserName().getValue() + "\nPassword: " + data.getPassword().getValue());

        loginPage.verifyLoginPageDisplay();        // Verify login page displayed

        loginPage.login(data.getUserName().getValue(), data.getPassword().getValue());  // Login

        loginPage.verifyLoginFailedMessageDisplay(); // Verify displayed login failed message
    }
}

