package com.codegym.dto;

import com.codegym.model.Customer;
import com.codegym.model.Transaction;
import com.codegym.model.TypeOfService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

public class TransactionDto {

    private Integer idTransaction;

    @NotNull(message = "Bắt buộc phải nhập!")
    @NotBlank(message = "Không được để trống!")
    @Pattern(regexp = "^[MGD-]+[0-9]{4}", message = "Phải đúng định dạng MGD-XXXX")
    private String codeTransaction;

    @NotNull(message = "Bắt buộc phải nhập!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateTransaction;

    @NotNull(message = "Bắt buộc phải nhập!")
    @NotBlank(message = "Không được để trống!")
    private String unitPrice;

    @NotNull(message = "Bắt buộc phải nhập!")
    @Min(value = 50, message = "Diện tịch tối thiểu là 50m2")
    private Integer acreage;

    @Valid
    private Customer customer;

    private TypeOfService typeOfService;

    public TransactionDto() {
    }

    public Integer getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getCodeTransaction() {
        return codeTransaction;
    }

    public void setCodeTransaction(String codeTransaction) {
        this.codeTransaction = codeTransaction;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getAcreage() {
        return acreage;
    }

    public void setAcreage(Integer acreage) {
        this.acreage = acreage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TypeOfService getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(TypeOfService typeOfService) {
        this.typeOfService = typeOfService;
    }

}
