
package es.codeurjc.hellowordvscode.Repositories;

import es.codeurjc.hellowordvscode.Entitys.Trip;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

//import es.codeurjc.daw.library.model.Book;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long>, QuerydslPredicateExecutor<Trip>{


}
