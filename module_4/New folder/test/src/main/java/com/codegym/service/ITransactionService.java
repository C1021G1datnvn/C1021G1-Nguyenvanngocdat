package com.codegym.service;

import com.codegym.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ITransactionService {

    Page<Transaction> findAll(Pageable pageable);
    Transaction findById(int id);
    void save(Transaction transaction);
    void remove(int id);


}
