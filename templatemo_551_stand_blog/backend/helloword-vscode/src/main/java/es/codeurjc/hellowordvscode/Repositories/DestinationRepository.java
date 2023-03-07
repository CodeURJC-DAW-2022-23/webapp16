package es.codeurjc.hellowordvscode.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
=======
>>>>>>> 2f590d3416dc0eb9e64ef8799132c4f5db37d3fc


import es.codeurjc.hellowordvscode.Entitys.Destination;

<<<<<<< HEAD
@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long>, QuerydslPredicateExecutor<Destination>{
=======

public interface DestinationRepository extends JpaRepository<Destination, Long>{
>>>>>>> 2f590d3416dc0eb9e64ef8799132c4f5db37d3fc
    
    Page<Destination> findByName(String name, Pageable page);

    
    Page<Destination> findAll(Pageable page);


}
