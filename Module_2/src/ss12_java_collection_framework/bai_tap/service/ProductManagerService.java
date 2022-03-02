package ss12_java_collection_framework.bai_tap.service;

import ss12_java_collection_framework.bai_tap.model.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagerService {
    Scanner scanner = new Scanner(System.in);
    static List<Product> listProduct = new ArrayList<>();
    public void addProduct() {
        System.out.print("nhập id ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("nhập tên ");
        String name = (scanner.nextLine());
        System.out.print("nhập giá ");
        double unitPrice = Integer.parseInt(scanner.nextLine());
        System.out.print("nhập số lượng ");
        int quantity = Integer.parseInt(scanner.nextLine());
        Product product = new Product(id, name, unitPrice, quantity);
        listProduct.add(product);
    }
    public void editProduct() {
        System.out.println("Nhập id của sản phẩm muốn chỉnh sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < listProduct.size(); i++) {
            if (id == listProduct.get(i).getId()) {
                System.out.println("Nhập tên sản phẩm: ");
                String editName = (scanner.nextLine());
                System.out.println("Nhập giá sản phẩm: ");
                double editUnitPrice = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập số lượng sản phẩm: ");
                int editQuantity = Integer.parseInt(scanner.nextLine());
                listProduct.get(i).setNameProduct(editName);
                listProduct.get(i).setUnitPrice(editUnitPrice);
                listProduct.get(i).setQuantity(editQuantity);
                check = true;
                break;
            }
        }if (check == false) {
            System.out.println("Not id in the list product!");
        }
    }
    public void removeproduct() {
        System.out.println("Nhập id của sản phẩm mà bạn muốn xoá: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        for (int i = 0; i < listProduct.size(); i++) {
            if (id == listProduct.get(i).getId()) {
                listProduct.remove(listProduct.get(i));
                check = true;
                break;
            }
        }if (check == false) {
            System.out.println("Id không tương ứng với sản phẩm!");
        }
    }
    public void showProduct() {
        for (Product product : listProduct) {
            System.out.println(product);
        }
    }
    public void searchProduct() {
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String strProduct = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < listProduct.size(); i++) {
            if (strProduct.contains(listProduct.get(i).getNameProduct())) {
                System.out.println(strProduct + "là sản phẩm bạn cần tìm");
                check = true;
                break;
            }
        }if (check == false) {
            System.out.println("This Product not in the list!");
        }
    }
    public void increase() {
        Collections.sort(listProduct);
        }
        public void decrease() {
        Product newProduct = new Product();
        Collections.sort(listProduct, newProduct);
        }

}
