package thi_c09.sercive;

import thi_c09.date.Validation;
import thi_c09.model.CellPhone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XPhoneService implements IPhone {
    public static final String CELL = "D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\thi_c09\\data_phone\\cell.csv";
    public static List<CellPhone> cellPhoneList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void XPhoneService() {
        cellPhoneList = readCellPhone();
    }
    public static void writeCellPhone() {
        try {
            FileWriter fileWriterCell = new FileWriter(CELL);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriterCell);
            for (CellPhone cellPhone : cellPhoneList) {
                bufferedWriter.write(cellPhone.getId() + "," +cellPhone.getPhoneName() + "," + cellPhone.getPrice()
                + "," + cellPhone.getQuantily() + "," +cellPhone.getProducter() + "," + cellPhone.getNational() + "," + cellPhone.getStatus());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<CellPhone> readCellPhone() {
        List<CellPhone> cellPhones = new ArrayList<>();
        try {
            FileReader fileReaderGphone = new FileReader(CELL);
            BufferedReader bufferedReader = new BufferedReader(fileReaderGphone);
            String line;
            String[] temp;
            CellPhone cellPhone;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                cellPhone = new CellPhone(temp[0], Double.parseDouble(temp[1]), Integer.parseInt(temp[2]), temp[3], temp[4], temp[5]);
                cellPhones.add(cellPhone);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cellPhones;
    }


    @Override
    public void addPhone() {
        boolean check;
        Double price = 0.0;
        int quantily = 0;
        String producter = null;
        String national = null;
        String status = null;

        System.out.println("Nh???p t??n c???a ??i???n tho???i x??ch tay: ");
        String namePhone = Validation.checkNamePhone();
        do {
            check = false;
            try {
                System.out.println("Nh???p gi?? ti???n c???a ??i???n tho???i x??ch tay: ");
                price =Validation.checkMoney();
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
                quantily =Validation.checkQuality();
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
                System.out.println("Nh???p qu???c gia c???a ??i???n tho???i x??ch tay: ");
                national = scanner.nextLine();
                if (!national.equals("Vi???t Nam")) {
                    System.out.println("Qu???c gia kh??ng ???????c l?? Vi???t Nam");
                    continue;
                }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nh???p tr???ng th??i c???a ??i???n tho???i x??ch tay: ");
                status = scanner.nextLine();
                if (status.equals("???? s???a ch???a") || status.equals("Ch??a s???a ch???a")) {
                    break;
                }
            }catch (NumberFormatException e) {
                System.out.println("l???i r???i, nh???p l???i!");
                check = true;
                continue;
            }
        }while (check);

        CellPhone cellPhone = new CellPhone(namePhone, price, quantily, producter, national, status);
        cellPhoneList.add(cellPhone);
        writeCellPhone();
        System.out.println("???? th??m th??nh c??ng ??i???n tho???i x??ch tay!");
    }

    @Override
    public void removePhone() {
        System.out.println("Nh???p id c???a ??i???n tho???i m?? b???n mu???n xo??!");
        int idRemove = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cellPhoneList.size(); i++) {
            if (idRemove == cellPhoneList.get(i).getId()) {
                System.out.println("Yes or No");
                String yes = scanner.nextLine();

                if (yes.equals("yes")) {
                    cellPhoneList.remove(i);
                    System.out.println("???? xo?? th??nh c??ng!");
                    writeCellPhone();
                }
            }
        }
    }

    @Override
    public void displayPhone() {
        for (CellPhone cellPhone : cellPhoneList) {
            System.out.println(cellPhone);
        }
    }

    @Override
    public void searchPhone() {
        System.out.println("Nh???p t??n c???a ??i???n tho???i m?? b???n mu???n t??m!");
        String namePhone = scanner.nextLine();
        for (int i = 0; i < cellPhoneList.size(); i++) {
            if (namePhone.equals(cellPhoneList.get(i).getPhoneName())) {
                System.out.println(cellPhoneList.get(i));
            } else {
                System.out.println("Kh??ng t??m th???y ten ??i???n tho???i c???a b???n!");
            }
        }
    }
}

