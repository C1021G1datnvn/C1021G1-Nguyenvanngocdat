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
        System.out.println("Nh???p m?? s???n ph???m nh???p kh???u: ");
        String idImport = scanner.nextLine();
        System.out.println("Nh???p t??n s???n ph???m nh???p kh???u: ");
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
                importedPrice = Validation.checkMoney();
            }catch (NumberFormatException e) {
                System.out.println("L???i! nh???p l???i");
                check = true;
            }
        }while (check);

        System.out.println("Nh???p t???nh/ th??nh ph??? nh???p kh???u: ");
        String province = scanner.nextLine();
        do {
            try {
                System.out.println("Nh???p s??? ti???n thu???: ");
                importedTax = Validation.checkMoney();
            }catch (NumberFormatException e) {
                System.out.println("L???i! nh???p l???i");
                check = true;
            }
        }while (check);

        ImportedProducts importedProducts = new ImportedProducts(idImport, nameProduct, price, quantily, producer, importedPrice, province, importedTax);
        importedProductsList.add(importedProducts);
        writeImport();
        System.out.println("Th??m s???n ph???m m???i th??nh c??ng");
    }

    @Override
    public void removeProduct() {
        System.out.println("Nh???p m?? s???n ph???m m?? b???n mu???n xo??!");
        String idProduct = scanner.nextLine();
        for (int i = 0; i < importedProductsList.size(); i++) {
            if (idProduct.equals(importedProductsList.get(i).getIdProduct())) {
                System.out.println("Yes or No");
                String anwser = scanner.nextLine();
                if (anwser.equals("Yes")) {
                    importedProductsList.remove(i);
                    System.out.println("Xo?? th??nh c??ng s???n ph???m!");
                }else {
                    System.out.println("Kh??ng xo?? s???n ph???m");
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
        System.out.println("Nh???p t??n s???n ph???m m?? b???n mu???n t??m!");
        String nameProduct = scanner.nextLine();
        for (int i = 0; i < importedProductsList.size(); i++) {
            if (nameProduct.contains(importedProductsList.get(i).getNameProduct())) {
                System.out.println("S???n ph???m m?? b???n mu???n t??m: ");
                System.out.println(importedProductsList.get(i));
            }
        }
    }
}
