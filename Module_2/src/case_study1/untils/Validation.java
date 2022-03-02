package case_study1.untils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    static Scanner input = new Scanner(System.in);

//person

    public static String checkServiceName() {

        String serviceName = input.nextLine();
        while (!Pattern.matches("[a-z]*", serviceName)) {
            System.out.print("Sai định dạng, vui lòng nhập lại! ");
            serviceName = input.nextLine();
        }
        return serviceName;
    }


    public static String checkGender() {
        while (true) {
            String gender = input.nextLine();
            if (gender.equalsIgnoreCase("male")
                    || gender.equalsIgnoreCase("female")){
                return gender;
            }else {
                System.out.print("Sai định dạng, vui lòng nhập lại! ");
            }
        }
    }

    public static String checkPhoneNumber() {
        String phone = input.nextLine();
        while (!Pattern.matches("^[0]+[0-9]{9}$", phone)) {
            System.out.println("Số điện thoại phải là 10 số!");
            phone = input.nextLine();
        }
        return phone;
    }
    public static String checkNumberCccd() {
        String cccd = input.nextLine();
        while (!Pattern.matches("^[0-9]{12}$", cccd)) {
            System.out.println("Số căn cước công dân là 12 số!");
            cccd = input.nextLine();
        }
        return cccd;
    }

    public static String checkEmail() {
        String email = input.nextLine();
        while (!Pattern.matches("^\\w+\\d+@\\w+(\\.\\w+){1,2}$", email)) {
            System.out.print("Sai định dạng, vui lòng nhập lại! ");
            email = input.nextLine();
        }
        return email;
    }
    public static int checkIdPerson() {
        int idPerson;
        do {
            idPerson = Integer.parseInt(input.nextLine());
        }while (idPerson > 10000);
        return idPerson;
    }
    public static int age() {
        int age;
        do {
            age = Integer.parseInt(input.nextLine());
        }while (age > 100);
        return age;
    }
    //employee
    public static Double salary() {
        Double salary;
        do {
            salary = Double.valueOf(input.nextLine());
        }while (salary < 0);
        return salary;
    }

    public static String dateOfBirth() {
        String dateBirth = input.nextLine();
        while (!Pattern.matches("[0-9]{1,2}/[0-9]{1,2}/(19|20)[0-9]{2}", dateBirth)) {
            System.out.println("Nhập sai định dạng, vui lòng nhập lại");
            dateBirth = input.nextLine();
        }
        return dateBirth;
    }
    //customer Diamond, Platinium, Gold, Silver, Member
    public static String customerRank() {
        String customRank = input.nextLine();
        while (!Pattern.matches("^(D|P|G|S|M){1}\\w*$", customRank)) {
            System.out.println("Nhập sai định dạng, vui lòng nhập lại");
            customRank = input.nextLine();
        }
        return customRank;
    }


    //class Facility
    public static Double checkArea() {
        double area;
        boolean hihi = false;
        do {
            hihi = false;
            area = Double.parseDouble(input.nextLine());
            if (area > 30) {
                hihi = false;
            }else {
                hihi = true;
            }
        } while (hihi);
        return area;
    }

    public static Double checkRoomRate() {
        double roomrate;
        do {
            roomrate = Double.parseDouble(input.nextLine());
        } while (roomrate < 0);
        return roomrate;
    }

    public static int checkPersonNumber() {
        int personNumber;
        do {
            personNumber = Integer.parseInt(input.nextLine());
        } while (personNumber < 0 || personNumber > 20);
        return personNumber;
    }

    public static int checkFloorNumber() {
        while (true) {
            int floorNumber = Byte.parseByte(input.nextLine());
            if (floorNumber > 0) {
                return floorNumber;
            }else{
                System.out.print("Enter again: ");
            }
        }
    }

    //class Booking
    public static String checkId() {
        String id = input.nextLine();
        while (!Pattern.matches("^SV(VL|HO|RO)-[0-9]{4}", id)) {
            System.out.print("Sai định dạng, vui lòng nhập lại! ");
            id = input.nextLine();
        }
        return id;
    }

}
