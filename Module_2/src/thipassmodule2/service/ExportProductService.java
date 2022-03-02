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
        System.out.println("Nhập mã sản phẩm xuất khẩu: ");
        String idImport = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm xuất khẩu: ");
        String nameProduct = scanner.nextLine();
        do {
            try {
                System.out.println("Nhập giá sản phẩm nhập khẩu: ");
                price = Validation.checkMoney();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi! nhập lại");
                check = true;
            }
        }while (check);

        do {
            try {
                System.out.println("Nhập số lượng sản phẩm nhập khẩu: ");
                quantily = Validation.checkQuality();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi! nhập lại");
                check = true;
            }
        }while (check);
        System.out.println("Nhập nhà sản xuất của sản phẩm: ");
        String producer = scanner.nextLine();
        do {
            try {
                System.out.println("Nhập giá nhập khẩu: ");
                exportPrice = Validation.checkMoney();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi! nhập lại");
                check = true;
            }
        }while (check);

        System.out.println("Nhập quốc gia sản xuất: ");
        String nationalProduction = scanner.nextLine();
        ExportProducts exportProducts = new ExportProducts(idImport, nameProduct, price, quantily, producer, exportPrice, nationalProduction);
        exportProductsList.add(exportProducts);
        writeExport();
        System.out.println("Đã thêm mới thành công!");
    }

    @Override
    public void removeProduct() {
        System.out.println("Nhập mã sản phẩm mà bạn muốn xoá!");
        String idProduct = scanner.nextLine();
        for (int i = 0; i < exportProductsList.size(); i++) {
            if (idProduct.equals(exportProductsList.get(i).getIdProduct())) {
                System.out.println("Yes or No");
                String anwser = scanner.nextLine();
                if (anwser.equals("Yes")) {
                    exportProductsList.remove(i);
                    System.out.println("Xoá thành công sản phẩm!");
                }else {
                    System.out.println("Không xoá sản phẩm");
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
        System.out.println("Nhập tên sản phẩm mà bạn muốn tìm!");
        String nameProduct = scanner.nextLine();
        for (int i = 0; i < exportProductsList.size(); i++) {
            if (nameProduct.contains(exportProductsList.get(i).getNameProduct())) {
                System.out.println("Sản phẩm mà bạn muốn tìm: ");
                System.out.println(exportProductsList.get(i));
            }
        }
    }
}
