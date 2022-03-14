package com.example.ex9baitap1.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "book")
    private List<BookCode> bookCodes;

    public Customer() {
    }

    public Customer(Long id, String name, List<BookCode> bookCodes) {
        this.id = id;
        this.name = name;
        this.bookCodes = bookCodes;
    }

    public Customer(String name, List<BookCode> bookCodes) {
        this.name = name;
        this.bookCodes = bookCodes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookCode> getBookCodes() {
        return bookCodes;
    }

    public void setBookCodes(List<BookCode> bookCodes) {
        this.bookCodes = bookCodes;
    }
}
