package es.codeurjc.hellowordvscode.Controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.io.*;
import java.net.URI;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.InputStreamResource;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import es.codeurjc.hellowordvscode.Entitys.User;
import es.codeurjc.hellowordvscode.Repositories.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository usuarios;
	
	@PostMapping
	public ResponseEntity<Object> uploadImage(@PathVariable long id, @RequestParam MultipartFile imageFile)
			throws IOException {

		User usuario = usuarios.findById(id).orElseThrow();

		URI location = fromCurrentRequest().build().toUri();

		usuario.setImage(location.toString());
		usuario.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
		usuarios.save(usuario);

		return ResponseEntity.created(location).build();
	}


	/*private HeadersBuilder<BodyBuilder> fromCurrentRequest() {
		return null;
	}*/

	@GetMapping
	public ResponseEntity<Object> downloadImage(@PathVariable long id) throws SQLException {

		User usuario = usuarios.findById(id).orElseThrow();

		if (usuario.getImageFile() != null) {

			Resource file = (Resource) new InputStreamResource(usuario.getImageFile().getBinaryStream());

			return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
					.contentLength(usuario.getImageFile().length()).body(file);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping
	public ResponseEntity<Object> deleteImage(@PathVariable long id) throws IOException {

		User usuario = usuarios.findById(id).orElseThrow();

		usuario.setImageFile(null);
		usuario.setImage(null);
		
		usuarios.save(usuario);

		return ResponseEntity.noContent().build();
	}
}