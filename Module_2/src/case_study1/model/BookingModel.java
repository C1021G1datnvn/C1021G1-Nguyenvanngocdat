package case_study1.model;

import case_study1.model.facility.Facility;
import case_study1.model.person.Customer;

public class BookingModel {
    private int idBooking;
    private String firstDay;
    private String lastDay;
    private int idCustomer;
    private String serviceName;
    private String typeService;

    public BookingModel(int id, String firstDay, String lastDay, Customer customer, Facility facility) {
    }

    public BookingModel(int idBooking, String firstDay, String lastDay, int idCustomer, String serviceName, String typeService) {
        this.idBooking = idBooking;
        this.firstDay = firstDay;
        this.lastDay = lastDay;
        this.idCustomer = idCustomer;
        this.serviceName = serviceName;
        this.typeService = typeService;
    }


    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public String getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(String firstDay) {
        this.firstDay = firstDay;
    }

    public String getLastDay() {
        return lastDay;
    }

    public void setLastDay(String lastDay) {
        this.lastDay = lastDay;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    @Override
    public String toString() {
        return "BookingModel{" +
                "idBooking=" + idBooking +
                ", firstDay='" + firstDay + '\'' +
                ", lastDay='" + lastDay + '\'' +
                ", idCustomer=" + idCustomer +
                ", serviceName='" + serviceName + '\'' +
                ", typeService='" + typeService + '\'' +
                '}';
    }
}
