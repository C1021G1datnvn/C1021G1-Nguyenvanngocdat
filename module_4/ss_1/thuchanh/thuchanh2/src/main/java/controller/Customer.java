package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Customer {
    @RequestMapping("/customer")
    public String showList() {
        return "customer/list.jsp";
    }
}
