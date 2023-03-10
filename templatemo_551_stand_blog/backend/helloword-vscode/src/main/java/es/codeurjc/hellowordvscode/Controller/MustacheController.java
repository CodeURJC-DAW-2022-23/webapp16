package es.codeurjc.hellowordvscode.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import es.codeurjc.hellowordvscode.Entitys.Destination;
import es.codeurjc.hellowordvscode.Repositories.DestinationRepository;
import es.codeurjc.hellowordvscode.Services.DestinationService;

@Controller
public class MustacheController {

	@Autowired
	private DestinationService destinationService;

	@Autowired
    private DestinationRepository destinationRepository;


	@ModelAttribute
	@GetMapping("/index")
    public String getAllDestinations(Model model) {
        List<Destination> destinations = destinationRepository.findAll();
        model.addAttribute("destinations", destinations);
        return "destinations";   
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
				List<Destination> destinations = destinationRepository.findAll();
        		model.addAttribute("destinations", destinations);
				return "destino";
			} else {
				return "error";
			}
		
	}
	@GetMapping("/destino")
	public String destino(Model model) {
		return "destino";
	}
	
/* 
	
	@GetMapping("/destino")
	public String showDestination(@RequestParam(name = "nombre") String nombre, Model model) {
	  Optional<Destination> destination = destinationRepository.findByName(nombre);
	  model.addAttribute("destino", destination);
	  return "destino";
	}

*/


	
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

	@GetMapping("/añadirDestinos")
	public String añadirDestinos(Model model) {
		return "añadirDestinos";
	}

	@GetMapping("/configUsuarios")
	public String configUsuarios(Model model) {
		return "configUsuarios";
	}

	@GetMapping("/editarDestinos")
	public String editarDestinos(Model model) {
		return "editarDestinos";
	}

	
 
}
