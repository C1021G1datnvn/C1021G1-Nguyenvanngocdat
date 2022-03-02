package ss0_baitap_oop.bai_tap2.controller;

import ss0_baitap_oop.bai_tap2.service.IStudentService;
import ss0_baitap_oop.bai_tap2.service.StudentServive;

import java.util.Arrays;
import java.util.Scanner;

public class StudentController {
    public static void main(String[] args) {
        IStudentService iStudentService = new StudentServive();
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        do {
            System.out.println("1: Add Student");
            System.out.println("2: Remove Student follow mssv. ");
            System.out.println("3: Remove Student follow index. ");
            System.out.println("4: Search Student. ");
            System.out.println("5: List Student. ");
            System.out.println("6: Sort Student List. ");
            System.out.println("0: Exit");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    iStudentService.add();
                    break;
                case 2:
                    System.out.println("Enter:");
                    int mssv = Integer.parseInt(scanner.nextLine());
                    iStudentService.remove(mssv);
                    break;
                case 3:
                    System.out.println("Enter index");
                    int index = Integer.parseInt(scanner.nextLine());
                    iStudentService.removeIndex(index);
                    break;
                case 4:
                    System.out.println("Enter search");
                    String searchId = scanner.nextLine();
                    iStudentService.search(searchId);
                    break;
                case 5:
                    iStudentService.showAll();
                    break;
                case 6:
                    iStudentService.sort();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Sin lũiiiiiiii....");
            }
        } while (select != 0);

    }
}
