package ss0_baitap_oop.bai_tap2.service;

import ss0_baitap_oop.bai_tap2.model.Student;

import java.util.Arrays;
import java.util.Scanner;

public class StudentServive implements IStudentService {
    private static int count = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static Student[] studentList = new Student[10];

    @Override
    public void add() {
        if (count < studentList.length) {
            System.out.print("Input Pass: ");
            int mssV = Integer.parseInt(scanner.nextLine());
            System.out.print("Input name: ");
            String fullName = scanner.nextLine();
            System.out.print("Input Date of Birth: ");
            String dateOffBirth = scanner.nextLine();
            System.out.print("Input Gender: ");
            String gender = scanner.nextLine();
            System.out.print("Input Class name: ");
            String className = scanner.nextLine();
            System.out.print("Input Couser: ");
            String couser = scanner.nextLine();
            studentList[count] = new Student(mssV, fullName, dateOffBirth, gender, className, couser);
            count++;
        }
    }

    @Override
    public void remove(int mssV) {
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null) {
                continue;
            } else if (studentList[i].getMssV() == mssV) {
                studentList[i] = null;
                for (int j = i; j < studentList.length - 1; j++) {
                    studentList[j] = studentList[j + 1];
                }
                studentList[studentList.length - 1] = null;
                break;
            }
        }
    }

    @Override
    public void removeIndex(int index) {
        for (int i = 1; i < studentList.length; i++) {
            if (i == index) {
                studentList[i] = null;
                studentList[i + 1] = studentList[i];
            }
        }
    }

    @Override
    public void search(String search) {
        for (int i = 1; i < studentList.length; i++) {
            if (studentList[i] == null) {
                continue;
            } else if (check(search) == true) {
                if (studentList[i].getName().contains(search)) {
                    System.out.println(studentList[i]);
                }
            } else {
                if (studentList[i].getMssV() == Integer.parseInt(search)) {
                    System.out.println(studentList[i]);
                }
            }
        }
    }
    public boolean check(String search) {
        for (int i = 0; i < search.length(); i++) {
            if (Character.isLetter(search.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void showAll() {
        for (Student student : studentList) {
            if (student == null ) {
                continue;
            }
            System.out.println(student);
        }
    }
    @Override
    public void sort() {
        Student[] newStudents = new Student [count];
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null) {
                break;
            }
            newStudents[i] = studentList[i];
        }
        Arrays.sort (newStudents);
        for (int i = 0; i < newStudents.length; i++) {
            System.out.println(newStudents[i]);
        }
    }
}