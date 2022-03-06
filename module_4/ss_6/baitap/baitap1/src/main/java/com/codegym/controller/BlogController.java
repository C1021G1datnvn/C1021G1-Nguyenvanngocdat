package com.codegym.controller;


import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping("/blog")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogList", blogService.selectAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createBlog(@ModelAttribute("blog") Blog blog) {
        blogService.create(blog);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blogList", new Blog());
        modelAndView.addObject("message", "Create blog successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Blog blog = blogService.selectById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView editBlog(Blog blog) {
        blogService.edit(blog);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "edit blog successfully");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable Long id) {
        Blog blog = blogService.selectById(id);
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
    public ModelAndView delete(Blog blog) {
        blogService.delete(blog);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "delete blog successfully");
        return modelAndView;
    }
}
