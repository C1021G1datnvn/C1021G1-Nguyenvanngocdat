package com.codegym.baitap1.service.impl;


import com.codegym.baitap1.model.Category;
import com.codegym.baitap1.repository.ICategoryRepository;
import com.codegym.baitap1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Category category) {
        repository.save(category);
    }

    @Override
    public void remove(Category category) {
        repository.delete(category);
    }

    @Override
    public Category findById(Long id) {
        return repository.findById(id).get();
    }


}
