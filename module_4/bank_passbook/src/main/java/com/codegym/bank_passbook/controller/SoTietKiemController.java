package com.codegym.bank_passbook.controller;


import com.codegym.bank_passbook.model.Customer;
import com.codegym.bank_passbook.model.SoTietKiem;
import com.codegym.bank_passbook.modelDTO.StkDto;
import com.codegym.bank_passbook.service.ICustomerService;
import com.codegym.bank_passbook.service.ISoTietKiemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SoTietKiemController {

    @Autowired
    private ISoTietKiemService soTietKiemService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/bank")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("soTietKiemList", soTietKiemService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        List<Customer> customer = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("soTietKiem", new StkDto());
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/create")
    public String createBank(@Valid @ModelAttribute StkDto stkDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        new StkDto().validate(stkDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        } else {
            SoTietKiem soTietKiem = new SoTietKiem();
            BeanUtils.copyProperties(stkDto, soTietKiem);
            soTietKiemService.save(soTietKiem);
            redirectAttributes.addFlashAttribute("message", "Thêm thành công!");
            return "redirect:/bank";
        }

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        soTietKiemService.findById(id);
        customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("soTietKiem", soTietKiemService.findById(id));
        modelAndView.addObject("customer", customerService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editBank(SoTietKiem soTietKiem, RedirectAttributes redirectAttributes) {
        soTietKiemService.save(soTietKiem);
        redirectAttributes.addFlashAttribute("message", "Đã edit thành công");
        return "redirect:/bank";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable Long id) {
        soTietKiemService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("soTietKiem", soTietKiemService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteBank(SoTietKiem soTietKiem, RedirectAttributes redirectAttributes) {
        soTietKiemService.remove(soTietKiem);
        redirectAttributes.addFlashAttribute("massage", "Đã delete thành công");
        return "redirect:/bank";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showView(@PathVariable Long id) {
        soTietKiemService.findById(id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("soTietKiem", soTietKiemService.findById(id).get());
        return modelAndView;
    }
}
