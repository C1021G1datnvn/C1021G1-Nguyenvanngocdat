package com.example.thithu.service;


import com.example.thithu.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ITransactionService {
    Page<Transaction> findAll(Pageable pageable);
    Transaction findById(Integer id);
    void save(Transaction transaction);
    void remove(Integer id);
    List<Transaction> search(String name);
}
