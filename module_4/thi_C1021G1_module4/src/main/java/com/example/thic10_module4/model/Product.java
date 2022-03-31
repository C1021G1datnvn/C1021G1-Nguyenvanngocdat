package com.example.thic10_module4.model;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameProduct;
    private Double price;
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_type_product", referencedColumnName = "id")
    private TypeProduct typeProduct;

    public Product() {
    }

    public Product(String nameProduct, Double price, String status, TypeProduct typeProduct) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.status = status;
        this.typeProduct = typeProduct;
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
}
