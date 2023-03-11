package es.codeurjc.hellowordvscode.Controller;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
   private PasswordEncoder passwordEncoder;

   @Autowired
   private TripRepository tripRepository;
   /**
    * @throws IOException
    * @throws URISyntaxException
    */
   
   
   
   
    @PostConstruct
    public void init() throws  IOException, URISyntaxException {
//user creators
      User admin = new User("admin2@gmail.com", "ADMIN", passwordEncoder.encode("adminPassword1234"), "ADMIN", "USER");
      userRepository.save(admin);

      User user1 = new User("user@gmail.com", "user", passwordEncoder.encode("pass"), "USER");
      userRepository.save(user1);

      User user2 = new User("user2@gmail.com", "user2", passwordEncoder.encode("pass2"), "USER");
      userRepository.save(user2);

      User user3 = new User("user3@gmail.com", "user3", passwordEncoder.encode("pass3"), "USER");
      userRepository.save(user3);

      User user4 = new User("user4@gmail.com", "user4", passwordEncoder.encode("pass4"), "USER");
      userRepository.save(user4);

      User user5 = new User("user5@gmail.com", "user5", passwordEncoder.encode("pass5"), "USER");
      userRepository.save(user5);

      User user6 = new User("user6@gmail.com", "user6", passwordEncoder.encode("pass6"), "USER");
      userRepository.save(user6);

//city creators
      Destination madrid = new Destination("Madrid", "This is information about Madrid city.");
      destinationRepository.save(madrid);

      Destination berlin = new Destination("Berlin", "This is information about Berlin city.");
      destinationRepository.save(berlin);

      Destination amsterdam = new Destination("Amsterdam", "This is information about Amsterdam city.");
      destinationRepository.save(amsterdam);

      Destination tokyo = new Destination("Tokyo", "This is information about Tokyo city.");
      destinationRepository.save(tokyo);

      Destination paris = new Destination("Paris", "información de paris PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
      destinationRepository.save(paris);

      Destination roma = new Destination("Roma", "información de Roma RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
      destinationRepository.save(roma);

      Destination londres = new Destination("Londres", "información de Londres LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
      destinationRepository.save(londres);

      Destination bruselas = new Destination("Bruselas", "información de Bruselas BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
      destinationRepository.save(bruselas);

      Destination barcelona = new Destination("Barcelona", "Pues barcelona blablablabalabsdhaufhajskdfha");
      destinationRepository.save(barcelona);
//trip creators
      Trip tripMadrid = new Trip(1);
      tripRepository.save(tripMadrid);

      Trip tripMadrid1 = new Trip(2);
      tripRepository.save(tripMadrid1);

      Trip tripMadrid2 = new Trip(3);
      tripRepository.save(tripMadrid2);

      Trip tripBerlin = new Trip(4);
      tripRepository.save(tripBerlin);

      Trip tripBerlin1 = new Trip(5);
      tripRepository.save(tripBerlin1);

      Trip tripBerlin2 = new Trip(6);
      tripRepository.save(tripBerlin2);

      Trip tripAmsterdam = new Trip(7);
      tripRepository.save(tripAmsterdam);

      Trip tripAmsterdam1 = new Trip(8);
      tripRepository.save(tripAmsterdam1);

      Trip tripAmsterdam2 = new Trip(9);
      tripRepository.save(tripAmsterdam2);

      Trip tripTokyo = new Trip(10);
      tripRepository.save(tripTokyo);

      Trip tripTokyo1 = new Trip(11);
      tripRepository.save(tripTokyo1);

      Trip tripTokyo2 = new Trip(12);
      tripRepository.save(tripTokyo2);

      Trip tripParis = new Trip(13);
      tripRepository.save(tripParis);

      Trip tripParis1 = new Trip(14);
      tripRepository.save(tripParis1);

      Trip tripParis2 = new Trip(15);
      tripRepository.save(tripParis2);

      Trip tripRoma = new Trip(16);
      tripRepository.save(tripRoma);

      Trip tripRoma1 = new Trip(17);
      tripRepository.save(tripRoma1);

      Trip tripRoma2 = new Trip(18);
      tripRepository.save(tripRoma2);

      Trip tripLondres = new Trip(19);
      tripRepository.save(tripLondres);

      Trip tripLondres1 = new Trip(20);
      tripRepository.save(tripLondres1);

      Trip tripLondres2 = new Trip(21);
      tripRepository.save(tripLondres2);

      Trip tripBruselas = new Trip(22);
      tripRepository.save(tripBruselas);

      Trip tripBruselas1 = new Trip(23);
      tripRepository.save(tripBruselas1);

      Trip tripBruselas2 = new Trip(24);
      tripRepository.save(tripBruselas2);

      Trip tripBarcelona = new Trip(25);
      tripRepository.save(tripBarcelona);

      Trip tripBarcelona1 = new Trip(26);
      tripRepository.save(tripBarcelona1);

      Trip tripBarcelona2 = new Trip(27);
      tripRepository.save(tripBarcelona2);

//comment creators
      Comment comment1 = new Comment ("pues barcelona es muy bonito y me gusto x edificio");
      commentRepository.save(comment1);

      Comment comment2 = new Comment("Pues Barcelona es muy bonito y me gustó el edificio Gaudí.");
      commentRepository.save(comment2);

      Comment comment3 = new Comment("Madrid es una ciudad increíble llena de historia y cultura.");
      commentRepository.save(comment3);

      Comment comment4 = new Comment("Berlín es una ciudad vibrante y emocionante con mucho que ofrecer.");
      commentRepository.save(comment4);

      Comment comment5 = new Comment("Amsterdam es una ciudad encantadora con canales pintorescos y una vibrante escena cultural.");
      commentRepository.save(comment5);

      Comment comment6 = new Comment("Tokio es una ciudad futurista y tecnológica con una rica cultura tradicional.");
      commentRepository.save(comment6);

      Comment comment7 = new Comment("París es conocida como la ciudad del amor y tiene algunos de los museos más famosos del mundo.");
      commentRepository.save(comment7);

      Comment comment8 = new Comment("Roma es una ciudad llena de historia y arte, y tiene algunos de los monumentos más icónicos del mundo.");
      commentRepository.save(comment8);

      Comment comment9 = new Comment("Londres es una ciudad cosmopolita y diversa con una gran cantidad de atracciones turísticas.");
      commentRepository.save(comment9);

      Comment comment10 = new Comment("Bruselas es conocida por su deliciosa comida y su arquitectura impresionante.");
      commentRepository.save(comment10);

//Trip Fillers
      tripAmsterdam.setComment(comment5);
      tripAmsterdam.setUser(user1);
      tripAmsterdam.setDestination(amsterdam);
      tripRepository.save(tripAmsterdam);

      tripAmsterdam1.setComment(comment5);
      tripAmsterdam1.setUser(user5);
      tripAmsterdam1.setDestination(amsterdam);
      tripRepository.save(tripAmsterdam1);

      tripBarcelona.setComment(comment1);
      tripBarcelona.setUser(user4);
      tripBarcelona.setDestination(barcelona);
      tripRepository.save(tripBarcelona);

    
      tripBarcelona1.setComment(comment2);
      tripBarcelona1.setUser(user1);
      tripBarcelona1.setDestination(barcelona);
      tripRepository.save(tripBarcelona1);


   }

}