package com.testek.projects.dataprovider.model;

import com.testek.datadriven.BaseModel;
import com.testek.datadriven.DataModel;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class CreateCustomerModel extends BaseModel{
    public DataModel name;
    public DataModel phone;
    public DataModel email;
    public DataModel contact;
    public DataModel country;
    public DataModel city;
    public DataModel address;
    public DataModel postalCode;

    public CreateCustomerModel() {
        super();
        name = createDataModelObj("Name");
        phone = createDataModelObj("Phone");
        email = createDataModelObj("Email");
        contact = createDataModelObj("Contact");
        country = createDataModelObj("Country");
        city = createDataModelObj("City");
        address = createDataModelObj("Address");
        postalCode = createDataModelObj("PostalCode");
    }
}
