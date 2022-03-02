package thi_thu_c10.service;

import thi_thu_c10.exception.MyException;
import thi_thu_c10.model.Student;
import thi_thu_c10.validate.Validation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IPerson{
    public static final String STUDENT = "D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\thi_thu_c10\\data\\student.csv";
    public static List<Student> studentList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public StudentService() {
        studentList = readStudent();
    }

    public void writeStudent() {
        try {
            FileWriter fileWriterStudent = new FileWriter(STUDENT);
            BufferedWriter bufferedWriterStudent = new BufferedWriter(fileWriterStudent);
            for (Student student : studentList) {
                bufferedWriterStudent.write(student.getId() + "," + student.getName() + "," + student.getDateOfBirth() + "," +
                        student.getGender() + "," + student.getClassPerson() + "," + student.getScore());
                bufferedWriterStudent.newLine();
            }
            bufferedWriterStudent.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readStudent() {
        List<Student> studentList1 = new ArrayList<>();
        try {
            FileReader fileReaderStudent = new FileReader(STUDENT);
            BufferedReader bufferedReaderStudent = new BufferedReader(fileReaderStudent);
            String line;
            String[] temp;
            Student student;
            while ((line = bufferedReaderStudent.readLine()) != null) {
                temp = line.split(",");
                student = new Student(temp[0], temp[1], temp[2], temp[3], temp[4], Double.parseDouble(temp[5]));
                studentList1.add(student);
            }
            bufferedReaderStudent.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList1;
    }

    @Override
    public void addNew() {
        boolean check = false;
        String id = null;
        String name = null;
        String dateOfBirth = null;
        String gender = null;
        String classPer = null;
        Double score = 0.0;

        do {
            try {
                System.out.println("Nhập id của sinh viên mà bạn cần thêm mới! (SV-XXXX)");
                id = Validation.checkIdStudent();
            }catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập lại!");
            }
        }while (check);

        do {
            try {
                System.out.println("Nhập tên của sinh viên đó!");
                name = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập lại!");
            }
        }while (check);

        do {
            try {
                System.out.println("Nhập ngày tháng năm sinh của sinh viên đó! (dd/MM/yy)");
                dateOfBirth = Validation.checkDateOfBirth();
            }catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập lại!");
            }
        }while (check);

        do {
            try {
                System.out.println("Nhập giới tính của sinh viên đó!(Nam/Nữ/Khác)");
                gender = Validation.checkGender();
            }catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập lại!");
            }
        }while (check);

        do {
            try {
                System.out.println("Nhập lớp của sinh viên đó!");
                classPer = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập lại!");
            }
        }while (check);

        do {
            try {
                System.out.println("Nhập điểm số của sinh viên đó!");
                score = Double.parseDouble(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập lại!");
            }
        }while (check);

        Student student = new Student(id, name, dateOfBirth, gender, classPer, score);
        studentList.add(student);
        writeStudent();
        System.out.println("Thêm mới thành công sinh viên!");
    }

    @Override
    public void remove() {
        String idRemove = null;
        boolean check = false;
        do {
            try {
                System.out.println("Nhập id của sinh viên mà bạn cần thêm mới! (SV-XXXX)");
                idRemove =scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập lại!");
                check = true;
            }
        }while (check);

        for (int i = 0; i < studentList.size(); i++) {
            if (idRemove.equals(studentList.get(i).getId())) {
                System.out.println("Yes/No");
                String select = scanner.nextLine();
                if (select.equals("Yes")) {
                    studentList.remove(i);
                    writeStudent();
                    System.out.println("Bạn đã xoá thành công");
                    check = true;
                }
            }
        }if (!check) {
            try {
                throw new MyException();
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void display() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void search() {
        String nameSearch = null;
        boolean check = false;
        do {
            try {
                System.out.println("Nhập tên của sinh viên mà bạn muốn tìm kiếm!");
                nameSearch = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập lại!");
            }
        }while (check);

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().contains(nameSearch)) {
                System.out.println("Đây là sinh viên bạn muốn tìm!");
                System.out.println(studentList.get(i));
            }
        }
    }
}
