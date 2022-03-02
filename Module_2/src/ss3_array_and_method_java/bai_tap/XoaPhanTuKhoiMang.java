package ss3_array_and_method_java.bai_tap;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[] = {10, 4, 6, 7, 8, 6, 0, 0};
        System.out.println(" Input number to delete:");
        int number = scanner.nextInt();
        System.out.println(" array new: ");
        for (int i = 0; i < arr.length; i++) {
            if (number == arr[i]) {
                for (int j = i + 1; j < arr.length; j++) {
                    arr[j - 1] = arr[j];
                }
            }
            System.out.println(arr[i]);
        }
    }
}
