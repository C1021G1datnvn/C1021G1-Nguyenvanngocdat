package ss3_array_and_method_java.bai_tap;

import java.util.Scanner;

public class SoLanXuatHienCuaKyTu {
    static int count = 0;
    static String str;
    static char character;
    static Scanner inp = new Scanner(System.in);

    public static int SoKiTu() {
        char[] string = str.toCharArray();
        for (int i = 0; i < string.length; i++) {
            if (character == string[i]) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.print("Nhập vào chuỗi để kiểm tra: ");
        str = inp.nextLine();
        System.out.print("Chuỗi nhập vào là: " + "'" + str + "'");

        System.out.println("");

        System.out.print("Nhập vào kí tự cần kiểm tra: ");
        character = inp.next().charAt(0);
        int countChar = SoKiTu();
        System.out.print("Số kí tự xuất hiện là: " + countChar);
    }
}
