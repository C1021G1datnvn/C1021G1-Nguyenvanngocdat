package com.codegym.bank_passbook.modelDTO;

import com.codegym.bank_passbook.model.Customer;
import org.aspectj.lang.annotation.After;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;


public class StkDto {

    @NotBlank
    private String maSTK;

    @NotBlank
    private Long maKhachHang;

    @Future
    private Date timeGui;

    @NotBlank
    private String kyHan;

    @NotBlank
    @Min(3000000)
    private Double soTien;

    @NotBlank
    private Customer customer;

    public StkDto() {
    }

    public StkDto(String maSTK, Long maKhachHang, Date timeGui, String kyHan, Double soTien, Customer customer) {
        this.maSTK = maSTK;
        this.maKhachHang = maKhachHang;
        this.timeGui = timeGui;
        this.kyHan = kyHan;
        this.soTien = soTien;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Date getTimeGui() {
        return timeGui;
    }

    public void setTimeGui(Date timeGui) {
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

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        StkDto stkDto = (StkDto) target;
//        Date stkTime = stkDto.getTimeGui();
//        java.util.Date date = new java.util.Date();
//        LocalDate date = LocalDate.parse(stkTime);
//        if (date < new Date().getTime()) {
//            errors.rejectValue("timeGui", "", "Thời gian phải lớn hơn hiện tại!");
//        }
//    }

}
