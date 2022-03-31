package com.example.case_study.repository;

import com.example.case_study.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Long> {
}
