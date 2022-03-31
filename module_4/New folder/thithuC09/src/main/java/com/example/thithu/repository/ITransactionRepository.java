package com.example.thithu.repository;


import com.example.thithu.model.Customer;
import com.example.thithu.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByCustomer_NameCustomerContaining(String name);
}
