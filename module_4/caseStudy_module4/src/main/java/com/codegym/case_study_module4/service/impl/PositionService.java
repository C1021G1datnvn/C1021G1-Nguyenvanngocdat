package com.codegym.case_study_module4.service.impl;

import com.codegym.case_study_module4.model.Position;
import com.codegym.case_study_module4.repository.IPositionRepository;
import com.codegym.case_study_module4.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }
}
