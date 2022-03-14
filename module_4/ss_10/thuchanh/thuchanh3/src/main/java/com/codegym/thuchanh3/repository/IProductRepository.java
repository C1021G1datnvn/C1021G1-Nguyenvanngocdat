package com.codegym.thuchanh3.repository;

import com.codegym.thuchanh3.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {

}
