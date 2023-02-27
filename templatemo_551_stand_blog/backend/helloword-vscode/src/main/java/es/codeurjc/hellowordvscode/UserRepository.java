package es.codeurjc.hellowordvscode;

import es.codeurjc.Usuario;



import org.springframework.data.jpa.repository.JpaRepository;

//import es.codeurjc.daw.library.model.Book;


public interface UserRepository extends JpaRepository<Usuario, Long>{

   


}
