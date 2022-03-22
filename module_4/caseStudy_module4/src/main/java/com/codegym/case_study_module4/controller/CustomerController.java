package com.codegym.case_study_module4.controller;


import com.codegym.case_study_module4.dto.CustomerDTO;
import com.codegym.case_study_module4.model.Customer;
import com.codegym.case_study_module4.service.ICustomerService;
import com.codegym.case_study_module4.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/")
    public ModelAndView showHomePage() {
        ModelAndView modelAndView = new ModelAndView("HomePage");
        return modelAndView;
    }

    @GetMapping("/customerList")
    public ModelAndView showCustomer(@PageableDefault(value = 4) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/customer/listCustomer");
        modelAndView.addObject("customerList", customerService.findAll(pageable));
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        return modelAndView;
    }


    @GetMapping("/customerCreate")
    public ModelAndView showCreateCustomer() {
        ModelAndView modelAndView = new ModelAndView("/customer/createCustomer");
        modelAndView.addObject("customerDTO", new CustomerDTO());
        modelAndView.addObject("customerType", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/customerCreate")
    public String createCustomer(@Valid CustomerDTO customerDTO, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model) {
        new CustomerDTO().validate(customerDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerType", customerTypeService.findAll());
            return "/customer/createCustomer";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDTO, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "create successfully");
        }
        return "redirect:/customerList";
    }



    @GetMapping("/customerEdit/{id}")
    public ModelAndView showEditCustomer(@PathVariable Integer id) {
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/customer/editCustomer");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("customerType", customerTypeService.findAll());
        return modelAndView;
    }
    @PostMapping("/customerEdit")
    public String editCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Edit successfully");
        return "redirect:/customerList";
    }

//    @GetMapping("/customerDelete/{id}")
//    public ModelAndView showDeleteCustomer(@PathVariable Integer id) {
//        Customer customer = customerService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("/customer/deleteCustomer");
//        modelAndView.addObject("customer", customer);
//        modelAndView.addObject("customerType", customerTypeService.findAll());
//        return modelAndView;
//    }


// cos 2 cachs để viết delete

    // 1 là viết bth 2 là viết bằng modal- đang viết theo kiểu modal
    @PostMapping("/customerDelete")
    public String deleteCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.remove(customer);
        redirectAttributes.addFlashAttribute("message", "delete successfully");
        return "redirect:/customerList";
    }

    @PostMapping("/searchCustomer")
    public String searchCustomer(@RequestParam  String name,@PageableDefault(value = 4) Pageable pageable, Model model){
        Page<Customer> searchCustomer = customerService.searchByName(name, pageable);
        model.addAttribute("searchName", name);
        model.addAttribute("customer", searchCustomer);
        return "customer/searchCustomer";
    }


}
