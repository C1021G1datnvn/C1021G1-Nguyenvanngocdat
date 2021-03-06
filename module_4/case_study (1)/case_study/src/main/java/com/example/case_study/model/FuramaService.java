package com.example.case_study.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class FuramaService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String serviceName;
    private Float serviceArea;
    private Float serviceCost;
    private Integer serviceMaxPeople;
    private String complimentary;
//    @ManyToMany
//    @JoinTable(name = "complimentary_service",
//            joinColumns = {@JoinColumn(name = "service_id")},
//            inverseJoinColumns = {@JoinColumn(name = "complimentary_id")})
//    private List<Complimentary> nameComplimentary;
    @ManyToOne
    @JoinColumn(name = "stand_room_id",referencedColumnName = "id")
    @JsonManagedReference
    private StandRoom standRoom;
    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "id")
    @JsonManagedReference
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "service_type_id",referencedColumnName = "id")
    @JsonManagedReference
    private ServiceType serviceType;



    public FuramaService() {
    }

    public FuramaService(String code, String serviceName, float serviceArea, float serviceCost,
                         int serviceMaxPeople, String complimentary,
                         StandRoom standRoom, RentType rentType, ServiceType serviceType) {
        this.code = code;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.complimentary = complimentary;
        this.standRoom = standRoom;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }


    public String getComplimentary() {
        return complimentary;
    }

    public void setComplimentary(String complimentary) {
        this.complimentary = complimentary;
    }

    public StandRoom getStandRoom() {
        return standRoom;
    }

    public void setStandRoom(StandRoom standRoom) {
        this.standRoom = standRoom;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Float getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Float serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Float getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Float serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

}
