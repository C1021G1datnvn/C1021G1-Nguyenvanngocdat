package ss3_array_and_method_java.bai_tap;

import java.util.Scanner;

public class TinhTongDuongCheoCuaMangHaiChieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input row: ");
        int row = scanner.nextInt();
        System.out.println("Input col: ");
        int col = scanner.nextInt();
        int array[][] = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.println("Input element [" + i + "," + j + "]");
                array[i][j] = scanner.nextInt();
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    sum += array[i][j];
                }
            }
        }
        System.out.println("Sum diagonal line: " + sum);
    }
}
