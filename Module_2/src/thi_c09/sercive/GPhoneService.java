package thi_c09.sercive;

import thi_c09.date.Validation;
import thi_c09.model.GenuinePhone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GPhoneService implements IPhone{
    // file data
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

        System.out.println("Nh???p t??n c???a ??i???n tho???i x??ch tay: ");
        String namePhone = Validation.checkNamePhone();

        do {
            check = false;
            try {
                System.out.println("Nh???p gi?? ti???n c???a ??i???n tho???i x??ch tay: ");
                price = Validation.checkMoney();
                break;
            }catch (NumberFormatException e) {
                System.out.println("L???i r???i nh???p l???i!");
                check = true;
                continue;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nh???p s??? l?????ng ??i???n tho???i x??ch tay: ");
                quantily = Validation.checkQuality();
            }catch (NumberFormatException e) {
                System.out.println("L???i r???i nh???p l???i!");
                check = true;
                continue;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nh???p nh?? s???n xu???t c???a ??i???n tho???i x??ch tay: ");
                producter = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("l???i r???i, nh???p l???i!");
                check = true;
                continue;
            }
        }while (check);

        do {
            check = true;
                System.out.println("Nh???p th???i gian b???o h??nh c???a ??i???n tho???i x??ch tay: ");
                warrantyPeriod = scanner.nextLine();
                if (warrantyPeriod.equals("1 n??m") || warrantyPeriod.equals("2 n??m")) {
                    break;
                }
        }while (check);

        do {
            check = true;
                System.out.println("Nh???p ph???m vi b???o h??nh c???a ??i???n tho???i x??ch tay: ");
                warrantyCoverage = scanner.nextLine();
                if (warrantyCoverage.equals("To??n qu???c") || warrantyCoverage.equals("Qu???c t???")) {
                    break;
                }
        }while (check);
        GenuinePhone genuinePhone = new GenuinePhone(namePhone, price, quantily, producter, warrantyPeriod, warrantyCoverage);
        genuinePhoneList.add(genuinePhone);
        writeGphone();
        System.out.println("???? th??m th??nh c??ng ??i???n tho???i ch??nh h??ng!");
    }


    @Override
    public void removePhone() {
        System.out.println("Nh???p id c???a ??i???n tho???i m?? b???n mu???n xo??");
        int idRemove = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < genuinePhoneList.size(); i++) {
            if (idRemove == genuinePhoneList.get(i).getId()) {
                System.out.println("yes/no");
                String yes = scanner.nextLine();
                if (yes.equals("yes")) {
                    genuinePhoneList.remove(i);
                    System.out.println("???? xo?? th??nh c??ng!");
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
        System.out.println("Nh???p t??n c???a ??i???n tho???i m?? b???n mu???n t??m!");
        String namePhone = scanner.nextLine();
        for (int i = 0; i < genuinePhoneList.size(); i++) {
            if (namePhone.equals(genuinePhoneList.get(i).getPhoneName())) {
                System.out.println(genuinePhoneList.get(i));
            }else {
                System.out.println("Kh??ng t??m th???y ten ??i???n tho???i c???a b???n!");
            }
        }
    }
}
