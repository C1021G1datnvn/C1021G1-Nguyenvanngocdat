package ss17_binary_serialization.bai_tap.service;

import ss17_binary_serialization.bai_tap.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    public static final String PRODUCT = "D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\ss17_binary_serialization\\bai_tap\\product.txt";
    List<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);



    @Override
    public void addProduct() {
        System.out.println("Nhập mã sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập hãng sản phẩm: ");
        String manufacturer = scanner.nextLine();
        System.out.println("Nhập giá của sẩn phẩm: ");
        String price = scanner.nextLine();
        products.add(new Product(id, name, manufacturer, price));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PRODUCT);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listProduct() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString());
        }
    }

    @Override
    public void searchProduct() {
        boolean check = false;
        System.out.println("Nhập tên sản phẩm bạn muốn tìm");
        String search = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(search)){
                System.out.println("Sản phẩm bạn cần tìm là: " + products.get(i).getName());
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("Sản phẩm không nằm trong danh sách chúng tôi có!");
        }
    }

    @Override
    public void readList() throws IOException, ClassNotFoundException {
        List<Product> productList = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(PRODUCT);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        productList = (List<Product>) objectInputStream.readObject();
        objectInputStream.close();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

}
