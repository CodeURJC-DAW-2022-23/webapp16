package es.codeurjc.hellowordvscode.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.hellowordvscode.Entitys.User;

//import es.codeurjc.daw.library.model.Book;


public interface UserRepository extends JpaRepository<User, Long>{

   Optional<User> findByName(String name);


}
