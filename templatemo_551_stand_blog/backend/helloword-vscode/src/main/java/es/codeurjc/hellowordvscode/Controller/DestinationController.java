package es.codeurjc.hellowordvscode.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.hellowordvscode.Entitys.Destination;
import es.codeurjc.hellowordvscode.Repositories.DestinationRepository;

@Controller
public class DestinationController {



    @Autowired
    private DestinationRepository destinations;
    
    
   

    @GetMapping("/destinations/{page}")
    public String getDestinations(Model model, @PathVariable Integer page) {
       
<<<<<<< Updated upstream
            return destinations.findAll(PageRequest.of(0, 2));
=======
        List <Destination> destiantionsList = destinations.findAll(PageRequest.of(page,10)).getContent();

        model.addAttribute("destinations", destiantionsList);
        return "mostrarDestino";
>>>>>>> Stashed changes
        
    }

 


    
}
