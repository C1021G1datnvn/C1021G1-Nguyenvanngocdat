package com.example.thuchanh2.controller;


import com.example.thuchanh2.model.Province;
import com.example.thuchanh2.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProvinceController {
    @Autowired
    IProvinceService provinceService;

    @GetMapping("/province")
    public ModelAndView showProvince(){
        Iterable<Province> province = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("province/list");
        modelAndView.addObject("provinceList", province);
        return modelAndView;
    }
    @GetMapping("/create-province")
    public ModelAndView showCreateProvince() {
        ModelAndView modelAndView = new ModelAndView("province/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }
    @PostMapping("/create-province")
    public String createProvince(Province province, RedirectAttributes redirectAttributes) {
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "create province successfully");
        return "redirect:/province";
    }
    @GetMapping("/edit-province/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        if (provinceService.findById(id).isPresent()) {
            Province province = provinceService.findById(id).orElse(null);
            ModelAndView modelAndView = new ModelAndView("province/edit");
            modelAndView.addObject("province", province);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("province/error");
            return modelAndView;
        }
    }
    @PostMapping("/edit-province")
    public String editProvince(Province province, RedirectAttributes redirectAttributes) {
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "edit province successfully");
        return "redirect:/province";
    }
    @GetMapping("/delete-province/{id}")
    public ModelAndView showDelete(@PathVariable Long id) {
        if (provinceService.findById(id).isPresent()) {
            Province province = provinceService.findById(id).orElse(null);
            ModelAndView modelAndView = new ModelAndView("province/delete");
            modelAndView.addObject("province", province);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("province/error");
            return modelAndView;
        }
    }
    @PostMapping("/delete-province")
    public String deleteProvince(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        provinceService.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete province successfully");
        return "redirect:/province";
    }


}
