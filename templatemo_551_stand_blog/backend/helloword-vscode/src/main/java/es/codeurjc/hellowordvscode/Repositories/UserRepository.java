package es.codeurjc.hellowordvscode.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
=======
>>>>>>> 2f590d3416dc0eb9e64ef8799132c4f5db37d3fc

import es.codeurjc.hellowordvscode.Entitys.User;


<<<<<<< HEAD
@Repository
public interface UserRepository extends JpaRepository<User, Long> ,QuerydslPredicateExecutor<User>{
=======

public interface UserRepository extends JpaRepository<User, Long>{
>>>>>>> 2f590d3416dc0eb9e64ef8799132c4f5db37d3fc

   Optional<User> findByName(String name);


}
