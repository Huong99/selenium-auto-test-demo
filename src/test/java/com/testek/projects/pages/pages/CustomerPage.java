package com.testek.projects.pages.pages;

import com.testek.consts.FrameConst;
import com.testek.projects.common.BasePage;
import com.testek.projects.dataprovider.model.CreateCustomerModel;
import com.testek.projects.pages.objects.CustomerObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CustomerPage extends BasePage {
    final CustomerObjects customerObject = new CustomerObjects();

    public void verifyCustomerPageDisplayed() {
        customerObject.verifyAddCustomerButtonDisplay();
    }

    public CreateCustomerPage clickToCreateCustomer() {
        customerObject.clickAddCustomerButton();
        return new CreateCustomerPage();
    }

    public CustomerPage searchCustomer(CreateCustomerModel data) {
        customerObject.inputKeyword(data)
                .clickSearchButton();
        return this;
    }

    public void verifyCustomerInfo(CreateCustomerModel data) {
        waitForDebug(1000);
        getWaitDriver().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='model-loading']")));

        List<WebElement> cusInfo = getWebDriver().findElements(By.xpath("//tr[contains(@class, 'row-table')]/td"));
        assertEqualCondition(cusInfo.get(0), cusInfo.get(0).getText(), data.getName().getValue(), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify name: ");
        assertEqualCondition(cusInfo.get(1), cusInfo.get(1).getText(), data.getPhone().getValue(), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify phone: ");
        assertEqualCondition(cusInfo.get(2), cusInfo.get(2).getText(), data.getEmail().getValue(), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify email: ");
        assertEqualCondition(cusInfo.get(3), cusInfo.get(3).getText(), data.getCountry().getValue(), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify country: ");
        assertEqualCondition(cusInfo.get(4), cusInfo.get(4).getText(), data.getCity().getValue(), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify city: ");
        assertEqualCondition(cusInfo.get(5), cusInfo.get(5).getText(), data.getAddress().getValue(), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify address: ");
        assertEqualCondition(cusInfo.get(6), cusInfo.get(6).getText(), data.getPostalCode().getValue(), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify postal code: ");

    }


}
