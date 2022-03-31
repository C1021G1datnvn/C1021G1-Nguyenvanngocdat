package com.codegym.bank_passbook.repository;


import com.codegym.bank_passbook.model.SoTietKiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoTietKiemRepository extends JpaRepository<SoTietKiem, Long> {

}
