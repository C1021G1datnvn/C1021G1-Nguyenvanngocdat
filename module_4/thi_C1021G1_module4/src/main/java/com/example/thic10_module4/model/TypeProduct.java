package com.example.thic10_module4.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameTypeProduct;

    @OneToMany(mappedBy = "typeProduct", cascade = CascadeType.ALL)
    private Set<Product> products;

    public TypeProduct() {
    }

    public TypeProduct(String nameTypeProduct, Set<Product> products) {
        this.nameTypeProduct = nameTypeProduct;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTypeProduct() {
        return nameTypeProduct;
    }

    public void setNameTypeProduct(String nameTypeProduct) {
        this.nameTypeProduct = nameTypeProduct;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
