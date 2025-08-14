package com.testek.projects.pages.locator;

import lombok.Getter;

@Getter
public class CategoryLocator extends BaseLocator{
    public CategoryLocator (){}

    // Locator
    String btnAddCategory = "//button[@testek='btn-add']";
    String btnExport = "//button[normalize-space() = 'Xuất khẩu']";
    String btnPrint = "//button[normalize-space() = 'In']";

    String printPage = "//print-preview-app";

}
