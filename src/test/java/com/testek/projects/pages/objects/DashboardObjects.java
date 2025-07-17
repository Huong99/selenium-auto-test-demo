package com.testek.projects.pages.objects;

import com.testek.consts.FrameConst;
import com.testek.projects.pages.locator.DashboardLocator;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class DashboardObjects extends BaseObjects{
    final DashboardLocator dashboardLocator = new DashboardLocator();

    public WebElement findUserIcon(){
        return findWebElement(dashboardLocator.getBtnUserIcon());
    }

    public WebElement findSuccessMessage(){ return findWebElement(dashboardLocator.getLblMessageSuccess());}

    public WebElement findProductNavigation(){ return findWebElement(dashboardLocator.getNgvProduct());}

    public void verifyUserIconDisplay(){
        assertTrueCondition(findUserIcon(), findUserIcon().isDisplayed(), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "User Icon is not display");
    }

    public void verifySuccessMessageDisplay(){
        assertEqualCondition(findSuccessMessage(), findSuccessMessage().getText(), "Đăng nhập thành công", FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "The login success message is not correct!!!");
    }

    public void verifyProductNavigationDisplay(){
        assertEqualCondition(findProductNavigation(), findProductNavigation().getText(), "Sản phẩm", FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "The Product Navigation is not correct!!!");
    }


}
