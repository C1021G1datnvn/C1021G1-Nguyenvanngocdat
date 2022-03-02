package thi_thu_c10.validate;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {
    static Scanner scanner = new Scanner(System.in);
    public static String checkIdStudent() {
        String checkID = scanner.nextLine();
        while (!Pattern.matches("[S][V]-[0-9]{4}",checkID)) {
            System.out.println("Sai đinh dạng, vui lòng nhập lại!");
            checkID = scanner.nextLine();
        }
        return checkID;
    }
    public static String checkIdLecturer() {
        String checkID = scanner.nextLine();
        while (!Pattern.matches("[G][V]-[0-9]{4}",checkID)) {
            System.out.println("Sai đinh dạng, vui lòng nhập lại!");
            checkID = scanner.nextLine();
        }
        return checkID;
    }
    public static String checkGender() {
        while (true) {
            String gender = scanner.nextLine();
            if (gender.equals("Nam") || gender.equals("Nữ") || gender.equals("Khác")) {
                return gender;
            }else {
                System.out.println("Sai định dạng, vui lòng nhập lại!");
            }
        }
    }
    public static String checkDateOfBirth() {
        String checkDateOfBirth = scanner.nextLine();
        while (!Pattern.matches("[0-9]{1,2}/[0-9]{1,2}/(19|20)[0-9]{2}", checkDateOfBirth)) {
            System.out.println("Sai định dạng, vui lòng nhập lại!");
            checkDateOfBirth = scanner.nextLine();
        }
        return checkDateOfBirth;
    }

}
