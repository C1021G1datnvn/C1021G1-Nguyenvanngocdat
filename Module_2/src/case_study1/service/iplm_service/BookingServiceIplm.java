package case_study1.service.iplm_service;

import case_study1.model.BookingModel;
import case_study1.model.facility.Facility;
import case_study1.model.person.Customer;
import case_study1.service.interface_service.IBookingService;
import case_study1.untils.BookingComparator;

import java.util.*;

public class BookingServiceIplm implements IBookingService {
    public static Set<BookingModel> bookingModelSet = new TreeSet<>(new BookingComparator());
    public static List<Customer> customerList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static Map<Facility, Integer> integerMap = new LinkedHashMap<>();

    public Set<BookingModel> sendBooking() {
        return bookingModelSet;
    }
    @Override
    public void display() {
        for (BookingModel bookingModel : bookingModelSet) {
            System.out.println(bookingModel.toString());
        }
    }

    @Override
    public void addBooking() {
        int id = 1;
        if (!bookingModelSet.isEmpty()) {
            id = bookingModelSet.size();
        }
        Customer customer = choseCustomer();
        Facility facility = choseFacility();
        System.out.println("Nhập ngày thuê: ");
        String firstDay = scanner.nextLine();
        System.out.println("Nhập ngày trả: ");
        String lastDay = scanner.nextLine();
        BookingModel bookingModel = new BookingModel(id, firstDay, lastDay, customer, facility);
        bookingModelSet.add(bookingModel);
        System.out.println("Đã booking thành công!");
    }



    public static Customer choseCustomer() {
        System.out.println("Danh sách khách hàng: ");
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
        System.out.println("Nhập id khách hàng: ");
        boolean check = true;
        int id = Integer.parseInt(scanner.nextLine());
        while (check) {
            for (Customer customer : customerList) {
                if (id == customer.getId()) {
                    check = false;
                    return customer;
                }
            }
            if (check) {
                System.out.println("Nhập sai rồi, nhập lại!");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        return null;
    }

    public static Facility choseFacility() {
        System.out.println("Danh sách dịch vụ: ");
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : integerMap.entrySet()) {
            System.out.println(facilityIntegerEntry.getKey().toString());
        }
        System.out.println("Nhập id dịch vụ: ");
        boolean check = true;
        String id = scanner.nextLine();
        while (check) {
            for (Map.Entry<Facility, Integer> facilityIntegerEntry : integerMap.entrySet()) {
                if (id.equals(facilityIntegerEntry.getKey())) {
                    check = false;
                    return facilityIntegerEntry.getKey();
                }
            }
            if (check) {
                System.out.println("Nhập sai rồi, nhập lại!");
                id = scanner.nextLine();
            }
        }
        return null;
    }
}
