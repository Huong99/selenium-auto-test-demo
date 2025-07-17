package com.testek.projects.pages.locator;

import lombok.Getter;

@Getter
public class DashboardLocator extends BaseLocator{
    public DashboardLocator(){
    }

    String btnUserIcon = "//div[@testek='icon-user']";
    String lblMessageSuccess = "//div[contains(@class, 'ant-message-success')]";
    String ngvProduct = "//div[contains(@class, 'icon-product')]/following-sibling::div";
}
