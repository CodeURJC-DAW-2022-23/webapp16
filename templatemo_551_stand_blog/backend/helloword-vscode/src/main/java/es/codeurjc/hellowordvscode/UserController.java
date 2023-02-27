package es.codeurjc.hellowordvscode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@Autowired
	UserRepository usuarios;
	
	@PostMapping
	public ResponseEntity<Object> uploadImage(@PathVariable long id, @RequestParam MultipartFile imageFile)
			throws IOException {

		Usuario usuario = usuarios.findById(id).orElseThrow();

		URI location = fromCurrentRequest().build().toUri();

		usuario.setImage(location.toString());
		usuario.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
		usuarios.save(usuario);

		return ResponseEntity.created(location).build();
	}

	@GetMapping
	public ResponseEntity<Object> downloadImage(@PathVariable long id) throws SQLException {

		Usuario usuario = usuarios.findById(id).orElseThrow();

		if (usuario.getImageFile() != null) {

			Resource file = new InputStreamResource(usuario.getImageFile().getBinaryStream());

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
					.contentLength(usuario.getImageFile().length()).body(file);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping
	public ResponseEntity<Object> deleteImage(@PathVariable long id) throws IOException {

		Usuario usuario = usuarios.findById(id).orElseThrow();

		usuario.setImageFile(null);
		usuario.setImage(null);
		
		usuarios.save(usuario);

		return ResponseEntity.noContent().build();
	}
}