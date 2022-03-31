package com.codegym.bank_passbook.model;


import javax.persistence.*;

@Entity
public class SoTietKiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maSTK;
    private Long maKhachHang;

    private String timeGui;
    private String kyHan;
    private Double soTien;

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    private Customer customers;


    public SoTietKiem() {
    }

    public SoTietKiem(String maSTK, Long maKhachHang, String timeGui, String kyHan, Double soTien, Customer customers) {
        this.maSTK = maSTK;
        this.maKhachHang = maKhachHang;
        this.timeGui = timeGui;
        this.kyHan = kyHan;
        this.soTien = soTien;
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaSTK() {
        return maSTK;
    }

    public void setMaSTK(String maSTK) {
        this.maSTK = maSTK;
    }

    public Long getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(Long maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTimeGui() {
        return timeGui;
    }

    public void setTimeGui(String timeGui) {
        this.timeGui = timeGui;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    public Double getSoTien() {
        return soTien;
    }

    public void setSoTien(Double soTien) {
        this.soTien = soTien;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }
}
