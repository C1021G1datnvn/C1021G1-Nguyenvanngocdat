package case_study1.service.iplm_service;

import case_study1.model.person.Customer;
import case_study1.service.interface_service.ICustomerService;
import case_study1.untils.Validation;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceIplm implements ICustomerService {
    public static final String CUSTOMER = "D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\case_study1\\data\\customer.csv";
    public static List<Customer> customerList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public CustomerServiceIplm() {
        readCustomerCSV();
    }

    public void writeCustomerCSV() {
        try {
            FileWriter fileWriter = new FileWriter(CUSTOMER);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : customerList) {
                bufferedWriter.write(customer.getId() + "," + customer.getName() + "," + customer.getAge()
                        + "," + customer.getAdress() + "," + customer.getGender() + "," + customer.getDateOfBirth() + "," + customer.getNumberPhone()
                        + "," + customer.getNumberCccd() + "," + customer.getEmail() + "," + customer.getCusRank());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> readCustomerCSV() {
        List<Customer> customerList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(CUSTOMER);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] temp;
            Customer customer;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                customer = new Customer(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), temp[3], temp[4], temp[5], temp[6], temp[7],
                        temp[8], temp[9]);
                customerList.add(customer);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }


    @Override
    public void addCustomer() {
        int id =0;
        String name = null;
        int age = 0;
        String addres = null;
        String gender = null;
        String dateOfBirth = null;
        String numberPhone = null;
        String numberCccd = null;
        String email = null;
        String cusRank = null;
        boolean check;
        do {
            check = false;
            try {
                System.out.println("Nhập id: ");
                id = Validation.checkIdPerson();;
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập tên: ");
                name = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập tuổi: ");
                age = Validation.age();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập địa chỉ: ");
                addres = scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập giới tính: (male | female)");
                gender = Validation.checkGender();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập ngày tháng năm sinh: (XX/XX/XXXX)");
                dateOfBirth = Validation.dateOfBirth();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);


        do {
            check = false;
            try {
                System.out.println("Nhập số điện thoại: ");
                numberPhone = Validation.checkPhoneNumber();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);


        do {
            check = false;
            try {
                System.out.println("Nhập số căn cước công dân: ");
                numberCccd = Validation.checkNumberCccd();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập email: ");
                email = Validation.checkEmail();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập loại khách hàng: ");
                cusRank = Validation.customerRank();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);
        Customer customer = new Customer(id, name, age, addres, gender, dateOfBirth, numberPhone, numberCccd, email, cusRank);
        customerList.add(customer);
        writeCustomerCSV();
        System.out.println("Đã thêm mới Customer!");
    }

    @Override
    public void editCustomer() {
        int id =0;
        String name = null;
        int age = 0;
        String addres = null;
        String gender = null;
        String dateOfBirth = null;
        String numberPhone = null;
        String numberCccd = null;
        String email = null;
        String cusRank = null;
        boolean check;
        System.out.println("Nhập id của khách hàng mà bạn muốn chỉnh sửa: ");
        int idEdit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == idEdit) {
                do {
                    check = false;
                    try {
                        System.out.println("Nhập id: ");
                        id = Validation.checkIdPerson();;
                    }catch (NumberFormatException e) {
                        System.out.println("Lỗi rồi, nhập lại nhé!");
                        check = true;
                    }
                }while (check);

                do {
                    check = false;
                    try {
                        System.out.println("Nhập tên: ");
                        name = scanner.nextLine();
                    }catch (NumberFormatException e) {
                        System.out.println("Lỗi rồi, nhập lại nhé!");
                        check = true;
                    }
                }while (check);

                do {
                    check = false;
                    try {
                        System.out.println("Nhập tuổi: ");
                        age = Validation.age();
                    }catch (NumberFormatException e) {
                        System.out.println("Lỗi rồi, nhập lại nhé!");
                        check = true;
                    }
                }while (check);

                do {
                    check = false;
                    try {
                        System.out.println("Nhập địa chỉ: ");
                        addres = scanner.nextLine();
                    }catch (NumberFormatException e) {
                        System.out.println("Lỗi rồi, nhập lại nhé!");
                        check = true;
                    }
                }while (check);

                do {
                    check = false;
                    try {
                        System.out.println("Nhập giới tính: (male | female)");
                        gender = Validation.checkGender();
                    }catch (NumberFormatException e) {
                        System.out.println("Lỗi rồi, nhập lại nhé!");
                        check = true;
                    }
                }while (check);

                do {
                    check = false;
                    try {
                        System.out.println("Nhập ngày tháng năm sinh: (XX/XX/XXXX)");
                        dateOfBirth = Validation.dateOfBirth();
                    }catch (NumberFormatException e) {
                        System.out.println("Lỗi rồi, nhập lại nhé!");
                        check = true;
                    }
                }while (check);

                do {
                    check = false;
                    try {
                        System.out.println("Nhập số điện thoại: ");
                        numberPhone = Validation.checkPhoneNumber();
                    }catch (NumberFormatException e) {
                        System.out.println("Lỗi rồi, nhập lại nhé!");
                        check = true;
                    }
                }while (check);


                do {
                    check = false;
                    try {
                        System.out.println("Nhập số căn cước công dân: ");
                        numberCccd = Validation.checkNumberCccd();
                    }catch (NumberFormatException e) {
                        System.out.println("Lỗi rồi, nhập lại nhé!");
                        check = true;
                    }
                }while (check);

                do {
                    check = false;
                    try {
                        System.out.println("Nhập email: ");
                        email = Validation.checkEmail();
                    }catch (NumberFormatException e) {
                        System.out.println("Lỗi rồi, nhập lại nhé!");
                        check = true;
                    }
                }while (check);

                do {
                    check = false;
                    try {
                        System.out.println("Nhập loại khách hàng: ");
                        cusRank = Validation.customerRank();
                    }catch (NumberFormatException e) {
                        System.out.println("Lỗi rồi, nhập lại nhé!");
                        check = true;
                    }
                }while (check);
                customerList.get(i).setId(id);
                customerList.get(i).setName(name);
                customerList.get(i).setAge(age);
                customerList.get(i).setAdress(addres);
                customerList.get(i).setGender(gender);
                customerList.get(i).setDateOfBirth(dateOfBirth);
                customerList.get(i).setNumberPhone(numberPhone);
                customerList.get(i).setNumberCccd(numberCccd);
                customerList.get(i).setEmail(email);
                customerList.get(i).setCusRank(cusRank);
                writeCustomerCSV();
            }
        }
    }

    @Override
    public void deleteCustomer() {
        System.out.println("Nhập tên của khách hàng mà bạn muốn xoá! ");
        String name = scanner.nextLine();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getName().equals(name)) {
                customerList.remove(i);
                System.out.println("Bạn đã xoá khách hàng này!");
            }
        }
    }

    @Override
    public void display() {
        for(Customer customer : customerList) {
            System.out.println(customer);
        }
    }
}
