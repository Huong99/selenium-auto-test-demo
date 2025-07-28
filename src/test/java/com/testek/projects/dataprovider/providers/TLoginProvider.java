package com.testek.projects.dataprovider.providers;

import com.testek.datadriven.BaseProvider;
import com.testek.projects.dataprovider.DataPath;
import com.testek.projects.dataprovider.model.TLoginModel;
import com.testek.utils.configloader.JsonUtils;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class TLoginProvider extends BaseProvider {
    JsonUtils jsonUtils = JsonUtils.getInstance();


    @DataProvider(name = "Testek_Login_001_Huong_Valid")
    public Object[][] Testek_Login_001_Huong_Valid(Method method) {
        var dataList = jsonUtils.readDataTestFromJSON(DataPath.DATA_LOGIN_DEMO_01, method.getName());

        // Using Model Class and Data From Json file
        TLoginModel templateModel = new TLoginModel();
        return updateDataModel(templateModel, dataList);
    }

    @DataProvider(name = "Testek_Login_002_Login_Invalid")
    public Object[][] Testek_Login_002_Login_Invalid(Method method) {
        var dataList = jsonUtils.readDataTestFromJSON(DataPath.DATA_LOGIN_DEMO_01, method.getName());

        // Using Model Class and Data From Json file
        TLoginModel templateModel = new TLoginModel();
        return updateDataModel(templateModel, dataList);
    }
}
