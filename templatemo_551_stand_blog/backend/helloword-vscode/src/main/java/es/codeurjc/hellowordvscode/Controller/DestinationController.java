package es.codeurjc.hellowordvscode.Controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.hellowordvscode.Entitys.Destination;
import es.codeurjc.hellowordvscode.Repositories.DestinationRepository;

@Controller
@RequestMapping("/index")
public class DestinationController {



    @Autowired
    private DestinationRepository destinations;
    
    
    @GetMapping("/")
    public Page<Destination> getDestinations(@RequestParam(required = false) Pageable page) {
       
            return destinations.findAll(PageRequest.of(0, 10));
        
    }

 


    
}
