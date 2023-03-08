package es.codeurjc.hellowordvscode.Controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.hellowordvscode.Entitys.Destination;
import es.codeurjc.hellowordvscode.Repositories.DestinationRepository;
import es.codeurjc.hellowordvscode.Services.DestinationService;


@Controller
public class MustacheController {

	@Autowired
	private DestinationService destinationService;

	@Autowired
    private DestinationRepository destinationRepository;

	
	@GetMapping("/index")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/admin")
	public String admin(Model model) {
		return "admin";
	}

	@GetMapping("/destino/{name}")
	public String showDestino(Model model, @PathVariable String name) {
		Optional<Destination> destiny = destinationService.findByName(name);
		if (destiny.isPresent()) {
				model.addAttribute("destino", destiny.get());
				return "destino";
			} else {
				return "index";
			}
		
	}

	/*@GetMapping("/destino")
	public String destino(Model model) {
		return "destino";
	}*/

	
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping("/loginerror")
    public String loginerror() {
        return "loginerror";
    }

	@GetMapping("/personalArea")
	public String personalArea(Model model, HttpServletRequest request) {
		model.addAttribute("username", request.getUserPrincipal().getName());
    	model.addAttribute("admin", request.isUserInRole("ADMIN"));
		return "personalArea";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		return "signup";
	}

	@GetMapping("/valoraciones")
	public String valoraciones(Model model) {
		return "valoraciones";
	}

	@GetMapping("/error")
	public String error(Model model) {
		return "error";
	}
	
 
}
