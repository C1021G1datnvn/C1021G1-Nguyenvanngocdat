package com.example.thuchanh2.controller;


import com.example.thuchanh2.model.Customer;
import com.example.thuchanh2.service.ICustomerService;
import com.example.thuchanh2.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    IProvinceService provinceService;

    @GetMapping("/customer")
    public ModelAndView showList(@PageableDefault(value = 2)Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customerList", customerService.findAll(pageable));
        return modelAndView;
    }
    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @PostMapping("/create-customer")
    public String saveCustomer(Customer customer) {
        customerService.save(customer);
//        model.addAttribute("message", "Create Successfully");
        return "redirect:/customer";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable Long id) {
        if (customerService.findById(id).isPresent()) {
            Customer customer1 = (Customer) customerService.findById(id).get();
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("customer", customer1);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }
    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete customer successfully");
        return "redirect:/customer";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showUpdate(@PathVariable Long id) {
        if (customerService.findById(id).isPresent()) {
            Customer customer = (Customer) customerService.findById(id).orElse(null);
            ModelAndView modelAndView = new ModelAndView("update");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }
    @PostMapping("edit")
    public String updateCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "edit customer successfully");
        return "redirect:/customer";
    }
    @PostMapping("/search")
    public String searchCustomer(@PathVariable String name, RedirectAttributes redirectAttributes) {
        customerService.search(name);
        redirectAttributes.addFlashAttribute("message", "search successfully");
        return "redirect:/customer";
    }


}
