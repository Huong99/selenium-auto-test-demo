package com.testek.projects.dataprovider.model;

import com.testek.datadriven.BaseModel;
import com.testek.datadriven.DataModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HCreateProductModel extends BaseModel {
    public DataModel category;
    public DataModel supplier;
    public DataModel code;
    public DataModel unit;
    public DataModel name;
    public DataModel description;
    public DataModel price;
    public DataModel quantity;

    public HCreateProductModel() {
        super();
        category = createDataModelObj("Category");
        supplier = createDataModelObj("Supplier");
        code = createDataModelObj("Code");
        unit = createDataModelObj("Unit");
        name = createDataModelObj("Name");
        description = createDataModelObj("Description");
        price = createDataModelObj("Price");
        quantity = createDataModelObj("Quantity");
    }
}
