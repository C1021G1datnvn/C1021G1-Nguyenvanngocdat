package ss3_array_and_method_java.bai_tap;


import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int size;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        size = input.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter the element " + (i + 1) + ":");
            array[i] = input.nextInt();
        }
        System.out.println("Enter the number you want to add ");
        int x = input.nextInt();
        System.out.println("Enter the index of number you want to add ");
        int index = input.nextInt();
        if (index <= -1 || index >= array.length - 1) {
            System.out.println("Can't add the number to the array");
        } else {
            int[] array1 = new int[array.length+1];
            array1[index] = x;
            for(int i = 0; i < index; i++){
                array1[i] = array[i];
            }
            for(int i = index; i < array.length; i++){
                array1[i + 1] = array[i];
            }
            for(int i = 0; i < array1.length; i++){
                System.out.println(array1[i] + " ");
            }
        }
    }
}