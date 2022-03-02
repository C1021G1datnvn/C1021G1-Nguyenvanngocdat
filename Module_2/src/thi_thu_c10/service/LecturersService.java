package thi_thu_c10.service;

import thi_thu_c10.exception.MyException;
import thi_thu_c10.exception.MyExceptionLec;
import thi_thu_c10.model.Lecturers;
import thi_thu_c10.validate.Validation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LecturersService implements  IPerson{
    public static final String LECTURERS = "D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\thi_thu_c10\\data\\lecturers.csv";
    public static List<Lecturers> lecturersList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public LecturersService() {
        lecturersList = readLecturers();
    }

    public void writeLecturers() {
        try {
            FileWriter fileWriterLec = new FileWriter(LECTURERS);
            BufferedWriter bufferedWriterLec = new BufferedWriter(fileWriterLec);
            for (Lecturers lecturers : lecturersList) {
                bufferedWriterLec.write(lecturers.getId() + "," + lecturers.getName() + "," + lecturers.getDateOfBirth() + "," +
                        lecturers.getGender() + "," + lecturers.getSpecialize());
                bufferedWriterLec.newLine();
            }
            bufferedWriterLec.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Lecturers> readLecturers() {
        List<Lecturers> lecturersList1 = new ArrayList<>();
        try {
            FileReader fileReaderLec = new FileReader(LECTURERS);
            BufferedReader bufferedReaderLec = new BufferedReader(fileReaderLec);
            String line;
            String[] temp;
            Lecturers lecturers;
            while ((line = bufferedReaderLec.readLine()) != null) {
                temp = line.split(",");
                lecturers = new Lecturers(temp[0], temp[1], temp[2], temp[3], temp[4]);
                lecturersList1.add(lecturers);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lecturersList1;
    }

    @Override
    public void addNew() {
        boolean check = false;
        String id = null;
        String name = null;
        String dateOfBirth = null;
        String gender = null;
        String specialize = null;

        do {
            try {
                System.out.println("Nhập id của giảng viên mà bạn cần thêm mới! (GV-XXXX)");
                id = Validation.checkIdLecturer();
            }catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập lại!");
            }
        }while (check);

        do {
            try {
                System.out.println("Nhập tên của giảng viên đó!");
                name = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập lại!");
            }
        }while (check);

        do {
            try {
                System.out.println("Nhập ngày tháng năm sinh của giảng viên đó! (dd/MM/yy)");
                dateOfBirth = Validation.checkDateOfBirth();
            }catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập lại!");
            }
        }while (check);

        do {
            try {
                System.out.println("Nhập giới tính của giảng viên đó!(Nam/Nữ/Khác)");
                gender = Validation.checkGender();
            }catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập lại!");
            }
        }while (check);

        do {
            try {
                System.out.println("Nhập chuyên môn của giảng viên mà bạn muốn thêm!");
                specialize = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập lại!");
            }
        }while (check);

        Lecturers lecturers = new Lecturers(id, name, dateOfBirth, gender, specialize);
        lecturersList.add(lecturers);
        writeLecturers();
        System.out.println("Đã thêm mới thành công giảng viên đó!");
    }

    @Override
    public void remove() {
        boolean check = false;
        String idRemove = null;
        do {
            try {
                System.out.println("Nhập id của giảng viên mà bạn muốn xoá! (GV-XXXX)");
                idRemove = Validation.checkIdLecturer();
            }catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập lại!");
                check = true;
            }
        }while (check);

        for (int i = 0; i < lecturersList.size(); i++) {
            if (idRemove.equals(lecturersList.get(i).getId())) {
                System.out.println("Yes/No");
                String select = scanner.nextLine();
                if (select.equals("Yes")) {
                    lecturersList.remove(i);
                    writeLecturers();
                    System.out.println("Bạn đã xoá thành công");
                    check = true;
                }
            }if (!check) {
                try {
                    throw new MyExceptionLec();
                } catch (MyExceptionLec e1) {
                    System.out.println(e1.getMessage());
                }
            }

        }
    }

    @Override
    public void display() {
        for (Lecturers lecturers : lecturersList) {
            System.out.println(lecturers);
        }
    }

    @Override
    public void search() {
        boolean check = false;
        String nameSearch = null;
        do {
            try {
                System.out.println("Nhập tên của giảng viên mà bạn muốn tìm kiếm!");
                nameSearch = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Sai định dạng, vui lòng nhập lại!");
            }
        }while (check);

        for (int i = 0; i < lecturersList.size(); i++) {
            if (lecturersList.get(i).getName().contains(nameSearch)) {
                System.out.println("Đây là giảng viên bạn muốn tìm!");
                System.out.println(lecturersList.get(i));
            }
        }
    }
}
