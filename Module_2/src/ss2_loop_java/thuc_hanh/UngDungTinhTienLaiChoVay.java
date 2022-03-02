package ss2_loop_java.thuc_hanh;

import java.util.Scanner;

public class UngDungTinhTienLaiChoVay {
    public static void main(String[] args) {
        double money;
        int month;
        double interestRate;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Money: ");
        money = scanner.nextDouble();
        System.out.println("Input Month: ");
        month = scanner.nextInt();
        System.out.println("Input Interestrate : ");
        interestRate = scanner.nextDouble();
        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += money * ((interestRate/100)/12) * interestRate;
        }
        System.out.println("Bank interest: " + totalInterest);
    }
}
