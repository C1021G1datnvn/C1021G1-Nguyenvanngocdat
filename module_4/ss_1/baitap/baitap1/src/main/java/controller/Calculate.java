package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculate {
    @GetMapping("/")
    public String myHome(){
        return "home";
    }
    @GetMapping("/home")
    public String calculate(@RequestParam double vnd, double usd, Model model) {
        double result = vnd * usd;
        model.addAttribute("result", result);
        return "home";
    }
}
