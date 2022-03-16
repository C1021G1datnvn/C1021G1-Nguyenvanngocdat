package com.codegym.baitap1.controller;


import com.codegym.baitap1.model.Category;
import com.codegym.baitap1.service.ICategoryService;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@RestController
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> showList() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/findCategory/{id}")
    public ResponseEntity<Category> showCategory(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
    }













//    @GetMapping("/create-category")
//    public ModelAndView showCreate() {
//        ModelAndView modelAndView = new ModelAndView("category/create");
//        modelAndView.addObject("categoryList", categoryService.findAll());
//        modelAndView.addObject("category", new Category());
//        return modelAndView;
//    }
//
//    @PostMapping("/create-category")
//    public ModelAndView createCategory(@ModelAttribute("category") Category category) {
//        categoryService.save(category);
//        ModelAndView modelAndView = new ModelAndView("category/create");
//        modelAndView.addObject("categoryList", new Category());
//        modelAndView.addObject("message", "Create category successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/edit-category/{id}")
//    public ModelAndView showEdit(@PathVariable Long id) {
//        Category category = categoryService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("category/edit");
//        modelAndView.addObject("category", category);
//        return modelAndView;
//    }
//
//    @PostMapping("/edit-category")
//    public String editCategory(Category category, RedirectAttributes redirectAttributes) {
//        categoryService.save(category);
//        redirectAttributes.addFlashAttribute("message", "edit category successfully");
//        return "redirect:/category";
//    }
//
//    @GetMapping("/delete-category/{id}")
//    public ModelAndView showDelete(@PathVariable Long id) {
//        Category category = categoryService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("category/delete");
//        modelAndView.addObject("category", category);
//        return modelAndView;
//    }
//    @PostMapping("/delete-category")
//    public String delete(Category category, RedirectAttributes redirectAttributes) {
//        categoryService.remove(category);
//        redirectAttributes.addFlashAttribute("message", "delete category successfully");
//        return "redirect:/category";
//    }
}
