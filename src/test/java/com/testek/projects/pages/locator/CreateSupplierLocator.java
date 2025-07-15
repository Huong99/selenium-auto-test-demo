package com.testek.projects.pages.locator;

import lombok.Getter;

@Getter
public class CreateSupplierLocator extends BaseLocator {
    @Getter
    public static CreateSupplierLocator instance = new CreateSupplierLocator();

    private CreateSupplierLocator() {
    }

    String lblTitleCreateSupplier = "//div[normalize-space() = 'Thêm nhà cung cấp' and contains(@class, 'header')]";

    // Create Supplier Locator
    String txtSupplierName = "ID|form_item_supName";
    String txtSupplierPhone = "ID|form_item_supPhone";
    String txtSupplierContact = "ID|form_item_supContactName";
    String txtSupplierCountry = "ID|form_item_supCountry";
    String txtSupplierCity = "ID|form_item_supCity";
    String txtSupplierAddress = "ID|form_item_supAddress";
    String txtSupplierPostalCode = "ID|form_item_supPostalCode";

    String btnAddMoreSupplier = "//button[@testek = 'btn-add-more']";
    String lblSuccessMessageSupplier = "//span[normalize-space()='Thêm nhà cung cấp thành công']";
    String txtSupplierCodeXPath = "//input[@placeholder = 'Mã nhà cung cấp']";
    String txtSupplierErrorMessageXPath = "//div[normalize-space() = 'Error message' and contains(@class, 'w-full')]//textarea";
}
