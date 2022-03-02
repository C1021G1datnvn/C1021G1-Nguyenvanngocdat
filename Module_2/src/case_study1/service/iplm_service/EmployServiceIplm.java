package case_study1.service.iplm_service;

import case_study1.model.person.Employee;
import case_study1.service.interface_service.IEmployeeService;
import case_study1.untils.Validation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployServiceIplm implements IEmployeeService {
    public static final String EMPLOYEE = "D:\\C1021G1-Nguyenvanngocdat\\Module_2\\src\\case_study1\\data\\employee.csv";
    private static List<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public EmployServiceIplm(){

        employeeList = readEmployeeCSV();
    }

    public void writeEmployeeCSV() {
        try {
            FileWriter fileWriter = new FileWriter(EMPLOYEE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee : employeeList) {
                bufferedWriter.write(employee.getId() + "," + employee.getName() + "," + employee.getAge()
                        + "," + employee.getAdress() + "," + employee.getGender() + "," + employee.getDateOfBirth() + "," + employee.getNumberPhone()
                        + "," + employee.getNumberCccd() + "," + employee.getEmail() + "," + employee.getLevel() + "," + employee.getSalary());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> readEmployeeCSV() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(EMPLOYEE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] temp;
            Employee employee;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                employee = new Employee(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), temp[3], temp[4], temp[5], temp[6], temp[7],
                        temp[8], Integer.parseInt(temp[9]), Double.parseDouble(temp[10]));
                employeeList.add(employee);
            }
        bufferedReader.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }


        @Override
    public void addEmployee() {
        int id =0;
        String name = null;
        int age = 0;
        String addres = null;
        String gender = null;
        String dateOfBirth = null;
        String numberPhone = null;
        String numberCccd = null;
        String email = null;
        int level = 0;
        Double salary = 0.0;
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
                System.out.println("Nhập cấp độ nhân viên: ");
                level = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("Nhập số lương: ");
                salary = Validation.salary();
            }catch (NumberFormatException e) {
                System.out.println("Lỗi rồi, nhập lại nhé!");
                check = true;
            }
        }while (check);

        Employee employee = new Employee(id, name, age, addres, gender, dateOfBirth, numberPhone, numberCccd, email, level, salary);
        employeeList.add(employee);
        writeEmployeeCSV();
        System.out.println("Đã thêm thành công nhân viên !");
    }

    @Override
    public void editEmployee() {
        int id =0;
        String name = null;
        int age = 0;
        String addres = null;
        String gender = null;
        String dateOfBirth = null;
        String numberPhone = null;
        String numberCccd = null;
        String email = null;
        int level = 0;
        Double salary = 0.0;
        boolean check = false;
        
        System.out.println("Nhập id của nhân viên bạn muốn chỉnh sửa: ");
        int idEdit = Integer.parseInt(scanner.nextLine());
        Employee employ = null;
        for (int i = 0; i < employeeList.size(); i++) {
            if (idEdit == employeeList.get(i).getId()) {
                employ = employeeList.get(i);
                System.out.println("Nhân viên có id bạn cần chỉnh sửa ở bên dưới, vui lòng nhập đúng yêu cầu!");
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
                employ.setId(id);
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
                employ.setName(name);
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
                employ.setAge(age);
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
                employ.setAdress(addres);
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
                employ.setGender(gender);
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
                employ.setDateOfBirth(dateOfBirth);
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
                employ.setNumberPhone(numberPhone);
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
                employ.setNumberCccd(numberCccd);
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
                employ.setEmail(email);
                do {
                    check = false;
                    try {
                        System.out.println("Nhập cấp độ nhân viên: ");
                        level = Integer.parseInt(scanner.nextLine());
                    }catch (NumberFormatException e) {
                        System.out.println("Lỗi rồi, nhập lại nhé!");
                        check = true;
                    }
                }while (check);
                employ.setLevel(level);
                do {
                    check = false;
                    try {
                        System.out.println("Nhập số lương: ");
                        salary = Validation.salary();
                    }catch (NumberFormatException e) {
                        System.out.println("Lỗi rồi, nhập lại nhé!");
                        check = true;
                    }
                }while (check);
                employ.setSalary(salary);
                writeEmployeeCSV();
                System.out.println("Nhân viên đã được chỉnh sửa thông tin!");
                check = true;
                break;
            }
        }if (check == false) {
            System.out.println("Không tìm ra id của nhân viên cần tìm!");
        }
    }

    @Override
    public void deleteEmployee() {
        System.out.println("Nhập tên của nhân viên mà bạn muốn xoá: ");
        String name = Validation.checkServiceName();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getName().equals(name)) {
                employeeList.remove(i);
                System.out.println("Bạn đã xoá nhân viên này!");
            }
        }
    }

    @Override
    public void display() {
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }
}
