package ss1_introduction_java.bai_tap;

import java.util.Scanner;

public class UngDungChuyeDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount of money: ");
        float usd = scanner.nextFloat();
        float vnd = usd / 23;
        System.out.println("the amount to be exchanged is: " + vnd);
    }
}
