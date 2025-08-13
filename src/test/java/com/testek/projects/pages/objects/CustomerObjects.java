package com.testek.projects.pages.objects;

import com.testek.consts.FrameConst;
import com.testek.projects.dataprovider.model.CreateCustomerModel;
import com.testek.projects.pages.locator.CustomerLocator;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class CustomerObjects extends BaseObjects {
    final CustomerLocator customerLocator = new CustomerLocator();

    // Find element
    public WebElement findAddCustomerEle() {
        return findWebElement(customerLocator.getBtnAddCustomer());
    }

    public WebElement findTxtSearchEle() {
        return findWebElement(customerLocator.getTxtSearch());
    }

    public WebElement findBtnSearchEle() {
        return findWebElement(customerLocator.getBtnSearch());
    }

    public void verifyAddCustomerButtonDisplay() {
        WebElement btnAddCus = findAddCustomerEle();
        assertEqualCondition(btnAddCus, btnAddCus.getText(), "Thêm khách hàng", FrameConst.FailureHandling.STOP_ON_FAILURE, "Verify add customer button:");
    }

    // Click button
    public CustomerObjects clickAddCustomerButton() {
        clickTo(findAddCustomerEle(), "Add Customer");
        return this;
    }

    public CustomerObjects clickSearchButton() {
        clickTo(findBtnSearchEle(), "Search");
        return this;
    }

    // Input text
    public CustomerObjects inputKeyword(CreateCustomerModel data) {
        inputText(findTxtSearchEle(), "Search Textbox", data.getEmail().getValue());
        return this;
    }
}
