package thi_c09.model;

public class CellPhone extends TypePhone {
    private String national; // quốc gia xách tay
    private String status; // trạng thái

    public CellPhone() {
    }

    public CellPhone(String national, String statuc) {
        this.national = national;
        this.status = statuc;
    }

    public CellPhone(String phoneName, Double price, int quantily, String producter, String national, String statuc) {
        super(phoneName, price, quantily, producter);
        this.national = national;
        this.status = statuc;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CellPhone{" +
                super.toString() +
                "national='" + national + '\'' +
                ", statuc='" + status + '\'' +
                '}';
    }
}
