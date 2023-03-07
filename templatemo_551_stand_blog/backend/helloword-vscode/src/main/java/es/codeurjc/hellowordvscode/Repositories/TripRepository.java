
package es.codeurjc.hellowordvscode.Repositories;

import es.codeurjc.hellowordvscode.Entitys.Trip;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

//import es.codeurjc.daw.library.model.Book;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long>, QuerydslPredicateExecutor<Trip>{
=======

//import es.codeurjc.daw.library.model.Book;


public interface TripRepository extends JpaRepository<Trip, Long>{
>>>>>>> 2f590d3416dc0eb9e64ef8799132c4f5db37d3fc


}
