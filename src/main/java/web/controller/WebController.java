package web.controller;

import Service.ApplicationService;
import domain.Feld;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private final ApplicationService service;

    public WebController(ApplicationService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model m){
        m.addAttribute("Feld",service.getFeld());
        return "start";
    }
}
