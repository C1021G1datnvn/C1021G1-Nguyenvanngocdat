package com.example.thuchanh1.repository;

import com.example.thuchanh1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
//    void deleteById(Long id);
}
