package es.codeurjc.hellowordvscode.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    public Object findAll() {
        return null;
    }

    
    
}
