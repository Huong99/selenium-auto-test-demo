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
}
