package es.codeurjc.hellowordvscode.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import es.codeurjc.hellowordvscode.Entitys.Destination;


public interface DestinationRepository extends JpaRepository<Destination, Long>{
    
    Page<Destination> findByName(String name, Pageable page);

    
    Page<Destination> findAll(Pageable page);


}
