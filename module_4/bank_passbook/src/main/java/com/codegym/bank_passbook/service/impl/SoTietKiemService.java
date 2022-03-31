package com.codegym.bank_passbook.service.impl;


import com.codegym.bank_passbook.model.SoTietKiem;
import com.codegym.bank_passbook.repository.ISoTietKiemRepository;
import com.codegym.bank_passbook.service.ISoTietKiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoTietKiemService implements ISoTietKiemService {

    @Autowired
    private ISoTietKiemRepository soTietKiemRepository;

    @Override
    public List<SoTietKiem> findAll() {
        return soTietKiemRepository.findAll();
    }

    @Override
    public Optional<SoTietKiem> findById(Long id) {
        return soTietKiemRepository.findById(id);
    }

    @Override
    public void save(SoTietKiem soTietKiem) {
        soTietKiemRepository.save(soTietKiem);
    }

    @Override
    public void remove(SoTietKiem soTietKiem) {
        soTietKiemRepository.delete(soTietKiem);
    }
}
