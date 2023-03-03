package es.codeurjc.hellowordvscode.Repositories;

import es.codeurjc.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//import es.codeurjc.daw.library.model.Book;


public interface UserRepository extends JpaRepository<User, Long>{

   Optional<User> findByName(String name);


}
