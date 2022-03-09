package com.codegym.baitap1.service;

import com.codegym.baitap1.model.Category;

import java.util.List;
import java.util.Optional;


public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);
    void remove(Category category);
    Category findById(Long id);
}
