package ss4_class_and_object_java.thuc_hanh;

import java.util.Scanner;

public class main_hcn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the width:");
        double width = scanner.nextDouble();
        System.out.print("Enter the height:");
        double height = scanner.nextDouble();
        LopHinhChuNhat lopHinhChuNhat = new LopHinhChuNhat(width, height);
        System.out.println("Your Rectangle \n"+ lopHinhChuNhat.display());
        System.out.println("Perimeter of the Rectangle: "+ lopHinhChuNhat.getPerimeter());
        System.out.println("Area of the Rectangle: "+ lopHinhChuNhat.getArea());
    }
}
