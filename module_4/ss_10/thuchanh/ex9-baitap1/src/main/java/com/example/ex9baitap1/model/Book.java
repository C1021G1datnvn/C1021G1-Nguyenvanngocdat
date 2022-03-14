package com.example.ex9baitap1.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer currentQuantity;
    @OneToMany(mappedBy = "book")
    private List<BookCode> bookCode;

    public Book() {
    }

    public Book(Long id, String name, Integer currentQuantity, List<BookCode> bookCode) {
        this.id = id;
        this.name = name;
        this.currentQuantity = currentQuantity;
        this.bookCode = bookCode;
    }

    public Book(String name, Integer currentQuantity, List<BookCode> bookCode) {
        this.name = name;
        this.currentQuantity = currentQuantity;
        this.bookCode = bookCode;
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

    public Integer getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(Integer currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public List<BookCode> getBookCode() {
        return bookCode;
    }

    public void setBookCode(List<BookCode> bookCode) {
        this.bookCode = bookCode;
    }
}

