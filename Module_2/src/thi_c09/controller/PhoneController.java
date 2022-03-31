package thi_c09.controller;

import thi_c09.model.GenuinePhone;
import thi_c09.sercive.GPhoneService;
import thi_c09.sercive.XPhoneService;

import java.util.Scanner;

public class PhoneController {
    static GPhoneService gPhoneService = new GPhoneService();
    static XPhoneService xPhoneService = new XPhoneService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        phoneManager();
    }

    public static void phoneManager() {
        boolean check = false;
        int number;
        do {
            System.out.println("--------CHƯƠNG TRÌNH QUẢN LÍ ĐIỆN THOẠI---------");
            System.out.println("Chọn chức năng theo số để tiếp tục!");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xoá");
            System.out.println("3. Xem danh sách điện thoại");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");
            System.out.println("Chọn chức năng: ");
            number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    selectPhone();
                    break;
                case 2:
                    removePhone();
                    break;
                case 3:
                    displayPhone();
                    break;
                case 4:
                    searchPhone();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Thoát ngay!");

            }
        }while (check);
    }



    public static void selectPhone() {
        int select;
        do {
            System.out.println("1. Điện thoại chính hãng!");
            System.out.println("2. Điện thoại xách tay!");
            System.out.println("0. Quay lại manu chính");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    gPhoneService.addPhone();
                    break;
                case 2:
                    xPhoneService.addPhone();
                    break;
                case 0:
                    phoneManager();
            }
        }while (true);
    }

    public static void displayPhone() {
        int select;
        do {
            System.out.println("1. Điện thoại chính hãng!");
            System.out.println("2. Điện thoại xách tay!");
            System.out.println("0. Quay lại manu chính");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    gPhoneService.displayPhone();
                    break;
                case 2:
                    xPhoneService.displayPhone();
                    break;
                case 0:
                    phoneManager();
            }
        }while (true);
    }

    public static void removePhone() {
        int select;
        do {
            System.out.println("1. Điện thoại chính hãng!");
            System.out.println("2. Điện thoại xách tay!");
            System.out.println("0. Quay lại manu chính");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    gPhoneService.removePhone();
                    break;
                case 2:
                    xPhoneService.removePhone();
                    break;
                case 0:
                    phoneManager();
            }
        }while (true);
    }

    public static void searchPhone() {
        int select;
        do {
            System.out.println("1. Điện thoại chính hãng!");
            System.out.println("2. Điện thoại xách tay!");
            System.out.println("0. Quay lại manu chính");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    gPhoneService.searchPhone();
                    break;
                case 2:
                    xPhoneService.searchPhone();
                    break;
                case 0:
                    phoneManager();
            }
        }while (true);
    }
}
