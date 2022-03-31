package com.codegym.bank_passbook.controller;


import com.codegym.bank_passbook.model.Customer;
import com.codegym.bank_passbook.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customer")
    public ModelAndView showCustomerList() {
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customerList", customerService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreateCustomer() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public String createCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Thêm thành công!");
        return "redirect:/customer";
    }
    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }
    @PostMapping("/edit-customer")
    public String editCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "edit thành công");
        return "redirect:/customer";
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDelete(@PathVariable Long id){
        customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer/delete");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("delete-customer")
    public String deleteCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.remove(customer);
        redirectAttributes.addFlashAttribute("message", "delete thành công");
        return "redirect:/customer";
    }

}
