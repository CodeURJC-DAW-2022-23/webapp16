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
	private DestinationService destinationService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
    private DestinationRepository destinationRepository;

	@Autowired
    private UserRepository userRepository;

	@Autowired
    private UserService userService;

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

	@GetMapping("/destino/{name}")
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

/* 
	@GetMapping("/destino/{name}")
	public String showDestino(Model model, @PathVariable String name) {
		Optional<Destination> destiny = destinationService.findByName(name);
		if (destiny.isPresent()) {
				model.addAttribute("destino", destiny.get());
				List<Destination> destinations = destinationRepository.findAll();
        		model.addAttribute("destinations", destinations);
				List<Trip> trips = tripRepository.findByDestination(destiny.get());
				model.addAttribute("trips", trips);
				return "destino";
			} else {
				return "error";
			}
	}
*/


	/* 
	@GetMapping("/destino")
	public String destino(Model model) {
		return "destino";
	}
	

	
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


	@GetMapping("/valoraciones")
	public String valoraciones(Model model) {
		return "valoraciones";
	}

	@GetMapping("/error")
	public String error(Model model) {
		return "Error";
	}

	@GetMapping("/crearViaje")
	public String crearViaje(Model model){
		return "crearViaje";
	}

	@GetMapping("/editarViaje")
	public String showEditarViaje(Model model){
		return "editarViaje";
	}

	@PostMapping("/editarViaje")
	public String editarViaje(Model model){
		return "editarViaje";
	}
	
	@GetMapping("/borrarViaje")
	public String borrarViaje(Model model){
		return "borrarViaje";
	}
	@GetMapping("/agregarDestinos")
	public String showAgregarDestinos() {
		return "agregarDestinos";
	}
	
	@PostMapping("/agregarDestinos")
	public String agregarDestinos(Model model, @RequestParam String name, @RequestParam String information, RedirectAttributes redirectAttrs) throws IOException {
		Destination destino = new Destination();
		destino.setName(name);
		destino.setInformation(information);
		destinationRepository.save(destino);
		model.addAttribute("nuevoDestino", destino);
    	redirectAttrs.addFlashAttribute("message", "Destino añadido con éxito");
    	return "redirect:/admin";
	}

	@GetMapping("/signup")
	public String showSignupForm() {
		return "signup";
	}

	@PostMapping("/signup")
	public String signup(Model model, @RequestParam String name, @RequestParam String email, @RequestParam String password) throws IOException{
		User usuario = new User(email, name, passwordEncoder.encode(password),"USER");
		usuario.setName(name);
		usuario.setEmail(email);
		usuario.setEncodedPassword(password);
		usuario.setImageFile(null);
		userRepository.save(usuario);
		model.addAttribute("username", usuario);
		return "personalArea";
	}

	/*@GetMapping("/editarDestinos/{name}")
	public String editarDestino(Model model, @PathVariable String name) {
  		Optional<Destination> destino = destinationService.findByName(name);
  		if (destino.isPresent()) {
    		model.addAttribute("destino", destino.get());
   	 		return "editarDestino";
  		} else {
    		return "error";
  		}
	}

	@PostMapping("/editarDestinos")
	public String editarDestinosProceso(Model model, Destination destino, boolean removeImage,MultipartFile imageField) throws IOException, SQLException {

		//updateImage(destination, removeImage, imageField);

		destinationService.save(destino);

		model.addAttribute("destinoName", destino.getName());

		return "redirect:/editarDestinos/"+destino.getName();
	}*/

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

	@GetMapping("/")
	public String paginaPrincipal(){
		return "index";
	}

 
}
