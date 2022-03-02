package thi_c09.sercive;

import thi_c09.date.Validation;
import thi_c09.model.GenuinePhone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GPhoneService implements IPhone{
    public static final String GPHONE = "D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\thi_c09\\data_phone\\gphone.csv";
    public static List<GenuinePhone> genuinePhoneList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static boolean check = false;
    public static void GPhoneService() {
        genuinePhoneList = readGphone();
    }
    public static void writeGphone() {
        try {
            FileWriter fileWriterGphone = new FileWriter(GPHONE);
            BufferedWriter bufferedWriterGphone = new BufferedWriter(fileWriterGphone);
            for (GenuinePhone genuinePhone : genuinePhoneList) {
                bufferedWriterGphone.write(genuinePhone.getId() + "," +genuinePhone.getPhoneName() + "," + genuinePhone.getPrice()
                                + "," + genuinePhone.getQuantily() + "," +genuinePhone.getProducter() + "," + genuinePhone.getWarrantyPeriod() + "," + genuinePhone.getWarrantyCoverage());
                       bufferedWriterGphone.newLine();
            }
            bufferedWriterGphone.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<GenuinePhone> readGphone() {
        List<GenuinePhone> genuinePhoneList = new ArrayList<>();
        try {
            FileReader fileReaderGphone = new FileReader(GPHONE);
            BufferedReader bufferedReaderGphone = new BufferedReader(fileReaderGphone);
            String line;
            String[] temp;
            GenuinePhone genuinePhone;
            while ((line = bufferedReaderGphone.readLine()) != null) {
                temp = line.split(",");
                genuinePhone = new GenuinePhone(temp[0], Double.parseDouble(temp[1]), Integer.parseInt(temp[2]), temp[3], temp[4], temp[5]);
                genuinePhoneList.add(genuinePhone);
            }
            bufferedReaderGphone.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return genuinePhoneList;
    }

    @Override
    public void addPhone() {
        boolean check;
        Double price = 0.0;
        int quantily = 0;
        String producter = null;
        String warrantyPeriod = null;
        String warrantyCoverage = null;

        System.out.println("Nhập tên của điện thoại xách tay: ");
        String namePhone = Validation.checkNamePhone();
        do {
            check = false;
            try {
                System.out.println("Nhập giá tiền của điện thoại xách tay: ");
                price = Validation.checkMoney();
                break;
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi nhập lại!");
                check = true;
                continue;
            }
        }while (check);
        do {
            check = false;
            try {
                System.out.println("Nhập số lượng điện thoại xách tay: ");
                quantily = Validation.checkQuality();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi nhập lại!");
                check = true;
                continue;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập nhà sản xuất của điện thoại xách tay: ");
                producter = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("lỗi rồi, nhập lại!");
                check = true;
                continue;
            }
        }while (check);

        do {
            check = true;
                System.out.println("Nhập thời gian bảo hành của điện thoại xách tay: ");
                warrantyPeriod = scanner.nextLine();
                if (warrantyPeriod.equals("1 năm") || warrantyPeriod.equals("2 năm")) {
                    break;
                }
        }while (check);

        do {
            check = true;
                System.out.println("Nhập phạm vi bảo hành của điện thoại xách tay: ");
                warrantyCoverage = scanner.nextLine();
                if (warrantyCoverage.equals("Toàn quốc") || warrantyCoverage.equals("Quốc tế")) {
                    break;
                }
        }while (check);
        GenuinePhone genuinePhone = new GenuinePhone(namePhone, price, quantily, producter, warrantyPeriod, warrantyCoverage);
        genuinePhoneList.add(genuinePhone);
        writeGphone();
        System.out.println("Đã thêm thành công điện thoại chính hãng!");
    }


    @Override
    public void removePhone() {
        System.out.println("Nhập id của điện thoại mà bạn muốn xoá");
        int idRemove = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < genuinePhoneList.size(); i++) {
            if (idRemove == genuinePhoneList.get(i).getId()) {
                System.out.println("yes/no");
                String yes = scanner.nextLine();

                if (yes.equals("yes")) {
                    genuinePhoneList.remove(i);
                    System.out.println("Đã xoá thành công!");
                    writeGphone();
                }
            }
        }
    }

    @Override
    public void displayPhone() {
        for (GenuinePhone genuinePhone : genuinePhoneList) {
            System.out.println(genuinePhone);
        }
    }

    @Override
    public void searchPhone() {
        System.out.println("Nhập tên của điện thoại mà bạn muốn tìm!");
        String namePhone = scanner.nextLine();
        for (int i = 0; i < genuinePhoneList.size(); i++) {
            if (namePhone.equals(genuinePhoneList.get(i).getPhoneName())) {
                System.out.println(genuinePhoneList.get(i));
            }else {
                System.out.println("Không tìm thấy ten điện thoại của bạn!");
            }
        }
    }
}
