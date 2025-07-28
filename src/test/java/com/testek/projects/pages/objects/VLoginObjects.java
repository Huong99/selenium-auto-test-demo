package com.testek.projects.pages.objects;

import com.testek.projects.pages.locator.VLoginLocator;
import com.testek.projects.pages.pages.DashboardPage;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class VLoginObjects extends BaseObjects{

    final VLoginLocator loginLocator = new VLoginLocator();

    // Find UserName textbox element
    public WebElement findEdtUserName(){
        return findWebElement(loginLocator.getEdtUserName());
    }

    public WebElement findEdtPassword(){
        return findWebElement(loginLocator.getEdtPassword());
    }

    public WebElement findBtnLogin(){
        return findWebElement(loginLocator.getBtnLogin());
    }

    public WebElement findLoginFailedMessage(){
        return findWebElement(loginLocator.getLblLoginFailedMessage());
    }

    public VLoginObjects inputUserName(String userName){
        this.inputText(findEdtUserName(), "UserName", userName);
        return this;
    }

    public VLoginObjects inputPassword(String value){
        this.inputText(findEdtPassword(), "UserName", value);
        return this;
    }

    public DashboardPage clickBtnLogin(){
        clickTo(findBtnLogin(), "Login");
        return new DashboardPage();
    }
}
