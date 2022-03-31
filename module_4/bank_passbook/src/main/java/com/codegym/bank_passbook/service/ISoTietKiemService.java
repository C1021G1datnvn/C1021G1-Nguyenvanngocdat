package com.codegym.bank_passbook.service;


import com.codegym.bank_passbook.model.SoTietKiem;

import java.util.List;
import java.util.Optional;

public interface ISoTietKiemService {
    List<SoTietKiem> findAll();
    Optional<SoTietKiem> findById(Long id);
    void save(SoTietKiem soTietKiem);
    void remove(SoTietKiem soTietKiem);
}
