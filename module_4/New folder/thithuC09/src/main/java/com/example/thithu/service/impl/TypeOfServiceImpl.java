package com.example.thithu.service.impl;

import com.example.thithu.model.TypeOfService;
import com.example.thithu.repository.ITypeOfServiceRepository;
import com.example.thithu.service.ITypeOfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfServiceImpl implements ITypeOfService {
    @Autowired
    private ITypeOfServiceRepository typeOfServiceRepository;

    @Override
    public List<TypeOfService> findAll() {
        return typeOfServiceRepository.findAll();
    }
}
