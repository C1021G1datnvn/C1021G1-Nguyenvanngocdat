package thi_c09.model;

public abstract class TypePhone {
    private int id;
    private int idAuto = 0;
    private String phoneName;
    private Double price;
    private int quantily;
    private String producter;


    public TypePhone() {
    }

    public TypePhone(String phoneName, Double price, int quantily, String producter) {
        idAuto++;
        this.id = idAuto;
        this.phoneName = phoneName;
        this.price = price;
        this.quantily = quantily;
        this.producter = producter;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
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

    public String getProducter() {
        return producter;
    }

    public void setProducter(String producter) {
        this.producter = producter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TypePhone{" +
                "id=" + id +
                ", phoneName='" + phoneName + '\'' +
                ", price=" + price +
                ", quantily=" + quantily +
                ", producter='" + producter + '\'' +
                '}';
    }
}
