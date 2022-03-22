package com.codegym.case_study_module4.service.impl;

import com.codegym.case_study_module4.model.Education;
import com.codegym.case_study_module4.repository.IEducationRepository;
import com.codegym.case_study_module4.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService {
    @Autowired
    private IEducationRepository educationRepository;

    @Override
    public Iterable<Education> findAll() {
        return educationRepository.findAll();
    }
}
