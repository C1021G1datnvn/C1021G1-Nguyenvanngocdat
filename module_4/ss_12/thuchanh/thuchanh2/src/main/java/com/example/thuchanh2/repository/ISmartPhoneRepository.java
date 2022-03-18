package com.example.thuchanh2.repository;


import com.example.thuchanh2.model.SmartPhone;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartPhoneRepository extends PagingAndSortingRepository<SmartPhone, Long> {

}
