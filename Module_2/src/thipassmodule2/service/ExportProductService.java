package thipassmodule2.service;

import thipassmodule2.model.ExportProducts;
import thipassmodule2.utils.Validation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExportProductService implements IProductService{
    public static final String EXPORT = "D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\thipassmodule2\\data\\ExportProduct.csv";
    public static List<ExportProducts> exportProductsList = new ArrayList<>();
    public  static Scanner scanner = new Scanner(System.in);

    public ExportProductService() {
        exportProductsList = readExport();
    }

    public void writeExport() {
        try {
            FileWriter fileWriter = new FileWriter(EXPORT);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (ExportProducts exportProducts : exportProductsList) {
                bufferedWriter.write(exportProducts.getIdProduct() + "," + exportProducts.getNameProduct() + "," + exportProducts.getPrice() + ","
                        + exportProducts.getQuantily() + "," + exportProducts.getExportPrice() + "," + exportProducts.getNationalProduction());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<ExportProducts> readExport() {
        List<ExportProducts> exportProductsList1 = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(EXPORT);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] temp;
            ExportProducts exportProducts;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                exportProducts = new ExportProducts(temp[0], temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3]),
                        temp[4], Double.parseDouble(temp[5]), temp[6]);
                exportProductsList1.add(exportProducts);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exportProductsList1;
    }
    @Override
    public void addProduct() {
        boolean check = false;
        Double price =0.0;
        int quantily = 0;
        Double exportPrice =0.0;
        System.out.println("Nh???p m?? s???n ph???m xu???t kh???u: ");
        String idImport = scanner.nextLine();
        System.out.println("Nh???p t??n s???n ph???m xu???t kh???u: ");
        String nameProduct = scanner.nextLine();
        do {
            try {
                System.out.println("Nh???p gi?? s???n ph???m nh???p kh???u: ");
                price = Validation.checkMoney();
            }catch (NumberFormatException e) {
                System.out.println("L???i! nh???p l???i");
                check = true;
            }
        }while (check);

        do {
            try {
                System.out.println("Nh???p s??? l?????ng s???n ph???m nh???p kh???u: ");
                quantily = Validation.checkQuality();
            }catch (NumberFormatException e) {
                System.out.println("L???i! nh???p l???i");
                check = true;
            }
        }while (check);
        System.out.println("Nh???p nh?? s???n xu???t c???a s???n ph???m: ");
        String producer = scanner.nextLine();
        do {
            try {
                System.out.println("Nh???p gi?? nh???p kh???u: ");
                exportPrice = Validation.checkMoney();
            }catch (NumberFormatException e) {
                System.out.println("L???i! nh???p l???i");
                check = true;
            }
        }while (check);

        System.out.println("Nh???p qu???c gia s???n xu???t: ");
        String nationalProduction = scanner.nextLine();
        ExportProducts exportProducts = new ExportProducts(idImport, nameProduct, price, quantily, producer, exportPrice, nationalProduction);
        exportProductsList.add(exportProducts);
        writeExport();
        System.out.println("???? th??m m???i th??nh c??ng!");
    }

    @Override
    public void removeProduct() {
        System.out.println("Nh???p m?? s???n ph???m m?? b???n mu???n xo??!");
        String idProduct = scanner.nextLine();
        for (int i = 0; i < exportProductsList.size(); i++) {
            if (idProduct.equals(exportProductsList.get(i).getIdProduct())) {
                System.out.println("Yes or No");
                String anwser = scanner.nextLine();
                if (anwser.equals("Yes")) {
                    exportProductsList.remove(i);
                    System.out.println("Xo?? th??nh c??ng s???n ph???m!");
                }else {
                    System.out.println("Kh??ng xo?? s???n ph???m");
                }
            }
        }
        writeExport();
    }

    @Override
    public void displayProduct() {
        for (ExportProducts exportProducts : exportProductsList) {
            System.out.println(exportProducts);
        }
    }

    @Override
    public void searchProduct() {
        System.out.println("Nh???p t??n s???n ph???m m?? b???n mu???n t??m!");
        String nameProduct = scanner.nextLine();
        for (int i = 0; i < exportProductsList.size(); i++) {
            if (nameProduct.contains(exportProductsList.get(i).getNameProduct())) {
                System.out.println("S???n ph???m m?? b???n mu???n t??m: ");
                System.out.println(exportProductsList.get(i));
            }
        }
    }
}
