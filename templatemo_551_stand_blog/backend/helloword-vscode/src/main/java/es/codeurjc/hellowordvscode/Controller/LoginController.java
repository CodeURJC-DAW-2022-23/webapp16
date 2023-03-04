package es.codeurjc.hellowordvscode.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
 
    @GetMapping("/login")
    public String login() {
        return "login";
    }
 
    @GetMapping("/loginerror")
    public String loginerror() {
        return "loginerror";
    }
    
}

