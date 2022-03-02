package ss1_introduction_java.bai_tap;

import java.util.Scanner;

public class UngDungChuyenDoiSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = scanner.nextInt();
        int ones = number % 10;
        int tens = (number / 10) % 10;
        int hundreds = (number / 100) % 10;
        if (number >= 0 && number < 10) {
            switch (number){
                case 0:
                    System.out.println("Zero.");
                    break;
                case 1:
                    System.out.println("One.");
                    break;
                case 2:
                    System.out.println("Two.");
                    break;
                case 3:
                    System.out.println("Three.");
                    break;
                case 4:
                    System.out.println("Four.");
                    break;
                case 5:
                    System.out.println("Five.");
                    break;
                case 6:
                    System.out.println("Six.");
                    break;
                case 7:
                    System.out.println("Seven.");
                    break;
                case 8:
                    System.out.println("Eight.");
                    break;
                case 9:
                    System.out.println("Nine.");
                    break;
            }
        }else if (number < 20) {
            switch (number) {
                case 10:
                    System.out.println("Ten.");
                    break;
                case 11:
                    System.out.println("Eleven.");
                    break;
                case 12:
                    System.out.println("Twelve.");
                    break;
                case 13:
                    System.out.println("Thirteen.");
                    break;
                case 14:
                    System.out.println("Fourteen.");
                    break;
                case 15:
                    System.out.println("Fiveteen.");
                    break;
                case 16:
                    System.out.println("Sixteen.");
                    break;
                case 17:
                    System.out.println("Seventeen.");
                    break;
                case 18:
                    System.out.println("Eightteen.");
                    break;
                case 19:
                    System.out.println("Nineteen.");
                    break;
            }
        }else if (number <= 99) {
            switch (tens) {
                case 2:
                    System.out.println("Twenty ");
                    break;
                case 3:
                    System.out.println("Thirty ");
                    break;
                case 4:
                    System.out.println("Forty ");
                    break;
                case 5:
                    System.out.println("Fivety ");
                    break;
                case 6:
                    System.out.println("Sixty ");
                    break;
                case 7:
                    System.out.println("Seventy ");
                    break;
                case 8:
                    System.out.println("Eighty ");
                    break;
                case 9:
                    System.out.println("Ninety ");
                    break;
            }
            switch (ones) {
                case 1:
                    System.out.println("One.");
                    break;
                case 2:
                    System.out.println("Two.");
                    break;
                case 3:
                    System.out.println("Three.");
                    break;
                case 4:
                    System.out.println("Four.");
                    break;
                case 5:
                    System.out.println("Five.");
                    break;
                case 6:
                    System.out.println("Six.");
                    break;
                case 7:
                    System.out.println("Seven.");
                    break;
                case 8:
                    System.out.println("Eight.");
                    break;
                case 9:
                    System.out.println("Nine.");
                    break;
            }
        }else if (number <= 999) {
            switch (hundreds) {
                case 1:
                    System.out.println("One hundred and ");
                    break;
                case 2:
                    System.out.println("Tow hundred and ");
                    break;
                case 3:
                    System.out.println("Three hundred and ");
                    break;
                case 4:
                    System.out.println("Four hundred and ");
                    break;
                case 5:
                    System.out.println("Five hundred and ");
                    break;
                case 6:
                    System.out.println("Six hundred and ");
                    break;
                case 7:
                    System.out.println("Senven hundred and ");
                    break;
                case 8:
                    System.out.println("Eight hundred and ");
                    break;
                case 9:
                    System.out.println("Nine hundred and ");
                    break;
            }
            switch (tens) {
                case 2:
                    System.out.println("Twenty ");
                    break;
                case 3:
                    System.out.println("Thirty ");
                    break;
                case 4:
                    System.out.println("Forty ");
                    break;
                case 5:
                    System.out.println("Fivety ");
                    break;
                case 6:
                    System.out.println("Sixty ");
                    break;
                case 7:
                    System.out.println("Seventy ");
                    break;
                case 8:
                    System.out.println("Eighty ");
                    break;
                case 9:
                    System.out.println("Ninety ");
                    break;
            }
            switch (ones) {
                case 1:
                    System.out.println("One.");
                    break;
                case 2:
                    System.out.println("Two.");
                    break;
                case 3:
                    System.out.println("Three.");
                    break;
                case 4:
                    System.out.println("Four.");
                    break;
                case 5:
                    System.out.println("Five.");
                    break;
                case 6:
                    System.out.println("Six.");
                    break;
                case 7:
                    System.out.println("Seven.");
                    break;
                case 8:
                    System.out.println("Eight.");
                    break;
                case 9:
                    System.out.println("Nine.");
                    break;
            }
        }
    }
}
