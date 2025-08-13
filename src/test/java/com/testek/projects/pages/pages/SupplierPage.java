package com.testek.projects.pages.pages;

import com.testek.driver.DriverManager;
import com.testek.projects.common.BasePage;
import com.testek.projects.pages.PageManagement;
import com.testek.projects.pages.objects.SupplierObjects;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
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

        waitForDebug(1000);
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

    public void verifyCreateSupplierPageDisplay() {
        Assert.assertTrue(supplierObjects.findTitleCreateSupplierPage().isDisplayed(), "Create Supplier Page is not displayed!!!");
    }

    public void verifySupplierListPageDisplay() {
        Assert.assertTrue(supplierObjects.findAddSupplierButtonEle().isDisplayed(), "Supplier List Page is not displayed!!!");
    }

    public Map<String, String> initNewSupplierInfo() {
        Map<String, String> newSupplierInfo = new HashMap<>();
        String currentTime = String.valueOf(System.currentTimeMillis());
        String name = "HuongPham_Auto_" + currentTime;
        String phone = "0" + currentTime;
        String contact = "HuongPham_Contact_" + currentTime;
        String country = "Viet nam";
        String city = "Ha Noi";
        String address = "Ha Noi_" + currentTime;
        String postalCode = String.valueOf(ThreadLocalRandom.current().nextInt(1_000_000, 10_000_000));
        newSupplierInfo.put("name", name);
        newSupplierInfo.put("phone", phone);
        newSupplierInfo.put("contact", contact);
        newSupplierInfo.put("country", country);
        newSupplierInfo.put("city", city);
        newSupplierInfo.put("address", address);
        newSupplierInfo.put("postalCode", postalCode);
        return newSupplierInfo;
    }

    public Map<String, String> fillSupplierInfo() {
        Map<String, String> supplierInfo = initNewSupplierInfo();

        supplierObjects.inputSupplierName(supplierInfo.get("name"))
                .inputSupplierPhone(supplierInfo.get("phone"))
                .inputSupplierContact(supplierInfo.get("contact"))
                .inputSupplierCountry(supplierInfo.get("country"))
                .inputSupplierCity(supplierInfo.get("city"))
                .inputSupplierAddress(supplierInfo.get("address"))
                .inputSupplierPostalCode(supplierInfo.get("postalCode"));
        return supplierInfo;
    }

    public SupplierPage clickToCreateMoreSupplier() {
        supplierObjects.clickAddMoreSupplierButton();
        return this;
    }

    public CreateSupplierPage clickToCreateSupplier() {
        supplierObjects.clickAddSupplierButton();
        return PageManagement.gotoCreateSupplierPage();
    }

    /**
     * Verify the supplier creation
     */
    public void verifySupplierCreation(Map<String, String> info) {
        // Verify success message
        getWaitDriver().until(ExpectedConditions.visibilityOf(supplierObjects.findSuccessMessageSupplierEle()));

        getWaitDriver().until(ExpectedConditions.attributeToBeNotEmpty(supplierObjects.findSupplierCodeEle(), "value"));
        String codeSupplier = supplierObjects.findSupplierCodeEle().getAttribute("value");
        getWaitDriver().until(ExpectedConditions.attributeToBeNotEmpty(supplierObjects.findSupplierErrorMessageEle(), "value"));
        String messageSupplier = supplierObjects.findSupplierErrorMessageEle().getAttribute("value");
        log.info("Code order: [{}]", codeSupplier);
        log.info("Message order: [{}]", messageSupplier);

        // Verify info in Error message textbox
        Assert.assertTrue(messageSupplier.contains("\"supName\":\"" + info.get("name")), "Supplier Name is not match");
        Assert.assertTrue(messageSupplier.contains("\"supContactName\":\"" + info.get("contact")), "Supplier Contact is not match");
        Assert.assertTrue(messageSupplier.contains("\"supAddress\":\"" + info.get("address")), "Supplier Address is not match");
        Assert.assertTrue(messageSupplier.contains("\"supCity\":\"" + info.get("city")), "Supplier City is not match");
        Assert.assertTrue(messageSupplier.contains("\"supPostalCode\":\"" + info.get("postalCode")), "Supplier Postal Code is not match");
        Assert.assertTrue(messageSupplier.contains("\"supCountry\":\"" + info.get("country")), "Supplier Country is not match");
        Assert.assertTrue(messageSupplier.contains("\"supPhone\":\"" + info.get("phone")), "Supplier Phone is not match");

    }
}
