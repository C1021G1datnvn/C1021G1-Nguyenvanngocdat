package com.example.ex9baitap1.service;

import com.example.ex9baitap1.model.BookCode;

public interface IBookCodeService<T> {
    Iterable<T> findAll();
    void save(BookCode bookCode);
    void remove(BookCode bookCode);
    BookCode findById(Integer id);
}
