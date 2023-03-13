package es.codeurjc.hellowordvscode.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import es.codeurjc.hellowordvscode.Entitys.Destination;
import es.codeurjc.hellowordvscode.Entitys.Trip;
import es.codeurjc.hellowordvscode.Repositories.DestinationRepository;
import es.codeurjc.hellowordvscode.Repositories.TripRepository;
import es.codeurjc.hellowordvscode.Services.DestinationService;

@Controller
public class MustacheController {

	@Autowired
	private DestinationService destinationService;

	@Autowired
    private DestinationRepository destinationRepository;

	@Autowired
    private TripRepository tripRepository;


	@ModelAttribute
	@GetMapping("/index")
    public String getAllDestinations(Model model) {
        Page<Destination> destinations = destinationRepository.findAll(PageRequest.of(0,10));
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
				List<Trip> trips = tripRepository.findByDestination(destiny);
				model.addAttribute("trips", trips);
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

	@GetMapping("/logout")
		public String log(Model model) {
			return "logout";
		}

	
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
