package com.codegym.case_study_module4.service;


import com.codegym.case_study_module4.model.CustomerType;

public interface ICustomerTypeService {
    Iterable<CustomerType> findAll();
}
