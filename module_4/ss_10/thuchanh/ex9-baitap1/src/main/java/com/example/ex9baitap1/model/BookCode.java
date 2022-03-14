package com.example.ex9baitap1.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class BookCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer codeBook;

    @ManyToOne
    @JoinColumn(name = "code_book", referencedColumnName = "id")
    private Book book;


    public BookCode() {
    }

    public BookCode(Long id, Integer codeBook, Book book) {
        this.id = id;
        this.codeBook = codeBook;
        this.book = book;
    }

    public BookCode(Integer codeBook, Book book) {
        this.codeBook = codeBook;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(Integer codeBook) {
        this.codeBook = codeBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
