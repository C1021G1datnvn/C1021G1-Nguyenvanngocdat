package com.example.ex10.service;


import com.example.ex10.model.Product;

import java.util.List;

public interface IProductService {
    Iterable<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void remove(Long id);
}
