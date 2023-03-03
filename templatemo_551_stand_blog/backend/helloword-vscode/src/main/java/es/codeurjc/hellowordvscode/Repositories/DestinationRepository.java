package es.codeurjc.hellowordvscode.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import es.codeurjc.hellowordvscode.Entitys.Destination;


public interface DestinationRepository extends JpaRepository<Destination, Long>, QuerydslPredicateExecutor<Destination>{




}
