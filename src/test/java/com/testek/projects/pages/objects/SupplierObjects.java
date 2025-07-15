package com.testek.projects.pages.objects;

import com.testek.projects.pages.locator.SupplierLocator;
import lombok.Getter;
import org.openqa.selenium.WebElement;

public class SupplierObjects extends BaseObjects {
    @Getter
    public static SupplierObjects instance = new SupplierObjects();

    private final SupplierLocator supplierLocator;

    private SupplierObjects() {
        supplierLocator = SupplierLocator.getInstance();
    }

    public WebElement findTxtSearch() {
        return findWebElement(supplierLocator.getTxtSearchSuppler());
    }

    public WebElement findBtnSearch() {
        return findWebElement(supplierLocator.getBtnSearchSupplier());
    }

    public WebElement findLoadingIcon() {
        return findWebElement(supplierLocator.getIconLoading());
    }

    public SupplierObjects inputKeyword(String value) {
        this.inputText(findTxtSearch(), "Search Supplier Textbox", value);
        return this;
    }

    public SupplierObjects clickSearchButton() {
        clickTo(findBtnSearch(), "Search Supplier Button");
        return this;
    }

    public WebElement findSupplierCodeEle() {
        return findWebElement(supplierLocator.getTxtSupplierCodeXPath());
    }

    public WebElement findSupplierErrorMessageEle() {
        return findWebElement(supplierLocator.getTxtSupplierErrorMessageXPath());
    }

    public WebElement findTitleCreateSupplierPage() {
        return findWebElement(supplierLocator.getLblTitleCreateSupplier());
    }

    public WebElement findSupplierNameEle() {
        return findWebElement(supplierLocator.getTxtSupplierName());
    }

    public WebElement findSupplierPhoneEle() {
        return findWebElement(supplierLocator.getTxtSupplierPhone());
    }

    public WebElement findSupplierContactEle() {
        return findWebElement(supplierLocator.getTxtSupplierContact());
    }

    public WebElement findSupplierCountryEle() {
        return findWebElement(supplierLocator.getTxtSupplierCountry());
    }

    public WebElement findSupplierCityEle() {
        return findWebElement(supplierLocator.getTxtSupplierCity());
    }

    public WebElement findSupplierAddressEle() {
        return findWebElement(supplierLocator.getTxtSupplierAddress());
    }

    public WebElement findSupplierPostalCodeEle() {
        return findWebElement(supplierLocator.getTxtSupplierPostalCode());
    }

    public WebElement findAddMoreSupplierButtonEle() {
        return findWebElement(supplierLocator.getBtnAddMoreSupplier());
    }

    public WebElement findAddSupplierButtonEle() {
        return findWebElement(supplierLocator.getBtnAddSupplier());
    }

    public WebElement findSuccessMessageSupplierEle() {
        return findWebElement(supplierLocator.getLblSuccessMessageSupplier());
    }

    // Input Supplier Name
    public SupplierObjects inputSupplierName(String value) {
        this.inputText(findSupplierNameEle(), "Supplier Name", value);
        return this;
    }


    // Input Supplier Phone
    public SupplierObjects inputSupplierPhone(String value) {
        this.inputText(findSupplierPhoneEle(), "Supplier Phone", value);
        return this;
    }

    // Input Supplier Contact
    public SupplierObjects inputSupplierContact(String value) {
        this.inputText(findSupplierContactEle(), "Supplier Contact", value);
        return this;
    }

    // Input Supplier City
    public SupplierObjects inputSupplierCity(String value) {
        this.inputText(findSupplierCityEle(), "Supplier City", value);
        return this;
    }

    // Input Supplier Country
    public SupplierObjects inputSupplierCountry(String value) {
        this.inputText(findSupplierCountryEle(), "Supplier Country", value);
        return this;
    }

    // Input Supplier Address
    public SupplierObjects inputSupplierAddress(String value) {
        this.inputText(findSupplierAddressEle(), "Supplier Address", value);
        return this;
    }

    // Input Supplier Postal Code
    public SupplierObjects inputSupplierPostalCode(String value) {
        this.inputText(findSupplierPostalCodeEle(), "Supplier Postal Code", value);
        return this;
    }

    public SupplierObjects clickAddMoreSupplierButton() {
        clickTo(findAddMoreSupplierButtonEle(), "Add More Supplier Button");
        return this;
    }

    public SupplierObjects clickAddSupplierButton() {
        clickTo(findAddSupplierButtonEle(), "Add More Supplier Button");
        return this;
    }
}
