package com.example.thuchanh2.controller;


import com.example.thuchanh2.model.SmartPhone;
import com.example.thuchanh2.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class SmartPhoneController {

    @Autowired
    private ISmartPhoneService smartPhoneService;

    @GetMapping("/smartphone")
    public ModelAndView showSmartPhone() {
        ModelAndView modelAndView = new ModelAndView("smartPhone/list");
        modelAndView.addObject("smartPhoneList", smartPhoneService.findAll());
        return modelAndView;
    }

    @PostMapping("/smartphones")
    public ResponseEntity<SmartPhone> createSmartPhone(@RequestBody SmartPhone smartPhone) {
        smartPhoneService.save(smartPhone);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/smartphones")
    public ResponseEntity<Iterable<SmartPhone>> allPhones() {
        return new ResponseEntity<>(smartPhoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/smartphones/{id}" )
    public ResponseEntity<List<SmartPhone>> deleteSmartphone(@PathVariable Long id) {
        Optional<SmartPhone> smartphoneOptional = smartPhoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhoneService.remove(id);
        List<SmartPhone> smartPhones = smartPhoneService.findAll();
        return new ResponseEntity<>(smartPhones, HttpStatus.OK);
    }



}
