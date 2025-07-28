package com.testek.projects.dataprovider.model;

import com.testek.datadriven.BaseModel;
import com.testek.datadriven.DataModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TLoginModel extends BaseModel {
    public DataModel userName;
    public DataModel password;

    public TLoginModel(){
        super();
        userName = createDataModelObj("UserName");
        password = createDataModelObj("Password");
    }
}
