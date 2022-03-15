package com.example.ex9baitap1.service;


import com.example.ex9baitap1.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService<T> {
    Iterable<T> findAll();
    void save(Book book);
    void remove(Book book);
    Book findById(Long id);
}
