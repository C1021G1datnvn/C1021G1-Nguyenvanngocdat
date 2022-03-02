package case_study1.model.facility;

import case_study1.model.facility.Facility;

public class Room extends Facility {
    private String freeServiceIncluded;

    public Room() {

    }

    public Room(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public Room(String nameService, Double useArea, Double rentPrice, int maxPax, String rentType, String maintenance, String freeServiceIncluded) {
        super(nameService, useArea, rentPrice, maxPax, rentType, maintenance);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String toString() {
        return "Room{" +
                "nameService= " + getNameService() +
                ", useArea= " + getUseArea() +
                ", rentPrice= " + getRentPrice() +
                ", maxPax= " + getMaxPax() +
                ", rentType= " + getRentType() +
                ", maintenance= " + getMaintenance() +
                "freeServiceIncluded='" + freeServiceIncluded + '\'' +
                '}';
    }
}
