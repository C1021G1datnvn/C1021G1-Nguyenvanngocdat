package com.example.practice.controller;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/login")
    public ModelAndView showLoginForm() {
        ModelAndView modelAndView = new ModelAndView("/user");
        modelAndView.addObject("user", new com.example.practice.model.User());
        return modelAndView;
    }

    @PostMapping("/doLogin")
    public ModelAndView doLogin(@ModelAttribute User user) {
        if(user.getUsername().equals("phamduythuan87@gmail.com") && user.getPassword().equals("231203")){
            ModelAndView modelAndView = new ModelAndView("/success");
            modelAndView.addObject("user",user);
            return modelAndView;
        }
        return new ModelAndView("/error");
    }
}
