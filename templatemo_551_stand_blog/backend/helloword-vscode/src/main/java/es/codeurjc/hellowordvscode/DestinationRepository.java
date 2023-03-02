package es.codeurjc.hellowordvscode;

import es.codeurjc.Destino;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DestinationRepository extends JpaRepository<Destino, Long>{

   Optional<Destino> findByName(String name);


}
