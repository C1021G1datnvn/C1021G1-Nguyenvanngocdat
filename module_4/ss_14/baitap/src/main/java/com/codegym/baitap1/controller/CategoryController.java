package com.codegym.baitap1.controller;


import com.codegym.baitap1.model.Category;
import com.codegym.baitap1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("categoryList", categoryService.findAll());
        return modelAndView;
    }


    @GetMapping("/create-category")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("categoryList", categoryService.findAll());
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create-category")
    public ModelAndView createCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("categoryList", new Category());
        modelAndView.addObject("message", "Create category successfully");
        return modelAndView;
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("category/edit");
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @PostMapping("/edit-category")
    public String editCategory(Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "edit category successfully");
        return "redirect:/category";
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView showDelete(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("category/delete");
        modelAndView.addObject("category", category);
        return modelAndView;
    }
    @PostMapping("/delete-category")
    public String delete(Category category, RedirectAttributes redirectAttributes) {
        categoryService.remove(category);
        redirectAttributes.addFlashAttribute("message", "delete category successfully");
        return "redirect:/category";
    }
}
