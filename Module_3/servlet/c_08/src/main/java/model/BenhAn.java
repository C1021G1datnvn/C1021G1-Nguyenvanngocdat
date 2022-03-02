package model;

public class BenhAn {
    private String maBenhAn;
    private String ngayNhapVien;
    private String ngayRaVien;

    public BenhAn() {

    }

    public BenhAn(String maBenhAn, String ngayNhapVien, String ngayRaVien) {
        this.maBenhAn = maBenhAn;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }
}
