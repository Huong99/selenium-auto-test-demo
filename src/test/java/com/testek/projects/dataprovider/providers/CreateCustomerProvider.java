package com.testek.projects.dataprovider.providers;

import com.testek.datadriven.BaseProvider;
import com.testek.projects.dataprovider.DataPath;
import com.testek.projects.dataprovider.model.CreateCustomerModel;
import com.testek.utils.configloader.JsonUtils;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class CreateCustomerProvider extends BaseProvider {
    JsonUtils jsonUtils = JsonUtils.getInstance();


    @DataProvider(name = "TK_CreateCustomer_001_Valid")
    public Object[][] TK_CreateCustomer_001_Valid(Method method) {

        var dataList = jsonUtils.readDataTestFromJSON(DataPath.DATA_CREATE_CUSTOMER, method.getName());

        // Using Model Class and Data From Json file
        CreateCustomerModel templateModel = new CreateCustomerModel();
        return updateDataModel(templateModel, dataList);
    }

    @DataProvider(name = "TK_CreateCustomer_002_InvalidPhone")
    public Object[][] TK_CreateCustomer_002_InvalidPhone(Method method) {

        var dataList = jsonUtils.readDataTestFromJSON(DataPath.DATA_CREATE_CUSTOMER, method.getName());

        // Using Model Class and Data From Json file
        CreateCustomerModel templateModel = new CreateCustomerModel();
        return updateDataModel(templateModel, dataList);
    }
}
