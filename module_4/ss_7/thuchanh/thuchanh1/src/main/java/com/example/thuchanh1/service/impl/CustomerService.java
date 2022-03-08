package com.example.thuchanh1.service.impl;


import com.example.thuchanh1.model.Customer;
import com.example.thuchanh1.repository.ICustomerRepository;
import com.example.thuchanh1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService<Customer> {
    @Autowired
    ICustomerRepository repository;


    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }


}
