package controller;


import model.CalculateImpl;
import model.ICalculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {

//    @Autowired
    ICalculate iCalculate = new CalculateImpl();

    @RequestMapping("/")
    public String calculate() {
        return "index";
    }
    @PostMapping("/Calculate")
    public String result(@RequestParam double num1, @RequestParam double num2, @RequestParam String calculate, Model model) {
        double result = iCalculate.calculation(num1, num2, calculate);
        model.addAttribute("result",result);
        return "index";
    }
}
