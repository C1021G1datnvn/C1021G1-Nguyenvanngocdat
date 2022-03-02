package thipassmodule2.model;

public abstract class ProductModle {
    private int id;
    private int idAuto;
    private String idProduct;
    private String nameProduct;
    private Double price;
    private int quantily;
    private String producer;

    public ProductModle() {
    }

    public ProductModle(String idProduct, String nameProduct, Double price, int quantily, String producer) {
        idAuto++;
        this.id = idAuto;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantily = quantily;
        this.producer = producer;
    }


    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
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

    public int getQuantily() {
        return quantily;
    }

    public void setQuantily(int quantily) {
        this.quantily = quantily;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "ProductModle{" +
                "id=" + id +
                ", idAuto=" + idAuto +
                ", idProduct='" + idProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", quantily=" + quantily +
                ", producer='" + producer + '\'' +
                '}';
    }
}
