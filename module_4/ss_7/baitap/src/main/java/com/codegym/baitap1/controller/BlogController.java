package com.codegym.baitap1.controller;


import com.codegym.baitap1.model.Blog;
import com.codegym.baitap1.service.IBlogService;
import com.codegym.baitap1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class BlogController {
    @Autowired
    IBlogService service;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("/blog")
    public ModelAndView showList(@PageableDefault(value = 1, sort = "id", direction = Sort.Direction.DESC) Pageable pageable ) {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogList", service.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("categoryList", categoryService.findAll());
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createBlog(@ModelAttribute("blog") Blog blog) {
        service.save(blog);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blogList", new Blog());
        modelAndView.addObject("message", "Create blog successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Blog blog = service.findById(id);
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;
    }

    @PostMapping("/edit")
    public String editBlog(Blog blog, RedirectAttributes redirectAttributes) {
        service.save(blog);
        redirectAttributes.addFlashAttribute("message", "edit blog successfully");
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable Long id) {
        Blog blog = service.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }
    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {
        service.remove(blog);
        redirectAttributes.addFlashAttribute("message", "delete blog successfully");
        return "redirect:/blog";
    }
//    @PostMapping("/search")
//    public ModelAndView search(@RequestParam String header, Model model) {
//
//
//       return null;
//    }


}
