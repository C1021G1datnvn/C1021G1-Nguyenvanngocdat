package ss2_loop_java.bai_tap;


import java.util.Scanner;

public class VeHinh {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1.Print the rectangle");
            System.out.println("2.Print the square triangle (The corner is square at bottom-left, bottom-right, top-left, top-right)");
            System.out.println("3.Print isosceles triangle");
            System.out.println("0.Exit");
            System.out.println("Enter your choice:");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    int x = 3, y = 7;
                    System.out.println("Print the rectangle");
                    for (int i = 1; i <= x; i++) {
                        for (int j = 1; j <= y; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    int z = 5;
                    System.out.println("Print the square triangle (The corner is square at bottom-left)");
                    for (int i = 1; i <= z; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    int a = 5;
                    System.out.println("Print the square triangle (The corner is square at top-left)");
                    for (int i = a; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Print isosceles triangle");
                    for (int row = 0; row <= 7; row++) {
                        for (int col = 7; col > row; col--) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= row * 2 -1; k++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    System.out.println("0.Exit");
                    break;
                default:
                    System.out.println("No choice.");
            }

        }
    }
}