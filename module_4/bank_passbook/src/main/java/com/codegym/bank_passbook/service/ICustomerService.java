package com.codegym.bank_passbook.service;

import com.codegym.bank_passbook.model.Customer;
import com.codegym.bank_passbook.model.SoTietKiem;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    void save(Customer customer);
    void remove(Customer customer);
}
