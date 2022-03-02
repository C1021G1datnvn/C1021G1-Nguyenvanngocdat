package thi_thu_c10.controller;

import thi_thu_c10.service.LecturersService;
import thi_thu_c10.service.StudentService;

import java.util.Scanner;

public abstract class ManageController {
    static Scanner scanner = new Scanner(System.in);
    static boolean check = false;
    static StudentService serviceStu = new StudentService();
    static LecturersService lecturersService = new LecturersService();

    public static void main(String[] args) {
        menuManage();
    }

    public static void menuManage() {
        int select = 0;
        do {
            System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ---");
            System.out.println("1. Thêm mới giảng viên hoặc sinh viên!");
            System.out.println("2. Xoá giảng viên hoặc sinh viên!");
            System.out.println("3. Xem danh sách giảng viên hoặc sinh viên!");
            System.out.println("4. Tìm kiếm giảng viên hoặc sinh viên!");
            System.out.println("5. Thoát khỏi chương trình!");
            System.out.println("---Chọn chức năng tương ứng---");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    searchPer();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Mời bạn nhập lại nhé!");
            }
        } while (check);
    }

    public static void add() {
        int select = 0;
        do {
            System.out.println("1. Thêm mới sinh viên!");
            System.out.println("2. Thêm mới giảng viên!");
            System.out.println("3. Quay về Menu chính!");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    serviceStu.addNew();
                    break;
                case 2:
                    lecturersService.addNew();
                    break;
                case 3:
                    menuManage();
            }
        } while (true);
    }

    public static void delete() {
        int select = 0;
        do {
            System.out.println("1. Xoá sinh viên!");
            System.out.println("2. Xoá giảng viên!");
            System.out.println("3. Quay về Menu chính!");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    serviceStu.remove();
                    break;
                case 2:
                    lecturersService.remove();
                    break;
                case 3:
                    menuManage();
            }
        } while (true);
    }


    public static void display() {
        int select = 0;
        do {
            System.out.println("1. Xem danh sách sinh viên!");
            System.out.println("2. Xem danh sách giảng viên!");
            System.out.println("3. Quay về Menu chính!");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    serviceStu.display();
                    break;
                case 2:
                    lecturersService.display();
                    break;
                case 3:
                    menuManage();
            }
        } while (true);
    }

    public static void searchPer() {
        int select = 0;
        do {
            System.out.println("1. Tìm kiếm sinh viên!");
            System.out.println("2. Tìm kiếm giảng viên!");
            System.out.println("3. Quay về Menu chính!");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    serviceStu.search();
                    break;
                case 2:
                    lecturersService.search();
                    break;
                case 3:
                    menuManage();
            }
        } while (true);
    }
}
