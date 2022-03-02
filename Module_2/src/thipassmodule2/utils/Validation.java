package thipassmodule2.utils;


import java.util.Scanner;

public class Validation {
    static Scanner scanner = new Scanner(System.in);
    public static Double checkMoney() {
        Double checkMoney;
        do {
            checkMoney = Double.parseDouble(scanner.nextLine());
            if (checkMoney < 0) {
                System.out.println("Nhập lại: ");
            }else if (checkMoney == 0) {
                System.out.println("Tặng free luôn!!!");
            }
        }while (checkMoney < 0);
        return checkMoney;
    }

    public static int checkQuality() {
        int checkQuality;
        do {
            checkQuality = Integer.parseInt(scanner.nextLine());
            if (checkQuality < 0) {
                System.out.println("Số lượng phải là số dương, Nhập lại!!!");
            }else if (checkQuality == 0) {
                System.out.println("Xem thôi chứ không mua!");
            }
        }while (checkQuality < 0);
        return checkQuality;
    }

}
