package com.example.ex9baitap1.service.impl;

import com.example.ex9baitap1.model.BookCode;
import com.example.ex9baitap1.repository.ICodeBookRepository;
import com.example.ex9baitap1.service.IBookCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCodeService implements IBookCodeService {

    @Autowired
    private ICodeBookRepository codeBookRepository;

    @Override
    public Iterable findAll() {
        return codeBookRepository.findAll();
    }

    @Override
    public void save(BookCode bookCode) {
        codeBookRepository.save(bookCode);
    }

    @Override
    public void remove(BookCode bookCode) {
        codeBookRepository.delete(bookCode);
    }

    @Override
    public BookCode findById(Integer id) {
        return codeBookRepository.findById(id).get();
    }



}
