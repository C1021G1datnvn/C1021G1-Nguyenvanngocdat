package com.codegym.bank_passbook.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCustomer;

    @OneToMany(mappedBy = "customers")
    private List<SoTietKiem> soTietKiem;


    public Customer() {
    }

    public Customer(String nameCustomer, List<SoTietKiem> soTietKiem) {
        this.nameCustomer = nameCustomer;
        this.soTietKiem = soTietKiem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public List<SoTietKiem> getSoTietKiem() {
        return soTietKiem;
    }

    public void setSoTietKiem(List<SoTietKiem> soTietKiem) {
        this.soTietKiem = soTietKiem;
    }
}
