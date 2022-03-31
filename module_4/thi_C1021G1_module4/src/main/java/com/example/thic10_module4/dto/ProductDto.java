package com.example.thic10_module4.dto;

import com.example.thic10_module4.model.TypeProduct;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProductDto implements Validator {

    private Long id;
    @NotBlank(message = "Không được để trống!")
    @Size(min = 5, max = 50)
    private String nameProduct;
    private Double price;
    @NotBlank(message = "Không được để trống!")
    private String status;
    private TypeProduct typeProduct;

    public ProductDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        if (productDto.getPrice() == null || productDto.getPrice() < 100) {
            errors.rejectValue("price", "", "Số tiền nhỏ là 100.000 VND");
        }
    }
}
