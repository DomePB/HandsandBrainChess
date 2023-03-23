package com.example.handandbrainchess;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greet(){
        return "test";
    }
}
