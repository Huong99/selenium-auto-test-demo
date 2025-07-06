package com.testek.projects.pages;

import com.testek.driver.DriverManager;
import com.testek.projects.pages.pages.CreatePage;
import com.testek.projects.pages.pages.HomePage;
import com.testek.projects.pages.pages.LoginPage;

import static com.testek.consts.FrameConst.AppConfig.APP_DOMAIN;


/**
 * Page management
 */
public class PageManagement {

    /* Access to the web page */
    public static LoginPage accessWebPage() {
        DriverManager.getDriver().get(APP_DOMAIN);
        return new LoginPage();
    }


    /* Go to the home page */
    public static HomePage gotoHomePage() {
        return new HomePage();
    }

    /* Go to the create page */
    public static CreatePage gotoCreatePage() {
        return new CreatePage();
    }


}
