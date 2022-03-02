package controller;

import model.InfoSettings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/setting")
public class SettingController {

    @GetMapping("/home")
    public ModelAndView settings() {
        ModelAndView model = new ModelAndView("home", "setting", new InfoSettings());
        List<String> listLanguages = new ArrayList<>();
        listLanguages.add("English");
        listLanguages.add("VietNam");
        listLanguages.add("Chinese");
        listLanguages.add("Japanese");
        model.addObject("listLanguages",listLanguages);
        List<Integer> listSize = new ArrayList<>();
        listSize.add(5);
        listSize.add(10);
        listSize.add(15);
        listSize.add(25);
        listSize.add(50);
        listSize.add(100);
        model.addObject("listSize", listSize);
        InfoSettings infoSettings = new InfoSettings();
        model.addObject("setting", infoSettings);
        return model;
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute("setting") InfoSettings infoSettings, Model model){
        model.addAttribute("languages", infoSettings.getLanguages());
        model.addAttribute("size", infoSettings.getSize());
        model.addAttribute("filter", infoSettings.isFilter());
        model.addAttribute("signature", infoSettings.getSignature());
        return "result";
    }

}
