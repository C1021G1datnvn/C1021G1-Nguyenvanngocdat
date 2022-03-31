package com.example.ex10.controller;


import com.example.ex10.model.Product;
import com.example.ex10.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("product");
        modelAndView.addObject("productList", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailProduct(@PathVariable Long id) {
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("productDetail", product);
        return modelAndView;
    }



}
