package com.example.ex9baitap1.controller;


import com.example.ex9baitap1.model.Book;
import com.example.ex9baitap1.model.BookCode;
import com.example.ex9baitap1.service.IBookCodeService;
import com.example.ex9baitap1.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBookCodeService bookCodeService;

    @GetMapping("/book")
    public ModelAndView showListBook() {
        ModelAndView modelAndView = new ModelAndView("book/list");
        modelAndView.addObject("bookList", bookService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-book")
    public ModelAndView showCreateBook() {
        ModelAndView modelAndView = new ModelAndView("book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/create-book")
    public String createBook(Book book, RedirectAttributes redirectAttributes) {
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message", "create successfully");
        return "redirect:/book";
    }

    @GetMapping("/delete-book/{id}")
    public ModelAndView showDeleteBook(@PathVariable Long id) {
        Book book = bookService.findById(id);
        ModelAndView modelAndView = new ModelAndView("book/delete");
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @PostMapping("/delete-book")
    public String deleteBook(Book book, RedirectAttributes redirectAttributes) {
        bookService.remove(book);
        redirectAttributes.addFlashAttribute("message", "delete successfully");
        return "redirect:/book";
    }

    @GetMapping("/borrow-book/{id}")
    public String borrowBook(@PathVariable Long id, Model model) throws Exception {
        Book book = bookService.findById(id);
        if (book.getCurrentQuantity() > 0) {
            book.setCurrentQuantity(book.getCurrentQuantity() - 1);
            bookService.save(book);
            int codeBook = (int) Math.floor((Math.random() * 89999) + 10000);
            BookCode bookCode = new BookCode(codeBook, book);
            bookCodeService.save(bookCode);
            model.addAttribute("codeBook", codeBook);
        }else {
            throw new Exception();
        }
        return "book/borrow";
    }

    @GetMapping("/back-book")
    public ModelAndView backBook() {
        ModelAndView modelAndView = new ModelAndView("book/comeBack");
        return modelAndView;
    }

    @PostMapping("/back-book")
    public String backBookPost( @RequestParam String input) {
        List<BookCode> bookCodeList = (List<BookCode>) bookCodeService.findAll();
        for (BookCode bookCode : bookCodeList) {
            if (bookCode.getCodeBook() == Long.parseLong(input)) {
                Long id = bookCode.getBook().getId();
                Book book = bookService.findById(id);
                book.setCurrentQuantity(book.getCurrentQuantity() + 1);
                bookService.save(book);
            }
        }
        return "redirect:/book";
    }

    @ExceptionHandler(Exception.class)
    public void TodoException(Exception ex) {
        System.out.println("Lỗi")   ;
    }
}
