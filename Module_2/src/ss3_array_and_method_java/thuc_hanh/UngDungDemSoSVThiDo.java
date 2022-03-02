package ss3_array_and_method_java.thuc_hanh;

import java.util.Scanner;

public class UngDungDemSoSVThiDo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input quality Student: ");
        int quality = scanner.nextInt();
        int count = 0;
        int array[] = new int[quality];
        if (quality > 30) {
            System.out.println("Quantity exceeds the allowable limit.");
        } else {
            for (int i = 0; i < array.length; i++) {
                System.out.println("Enter a mark for student: " + (i + 1));
                array[i] = scanner.nextInt();
            }
            System.out.println("List of mark: ");
            for (int j = 0; j < array.length; j++) {
                if (array[j] >= 5 && array[j] <= 10){
                    count++;
                }
            }
            System.out.println("number of Student pass module: " + count);
        }
    }
}
