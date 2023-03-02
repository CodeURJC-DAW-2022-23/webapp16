package es.codeurjc.hellowordvscode;

import es.codeurjc.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//import es.codeurjc.daw.library.model.Book;


public interface UserRepository extends JpaRepository<Usuario, Long>{

   Optional<Usuario> findByName(String name);


}
