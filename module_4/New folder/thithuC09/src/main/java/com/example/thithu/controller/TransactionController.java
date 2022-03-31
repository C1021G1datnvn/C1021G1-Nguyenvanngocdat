package com.example.thithu.controller;

import com.example.thithu.dto.TransactionDto;
import com.example.thithu.model.Transaction;
import com.example.thithu.service.ICustomerService;
import com.example.thithu.service.ITransactionService;
import com.example.thithu.service.ITypeOfService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TransactionController {
    @Autowired
    private ITransactionService transactionService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ITypeOfService typeOfService;

    @GetMapping("/transaction")
    public ModelAndView showList(@PageableDefault(value = 3)Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("listTransaction");
        modelAndView.addObject("transactionList", transactionService.findAll(pageable));
        modelAndView.addObject("customerList", customerService.findAll());
        modelAndView.addObject("typeOfServiceList", typeOfService.findAll());
        return modelAndView;
    }
    @GetMapping("/createTransaction")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("createTransaction");
        modelAndView.addObject("transactionDto", new TransactionDto());
        modelAndView.addObject("customerList", customerService.findAll());
        modelAndView.addObject("typeOfServiceList", typeOfService.findAll());
        return modelAndView;
    }
    @PostMapping("/createTransaction")
    public String create(@Valid TransactionDto transactionDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        new TransactionDto().validate(transactionDto, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("customerList", customerService.findAll());
            model.addAttribute("typeOfServiceList", typeOfService.findAll());
            return "createTransaction";
        }else {
            Transaction transaction = new Transaction();
            BeanUtils.copyProperties(transactionDto, transaction);
            transactionService.save(transaction);
            redirectAttributes.addFlashAttribute("message", "create successfully");
        }
        return "redirect:/transaction";
    }
    @GetMapping("/viewTransaction/{id}")
    public ModelAndView showDetailTransaction(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("viewTransaction");
        modelAndView.addObject("transaction", transactionService.findById(id));
        modelAndView.addObject("customerList", customerService.findAll());
        modelAndView.addObject("typeOfServiceList", typeOfService.findAll());
        return modelAndView;
    }
    @PostMapping("/delete")
    public String deleteTransaction(@RequestParam ("id") Integer id, RedirectAttributes redirectAttributes) {
        transactionService.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete successfully");
        return "redirect:/transaction";
    }
    @GetMapping("/search")
    public String search(@RequestParam(name = "search", required = false) String name, Model model) {
        model.addAttribute("transactionList", transactionService.search(name));
        return "listTransaction";
    }
}
