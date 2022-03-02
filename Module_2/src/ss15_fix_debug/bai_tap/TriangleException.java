package ss15_fix_debug.bai_tap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleException {
    public static void main(String[] args) throws Exception {
        triangle();
    }
    public static void triangle() throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập giá trị cạnh thứ nhất của tam giác: ");
            int a = scanner.nextInt();
            if (a < 0) {
                throw new IllegalTriangleException();
            }
            System.out.println("Nhập giá trị cạnh thứ hai của tam giác: ");
            int b = scanner.nextInt();
            if (b < 0) {
                throw new IllegalTriangleException();
            }
            System.out.println("Nhập giá trị cạnh thứ ba của tam giác: ");
            int c = scanner.nextInt();

            if (c < 0) {
                throw new IllegalTriangleException();
            }
            if (a + b <= c || b + c <= a || a + c <= b) {
                throw new IllegalTriangleException_2();
            }

        }catch (InputMismatchException e) {
            System.out.println("Vui lòng nhập số!");
        }catch (IllegalTriangleException_2 e1) {
            e1.check();
        }catch (IllegalTriangleException e2){
            e2.negative();
        } finally {
            System.exit(0);
        }
    }
}
