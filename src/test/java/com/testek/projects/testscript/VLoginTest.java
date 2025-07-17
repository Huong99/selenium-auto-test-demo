package com.testek.projects.testscript;

import com.testek.annotations.FrameAnnotation;
import com.testek.consts.AuthorType;
import com.testek.consts.FrameConst;
import com.testek.projects.common.TestBase;
import com.testek.projects.pages.pages.DashboardPage;
import com.testek.projects.pages.pages.VLoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VLoginTest extends TestBase {
    VLoginPage loginPage;
    DashboardPage dashboardPage;

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
    @Test(description = "Verify login")
    public void TK_VLogin_001_Valid() {
        loginPage.verifyLoginPageDisplay();        // Verify login page displayed

        dashboardPage = loginPage.login("admin_com_role", "aA12345678@"); // Login

        dashboardPage.verifyDashboardPageDisplay();     // Verify dashboard page displayed

    }
}
