package com.codegym.case_study_module4.service.impl;

import com.codegym.case_study_module4.model.Division;
import com.codegym.case_study_module4.repository.IDivisionRepository;
import com.codegym.case_study_module4.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository divisionRepository;

    @Override
    public Iterable<Division> findAll() {
        return divisionRepository.findAll();
    }
}
