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

        System.out.println("Nhập tên của điện thoại xách tay: ");
        String namePhone = Validation.checkNamePhone();
        do {
            check = false;
            try {
                System.out.println("Nhập giá tiền của điện thoại xách tay: ");
                price =Validation.checkMoney();
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
                quantily =Validation.checkQuality();
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
                System.out.println("Nhập quốc gia của điện thoại xách tay: ");
                national = scanner.nextLine();
                if (!national.equals("Việt Nam")) {
                    System.out.println("Quốc gia không được là Việt Nam");
                    continue;
                }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập trạng thái của điện thoại xách tay: ");
                status = scanner.nextLine();
                if (status.equals("Đã sửa chữa") || status.equals("Chưa sửa chữa")) {
                    break;
                }
            }catch (NumberFormatException e) {
                System.out.println("lỗi rồi, nhập lại!");
                check = true;
                continue;
            }
        }while (check);

        CellPhone cellPhone = new CellPhone(namePhone, price, quantily, producter, national, status);
        cellPhoneList.add(cellPhone);
        writeCellPhone();
        System.out.println("Đã thêm thành công điện thoại xách tay!");
    }

    @Override
    public void removePhone() {
        System.out.println("Nhập id của điện thoại mà bạn muốn xoá!");
        int idRemove = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cellPhoneList.size(); i++) {
            if (idRemove == cellPhoneList.get(i).getId()) {
                System.out.println("Yes or No");
                String yes = scanner.nextLine();

                if (yes.equals("yes")) {
                    cellPhoneList.remove(i);
                    System.out.println("Đã xoá thành công!");
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
        System.out.println("Nhập tên của điện thoại mà bạn muốn tìm!");
        String namePhone = scanner.nextLine();
        for (int i = 0; i < cellPhoneList.size(); i++) {
            if (namePhone.equals(cellPhoneList.get(i).getPhoneName())) {
                System.out.println(cellPhoneList.get(i));
            } else {
                System.out.println("Không tìm thấy ten điện thoại của bạn!");
            }
        }
    }
}

