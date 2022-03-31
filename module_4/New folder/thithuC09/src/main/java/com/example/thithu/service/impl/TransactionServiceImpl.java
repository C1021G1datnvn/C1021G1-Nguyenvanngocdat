package com.example.thithu.service.impl;

import com.example.thithu.model.Transaction;
import com.example.thithu.repository.ITransactionRepository;
import com.example.thithu.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements ITransactionService {
    @Autowired
    private ITransactionRepository transactionRepository;

    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }

    @Override
    public Transaction findById(Integer id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public void remove(Integer id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public List<Transaction> search(String name) {
        return transactionRepository.findByCustomer_NameCustomerContaining(name);
    }


}
