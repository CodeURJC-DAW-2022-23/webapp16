package es.codeurjc.hellowordvscode.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import es.codeurjc.hellowordvscode.Entitys.Destination;
import es.codeurjc.hellowordvscode.Repositories.DestinationRepository;

@Service
public class DestinationService {

	
    
    @Autowired
	private DestinationRepository repository;

	public Optional<Destination> findById(long id) {
		return repository.findById(id);
	}

    public Optional<Destination> findByName(String name) {
		return repository.findByName(name);
	}
    
    
    public Optional<Destination> orderByMedian(int median) {
		return repository.orderByMedian(median);
	}
    

    

    public List<Destination> findAll() {
        return repository.findAll();
    }

    public void save(Destination destino) {
		repository.save(destino);
    }



    
    
}
