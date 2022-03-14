package com.example.ex9baitap1.service.impl;


import com.example.ex9baitap1.model.Book;
import com.example.ex9baitap1.repository.IBookRepository;
import com.example.ex9baitap1.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;


    @Override
    public Iterable findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }


}
