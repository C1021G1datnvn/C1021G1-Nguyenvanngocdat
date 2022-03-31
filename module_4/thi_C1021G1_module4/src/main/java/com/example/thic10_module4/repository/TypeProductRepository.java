package com.example.thic10_module4.repository;

import com.example.thic10_module4.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TypeProductRepository extends JpaRepository<TypeProduct, Long> {
}
