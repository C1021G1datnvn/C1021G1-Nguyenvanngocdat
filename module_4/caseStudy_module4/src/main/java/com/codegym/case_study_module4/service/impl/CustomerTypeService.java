package com.codegym.case_study_module4.service.impl;

import com.codegym.case_study_module4.model.CustomerType;
import com.codegym.case_study_module4.repository.ICustomerTypeRepo;
import com.codegym.case_study_module4.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepo customerTypeRepo;

    @Override
    public Iterable<CustomerType> findAll() {
        return customerTypeRepo.findAll();
    }
}
