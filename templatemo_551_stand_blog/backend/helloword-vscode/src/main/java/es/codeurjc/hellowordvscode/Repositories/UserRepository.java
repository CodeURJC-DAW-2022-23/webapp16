package es.codeurjc.hellowordvscode.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import es.codeurjc.hellowordvscode.Entitys.User;



public interface UserRepository extends JpaRepository<User, Long> ,QuerydslPredicateExecutor<User>{

   Optional<User> findByName(String name);


}
