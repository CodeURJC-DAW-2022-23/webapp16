package es.codeurjc.hellowordvscode.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
 
    // @GetMapping("/")
    // public String index() {
    //     return "index";
    // }
 
    // @GetMapping("/login")
    // public String login() {
    //     return "login";
    // }
 
    // @GetMapping("/loginerror")
    // public String loginerror() {
    //     return "loginerror";
    // }
    
    // @GetMapping("/personalArea")
    // public String privatePage(Model model, HttpServletRequest request) {
    //     model.addAttribute("username", request.getUserPrincipal().getName());
    //     model.addAttribute("admin", request.isUserInRole("ADMIN"));
 
    //     return "personalArea";
    // }
}

