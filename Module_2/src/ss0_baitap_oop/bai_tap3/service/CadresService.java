package ss0_baitap_oop.bai_tap3.service;

import ss0_baitap_oop.bai_tap3.model.Cadres;

public class CadresService extends Cadres {
    public static void main(String[] args) {
        Cadres cadres = new Cadres();
        cadres = new Cadres("01", "Hồ Văn Khuyến", "Đà Nẵng", "1999", "Công nghệ thông tin", "12/12", 15000000, 2500000);
        System.out.println(cadres);
        System.out.println("Lương thực nhận là: " + cadres.getActuallyReceived());
    }
}
