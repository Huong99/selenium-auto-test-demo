package com.testek.projects.pages.locator;

import lombok.Getter;

@Getter
public class SupplierLocator extends BaseLocator {
    @Getter
    public static SupplierLocator instance = new SupplierLocator();

    private SupplierLocator() {
    }

    // Locator
    String txtSearchSuppler = "//div/input[@placeholder='keyword']";
    String btnSearchSupplier = "//button[@testek = 'btn-search']";
    String iconLoading = "//div[@class='model-loading']";
}
