package com.example.thuchanh2.service.impl;


import com.example.thuchanh2.model.Customer;
import com.example.thuchanh2.repository.ICustomerRepository;
import com.example.thuchanh2.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService<Customer> {
    @Autowired
    ICustomerRepository repository;


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
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

    @Override
    public List<Customer> search(String name) {
        return repository.findCustomerByFirstNameContains(name);
    }

}
