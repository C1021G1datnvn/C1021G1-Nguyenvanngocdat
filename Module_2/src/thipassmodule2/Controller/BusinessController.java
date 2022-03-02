package thipassmodule2.Controller;

import thipassmodule2.service.ExportProductService;
import thipassmodule2.service.ImportedProductsService;

import java.util.Scanner;

public class BusinessController {
    public static ImportedProductsService serviceImport = new ImportedProductsService();
    public static ExportProductService serviceExport = new ExportProductService();
    static Scanner scanner;
    static int choice;

    static void add(){
        scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Thêm một sản phẩm mới");
        do{

            System.out.println();
            System.out.println("1. Thêm mới sản phẩm nhập khẩu");
            System.out.println("2. Thêm một sản phẩm xuất khẩu");
            try{
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Vui lòng nhập một số");
                continue;
            }

            switch (choice){
                case 1:
                    serviceImport.addProduct();
                    break;
                case 2:
                    serviceExport.addProduct();
                    break;
                default:
                    System.out.println("vui lòng chọn số từ 1 đến 2");
                    continue;
            }
            break;
        }while(true);
    }
    static void search() {
        scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Tìm kiếm một sản phẩm mới");
        do{

            System.out.println();
            System.out.println("1. Tìm sản phẩm nhập khẩu");
            System.out.println("2. Tìm sản phẩm xuất khẩu");
            try{
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Vui lòng nhập một số");
                continue;
            }

            switch (choice){
                case 1:
                    serviceImport.searchProduct();
                    break;
                case 2:
                    serviceExport.searchProduct();
                    break;
                default:
                    System.out.println("vui lòng chọn số từ 1 đến 2");
                    continue;
            }
            break;
        }while(true);
    }

    static void display(){
        int choice = 0;
        scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Hiển thị danh sách sản phẩm");
        do{
            System.out.println();
            System.out.println("1. Hiển thị danh sách sản phẩm nhập khẩu");
            System.out.println("2. Hiển thị danh sách sản phẩm xuất khẩu");
            try{
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Vui lòng nhập một số");
                continue;
            }

            switch (choice){
                case 1:
                    serviceImport.displayProduct();
                    break;
                case 2:
                    serviceExport.displayProduct();
                    break;
                default:
                    System.out.println("vui lòng chọn số từ 1 đến 2");
                    continue;
            }
            break;
        }while(true);
    }
    static void delete() {

        int choice = 0;
        scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Xoá sản phẩm");
        do{
            System.out.println();
            System.out.println("1. Xoá 1 sản phẩm nhập khẩu");
            System.out.println("2. Xoá một sản phẩm xuất khẩu");
            try{
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.out.println("Vui lòng nhập một số");
                continue;
            }

            switch (choice){
                case 1:
                    serviceImport.removeProduct();
                    break;
                case 2:
                    serviceExport.removeProduct();
                    break;
                default:
                    System.out.println("vui lòng chọn số từ 1 đến 2");
                    continue;
            }
            break;
        }while(true);
    }
}
