package es.codeurjc.hellowordvscode.Controller;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.hibernate.SessionFactory;

import es.codeurjc.hellowordvscode.Entitys.Comment;
import es.codeurjc.hellowordvscode.Entitys.Destination;
import es.codeurjc.hellowordvscode.Entitys.Trip;
import es.codeurjc.hellowordvscode.Entitys.User;
import es.codeurjc.hellowordvscode.Repositories.DestinationRepository;
import es.codeurjc.hellowordvscode.Repositories.TripRepository;
import es.codeurjc.hellowordvscode.Repositories.UserRepository;
import es.codeurjc.hellowordvscode.Services.DestinationService;
import es.codeurjc.hellowordvscode.Services.UserService;

@Controller
public class MustacheController {


	private SessionFactory sessionFactory;

    @Autowired
    public void TuControlador(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Autowired
    private DestinationRepository destinationRepository;

	@Autowired
    private DestinationService destinationService;

	@Autowired
    private TripRepository tripRepository;

	@ModelAttribute
	public void addAttributes(Model model, HttpServletRequest request) {

		Principal principal = request.getUserPrincipal();

		if (principal != null) {

			model.addAttribute("logged", true);
			model.addAttribute("username", principal.getName());
			model.addAttribute("user", request.isUserInRole("USER"));

		} else {
			model.addAttribute("logged", false);
		}
	}

	public List<Destination> setMedias(List<Destination> destinos){//IN: destinations list; OUT: --
		for (int i=0;i<destinos.size();i++){
			String nombre= destinos.get(i).getName();
			//System.out.println(nombre);
			destinos.get(i).setMean(obtenerMedia(nombre));
			destinationRepository.save(destinos.get(i));
	
		}
		return destinos;
	}

	public int obtenerMedia(String destinationName){//IN: destination; OUT: integer
		int media=0;
		List<Trip> trips = tripRepository.findByDestinationName(destinationName); 
		for (int i=0; i<trips.size();i++){
			/*Trip viaje= new Trip();
			Comment comentario= new Comment();
			int nota;
			viaje=trips.get(i);
			comentario=viaje.getComment();
			nota=comentario.getNota();
			media+=nota;
*/
			media+=trips.get(i).getComment().getNota();
		}
		if (trips.size()>0){
			return (media/trips.size());
		}
		else{
			return 0;
		}
		
	}

	@ModelAttribute
	@GetMapping("/index")
    public String getAllDestinations(Model model) {
        Page<Destination> destinations = destinationRepository.findAll(PageRequest.of(0,10));
        model.addAttribute("destinations", destinations);
        return "destinations";   
	}
  


	
	@GetMapping("/admin")
	public String adminList(Model model) {
		List<Destination> destinations = destinationRepository.findAll();
        model.addAttribute("destinations", destinations);
        return "admin";
	}

	@GetMapping("/destination/{name}")
	public String showDestino(Model model, @PathVariable String name) {
		Optional<Destination> destiny = destinationService.findByName(name);
		if (destiny.isPresent()) {
				model.addAttribute("destino", destiny.get());
				List<Destination> destinations = destinationRepository.findAll();
				destinations=setMedias(destinations);
        		model.addAttribute("destinations", destinations);
				List<Trip> trips = tripRepository.findByDestination(destiny.get());
				model.addAttribute("trips", trips);
				return "destino";
			} else {
				return "error";
			}
	}



	
	@GetMapping("/personalArea")
	public String personalArea(Model model, HttpServletRequest request) {
		model.addAttribute("username", request.getUserPrincipal().getName());
    	model.addAttribute("admin", request.isUserInRole("ADMIN"));

		return "personalArea";
	}


	@GetMapping("/valoraciones")
	public String valoraciones(Model model) {
		return "valoraciones";
	}

	@GetMapping("/error")
	public String error(Model model) {
		return "error";
	}


	//NO cambiar al controlador de destination, da error, necesita estar con /personalArea
	@GetMapping("/editarDestinos/{name}")
    public String editarDestino(@PathVariable("name") String name, Model model) {
        Destination destination = destinationRepository.findByName(name)
            .orElseThrow(() -> new EntityNotFoundException("El destino con nombre " + name + " no existe."));
        model.addAttribute("destination", destination);
        return "editarDestinos";
    }

    @PostMapping("/editarDestinos/{name}")
    public String actualizarDestino(@PathVariable("name") String name, @Validated Destination destinationActualizado, RedirectAttributes redirectAttributes) {
        Destination destination = destinationRepository.findByName(name)
            .orElseThrow(() -> new EntityNotFoundException("El destino con nombre " + name + " no existe."));
        
		destination.setName(destinationActualizado.getName());
        destination.setInformation(destinationActualizado.getInformation());
        //Actualizar otros atributos aquí
		sessionFactory.getCurrentSession().merge(destination);
        //destinationRepository.save(destination);
        redirectAttributes.addFlashAttribute("mensaje", "El destino " + destination.getName() + " se actualizó correctamente.");
        return "redirect:/index";
    }

 
}
