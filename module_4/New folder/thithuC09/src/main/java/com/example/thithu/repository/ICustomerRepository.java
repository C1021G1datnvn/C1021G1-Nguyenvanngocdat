package com.example.thithu.repository;

import com.example.thithu.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}
