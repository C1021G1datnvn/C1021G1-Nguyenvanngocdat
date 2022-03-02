package model;

public class Product {
    private int id;
    private String nameProduct;
    private double price;
    private String productDescription;
    private String manufacturer;

    public Product() {
    }

    public Product(int id, String nameProduct, double price, String productDescription, String manufacturer) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.productDescription = productDescription;
        this.manufacturer = manufacturer;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
