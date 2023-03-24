package com.example.handandbrainchess;

import com.example.handandbrainchess.Service.ApplicationService;
import com.example.handandbrainchess.domain.Feld;
import com.example.handandbrainchess.domain.Figuren;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

    private final ApplicationService service;
    private Integer moveRow1;
    private Integer moveRow2;
    private Integer moveColumn1;
    private Integer moveColumn2;
    private Figuren[][] Feld;
    public WebController(ApplicationService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model m){
        Feld = service.getFeld();
        m.addAttribute("Feld",Feld);
        return "start";
    }
    @GetMapping("/move")
    @SendTo("/topic/greetings")
    public String move(Model m, @RequestParam("idrow") int idrow, @RequestParam("idcolumn") int idcolumn){
      //  System.out.println("Reihe: " + idrow + " Spalte: "+ idcolumn);
      //  m.addAttribute("Feld",service.getFeld());
        if(moveRow1 == null){
            moveRow1 = idrow;
        }
        else if(moveRow2 == null){
            moveRow2 = idrow;
        }
        if(moveColumn1 == null){
            moveColumn1 = idcolumn;
        }else if(moveColumn2 == null){
            moveColumn2 = idcolumn;
        }
        if(moveRow2 != null && moveColumn2 != null){
            service.move(moveRow1,moveColumn1,moveRow2,moveColumn2);
            moveRow1 = null;
            moveRow2 = null;
            moveColumn1 = null;
            moveColumn2= null;
        }
        return "redirect:/";
    }

    @PostMapping("/")
    public String init(){
        service.init();
        return "redirect:/";
    }
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greet(String id) {
        return id;
    }
}
