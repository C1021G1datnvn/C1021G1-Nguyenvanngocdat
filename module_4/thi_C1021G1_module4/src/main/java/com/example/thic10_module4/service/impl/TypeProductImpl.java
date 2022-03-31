package com.example.thic10_module4.service.impl;

import com.example.thic10_module4.model.TypeProduct;
import com.example.thic10_module4.repository.TypeProductRepository;
import com.example.thic10_module4.service.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductImpl implements ITypeProductService {
    @Autowired
    private TypeProductRepository typeProductRepository;
    @Override
    public List<TypeProduct> findAll() {
        return typeProductRepository.findAll();
    }
}
