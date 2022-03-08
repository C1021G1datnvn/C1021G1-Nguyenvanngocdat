package com.example.thuchanh2.service;


import com.example.thuchanh2.model.Province;

import java.util.Optional;

public interface IProvinceService {
    Iterable<Province> findAll();
    Optional<Province> findById(Long id);
    void save(Province province);
    void remove(Long id);
}
