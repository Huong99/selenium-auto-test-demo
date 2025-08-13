package com.testek.projects.pages.locator;

import lombok.Getter;

@Getter
public class CustomerLocator extends BaseLocator {
    public CustomerLocator() {
    }

    // Locator
    String btnAddCustomer = "//button[@testek='btn-add']";
    String txtSearch = "//div/input[@testek = 'search-input']";
    String btnSearch = "//button[@testek = 'btn-search']";

}
