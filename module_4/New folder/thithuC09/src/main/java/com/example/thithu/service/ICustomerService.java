package com.example.thithu.service;

import com.example.thithu.model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();
    Customer findById(Integer id);
}
