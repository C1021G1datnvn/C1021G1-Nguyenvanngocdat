package case_study1.model.facility;

import case_study1.model.facility.Facility;

public class Villa extends Facility {
    private String roomStandard;
    private Double poolArea;
    private int floorNumber;

    public Villa() {

    }

    public Villa(String roomStandard, Double poolArea, int floorNumber) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floorNumber = floorNumber;
    }

    public Villa(String nameService, Double useArea, Double rentPrice, int maxPax, String rentType, String maintenance, String roomStandard, Double poolArea, int floorNumber) {
        super(nameService, useArea, rentPrice, maxPax, rentType, maintenance);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floorNumber = floorNumber;
    }



    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "nameService= " + getNameService() +
                ", useArea= " + getUseArea() +
                ", rentPrice= " + getRentPrice() +
                ", maxPax= " + getMaxPax() +
                ", rentType= " + getRentType() +
                ", maintenance= " + getMaintenance() +
                ", roomStandard='" + roomStandard + '\'' +
                ", poolArea='" + poolArea + '\'' +
                ", floorNumber=" + floorNumber +
                '}';
    }
}
