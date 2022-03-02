package ss2_loop_java.bai_tap;


import java.util.Scanner;

public class InRa20SNTDauTien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input PrimeNumber: ");
        int number = scanner.nextInt();
        int count = 0;
        int n = 2;
        while (count < number) {
            if (isPrimeNumber(n)) {
                System.out.println(n + " ");
                count++;
            }
            n++;
        }
    }
    public static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
