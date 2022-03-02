package ss12_java_collection_framework.bai_tap.model;

import java.util.Comparator;

public class Product implements Comparable<Product>, Comparator<Product> {
    private int id;
    private String nameProduct;
    private double unitPrice;
    private int quantity;
    public Product() {
    }

    public Product(int id, String nameProduct, double unitPrice, int quantity) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        if (this.unitPrice > o.getUnitPrice()) {
            return 1;
        }else if(this.unitPrice < o.getUnitPrice()) {
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.unitPrice > o2.getUnitPrice()) {
            return -1;
        }else if(o1.unitPrice < o2.getUnitPrice()) {
            return 1;
        }else {
            return 0;
        }
    }
}
