package com.testek.projects.pages.objects;

import com.testek.projects.pages.locator.CreateSupplierLocator;
import lombok.Getter;
import org.openqa.selenium.WebElement;

public class CreateSupplierObjects extends BaseObjects {
    @Getter
    public static CreateSupplierObjects instance = new CreateSupplierObjects();

    private final CreateSupplierLocator createLocator;

    private CreateSupplierObjects() {
        createLocator = CreateSupplierLocator.getInstance();
    }

    public WebElement findSupplierCodeEle() {
        return findWebElement(createLocator.getTxtSupplierCodeXPath());
    }

    public WebElement findSupplierErrorMessageEle() {
        return findWebElement(createLocator.getTxtSupplierErrorMessageXPath());
    }

    public WebElement findTitleCreateSupplierPage() {
        return findWebElement(createLocator.getLblTitleCreateSupplier());
    }

    public WebElement findSupplierNameEle() {
        return findWebElement(createLocator.getTxtSupplierName());
    }

    public WebElement findSupplierPhoneEle() {
        return findWebElement(createLocator.getTxtSupplierPhone());
    }

    public WebElement findSupplierContactEle() {
        return findWebElement(createLocator.getTxtSupplierContact());
    }

    public WebElement findSupplierCountryEle() {
        return findWebElement(createLocator.getTxtSupplierCountry());
    }

    public WebElement findSupplierCityEle() {
        return findWebElement(createLocator.getTxtSupplierCity());
    }

    public WebElement findSupplierAddressEle() {
        return findWebElement(createLocator.getTxtSupplierAddress());
    }

    public WebElement findSupplierPostalCodeEle() {
        return findWebElement(createLocator.getTxtSupplierPostalCode());
    }

    public WebElement findAddMoreSupplierButtonEle() {
        return findWebElement(createLocator.getBtnAddMoreSupplier());
    }

    public WebElement findSuccessMessageSupplierEle() {
        return findWebElement(createLocator.getLblSuccessMessageSupplier());
    }

    // Input Supplier Name
    public CreateSupplierObjects inputSupplierName(String value) {
        this.inputText(findSupplierNameEle(), "Supplier Name", value);
        return this;
    }


    // Input Supplier Phone
    public CreateSupplierObjects inputSupplierPhone(String value) {
        this.inputText(findSupplierPhoneEle(), "Supplier Phone", value);
        return this;
    }

    // Input Supplier Contact
    public CreateSupplierObjects inputSupplierContact(String value) {
        this.inputText(findSupplierContactEle(), "Supplier Contact", value);
        return this;
    }

    // Input Supplier City
    public CreateSupplierObjects inputSupplierCity(String value) {
        this.inputText(findSupplierCityEle(), "Supplier City", value);
        return this;
    }

    // Input Supplier Country
    public CreateSupplierObjects inputSupplierCountry(String value) {
        this.inputText(findSupplierCountryEle(), "Supplier Country", value);
        return this;
    }

    // Input Supplier Address
    public CreateSupplierObjects inputSupplierAddress(String value) {
        this.inputText(findSupplierAddressEle(), "Supplier Address", value);
        return this;
    }

    // Input Supplier Postal Code
    public CreateSupplierObjects inputSupplierPostalCode(String value) {
        this.inputText(findSupplierPostalCodeEle(), "Supplier Postal Code", value);
        return this;
    }

    public CreateSupplierObjects clickAddMoreSupplierButton() {
        clickTo(findAddMoreSupplierButtonEle(), "Add More Supplier Button");
        return this;
    }

}
