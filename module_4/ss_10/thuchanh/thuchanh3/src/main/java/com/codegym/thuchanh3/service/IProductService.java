package com.codegym.thuchanh3.service;

import com.codegym.thuchanh3.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
