package com.example.handandbrainchess;

import com.example.handandbrainchess.Service.ApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    private final ApplicationService service;

    public WebController(ApplicationService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model m){
        service.init();
        m.addAttribute("Feld",service.getFeld());
        return "start";
    }
    @GetMapping("/move")
    public String move(Model m, @RequestParam("idrow") int idrow, @RequestParam("idcolumn") int idcolumn){
        System.out.println("Reihe: " + idrow + " Spalte: "+ idcolumn);
        m.addAttribute("Feld",service.getFeld());
        return "start";
    }
}
