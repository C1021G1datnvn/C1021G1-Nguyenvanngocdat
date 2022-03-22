package com.codegym.case_study_module4.controller;


import com.codegym.case_study_module4.model.Employee;
import com.codegym.case_study_module4.service.IDivisionService;
import com.codegym.case_study_module4.service.IEducationService;
import com.codegym.case_study_module4.service.IEmployeeService;
import com.codegym.case_study_module4.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IEducationService educationService;

    @GetMapping("/employeeList")
    public ModelAndView showEmployeeList(@PageableDefault (value = 2)Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("employee/employeeList");
        modelAndView.addObject("employeeList", employeeService.findAll(pageable));
        modelAndView.addObject("position", positionService.findAll());
        modelAndView.addObject("division", divisionService.findAll());
        modelAndView.addObject("education", educationService.findAll());
        return modelAndView;
    }

    @GetMapping("/employeeCreate")
    public ModelAndView showCreateEmployee() {
        ModelAndView modelAndView = new ModelAndView("employee/createEmployee");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("position", positionService.findAll());
        modelAndView.addObject("division", divisionService.findAll());
        modelAndView.addObject("education", educationService.findAll());
        return modelAndView;
    }
    @PostMapping("/employeeCreate")
    public String createEmployee(Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "create successfully");
        return "redirect:/employeeList";
    }

    @GetMapping("/employeeEdit/{id}")
    public ModelAndView showEditEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("employee/editEmployee");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("position", positionService.findAll());
        modelAndView.addObject("division", divisionService.findAll());
        modelAndView.addObject("education", educationService.findAll());
        return modelAndView;
    }
    @PostMapping("/employeeEdit")
    public String editEmployee(Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "edit successfully");
        return "redirect:/employeeList";
    }

    @PostMapping("/employeeDelete")
    public String deleteEmployee(Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.remove(employee);
        redirectAttributes.addFlashAttribute("message", "delete successfully");
        return "redirect:/employeeList";
    }

}
