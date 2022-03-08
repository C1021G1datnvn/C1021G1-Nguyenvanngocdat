package com.example.thuchanh1.service.impl;

import com.example.thuchanh1.model.Province;
import com.example.thuchanh1.repository.IProvinceRepository;
import com.example.thuchanh1.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    IProvinceRepository repository;


    @Override
    public Iterable<Province> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Province province) {
        repository.save(province);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
