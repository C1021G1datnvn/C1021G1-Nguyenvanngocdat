package ss3_array_and_method_java.thuc_hanh;

import java.util.Scanner;

public class TimGiaTriLonNhatTrongMang {
    public static void main(String[] args) {
        int size;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a size:");
        size = scanner.nextInt();
        if (size > 20) {
            System.out.println("Size should not exceed 20");
        } else {
            int array[] = new int[size];
            for (int i = 0; i < array.length; i++) {
                System.out.println("Enter element " + i);
                array[i] = scanner.nextInt();
            }
            System.out.println("Elements in array: ");
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[j]);
            }
            int max = array[0];
            int index = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                    index = index + i;
                }
            }
            System.out.println("The largest property value in the list is " + max + " ,at position " + index);
        }
    }
}
