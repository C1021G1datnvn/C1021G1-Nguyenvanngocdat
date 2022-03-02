package ss3_array_and_method_java.bai_tap;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length array: ");
        int length = scanner.nextInt();
        int array[] = new int[length];
        for(int i = 0 ; i < array.length; i++) {
            System.out.println("Input element: " + i);
            array[i] = scanner.nextInt();
//            System.out.println("Array have element is: " + array[i]);
        }
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("Min number is: " + min);
    }
}
