package case_study1.model.facility;

import java.util.Objects;

public abstract class Facility {
    private String nameService;
    private Double useArea;
    private Double rentPrice;
    private int maxPax;
    private String rentType;
    private String maintenance;

    public Facility() {

    }

    public Facility(String nameService, Double useArea, Double rentPrice, int maxPax, String rentType, String maintenance) {
        this.nameService = nameService;
        this.useArea = useArea;
        this.rentPrice = rentPrice;
        this.maxPax = maxPax;
        this.rentType = rentType;
        this.maintenance = maintenance;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Double getUseArea() {
        return useArea;
    }

    public void setUseArea(Double useArea) {
        this.useArea = useArea;
    }

    public Double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public int getMaxPax() {
        return maxPax;
    }

    public void setMaxPax(int maxPax) {
        this.maxPax = maxPax;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return maxPax == facility.maxPax && nameService.equals(facility.nameService) && useArea.equals(facility.useArea) && rentPrice.equals(facility.rentPrice) && rentType.equals(facility.rentType) && maintenance.equals(facility.maintenance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameService, useArea, rentPrice, maxPax, rentType, maintenance);
    }
}
