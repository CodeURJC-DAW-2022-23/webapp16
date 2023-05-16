package es.codeurjc.hellowordvscode.Repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.hellowordvscode.Entitys.Destination;


public interface DestinationRepository extends JpaRepository<Destination, Long>{
    
    Optional<Destination> findByName(String name);
    
    Page<Destination> findAll(Pageable page);

   // Optional<Destination> orderByMedian(int median);


}
