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
                System.out.println("Nh???p id c???a gi???ng vi??n m?? b???n c???n th??m m???i! (GV-XXXX)");
                id = Validation.checkIdLecturer();
            }catch (NumberFormatException e) {
                System.out.println("Sai ?????nh d???ng, vui l??ng nh???p l???i!");
            }
        }while (check);

        do {
            try {
                System.out.println("Nh???p t??n c???a gi???ng vi??n ????!");
                name = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Sai ?????nh d???ng, vui l??ng nh???p l???i!");
            }
        }while (check);

        do {
            try {
                System.out.println("Nh???p ng??y th??ng n??m sinh c???a gi???ng vi??n ????! (dd/MM/yy)");
                dateOfBirth = Validation.checkDateOfBirth();
            }catch (NumberFormatException e) {
                System.out.println("Sai ?????nh d???ng, vui l??ng nh???p l???i!");
            }
        }while (check);

        do {
            try {
                System.out.println("Nh???p gi???i t??nh c???a gi???ng vi??n ????!(Nam/N???/Kh??c)");
                gender = Validation.checkGender();
            }catch (NumberFormatException e) {
                System.out.println("Sai ?????nh d???ng, vui l??ng nh???p l???i!");
            }
        }while (check);

        do {
            try {
                System.out.println("Nh???p chuy??n m??n c???a gi???ng vi??n m?? b???n mu???n th??m!");
                specialize = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Sai ?????nh d???ng, vui l??ng nh???p l???i!");
            }
        }while (check);

        Lecturers lecturers = new Lecturers(id, name, dateOfBirth, gender, specialize);
        lecturersList.add(lecturers);
        writeLecturers();
        System.out.println("???? th??m m???i th??nh c??ng gi???ng vi??n ????!");
    }

    @Override
    public void remove() {
        boolean check = false;
        String idRemove = null;
        do {
            try {
                System.out.println("Nh???p id c???a gi???ng vi??n m?? b???n mu???n xo??! (GV-XXXX)");
                idRemove = Validation.checkIdLecturer();
            }catch (NumberFormatException e) {
                System.out.println("Sai ?????nh d???ng, vui l??ng nh???p l???i!");
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
                    System.out.println("B???n ???? xo?? th??nh c??ng");
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
                System.out.println("Nh???p t??n c???a gi???ng vi??n m?? b???n mu???n t??m ki???m!");
                nameSearch = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Sai ?????nh d???ng, vui l??ng nh???p l???i!");
            }
        }while (check);

        for (int i = 0; i < lecturersList.size(); i++) {
            if (lecturersList.get(i).getName().contains(nameSearch)) {
                System.out.println("????y l?? gi???ng vi??n b???n mu???n t??m!");
                System.out.println(lecturersList.get(i));
            }
        }
    }
}
