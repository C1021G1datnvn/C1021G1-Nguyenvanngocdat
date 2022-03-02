package ss12_java_collection_framework.bai_tap.controller;

import ss12_java_collection_framework.bai_tap.service.ProductManagerService;

import java.util.Scanner;

public class ProductController {
    public static void main(String[] args) {
        int select;
        do {
            System.out.println("--------Menu---------");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa đổi thông tin sản phẩm");
            System.out.println("3. Xoá sản phẩm");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần theo giá");
            System.out.println("7. Sắp xếp sản phẩm giảm dần theo giá");
            System.out.println("0. Thoát khỏi danh sách sản phẩm");
            Scanner scanner = new Scanner(System.in);
            select = Integer.parseInt(scanner.nextLine());
            ProductManagerService productManagerService = new ProductManagerService();
            switch (select) {
                case 1:
                    productManagerService.addProduct();
                    break;
                case 2:
                    productManagerService.editProduct();
                    break;
                case 3:
                    productManagerService.removeproduct();
                    break;
                case 4:
                    productManagerService.showProduct();
                    break;
                case 5:
                    productManagerService.searchProduct();
                    break;
                case 6:
                    productManagerService.increase();
                    break;
                case 7:
                    productManagerService.decrease();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Nhập lại! ");

            }
        } while (select != 0);
    }
}
