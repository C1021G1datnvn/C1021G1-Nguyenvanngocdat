package com.example.case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


import java.util.List;
@Entity
public class ServiceType {
    public List<FuramaService> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<FuramaService> serviceList) {
        this.serviceList = serviceList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serviceTypeName;
    @OneToMany(mappedBy = "serviceType")
    @JsonBackReference
    private List<FuramaService> serviceList;

    public ServiceType() {
    }

    public ServiceType(Long serviceTypeId, String serviceTypeName) {
        this.id = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long serviceTypeId) {
        this.id = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }
}
