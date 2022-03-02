package thi_c09.model;

public class GenuinePhone extends TypePhone{
    private String warrantyPeriod; // time bảo hành
    private String warrantyCoverage; // phạm vi bảo hành

    public GenuinePhone() {
    }

    public GenuinePhone(String warrantyPeriod, String warrantyCoverage) {
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyCoverage = warrantyCoverage;
    }

    public GenuinePhone(String phoneName, Double price, int quantily, String producter, String warrantyPeriod, String warrantyCoverage) {
        super(phoneName, price, quantily, producter);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyCoverage = warrantyCoverage;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public void setWarrantyCoverage(String warrantyCoverage) {
        this.warrantyCoverage = warrantyCoverage;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public String getWarrantyCoverage() {
        return warrantyCoverage;
    }

    @Override
    public String toString() {
        return "GenuinePhone{" +
                super.toString() +
                "warrantyPeriod='" + warrantyPeriod + '\'' +
                ", warrantyCoverage='" + warrantyCoverage + '\'' +
                '}';
    }
}
