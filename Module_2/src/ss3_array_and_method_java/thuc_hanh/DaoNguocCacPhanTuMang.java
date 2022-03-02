package ss3_array_and_method_java.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class DaoNguocCacPhanTuMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The number of elements in the array: ");
        int size = scanner.nextInt();
        if (size > 20) {
            System.out.println("Size does not exceed 20");
        }else {
            int[] array = new int [size];
            for (int i = 0; i < array.length; i++) {
                System.out.println("Enter element" + i);
                array[i] = scanner.nextInt();
            }
            System.out.println("Elements in array: ");
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[j]);
            }
            for (int j = 0; j < array.length / 2; j++) {
                int temp = array[j];
                array[j] = array[size - 1 - j];
                array[size - 1 - j] = temp;
            }
            System.out.printf("Reverse array: ");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + "\t");
            }
        }
    }
}
