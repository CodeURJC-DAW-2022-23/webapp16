package es.codeurjc.hellowordvscode.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import es.codeurjc.hellowordvscode.Entitys.User;



public interface UserRepository extends JpaRepository<User, Long>{

   Optional<User> findByName(String name);

   Optional<User> findByEmail(String email);

   List<String> findRolesByName(String name);

   // @Query("")
   // List<Review> findReviewsOfUser(Long userId, Pageable pageable);


}
