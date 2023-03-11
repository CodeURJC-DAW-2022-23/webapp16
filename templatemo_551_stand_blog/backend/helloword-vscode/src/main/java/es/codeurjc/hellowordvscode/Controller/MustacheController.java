package es.codeurjc.hellowordvscode.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.hellowordvscode.Entitys.Comment;
import es.codeurjc.hellowordvscode.Entitys.Destination;
import es.codeurjc.hellowordvscode.Entitys.Trip;
import es.codeurjc.hellowordvscode.Repositories.CommentRepository;
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

	@Autowired
    private CommentRepository commentRepository;


	@ModelAttribute
	@GetMapping("/index")
    public String getAllDestinations(Model model) {
        List<Destination> destinations = destinationRepository.findAll();
        model.addAttribute("destinations", destinations);
        return "destinations";   
	}
	
	

	@ModelAttribute
	@GetMapping("/admin")
    public String getAllDestinationsAdmin(Model model) {
        List<Destination> destinations = destinationRepository.findAll();
        model.addAttribute("destinations", destinations);
        return "destinations";   
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

	
/* 
	
	@GetMapping("/destino")
	public String showDestination(@RequestParam(name = "nombre") String nombre, Model model) {
	  Optional<Destination> destination = destinationRepository.findByName(nombre);
	  model.addAttribute("destino", destination);
	  return "destino";
	}

*/

	@GetMapping("/logout")
		public String logout(Model model) {
			return "logout";
		}

	
	/*@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping("/loginerror")
    public String loginerror() {
        return "loginerror";
	}*/

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

	@GetMapping("/agregarDestinos")
	public String agregarDestinos(Model model, String name, String information) throws IOException {
		Destination destino = new Destination();
		destino.setName(name);
		destino.setInformation(information);
		destinationRepository.save(destino);
		model.addAttribute("nuevoDestino", destino);
		//model.addAttribute("mensaje", "El destino ha sido guardado con éxito.");
    	return "agregarDestinos";
	}



	/*@GetMapping("/editarDestinos/{name}")
	public String editarDestinos(Model model, @PathVariable("name") String name) {
    	Optional<Destination> destino = destinationService.findByName(name);
    	if (destino == null) {
        	model.addAttribute("error", "No se encontró el destino con el nombre " + name);
        	return "error";
    	}
    	model.addAttribute("destino", destino);
    	return "editarDestinos";
	}

	@PostMapping("/guardarDestino")
	public String guardarDestino(@ModelAttribute("destino") Destination destino) {
    	Destination destinoExistente = destinationService.findByName(destino.getNombre());
    	if (destinoExistente != null) {
        	destinoExistente.setDescripcion(destino.getInformation());
        	destinoExistente.setPrecio(destino.getPrecio());
        	destinationService.actualizar(destinoExistente);
    	}
    	return "redirect:/destinos";
	}*/





	@GetMapping("/configUsuarios")
	public String configUsuarios(Model model) {
		return "configUsuarios";
	}

	
 
}
