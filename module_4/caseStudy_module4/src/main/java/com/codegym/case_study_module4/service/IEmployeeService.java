package com.codegym.case_study_module4.service;


import com.codegym.case_study_module4.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
    Employee findById(Integer id);
    void save(Employee employee);
    void remove(Employee employee);
}
