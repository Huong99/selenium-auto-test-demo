package com.testek.projects.pages.objects;

import com.testek.consts.FrameConst;
import com.testek.projects.pages.locator.CreateCustomerLocator;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class CreateCustomerObjects extends BaseObjects {
    final CreateCustomerLocator createCustomerLocator = new CreateCustomerLocator();

    public CreateCustomerObjects() {
    }

    // Find Element
    public WebElement findAddCustomerTitle() {
        return findWebElement(createCustomerLocator.getLblAddCustomerTitle());
    }

    public WebElement findTxtCustomerName() {
        return findWebElement(createCustomerLocator.getTxtName());
    }

    public WebElement findTxtCustomerPhone() {
        return findWebElement(createCustomerLocator.getTxtPhone());
    }

    public WebElement findTxtCustomerEmail() {
        return findWebElement(createCustomerLocator.getTxtEmail());
    }

    public WebElement findTxtCustomerContact() {
        return findWebElement(createCustomerLocator.getTxtContact());
    }

    public WebElement findTxtCustomerCountry() {
        return findWebElement(createCustomerLocator.getTxtCountry());
    }

    public WebElement findTxtCustomerCity() {
        return findWebElement(createCustomerLocator.getTxtCity());
    }

    public WebElement findTxtCustomerAddress() {
        return findWebElement(createCustomerLocator.getTxtAddress());
    }

    public WebElement findTxtCustomerPostalCode() {
        return findWebElement(createCustomerLocator.getTxtPostalCode());
    }

    public WebElement findAddCustomerButton() {
        return findWebElement(createCustomerLocator.getBtnAdd());
    }

    public WebElement findSuccessMessageEle() {
        return findWebElement(createCustomerLocator.getLblSuccessMessageCustomer());
    }

    public WebElement findCustomerCode() {
        return findWebElement(createCustomerLocator.getTxtCustomerCode());
    }

    public WebElement findErrorMessage() {
        return findWebElement(createCustomerLocator.getTxtErrorMessage());
    }

    // Verify the title is correct
    public void verifyAddCustomerTitleDisplay() {
        WebElement lblTitle = findAddCustomerTitle();
        assertEqualCondition(lblTitle, lblTitle.getText(), "Thêm khách hàng", FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify title display:");
    }

    // Input info
    public CreateCustomerObjects inputCustomerName(String value) {
        inputText(findTxtCustomerName(), "Customer Name", value);
        return this;
    }

    public CreateCustomerObjects inputCustomerPhone(String value) {
        inputText(findTxtCustomerPhone(), "Customer Phone number", value);
        return this;
    }

    public CreateCustomerObjects inputCustomerEmail(String value) {
        inputText(findTxtCustomerEmail(), "Customer Name", value);
        return this;
    }

    public CreateCustomerObjects inputCustomerContact(String value) {
        inputText(findTxtCustomerContact(), "Customer Contact", value);
        return this;
    }

    public CreateCustomerObjects inputCustomerCountry(String value) {
        inputText(findTxtCustomerCountry(), "Customer Country", value);
        return this;
    }

    public CreateCustomerObjects inputCustomerCity(String value) {
        inputText(findTxtCustomerCity(), "Customer City", value);
        return this;
    }

    public CreateCustomerObjects inputCustomerAddress(String value) {
        inputText(findTxtCustomerAddress(), "Customer Address", value);
        return this;
    }

    public CreateCustomerObjects inputCustomerPostalCode(String value) {
        inputText(findTxtCustomerPostalCode(), "Customer Postal Code", value);
        return this;
    }

    // Click add button
    public CreateCustomerObjects clickAddCustomerButton() {
        this.clickTo(findAddCustomerButton(), "Add Customer");
        return this;
    }

    // Verify success message display
    public void verifySuccessMessage() {
        assertTrueCondition(findSuccessMessageEle(), findSuccessMessageEle().isDisplayed(), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify success message: ");
    }
}
