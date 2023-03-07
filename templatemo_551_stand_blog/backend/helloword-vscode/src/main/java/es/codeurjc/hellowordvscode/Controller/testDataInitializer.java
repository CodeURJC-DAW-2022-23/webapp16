import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.codeurjc.hellowordvscode.Entitys.User;
import es.codeurjc.hellowordvscode.Repositories.UserRepository;

@Component
public class testDataInitializer implements CommandLineRunner {
   @Autowired
   private UserRepository userRepository;

   @Override
   public void run(String... args) throws Exception {
      User user1 = new User();
      user1.setName("John Smith");
      user1.setEmail("john.smith@example.com");
      userRepository.save(user1);

      User user2 = new User();
      user2.setName("Jane Doe");
      user2.setEmail("jane.doe@example.com");
      userRepository.save(user2);
   }
}
