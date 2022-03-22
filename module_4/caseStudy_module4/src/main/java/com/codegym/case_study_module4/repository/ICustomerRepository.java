package com.codegym.case_study_module4.repository;

import com.codegym.case_study_module4.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
    Page<Customer> findCustomerByCustomerName(String name, Pageable pageable);
}
