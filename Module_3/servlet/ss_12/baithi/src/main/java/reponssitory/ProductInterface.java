package reponssitory;

import model.Product;

import java.util.List;

public interface ProductInterface {
    List<Product> selectAll();
    Product selectID(int id);
    void create(Product product);
    void remove(int id);
    void update(Product product);
    List<Product> searchName(String name);
    List<Product> searchColor(String color);
}
