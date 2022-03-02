package thipassmodule2.service;

import thipassmodule2.model.ImportedProducts;
import thipassmodule2.utils.NotFoundProductException;
import thipassmodule2.utils.Validation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportedProductsService implements IProductService {
    public static final String IMPORT = "D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\thipassmodule2\\data\\ImportProduct.csv";
    public static List<ImportedProducts> importedProductsList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public ImportedProductsService() {
        importedProductsList = readImport();
    }

    public void writeImport() {
        try {
            FileWriter fwImprot = new FileWriter(IMPORT);
            BufferedWriter bwImport = new BufferedWriter(fwImprot);
            for (ImportedProducts importPro : importedProductsList) {
                bwImport.write(importPro.getIdProduct() + "," + importPro.getNameProduct() + "," + importPro.getPrice() + ","
                        + importPro.getQuantily() + "," + importPro.getProducer() + "," + importPro.getImportedPrice() + "," +
                        importPro.getProvince() + "," + importPro.getImportedTax());
                bwImport.newLine();
            }
            bwImport.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<ImportedProducts> readImport() {
        List<ImportedProducts> importedProductsList1 = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(IMPORT);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] temp;
            ImportedProducts importedProducts;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                importedProducts = new ImportedProducts(temp[0], temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3]),
                        temp[4], Double.parseDouble(temp[5]), temp[6], Double.parseDouble(temp[7]));
                importedProductsList1.add(importedProducts);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return importedProductsList1;
    }

    @Override
    public void addProduct() {
        boolean check = false;
        Double price = 0.0;
        int quantily = 0;
        Double importedPrice =0.0;
        Double importedTax =0.0;
        System.out.println("Nhập mã sản phẩm nhập khẩu: ");
        String idImport = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm nhập khẩu: ");
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
                importedPrice = Validation.checkMoney();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi! nhập lại");
                check = true;
            }
        }while (check);

        System.out.println("Nhập tỉnh/ thành phố nhập khẩu: ");
        String province = scanner.nextLine();
        do {
            try {
                System.out.println("Nhập số tiền thuế: ");
                importedTax = Validation.checkMoney();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi! nhập lại");
                check = true;
            }
        }while (check);

        ImportedProducts importedProducts = new ImportedProducts(idImport, nameProduct, price, quantily, producer, importedPrice, province, importedTax);
        importedProductsList.add(importedProducts);
        writeImport();
        System.out.println("Thêm sản phẩm mới thành công");
    }

    @Override
    public void removeProduct() {
        System.out.println("Nhập mã sản phẩm mà bạn muốn xoá!");
        String idProduct = scanner.nextLine();
        for (int i = 0; i < importedProductsList.size(); i++) {
            if (idProduct.equals(importedProductsList.get(i).getIdProduct())) {
                System.out.println("Yes or No");
                String anwser = scanner.nextLine();
                if (anwser.equals("Yes")) {
                    importedProductsList.remove(i);
                    System.out.println("Xoá thành công sản phẩm!");
                }else {
                    System.out.println("Không xoá sản phẩm");
                }
            }
        }
        writeImport();
    }

    @Override
    public void displayProduct() {
        for (ImportedProducts importedProducts : importedProductsList) {
            System.out.println(importedProducts);
        }
    }

    @Override
    public void searchProduct() {
        System.out.println("Nhập tên sản phẩm mà bạn muốn tìm!");
        String nameProduct = scanner.nextLine();
        for (int i = 0; i < importedProductsList.size(); i++) {
            if (nameProduct.contains(importedProductsList.get(i).getNameProduct())) {
                System.out.println("Sản phẩm mà bạn muốn tìm: ");
                System.out.println(importedProductsList.get(i));
            }
        }
    }
}
