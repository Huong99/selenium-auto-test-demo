package com.testek.projects.pages.pages;

import com.testek.consts.FrameConst.FailureHandling;
import com.testek.projects.common.BasePage;
import com.testek.projects.dataprovider.model.CreateProductModel;
import com.testek.projects.dataprovider.model.HCreateProductModel;
import com.testek.projects.pages.objects.ProductObjects;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

import static com.testek.utils.FakerUtils.getRandomPrice;
import static com.testek.utils.FakerUtils.getRandomQuantity;

/**
 * Implement the functions of the Product page
 */
public class ProductPage extends BasePage {
    private final ProductObjects productObjects;

    public ProductPage() {
        super();
        PageFactory.initElements(webDriver, this);
        productObjects = ProductObjects.getInstance();
    }

    public ProductPage clickToCreateProduct() {
        productObjects.clickAddProductButton();
        return this;
    }

    //region Integration Functions
    public ProductPage fillProductInfo(CreateProductModel model) {

        /* Update the random Price & Quantity */
        long currentTimeMillis = System.nanoTime();
        model.getPrice().setValue(String.valueOf(getRandomPrice()));
        model.getQuantity().setValue(String.valueOf(getRandomQuantity()));
        model.getCode().setValue(model.getCode().getValue() + currentTimeMillis);
        model.getName().setValue(model.getName().getValue() + currentTimeMillis);
        model.getDescription().setValue(model.getDescription().getValue() + currentTimeMillis);

        productObjects.selectCategory(model.getCategory().getValue())
                .selectSupplier(model.getSupplier().getValue())
                .inputProductCode(model.getCode().getValue())
                .inputProductUnit(model.getUnit().getValue())
                .inputProductName(model.getName().getValue())
                .inputProductDescription(model.getDescription().getValue())
                .inputProductPrice(model.getPrice().getValue())
                .inputProductQuantity(model.getPrice().getValue());
        return this;
    }

    public ProductPage fillProductInfo(HCreateProductModel data) {
        long currentTimeMillis = System.currentTimeMillis();
        data.getCode().setValue(data.getCode().getValue() + currentTimeMillis);
        data.getName().setValue(data.getName().getValue() + currentTimeMillis);
        data.getDescription().setValue(data.getDescription().getValue() + currentTimeMillis);
        data.getPrice().setValue(String.valueOf(getRandomPrice()));
        data.getQuantity().setValue(String.valueOf(getRandomQuantity()));

        productObjects.selectCategory(data.getCategory().getValue())
                .selectSupplier(data.getSupplier().getValue())
                .inputProductCode(data.getCode().getValue())
                .inputProductUnit(data.getUnit().getValue())
                .inputProductName(data.getName().getValue())
                .inputProductDescription(data.getDescription().getValue())
                .inputProductPrice(data.getPrice().getValue())
                .inputProductQuantity(data.getQuantity().getValue());
        return this;
    }

    /* Verify the product page display */
    public void verifyProductPageDisplay() {
        WebElement element = waitForElementVisible(productObjects.findBtnAddProductPage());
        assertTrueCondition(element, Objects.nonNull(element), FailureHandling.CONTINUE_ON_FAILURE, "Verify the Product page is displayed");
    }

    /**
     * Verify the product creation
     */
    public void verifyProductCreation() {
        productObjects.verifySuccessMessageDisplayed();

        WebElement productIdEle = productObjects.findProductIdRes();
        assertTrueCondition(productIdEle, Objects.nonNull(productIdEle), FailureHandling.CONTINUE_ON_FAILURE, "Verify the product ID is displayed after creating a product");

        WebElement productResultEle = productObjects.findProductResult();
        String resultText = getValueOfElement(productResultEle);
        JSONObject productJson = new JSONObject(resultText);
        assertEqualCondition(productResultEle, productJson.getJSONObject("data").get("id"), getValueOfElement(productIdEle),
                FailureHandling.CONTINUE_ON_FAILURE, "Verify the product code matches the input value");

        // TODO: Verify the product info
    }

    public void verifyProductCreation(HCreateProductModel data) {
        productObjects.verifySuccessMessage();

        WebElement productIdEle = productObjects.findProductIdRes();
        WebElement resultProductEle = productObjects.findProductResult();
        String infoPro = resultProductEle.getAttribute("value");

        assertTrueCondition(resultProductEle, infoPro.contains(productIdEle.getText()), FailureHandling.CONTINUE_ON_FAILURE, "Verify product code: ");
        assertTrueCondition(resultProductEle, infoPro.contains(data.getCategory().getValue()), FailureHandling.CONTINUE_ON_FAILURE, "Verify category: ");
        assertTrueCondition(resultProductEle, infoPro.contains("productCode\":\"" + data.getCode().getValue()), FailureHandling.CONTINUE_ON_FAILURE, "Verify code: ");
        assertTrueCondition(resultProductEle, infoPro.contains("supName\":\"" + data.getSupplier().getValue()), FailureHandling.CONTINUE_ON_FAILURE, "Verify supplier: ");
        assertTrueCondition(resultProductEle, infoPro.contains("productDesc\":\"" + data.getDescription().getValue()), FailureHandling.CONTINUE_ON_FAILURE, "Verify description: ");
        assertTrueCondition(resultProductEle, infoPro.contains("unit\":\"" + data.getUnit().getValue()), FailureHandling.CONTINUE_ON_FAILURE, "Verify unit: ");
        assertTrueCondition(resultProductEle, infoPro.contains("productName\":\"" + data.getName().getValue()), FailureHandling.CONTINUE_ON_FAILURE, "Verify name: ");
        assertTrueCondition(resultProductEle, infoPro.contains("price\":" + data.getPrice().getValue()), FailureHandling.CONTINUE_ON_FAILURE, "Verify price: ");
        assertTrueCondition(resultProductEle, infoPro.contains("quantity\":" + data.getQuantity().getValue()), FailureHandling.CONTINUE_ON_FAILURE, "Verify quatity: ");
    }

    //endregion
}
