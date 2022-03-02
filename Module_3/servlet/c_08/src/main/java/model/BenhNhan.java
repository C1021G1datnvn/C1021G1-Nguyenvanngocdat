package model;

public class BenhNhan {
    private String maBenhNhan;
    private String tenBenhNhan;
    private String liDoNhapvien;
    private String maBenhAn;

    public BenhNhan() {
    }

    public BenhNhan(String maBenhNhan, String tenBenhNhan, String liDoNhapvien, String maBenhAn) {
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.liDoNhapvien = liDoNhapvien;
        this.maBenhAn = maBenhAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getLiDoNhapvien() {
        return liDoNhapvien;
    }

    public void setLiDoNhapvien(String liDoNhapvien) {
        this.liDoNhapvien = liDoNhapvien;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }
}
