package es.codeurjc.hellowordvscode.Controller;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.hellowordvscode.Entitys.Comment;
import es.codeurjc.hellowordvscode.Entitys.Destination;
import es.codeurjc.hellowordvscode.Entitys.Trip;
import es.codeurjc.hellowordvscode.Entitys.User;
import es.codeurjc.hellowordvscode.Repositories.CommentRepository;
import es.codeurjc.hellowordvscode.Repositories.DestinationRepository;
import es.codeurjc.hellowordvscode.Repositories.TripRepository;
import es.codeurjc.hellowordvscode.Repositories.UserRepository;


@Service
public class testDataInitializer{
   @Autowired
   private UserRepository userRepository;

   @Autowired
   private DestinationRepository destinationRepository;

   @Autowired
   private CommentRepository commentRepository;

   @Autowired
   private TripRepository tripRepository;
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
      //destino1.setId((long)6);
      destinationRepository.save(destino1);
      
      
      Destination destino2= new Destination();
      destino2.setName("Roma");
      destino2.setInformation("información de Roma RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
      //destino2.setId((long)2);
      destinationRepository.save(destino2);

      
      Destination destino3= new Destination();
      destino3.setName("Londres");
      destino3.setInformation("información de Londres LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
     // destino3.setId((long)1);
      destinationRepository.save(destino3);
   
      Destination destino4= new Destination();
      destino4.setName("Bruselas");
      destino4.setInformation("información de Bruselas BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
      //destino4.setId((long)0);
      destinationRepository.save(destino4);
/*
      Comment comentario= new Comment();
      comentario.setTexto("roma es un sitio muy bonitoroma es un sitio muy bonitoroma es un sitio muy bonitoroma es un sitio muy bonito");
      comentario.setId((long) 5);
      comentario.setId_viaje((long)5);
      commentRepository.save(comentario);

      Comment comentario1 = new Comment();
      comentario1.setTexto("me entanta pairasdfasdfajksdfhajsdfkjlasdfjkasdfbhajk");
      comentario1.setId((long) 2);
      commentRepository.save(comentario1);


      Trip trip1 = new Trip();
      trip1.setComment(comentario);
      trip1.setDestination(destino1);
      trip1.setId((long)3);
      trip1.setUser(user2);
      tripRepository.save(trip1);

      Trip trip2 = new Trip();
      trip2.setComment((Comment)comentario1);
      trip2.setDestination((Destination)destino3);
      trip2.setId((long)5);
      trip2.setUser(user1);
      tripRepository.save(trip2);
 */
   }

}