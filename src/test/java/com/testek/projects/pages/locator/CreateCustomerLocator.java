package com.testek.projects.pages.locator;

import lombok.Getter;

@Getter
public class CreateCustomerLocator extends BaseLocator{
    public CreateCustomerLocator(){
    }

    // Locator
    String lblAddCustomerTitle = "//div[@testek = 'base-detail']//div[@class = 'header']";

    String txtName = "ID|form_item_name";
    String txtPhone = "ID|form_item_phoneNum";
    String txtEmail = "ID|form_item_email";
    String txtContact = "ID|form_item_contact";
    String txtCountry = "ID|form_item_country";
    String txtCity = "ID|form_item_city";
    String txtAddress = "ID|form_item_address";
    String txtPostalCode = "ID|form_item_postalCode";

    String btnAdd = "//button[@testek = 'btn-add']";

    String lblSuccessMessageCustomer = "//span[normalize-space()='Thêm khách hàng thành công']";

    String txtCustomerCode = "//input[@placeholder = 'Mã khách hàng']";
    String txtErrorMessage = "//textarea";
}
