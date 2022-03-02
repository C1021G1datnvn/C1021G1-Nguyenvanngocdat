package case_study1.service.iplm_service;

import case_study1.model.BookingModel;
import case_study1.model.ContractModel;
import case_study1.model.person.Customer;
import case_study1.service.interface_service.IContractService;

import java.util.*;

public class ContractServiceiplm implements IContractService {
    public static List<ContractModel> contractModels = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        Queue<BookingModel> bookingModelQueue = new LinkedList<>();
        Set<BookingModel> bookingModelSet = new BookingServiceIplm().sendBooking();
        for (BookingModel bookingModel : bookingModelSet) {
            bookingModelQueue.add(bookingModel);
        }
        BookingModel bookingModel = bookingModelQueue.poll();
        int customer = bookingModel.getIdCustomer();
        System.out.println("Đang tạo hợp đồng cho Booking có thông tin: " + bookingModel.toString());
        System.out.println("Đang tạo hợp đồng cho khách hàng có thông tin: " + customer);
        System.out.println("Nhập id hợp đồng: ");
        String id = scanner.nextLine();
        System.out.println("Nhập số tiền trả trước: ");
        String price = scanner.nextLine();
        System.out.println("Nhập số chi phí: ");
        String pay = scanner.nextLine();
        ContractModel contractModel = new ContractModel();
    }

    @Override
    public void newContract() {

    }

    @Override
    public void displayContract() {

    }

    @Override
    public void editContract() {

    }
}
