package com.codegym.baitap1.controller;


import com.codegym.baitap1.model.Blog;
import com.codegym.baitap1.service.IBlogService;
import com.codegym.baitap1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class BlogController {

    @Autowired
    IBlogService service;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("/blog")
    public ResponseEntity<Iterable<Blog>> showBlog() {
        List<Blog> listBLog = service.findAll();
        if (listBLog.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listBLog, HttpStatus.OK);
    }

    @GetMapping("/findBlog/{id}")
    public ResponseEntity<Blog> findBlog(@PathVariable Long id) {
        Optional<Blog> blog = service.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
        service.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Long id) {
        Optional<Blog> optionalBlog = service.findById(id);
        if (!optionalBlog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("edit/{id}")
    public ResponseEntity<Blog> editBlog(@PathVariable Long id, @RequestBody Blog blog) {
        Optional<Blog> optionalBlog = service.findById(id);
        if (!optionalBlog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        optionalBlog.get().setHeader(blog.getHeader());
        optionalBlog.get().setBody(blog.getBody());
        optionalBlog.get().setFooter(blog.getFooter());
        service.save(optionalBlog.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }













//    @GetMapping("/create")
//    public ModelAndView showCreate() {
//        ModelAndView modelAndView = new ModelAndView("create");
//        modelAndView.addObject("categoryList", categoryService.findAll());
//        modelAndView.addObject("blog", new Blog());
//        return modelAndView;
//    }
//
//    @PostMapping("/create")
//    public ModelAndView createBlog(@ModelAttribute("blog") Blog blog) {
//        service.save(blog);
//        ModelAndView modelAndView = new ModelAndView("create");
//        modelAndView.addObject("blogList", new Blog());
//        modelAndView.addObject("message", "Create blog successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView showEdit(@PathVariable Long id) {
//        Blog blog = service.findById(id);
//            ModelAndView modelAndView = new ModelAndView("edit");
//            modelAndView.addObject("blog", blog);
//            return modelAndView;
//    }
//
//    @PostMapping("/edit")
//    public String editBlog(Blog blog, RedirectAttributes redirectAttributes) {
//        service.save(blog);
//        redirectAttributes.addFlashAttribute("message", "edit blog successfully");
//        return "redirect:/blog";
//    }
//
//    @GetMapping("/delete/{id}")
//    public ModelAndView showDelete(@PathVariable Long id) {
//        Blog blog = service.findById(id);
//        if (blog != null) {
//            ModelAndView modelAndView = new ModelAndView("delete");
//            modelAndView.addObject("blog", blog);
//            return modelAndView;
//        }else {
//            ModelAndView modelAndView = new ModelAndView("error");
//            return modelAndView;
//        }
//    }
//    @PostMapping("/delete")
//    public String delete(Blog blog, RedirectAttributes redirectAttributes) {
//        service.remove(blog);
//        redirectAttributes.addFlashAttribute("message", "delete blog successfully");
//        return "redirect:/blog";
//    }
//    @PostMapping("/search")
//    public ModelAndView search(@RequestParam String header, Model model) {
//
//
//       return null;
//    }

}
