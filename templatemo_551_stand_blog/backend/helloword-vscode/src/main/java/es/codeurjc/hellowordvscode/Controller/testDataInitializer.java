package es.codeurjc.hellowordvscode.Controller;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.hellowordvscode.Entitys.Destination;
import es.codeurjc.hellowordvscode.Entitys.User;
import es.codeurjc.hellowordvscode.Repositories.DestinationRepository;
import es.codeurjc.hellowordvscode.Repositories.UserRepository;


@Service
public class testDataInitializer{
   @Autowired
   private UserRepository userRepository;

   @Autowired
   private DestinationRepository destinationRepository;
   /**
    * @throws IOException
    * @throws URISyntaxException
    */
   @PostConstruct
   public void init() throws  IOException, URISyntaxException {
      User user1 = new User();
      user1.setName("Juan");
      user1.setEmail("john.smith@example.com");
      userRepository.save(user1);

      User user2 = new User();
      user2.setName("Jane Doe");
      user2.setEmail("jane.doe@example.com");
      userRepository.save(user2);
      
      Destination destino1= new Destination();
      destino1.setName("Paris");
      destino1.setInformation("información de paris PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
      destinationRepository.save(destino1);
      
      
      Destination destino2= new Destination();
      destino2.setName("Roma");
      destino2.setInformation("información de Roma RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
      destinationRepository.save(destino2);

      
      Destination destino3= new Destination();
      destino3.setName("Londres");
      destino3.setInformation("información de Londres LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
      destinationRepository.save(destino3);
   
      Destination destino4= new Destination();
      destino4.setName("Bruselas");
      destino4.setInformation("información de Bruselas BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
      destinationRepository.save(destino4);

   }

}