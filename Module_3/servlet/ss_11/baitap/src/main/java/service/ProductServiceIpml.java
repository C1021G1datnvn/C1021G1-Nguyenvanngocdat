package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceIpml implements ProductService {

    private  static final Map<Integer,Product> listProduct = new HashMap<>();
    static {
        listProduct.put(1,new Product(1,"Bánh Mì",15000,"Bánh MÌ Thịt","Bà7"));
        listProduct.put(2,new Product(2,"Snack",5000,"Khoai Tây","Oshi"));
        listProduct.put(3,new Product(3,"Ốc Hương",35000,"Xào Bơ Tỏi","59B"));
        listProduct.put(4,new Product(4,"Bánh Xèo",20000,"Bánh Xèo Thịt","Bà Tứ"));
        listProduct.put(5,new Product(5,"Trà Sữa",15000,"Trân Châu","Bông"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(listProduct.values());
    }

    @Override
    public Product findById(int id) {
        return listProduct.get(id);
    }

    @Override
    public void save(Product product) {
        listProduct.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
         listProduct.put(id,product);
    }

    @Override
    public void remove(int id) {
         listProduct.remove(id);
    }

    @Override
    public void search(String nameProduct) {

    }
}
