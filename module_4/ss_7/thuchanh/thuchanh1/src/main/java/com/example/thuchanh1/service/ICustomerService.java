package com.example.thuchanh1.service;


import com.example.thuchanh1.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService<T> {
    List<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
//    Customer update(Long id);
}
