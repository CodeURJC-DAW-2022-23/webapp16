package es.codeurjc.hellowordvscode.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.hellowordvscode.Entitys.Destination;
import es.codeurjc.hellowordvscode.Repositories.DestinationRepository;

@RestController
@RequestMapping
public class DestinationController {

    @Autowired
    private DestinationRepository destinations;

    @GetMapping("/destinations")
    public Page<Destination> getDestinations(@RequestParam (required = false) String name, Pageable page) {
        if (name != null){
            return destinations.findByName(name, page);
        }
        else{
            return destinations.findAll(page);
        }
    }
    
}