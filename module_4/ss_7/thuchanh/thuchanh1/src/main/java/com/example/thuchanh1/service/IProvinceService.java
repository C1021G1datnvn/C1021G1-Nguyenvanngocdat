package com.example.thuchanh1.service;


import com.example.thuchanh1.model.Province;

import java.util.Optional;

public interface IProvinceService {
    Iterable<Province> findAll();
    Optional<Province> findById(Long id);
    void save(Province province);
    void remove(Long id);
}
