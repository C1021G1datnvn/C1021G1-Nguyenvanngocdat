package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.Swap;

import java.util.Map;

@Controller
public class Dictionary {
    Swap swap = new Swap();
    Map<String, String> map = swap.swap();
    @GetMapping("/")
    public String swap() {
        return "home";
    }
    @GetMapping("/home")
    public String swapDictionary(@RequestParam String english, Model model) {
        for (Map.Entry<String, String> stringMap : map.entrySet()) {
            if (stringMap.getKey().equals(english)) {
                model.addAttribute("result", stringMap.getValue());
            }else {
                model.addAttribute("message", "không tìm thấy từ hợp lệ");
            }
        }
        return "swap";
    }
}
