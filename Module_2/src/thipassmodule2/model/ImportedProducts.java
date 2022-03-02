package thipassmodule2.model;

public class ImportedProducts extends ProductModle{
    private Double importedPrice; //Giá nhập khẩu
    private String province; //tỉnh thành
    private Double importedTax; //thuế

    public ImportedProducts() {
    }

    public ImportedProducts(Double importedPrice, String province, Double importedTax) {
        this.importedPrice = importedPrice;
        this.province = province;
        this.importedTax = importedTax;
    }

    public ImportedProducts(String idProduct, String nameProduct, Double price, int quantily, String producer, Double importedPrice, String province, Double importedTax) {
        super(idProduct, nameProduct, price, quantily, producer);
        this.importedPrice = importedPrice;
        this.province = province;
        this.importedTax = importedTax;
    }

    public Double getImportedPrice() {
        return importedPrice;
    }

    public void setImportedPrice(Double importedPrice) {
        this.importedPrice = importedPrice;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Double getImportedTax() {
        return importedTax;
    }

    public void setImportedTax(Double importedTax) {
        this.importedTax = importedTax;
    }

    @Override
    public String toString() {
        return "ImportedProducts{" +
                super.toString() +
                "importedPrice=" + importedPrice +
                ", province='" + province + '\'' +
                ", importedTax=" + importedTax +
                '}';
    }
}
