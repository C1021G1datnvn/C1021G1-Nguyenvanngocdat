package com.example.thic10_module4.controller;

import com.example.thic10_module4.dto.ProductDto;
import com.example.thic10_module4.model.Product;
import com.example.thic10_module4.service.IProductService;
import com.example.thic10_module4.service.ITypeProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ITypeProductService typeProductService;

    @GetMapping("/product")
    public ModelAndView showList(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("listProduct");
        modelAndView.addObject("productList", productService.findAll(pageable));
        modelAndView.addObject("typeProductList", typeProductService.findAll());
        return modelAndView;
    }

    @GetMapping("/createProduct")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("createProduct");
        modelAndView.addObject("productDto", new ProductDto());
        modelAndView.addObject("typeProductList", typeProductService.findAll());
        return modelAndView;
    }

    @PostMapping("createProduct")
    public String createProduct(@Valid ProductDto productDto, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model) {
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("typeProductList", typeProductService.findAll());
            return "createProduct";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            productService.save(product);
            redirectAttributes.addFlashAttribute("message", "create successfully");
            return "redirect:/product";
        }

    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(Long id, RedirectAttributes redirectAttributes) {
        productService.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete successfully");
        return "redirect:/product";
    }

    @GetMapping("/editProduct/{id}")
    public ModelAndView showEdit(@PathVariable Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView("editProduct");
        modelAndView.addObject("typeProductList", typeProductService.findAll());
        Product product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        model.addAttribute("productDto", productDto);
        return modelAndView;
    }

    @PostMapping("/editProduct")
    public String editProduct(@Valid ProductDto productDto, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, Model model) {
        new ProductDto().validate(productDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("typeProductList", typeProductService.findAll());
            return "editProduct";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            productService.save(product);
            redirectAttributes.addFlashAttribute("message", "edit successfully");
            return "redirect:/product";
        }
    }
    @GetMapping("/search")
    public String searchEmployee(@RequestParam(name = "name", required = false) String name,
                                 @PageableDefault(value = 5) Pageable pageable, Model model){
        model.addAttribute("productList", productService.searchByName(name,pageable));
        return "/listProduct";
    }


}
