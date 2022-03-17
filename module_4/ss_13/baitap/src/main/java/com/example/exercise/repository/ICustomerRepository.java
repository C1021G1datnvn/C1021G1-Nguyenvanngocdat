package com.example.exercise.repository;

import com.example.exercise.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

}
