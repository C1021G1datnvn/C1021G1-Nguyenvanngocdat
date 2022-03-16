package com.codegym.thuchanh1.service.impl;

import com.codegym.thuchanh1.model.Customer;
import com.codegym.thuchanh1.repository.ICustomerRepository;
import com.codegym.thuchanh1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerService implements ICustomerService<Customer> {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Iterable findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
