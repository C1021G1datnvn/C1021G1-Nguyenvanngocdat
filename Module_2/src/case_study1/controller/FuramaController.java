package case_study1.controller;


import case_study1.service.iplm_service.BookingServiceIplm;
import case_study1.service.iplm_service.CustomerServiceIplm;
import case_study1.service.iplm_service.EmployServiceIplm;
import case_study1.service.iplm_service.FuramaServiceIplm;

import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        dissplayMainMenu();
    }
    public static boolean check;

    public static void dissplayMainMenu() {
        int select;
        Scanner scanner = new Scanner(System.in);
        do {
            check = false;
            System.out.println("----------FURAMA-----------");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotio Management");
            System.out.println("6. Exit");
            System.out.println("----------THEEND-----------");
            try {
                select = scanner.nextInt();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi nhập lại !");
                check = true;
                continue;
            }
            switch (select) {
                case 1:
                    dissplayEmployeeMenu();
                    break;
                case 2:
                    dissplayCustomerMenu();
                    break;
                case 3:
                    dissplayFacilityMenu();
                    break;
                case 4:
                    dissplayBookingMenu();
                    break;
                case 5:
                    dissplayPromotionMenu();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Enter again plase !");
            }
        }while (check);
    }
    public static void dissplayEmployeeMenu() {
        EmployServiceIplm employeeServiceIplm = new EmployServiceIplm();
        Scanner scanner = new Scanner(System.in);
        int select;
        do {

            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Delete employee");
            System.out.println("5. Return main menu");
            try {
                select = scanner.nextInt();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi nhập lại !");
                check = true;
                continue;
            }
            switch (select) {
                case 1:
                    employeeServiceIplm.display();
                    dissplayEmployeeMenu();
                    break;
                case 2:
                    employeeServiceIplm.addEmployee();
                    dissplayEmployeeMenu();
                    break;
                case 3:
                    employeeServiceIplm.editEmployee();
                    dissplayEmployeeMenu();
                    break;
                case 4:
                    employeeServiceIplm.deleteEmployee();
                    dissplayEmployeeMenu();
                    break;
                case 5:
                    dissplayMainMenu();
                    break;
                default:
                    System.out.println("Thoát khỏi chương trình!");
            }
        }while (check);
    }
    public static void dissplayCustomerMenu() {
        CustomerServiceIplm customerServiceIplm = new CustomerServiceIplm();
        Scanner scanner = new Scanner(System.in);
        int select;
        do {
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customers");
            System.out.println("3. Edit customers");
            System.out.println("4. Delete customer");
            System.out.println("5. Return main menu");
            try {
                select = scanner.nextInt();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi nhập lại!");
                check = true;
                continue;
            }
            switch (select) {
                case 1:
                    customerServiceIplm.display();
                    dissplayCustomerMenu();
                    break;
                case 2:
                    customerServiceIplm.addCustomer();
                    dissplayCustomerMenu();
                    break;
                case 3:
                    customerServiceIplm.editCustomer();
                    dissplayCustomerMenu();
                    break;
                case 4:
                    customerServiceIplm.deleteCustomer();
                    dissplayCustomerMenu();
                    break;
                case 5:
                    dissplayMainMenu();
                    break;
                default:
                    System.out.println("Thoát khỏi chương trình!");
            }
        }while (check);
    }
    public static void dissplayFacilityMenu() {
        FuramaServiceIplm facilityService = new FuramaServiceIplm();
        Scanner scanner = new Scanner(System.in);
        int select;
        do {
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            try {
                select = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi nhập lại!");
                check = true;
                continue;
            }
            switch (select) {
                case 1:
                    dissPlayFacility();
                    break;
                case 2:
                    addFacilityNew();
                    break;
                case 3:
                    facilityService.maintenance();
                    break;
                case 4:
                    dissplayMainMenu();
                    break;
            }
        }while (check);
    }
    public static void dissplayBookingMenu() {
        Scanner scanner = new Scanner(System.in);
        BookingServiceIplm bookingServiceIplm = new BookingServiceIplm();
        int select;
        do {
            System.out.println("1. Display list booking");
            System.out.println("2. Add new booking");
            System.out.println("3. Create new constracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            try {
                select = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi nhập lại!");
                check = true;
                continue;
            }
            switch (select) {
                case 1:
                    bookingServiceIplm.display();
                    dissplayBookingMenu();
                    break;
                case 2:
                    bookingServiceIplm.addBooking();
                    dissplayBookingMenu();
                    break;
                case 3:

                    break;
            }
        }while (check);
    }
    public static void dissplayPromotionMenu() {
        Scanner scanner = new Scanner(System.in);
        int select;
        do {
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            try {
                select = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi nhập lại!");
                check = true;
                continue;
            }
            switch (select) {
//viết case
            }
        }while (check);
    }
    public static void addFacilityNew() {
        FuramaServiceIplm facilityService = new FuramaServiceIplm();
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Display Facility.");
            System.out.println("2. Add new Villa.");
            System.out.println("3. Add new House.");
            System.out.println("4. Add new Room.");
            System.out.println("5. Return main menu");
            try {
                option = scanner.nextInt();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi nhập lại!");
                check = true;
                continue;
            }
            switch (option) {
                case 1:
                    dissPlayFacility();
                    dissplayFacilityMenu();
                    break;
                case 2:
                    facilityService.addNewVilla();
                    addFacilityNew();
                    break;
                case 3:
                    facilityService.addNewHouse();
                    addFacilityNew();
                    break;
                case 4:
                    facilityService.addNewRoom();
                    addFacilityNew();
                    break;
                case 5:
                    dissplayFacilityMenu();
                    break;
                default:
                    System.out.println("Thêm mới không thành công!");
            }
        }while (check);
    }
    public static void dissPlayFacility() {
        int number;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Display Villa.");
            System.out.println("2. Display House.");
            System.out.println("3. Display Room.");
            System.out.println("4. Return main menu");
            number = Integer.parseInt(scanner.nextLine());
            switch (number) {
                case 1:
                    FuramaServiceIplm.dissPlayVilla();
                    dissPlayFacility();
                    break;
                case 2:
                    FuramaServiceIplm.dissPlayHouse();
                    dissPlayFacility();
                    break;
                case 3:
                    FuramaServiceIplm.dissPlayRoom();
                    dissPlayFacility();
                    break;
                case 4:
                    dissplayFacilityMenu();
                    break;
                default:
                    System.out.println("Vui lòng nhập lại!");
            }
        }while (check);

    }
}