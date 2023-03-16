
package es.codeurjc.hellowordvscode.Repositories;

import es.codeurjc.hellowordvscode.Entitys.Destination;
import es.codeurjc.hellowordvscode.Entitys.Trip;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TripRepository extends JpaRepository<Trip, Long>{

    List<Trip> findByDestination(Optional<Destination> destiny);
    List<Trip> findByDestinationName(String name);


}
