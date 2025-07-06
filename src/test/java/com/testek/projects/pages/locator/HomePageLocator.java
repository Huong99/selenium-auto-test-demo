package com.testek.projects.pages.locator;

import lombok.Getter;

@Getter
public class HomePageLocator extends BaseLocator{
    @Getter
    public static HomePageLocator instance = new HomePageLocator();

    private HomePageLocator() {
    }


    String lblHeader = "//div[@id='about-me']/h2";
    String btnInsert = "//div[contains(@class, 'icon-insert')]";
    String lblCreateSupplier = "//li//div[normalize-space()='Nhà cung cấp']";
}
