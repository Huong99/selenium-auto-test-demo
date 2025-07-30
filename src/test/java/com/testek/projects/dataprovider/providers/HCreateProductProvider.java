package com.testek.projects.dataprovider.providers;

import com.testek.datadriven.BaseProvider;
import com.testek.projects.dataprovider.DataPath;
import com.testek.projects.dataprovider.model.HCreateProductModel;
import com.testek.utils.configloader.JsonUtils;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class HCreateProductProvider extends BaseProvider {
    JsonUtils jsonUtils = JsonUtils.getInstance();


    @DataProvider(name = "HuongPham_CreateProduct_001_Valid")
    public Object[][] HuongPham_CreateProduct_001_Valid(Method method) {
        var dataList = jsonUtils.readDataTestFromJSON(DataPath.DATA_CREATE_PRODUCT_H, method.getName());

        // Using Model Class and Data From Json file
        HCreateProductModel templateModel = new HCreateProductModel();
        return updateDataModel(templateModel, dataList);
    }
}
