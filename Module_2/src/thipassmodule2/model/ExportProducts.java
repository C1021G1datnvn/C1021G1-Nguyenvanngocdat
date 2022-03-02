package thipassmodule2.model;

public class ExportProducts extends ProductModle{
    private Double exportPrice; //giá xuất khẩu
    private String nationalProduction; //quốc gia sản xuất

    public ExportProducts() {
    }

    public ExportProducts(Double exportPrice, String nationalProduction) {
        this.exportPrice = exportPrice;
        this.nationalProduction = nationalProduction;
    }

    public ExportProducts(String idProduct, String nameProduct, Double price, int quantily, String producer, Double exportPrice, String nationalProduction) {
        super(idProduct, nameProduct, price, quantily, producer);
        this.exportPrice = exportPrice;
        this.nationalProduction = nationalProduction;
    }

    public Double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(Double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getNationalProduction() {
        return nationalProduction;
    }

    public void setNationalProduction(String nationalProduction) {
        this.nationalProduction = nationalProduction;
    }

    @Override
    public String toString() {
        return "ExportProducts{" +
                super.toString() +
                "exportPrice=" + exportPrice +
                ", nationalProduction='" + nationalProduction + '\'' +
                '}';
    }
}
