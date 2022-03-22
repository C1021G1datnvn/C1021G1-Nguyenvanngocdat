package com.codegym.case_study_module4.dto;

public class CustomerTypeDTO {

    private Integer id;
    private String customerTypeName;

    public CustomerTypeDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
