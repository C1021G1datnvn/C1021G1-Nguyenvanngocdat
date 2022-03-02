package model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private double price;
    private int quantily;
    private String color;


    private int idCategory;
    private String nameCategory;


    public Product() {
    }

    public Product(String nameProduct, double price, int quantily, String color, String nameCategory) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantily = quantily;
        this.color = color;
        this.nameCategory = nameCategory;
    }

    public Product(String nameProduct, double price, int quantily, String color, int idCategory) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantily = quantily;
        this.color = color;
        this.idCategory = idCategory;
    }

    public Product(int idProduct, String nameProduct, double price, int quantily, String color, int idCategory) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantily = quantily;
        this.color = color;
        this.idCategory = idCategory;
    }



    public Product(int idProduct, String nameProduct, double price, int quantily, String color, int idCategory, String nameCategory) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantily = quantily;
        this.color = color;
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
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

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
