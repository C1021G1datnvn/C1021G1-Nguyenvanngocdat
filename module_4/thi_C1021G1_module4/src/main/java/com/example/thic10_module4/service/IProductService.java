package com.example.thic10_module4.service;


import com.example.thic10_module4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    Product findById(Long id);
    void save(Product product);
    void remove(Long id);
    Page<Product> searchByName(String name, Pageable pageable);
}
