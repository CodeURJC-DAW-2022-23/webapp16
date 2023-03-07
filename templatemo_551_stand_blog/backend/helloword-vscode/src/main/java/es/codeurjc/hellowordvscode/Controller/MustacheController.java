package es.codeurjc.hellowordvscode.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MustacheController {
	
	@GetMapping("/index")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/admin")
	public String admin(Model model) {
		return "admin";
	}

	@GetMapping("/destino")
	public String destino(Model model) {
		return "destino";
	}
	
	@GetMapping("/Login")
	public String login(Model model) {
		return "Login";
	}

	@GetMapping("/personalArea")
	public String personalArea(Model model, HttpServletRequest request) {
		model.addAttribute("username", request.getUserPrincipal().getName());
    	model.addAttribute("admin", request.isUserInRole("ADMIN"));
		return "personalArea";
	}

	@GetMapping("/Signup")
	public String signup(Model model) {
		return "Signup";
	}

	@GetMapping("/valoraciones")
	public String valoraciones(Model model) {
		return "valoraciones";
	}

	@GetMapping("/error")
	public String error(Model model) {
		return "error";
	}

	@GetMapping("/login")
    public String login() {
        return "login";
    }
 
    @GetMapping("/loginerror")
    public String loginerror() {
        return "loginerror";
    }

	
}
