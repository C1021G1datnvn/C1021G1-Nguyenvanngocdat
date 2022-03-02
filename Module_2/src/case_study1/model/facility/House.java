package case_study1.model.facility;

import case_study1.model.facility.Facility;

import java.util.Objects;

public class House extends Facility {
    private String roomStandard;
    private int floorNumber;

    public House() {

    }

    public House(String roomStandard, int floorNumber) {
        this.roomStandard = roomStandard;
        this.floorNumber = floorNumber;
    }

    public House(String nameService, Double useArea, Double rentPrice, int maxPax, String rentType, String maintenance, String roomStandard, int floorNumber) {
        super(nameService, useArea, rentPrice, maxPax, rentType, maintenance);
        this.roomStandard = roomStandard;
        this.floorNumber = floorNumber;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "House{" +
                "nameService= " + getNameService() +
                ", useArea= " + getUseArea() +
                ", rentPrice= " + getRentPrice() +
                ", maxPax= " + getMaxPax() +
                ", rentType= " + getRentType() +
                ", maintenance= " + getMaintenance() +
                "roomStandard='" + roomStandard + '\'' +
                ", floorNumber=" + floorNumber +
                '}';
    }

}
