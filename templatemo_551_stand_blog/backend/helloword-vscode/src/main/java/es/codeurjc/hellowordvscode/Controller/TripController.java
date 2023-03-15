/*package es.codeurjc.hellowordvscode.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.hellowordvscode.Entitys.Trip;
import es.codeurjc.hellowordvscode.Repositories.TripRepository;

@Controller
@RequestMapping("/index")
public class TripController {



    @Autowired
    private TripRepository trips;
    
    
    @GetMapping("/")
    public Page<Trip> getTrips(@RequestParam(required = false) Pageable page) {
       
            return trips.findAll(PageRequest.of(0, 10));
        
    }


    
}
*/

