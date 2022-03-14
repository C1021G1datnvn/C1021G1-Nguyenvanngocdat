package com.example.ex9baitap1.controller;


import com.example.ex9baitap1.service.IBookCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookCodeController {
    @Autowired
    private IBookCodeService codeService;

    @GetMapping("/code")
    public ModelAndView showCode() {
        ModelAndView modelAndView = new ModelAndView("bookcode/show");
        modelAndView.addObject("bookcode", codeService.findAll());
        return modelAndView;
    }

}
