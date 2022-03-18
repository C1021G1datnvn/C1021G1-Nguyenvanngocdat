package com.example.thuchanh2.service;

import com.example.thuchanh2.model.SmartPhone;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;
import java.util.Optional;

public interface ISmartPhoneService {

    List<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);

    void save(SmartPhone smartPhone);

    void remove(Long id);
}
