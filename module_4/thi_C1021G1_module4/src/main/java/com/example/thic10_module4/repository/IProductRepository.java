package com.example.thic10_module4.repository;

import com.example.thic10_module4.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameProductContaining(String name, Pageable pageable);
//    Page<Product> findByPriceContaining(Doubl)
}
