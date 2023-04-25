package es.codeurjc.hellowordvscode.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.codeurjc.hellowordvscode.Entitys.User;
import es.codeurjc.hellowordvscode.Repositories.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
    private UserRepository userRepository;

    @GetMapping("/logout")
	public String log(Model model) {
		return "logout";
	}

	
	@GetMapping("/login")
	public String login(Model model) {
		return "Login";
	}

	@GetMapping("/loginerror")
    public String loginerror() {
        return "loginerror";
	}

	@GetMapping("/signup")
	public String showSignupForm() {
		return "Signup";
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
		return "redirect:/personalArea";
	}

}

