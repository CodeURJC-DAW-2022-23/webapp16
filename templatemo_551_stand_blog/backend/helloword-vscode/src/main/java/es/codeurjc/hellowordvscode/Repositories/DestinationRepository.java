package es.codeurjc.hellowordvscode.Repositories;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.querydsl.core.types.Predicate;

import es.codeurjc.hellowordvscode.Entitys.Destination;


public interface DestinationRepository extends JpaRepository<Destination, Long>, QuerydslPredicateExecutor<Destination>{
    
    Page<Destination> findByName(String name, Pageable page);

    
    Page<Destination> findAll(Pageable page);


}
