package web.controller;

import domain.Feld;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {


    @GetMapping("/")
    public String index(Model m){
        m.addAttribute("Feld");
        return "start";
    }
}
