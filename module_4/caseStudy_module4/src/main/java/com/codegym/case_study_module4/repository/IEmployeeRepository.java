package com.codegym.case_study_module4.repository;


import com.codegym.case_study_module4.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

}
