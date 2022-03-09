package com.example.thuchanh2.service;


import com.example.thuchanh2.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService<T> {
    Page<T> findAll(Pageable pageable);

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
    List<Customer> search(String name);
}
