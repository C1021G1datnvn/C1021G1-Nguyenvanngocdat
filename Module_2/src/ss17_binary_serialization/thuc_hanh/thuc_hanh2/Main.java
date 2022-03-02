package ss17_binary_serialization.thuc_hanh.thuc_hanh2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String STUDENT = "D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\ss17_binary_serialization\\thuc_hanh\\thuc_hanh2\\student.txt";

    public static void writeToObject(String path, List<Student> students) throws FileNotFoundException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readToObject(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            students = (List<Student>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    return students;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Hoàng", "Bình Định"));
        students.add(new Student(2, "Ling", "Đà Nẵng"));
        students.add(new Student(3, "Bảo", "Đà Nẵng"));
        students.add(new Student(4, "Hiếu", "Quảng Nam"));
        students.add(new Student(5, "Thuận", "Quảng Nam"));
        students.add(new Student(6, "Đạt", "Quảng Trị"));
        writeToObject(STUDENT, students);
        List<Student> studentList = readToObject(STUDENT);
        for (Student student:studentList) {
            System.out.println(student);
        }
    }
}
