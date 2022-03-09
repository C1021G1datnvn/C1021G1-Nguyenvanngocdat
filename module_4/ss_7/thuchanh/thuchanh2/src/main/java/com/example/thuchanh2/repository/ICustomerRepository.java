package com.example.thuchanh2.repository;

import com.example.thuchanh2.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findCustomerByFirstNameContains(String name);
}
