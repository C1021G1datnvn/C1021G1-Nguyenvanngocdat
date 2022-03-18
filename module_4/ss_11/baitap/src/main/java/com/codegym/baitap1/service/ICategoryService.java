package com.codegym.baitap1.service;

import com.codegym.baitap1.model.Category;

import java.util.List;
import java.util.Optional;


public interface ICategoryService<T> {
    List<Category> findAll();
    void save(Category category);
    void remove(Long id);
    Optional<T> findById(Long id);
}
