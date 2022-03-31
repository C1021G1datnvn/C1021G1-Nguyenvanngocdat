package com.example.thithu.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TypeOfService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idService;
    private String nameService;

    @OneToMany(mappedBy = "typeOfService", cascade = CascadeType.ALL)
    private Set<Transaction> transactions;

    public TypeOfService() {
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }
}
