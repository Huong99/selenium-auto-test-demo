package com.testek.projects.pages.pages;

import com.testek.driver.DriverManager;
import com.testek.projects.common.BasePage;
import com.testek.projects.pages.objects.SupplierObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class SupplierPage extends BasePage {
    private final SupplierObjects supplierObjects;

    public SupplierPage() {
        webDriver = DriverManager.getDriver();
        PageFactory.initElements(webDriver, this);

        supplierObjects = SupplierObjects.getInstance();
    }

    public void searchAndVerify(Map<String, String> info) {
        supplierObjects.inputKeyword(info.get("name"))
                .clickSearchButton();

        waitForDebug();
        getWaitDriver().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='model-loading']")));

        // Verify info of Supplier
        List<WebElement> supplierInfo = getWebDriver().findElements(By.xpath("//tr[contains(@class, 'row-table')]/td"));
        Assert.assertEquals(supplierInfo.get(0).getText(), info.get("name"), "Supplier Name is not match");
        Assert.assertEquals(supplierInfo.get(1).getText(), info.get("address"), "Supplier Address is not match");
        Assert.assertEquals(supplierInfo.get(2).getText(), info.get("phone"), "Supplier Phone is not match");
        Assert.assertEquals(supplierInfo.get(3).getText(), info.get("contact"), "Supplier Contact is not match");
        Assert.assertEquals(supplierInfo.get(4).getText(), info.get("city"), "Supplier City is not match");
        Assert.assertEquals(supplierInfo.get(5).getText(), info.get("country"), "Supplier Country is not match");
        Assert.assertEquals(supplierInfo.get(6).getText(), info.get("postalCode"), "Supplier Postal Code is not match");
    }
}
