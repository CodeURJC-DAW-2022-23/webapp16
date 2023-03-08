package es.codeurjc.hellowordvscode.Controller;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import es.codeurjc.hellowordvscode.Entitys.Destination;
import es.codeurjc.hellowordvscode.Entitys.User;

import es.codeurjc.hellowordvscode.Repositories.UserRepository;
import es.codeurjc.hellowordvscode.Repositories.DestinationRepository;


@Service
public class testDataInitializer{
   @Autowired
   private UserRepository userRepository;

   @Autowired
   private DestinationRepository destinationRepository;
  

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

      Destination dest1 = new Destination();
      dest1.setName("Roma");
      destinationRepository.save(dest1);

   

   }
}
