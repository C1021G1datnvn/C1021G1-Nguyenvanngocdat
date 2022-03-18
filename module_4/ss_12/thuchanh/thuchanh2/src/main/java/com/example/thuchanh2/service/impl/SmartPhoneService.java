package com.example.thuchanh2.service.impl;

import com.example.thuchanh2.model.SmartPhone;
import com.example.thuchanh2.repository.ISmartPhoneRepository;
import com.example.thuchanh2.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SmartPhoneService implements ISmartPhoneService {

    @Autowired
    private ISmartPhoneRepository smartPhoneRepository;

    @Override
    public List<SmartPhone> findAll() {
        return (List<SmartPhone>) smartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public void save(SmartPhone smartPhone) {
        smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }
}
