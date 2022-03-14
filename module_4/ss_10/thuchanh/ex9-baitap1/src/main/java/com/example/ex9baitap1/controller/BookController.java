package com.example.ex9baitap1.controller;


import com.example.ex9baitap1.model.Book;
import com.example.ex9baitap1.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

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


}
