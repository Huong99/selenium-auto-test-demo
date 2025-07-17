package com.testek.projects.pages.pages;

import com.testek.consts.FrameConst;
import com.testek.projects.common.BasePage;
import com.testek.projects.pages.objects.VLoginObjects;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class VLoginPage extends BasePage {
    final VLoginObjects loginObjects = new VLoginObjects();

    public void goToLoginPage(){
        goToURL("https://testek.vn/lab/auto/login");
    }

    public DashboardPage login(String userName, String password){
        return loginObjects.inputUserName(userName)
                .inputPassword(password)
                .clickBtnLogin();
    }

    public void verifyLoginPageDisplay(){
        WebElement btnLoginEle = loginObjects.findBtnLogin();
        assertTrueCondition(btnLoginEle, btnLoginEle.isDisplayed(), FrameConst.FailureHandling.STOP_ON_FAILURE, "Not displayed Login Page!!!");
    }

}
