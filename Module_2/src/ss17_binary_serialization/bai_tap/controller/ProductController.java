package ss17_binary_serialization.bai_tap.controller;

import ss17_binary_serialization.bai_tap.service.ProductService;

import java.io.IOException;
import java.util.Scanner;

public class ProductController {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);

        int select;
        do {
            System.out.println("-------------Menu--------------");
            System.out.println("1. List product");
            System.out.println("2. Add product");
            System.out.println("3. Search product");
            System.out.println("4. Read product");
            System.out.println("0. Exit");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    productService.listProduct();
                    break;
                case 2:
                    productService.addProduct();
                    break;
                case 3:
                    productService.searchProduct();
                    break;
                case 4:
                    productService.readList();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Xin vui lòng nhập lại!");
            }
        }while (select != 0);
    }
}
