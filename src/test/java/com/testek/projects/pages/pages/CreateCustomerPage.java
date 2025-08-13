package com.testek.projects.pages.pages;

import com.testek.consts.FrameConst;
import com.testek.projects.common.BasePage;
import com.testek.projects.dataprovider.model.CreateCustomerModel;
import com.testek.projects.pages.objects.CreateCustomerObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateCustomerPage extends BasePage {
    final CreateCustomerObjects createCustomerObjects = new CreateCustomerObjects();

    public void verifyCreateCustomerPageDisplay() {
        createCustomerObjects.verifyAddCustomerTitleDisplay();
    }

    public CreateCustomerPage fillCustomerInfoAndClickAdd(CreateCustomerModel data) {
        long currentTime = System.currentTimeMillis();
        data.getName().setValue(data.getName().getValue() + currentTime);
        data.getEmail().setValue(currentTime + data.getEmail().getValue());

        createCustomerObjects.inputCustomerName(data.getName().getValue())
                .inputCustomerPhone(data.getPhone().getValue())
                .inputCustomerEmail(data.getEmail().getValue())
                .inputCustomerContact(data.getContact().getValue())
                .inputCustomerCountry(data.getCountry().getValue())
                .inputCustomerCity(data.getCity().getValue())
                .inputCustomerAddress(data.getAddress().getValue())
                .inputCustomerPostalCode(data.getPostalCode().getValue())
                .clickAddCustomerButton();
        return this;
    }

    public void verifyCustomerCreationSuccess(CreateCustomerModel data) {
        createCustomerObjects.verifySuccessMessage();

        WebElement customerIdEle = createCustomerObjects.findCustomerCode();
        WebElement resultCustomerEle = createCustomerObjects.findErrorMessage();
        getWaitDriver().until(ExpectedConditions.attributeToBeNotEmpty(resultCustomerEle, "value"));
        String infoCus = resultCustomerEle.getAttribute("value");
        System.out.println(infoCus);

        assertTrueCondition(resultCustomerEle, infoCus.contains(customerIdEle.getText()), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify customer code: ");
        assertTrueCondition(resultCustomerEle, infoCus.contains("name\":\"" + data.getName().getValue()), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify name: ");
        assertTrueCondition(resultCustomerEle, infoCus.contains("phoneNum\":\"" + data.getPhone().getValue()), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify phone: ");
        assertTrueCondition(resultCustomerEle, infoCus.contains("email\":\"" + data.getEmail().getValue()), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify email: ");
        assertTrueCondition(resultCustomerEle, infoCus.contains("contact\":\"" + data.getContact().getValue()), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify contact: ");
        assertTrueCondition(resultCustomerEle, infoCus.contains("country\":\"" + data.getCountry().getValue()), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify country: ");
        assertTrueCondition(resultCustomerEle, infoCus.contains("city\":\"" + data.getCity().getValue()), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify city: ");
        assertTrueCondition(resultCustomerEle, infoCus.contains("address\":\"" + data.getAddress().getValue()), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify address: ");
        assertTrueCondition(resultCustomerEle, infoCus.contains("postalCode\":\"" + data.getPostalCode().getValue()), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify postal code: ");

    }

    public void verifyCustomerCreationFailedWithInvalidPhone(){
        WebElement resultCustomerEle = createCustomerObjects.findErrorMessage();
        getWaitDriver().until(ExpectedConditions.attributeToBeNotEmpty(resultCustomerEle, "value"));
        String infoCus = resultCustomerEle.getAttribute("value");
        System.out.println(infoCus);

        assertTrueCondition(resultCustomerEle, infoCus.contains("code\":400"), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify status code: ");
        assertTrueCondition(resultCustomerEle, infoCus.contains("message\":\"Dữ liệu nhập không hợp lệ"), FrameConst.FailureHandling.CONTINUE_ON_FAILURE, "Verify error message: ");
    }

}
