package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> finAll();
    void create(Product product);
    void remove(int id);
    Product finById(int id);
    void update(Product product);
    List<Product> searchName(String name);
    List<Product> searchColor(String color);

}
