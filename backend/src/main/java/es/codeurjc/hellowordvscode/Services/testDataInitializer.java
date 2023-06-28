package es.codeurjc.hellowordvscode.Services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import com.mysql.cj.jdbc.Blob;

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


   
    
   
   
   
    @PostConstruct
    public void init() throws  IOException, URISyntaxException {
      //user creators
      User admin = new User("admin2@gmail.com", "admin", passwordEncoder.encode("adminpass"), "ADMIN");
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
      Destination madrid = new Destination("Madrid", "This is information about Madrid city.", "Madrid es una ciudad que te envuelve en su energía y te hace sentir vivo. Desde el primer momento en que pones un pie en la ciudad, te das cuenta de que hay algo especial en ella. Sus calles empedradas, sus edificios históricos, sus parques llenos de vida y su gastronomía son solo algunas de las cosas que la hacen única. Pasear por el centro de Madrid es una experiencia que no te puedes perder. La Gran Vía, la Puerta del Sol, la Plaza Mayor y la Puerta de Alcalá son solo algunos de los lugares más emblemáticos de la ciudad. Pero más allá de los sitios turísticos, lo que realmente hace que Madrid sea especial son sus barrios. Desde la bohemia Malasaña hasta la elegante Salamanca, cada barrio tiene su propia personalidad y ofrece algo único. En cuanto a la gastronomía, Madrid es un  raíso para los amantes de la comida. Desde los clásicos bocadillos de calamares hasta los famosos churros con chocolate, la ciudad ofrece una gran variedad de deliciosos platos. Además, Madrid es conocida por su animada vida nocturna, con bares y discotecas para todos los gustos. Pero Madrid no es solo una ciudad para los turistas. Los madrileños son amables y acogedores, y la ciudad es un lugar ideal para vivir. Es un centro cultural importante, con una gran cantidad de museos y teatros, y ofrece una amplia variedad de actividades para todos los gustos. En resumen, Madrid es una ciudad que tiene todo lo que uno puede desear: una rica historia, cultura, comida, vida nocturna y gente amable. Si buscas una ciudad que te deje con ganas de más, no puedes equivocarte con Madrid.");
      try {
            setDestinationImage(madrid, "/images/Madrid.jpg");
      } 
      catch (IOException e) {
            e.printStackTrace();
      }

      destinationRepository.save(madrid);


      Destination berlin = new Destination("Berlin", "This is information about Berlin city.", "Descubre la vibrante ciudad de Berlín, la capital de Alemania que tiene algo para todos. Desde su rica historia y cultura hasta su vida nocturna única y ambiente creativo, Berlín es una ciudad que no te puedes perder. Uno de los mayores atractivos de Berlín es su historia, que se remonta a la época medieval. Visita los restos del Muro de Berlín y el Checkpoint Charlie para aprender más sobre la división de la ciudad durante la Guerra Fría. También puedes visitar la icónica Puerta de Brandenburgo, el Reichstag y el Museo de la Topografía del Terror para profundizar en la historia de Berlín. Además de su historia, Berlín es conocida por su vibrante vida nocturna. Desde bares y clubes hasta festivales de música electrónica, Berlín tiene algo para todos los gustos. Si te gusta la música, no te pierdas el famoso club Berghain, que es conocido por su música electrónica de alta calidad y sus fiestas interminables. Berlín también es una ciudad creativa, con una escena artística próspera y una cultura underground única. Pasea por el barrio de Kreuzberg para descubrir tiendas de moda alternativa, galerías de arte y murales de grafiti. Además, Berlín es el hogar de una variedad de festivales de arte y cine, como el Festival Internacional de Cine de Berlín. Por último, no puedes irte de Berlín sin probar su deliciosa comida callejera. Desde la clásica salchicha alemana hasta la comida turca y vietnamita, Berlín tiene una variedad de opciones gastronómicas para satisfacer todos los antojos. En resumen, Berlín es una ciudad que ofrece algo para todos, desde su rica historia y cultura hasta su vibrante vida nocturna y ambiente creativo. Si estás buscando un destino emocionante y diverso, ¡Berlín es el lugar perfecto para ti!");
      try {
            setDestinationImage(berlin, "/images/Berlin.jpg");
      } 
      catch (IOException e) {
            e.printStackTrace();
      }

      destinationRepository.save(berlin);

      Destination amsterdam = new Destination("Amsterdam", "This is information about Amsterdam city.","Amsterdam, la ciudad de los canales, los tulipanes y la bicicleta. En la capital holandesa, hay algo que ver y hacer en cada esquina. Desde pasear por los canales y disfrutar de la arquitectura típica holandesa hasta visitar sus famosos museos, como el Rijksmuseum y el Van Gogh Museum. Pero Ámsterdam no es solo una ciudad de turismo cultural, sino que también es un lugar muy animado, con una vibrante vida nocturna y una gran oferta de restaurantes, bares y cafeterías. Además, es una ciudad muy accesible en bicicleta, lo que la convierte en una experiencia muy divertida y práctica para moverse por la ciudad. Y no podemos olvidar mencionar que en Ámsterdam se encuentra el famoso Barrio Rojo, un lugar histórico que atrae a muchos turistas por sus luces rojas y sus escaparates.En resumen, Ámsterdam es una ciudad que lo tiene todo: cultura, historia, diversión y una belleza única que no dejará de sorprenderte. Si tienes la oportunidad de visitarla, no dudes en hacerlo, ¡no te arrepentirás!");
      
      try {
            setDestinationImage(amsterdam, "/images/Amsterdam.jpg");
      } 
      catch (IOException e) {
            e.printStackTrace();
      }

      destinationRepository.save(amsterdam);

      Destination tokyo = new Destination("Tokyo", "This is information about Tokyo city.", "Tokyo es una ciudad fascinante que combina la modernidad más avanzada con una rica cultura tradicional. Esta metrópoli es conocida por su deliciosa comida, su impresionante arquitectura, sus vibrantes barrios y su incomparable tecnología. Tokyo es una ciudad que nunca duerme, donde siempre hay algo nuevo por descubrir. Paseando por las calles de Tokyo, es fácil encontrar templos y santuarios antiguos que contrastan con la tecnología de vanguardia de los edificios más modernos. Los barrios de Shibuya y Shinjuku son especialmente populares por su vida nocturna y sus tiendas de moda. Los amantes de la comida encontrarán en Tokyo un paraíso gastronómico. Desde sushi y ramen hasta okonomiyaki y takoyaki, la comida callejera japonesa es una delicia para los sentidos. Además, los mercados de pescado de la ciudad, como el famoso Tsukiji, ofrecen una experiencia única. La cultura popular también es una parte importante de Tokyo. Desde el anime y el manga hasta la música J-Pop y la moda callejera, la ciudad es el hogar de muchas subculturas que tienen una gran influencia en todo el mundo. En definitiva, Tokyo es una ciudad emocionante y única que tiene algo que ofrecer para todos los gustos. Ya sea por su cultura, su comida, su tecnología o su vibrante vida nocturna, esta ciudad te dejará con recuerdos inolvidables.");
      
      try {
            setDestinationImage(tokyo, "/images/Tokyo.jpg");
      } 
      catch (IOException e) {
            e.printStackTrace();
      }
      destinationRepository.save(tokyo);

      Destination paris = new Destination("Paris", "información de paris", "París es la ciudad del amor, la moda y la gastronomía. Con su icónica Torre Eiffel y los encantadores cafés en las calles empedradas, París atrae a millones de visitantes cada año. Pasear por los Jardines de Luxemburgo o por el barrio de Montmartre es una experiencia única. Además, la ciudad cuenta con algunos de los museos más famosos del mundo, como el Louvre, que alberga obras de arte invaluables como la Mona Lisa. Los macarons y croissants recién horneados son solo una muestra de la deliciosa gastronomía francesa que puede encontrarse en la ciudad. En resumen, París es una ciudad que ofrece una mezcla perfecta de cultura, romance y deliciosa comida que la hace imposible de resistir para cualquier amante de los viajes.");
      
      try {
            setDestinationImage(paris, "/images/Paris.jpg");
      } 
      catch (IOException e) {
            e.printStackTrace();
      }
      destinationRepository.save(paris);

      Destination roma = new Destination("Roma", "información de Roma", "Roma es una ciudad llena de historia y cultura que cautiva a todo aquel que la visita. Conocida como la Ciudad Eterna, sus calles empedradas, impresionantes monumentos y plazas llenas de vida la hacen una de las ciudades más fascinantes de Europa. El Coliseo, el Panteón, la Fontana di Trevi y el Vaticano son solo algunos de los lugares que no puedes dejar de visitar. Además de su impresionante patrimonio histórico, Roma es una ciudad llena de sabor y vida. La comida es deliciosa y variada, desde la auténtica pizza napolitana hasta la pasta fresca y los helados artesanales. En Roma, la vida se vive en la calle, en sus mercados y plazas donde se respira el auténtico espíritu italiano. Si tienes tiempo, te recomendamos perderte por los barrios más auténticos de la ciudad, como Trastevere o Monti, donde encontrarás tiendas, restaurantes y bares con mucho encanto. En definitiva, Roma es una ciudad que te enamorará, llena de rincones por descubrir y experiencias por vivir. Sin duda, una visita obligada para todo viajero que quiera conocer la verdadera esencia de Italia.");
      
      try {
            setDestinationImage(roma, "/images/Roma.jpg");
      } 
      catch (IOException e) {
            e.printStackTrace();
      }
      destinationRepository.save(roma);

      Destination londres = new Destination("Londres", "información de Londres", "Londres, la capital de Inglaterra, es una ciudad vibrante y diversa con una rica historia y cultura. En el centro de la ciudad, se encuentran famosos lugares turísticos como el Big Ben, el Palacio de Buckingham, el London Eye y la Torre de Londres. Los turistas pueden disfrutar de una caminata por el río Támesis o visitar algunos de los mejores museos del mundo, como el British Museum, la National Gallery y la Tate Modern. Los amantes de la moda pueden explorar las tiendas de Oxford Street y Carnaby Street, mientras que los fanáticos de la música pueden pasear por el distrito de Camden. Los aficionados al teatro pueden disfrutar de un espectáculo en el West End, y aquellos interesados en la ciencia pueden visitar el Museo de la Ciencia o el Observatorio de Greenwich. Además, Londres tiene una gran variedad de restaurantes, desde la cocina británica tradicional hasta la comida internacional de alta calidad. Sin duda, una visita a Londres es una experiencia única y emocionante que dejará a los viajeros con recuerdos inolvidables.");
      
      try {
            setDestinationImage(londres, "/images/Londres.jpg");
      } 
      catch (IOException e) {
            e.printStackTrace();
      }
      destinationRepository.save(londres);

      Destination bruselas = new Destination("Bruselas", "información de Bruselas", "Bruselas, la capital de Bélgica, es una ciudad con una rica historia y cultura. Conocida por su arquitectura impresionante, deliciosa comida y una vibrante escena cultural, Bruselas es un destino que no puede faltar en cualquier itinerario europeo. Una de las atracciones más populares de la ciudad es la Grand Place, una impresionante plaza del siglo XVII rodeada de edificios históricos, como el Ayuntamiento de Bruselas y la Casa del Rey. Otras joyas arquitectónicas incluyen la Basílica del Sagrado Corazón, la Torre del Atomium y el Palacio Real de Bruselas. La ciudad también es conocida por su deliciosa comida, especialmente por sus famosos chocolates y cervezas. Los visitantes pueden disfrutar de una amplia variedad de restaurantes, cafeterías y bares, y también pueden explorar los mercados de alimentos locales para probar algunos de los productos frescos de la región. Además, Bruselas es un importante centro cultural con una variedad de museos, teatros y galerías de arte. El Museo de Arte e Historia es una visita obligada para los amantes del arte y la historia, mientras que el Centro Belga del Cómic es un lugar único dedicado a la historia del cómic belga. Con su encanto histórico y su moderna vibración cultural, Bruselas es una ciudad que atrae a visitantes de todo el mundo y seguramente dejará una impresión duradera en todos aquellos que la visiten.");
      
      try {
            setDestinationImage(bruselas, "/images/Bruselas.jpg");
      } 
      catch (IOException e) {
            e.printStackTrace();
      }
      destinationRepository.save(bruselas);

      Destination barcelona = new Destination("Barcelona", "Pues barcelona blablablabalabsdhaufhajskdfha","Barcelona es una ciudad vibrante, llena de cultura, historia y vida. Con su impresionante arquitectura modernista, playas bañadas por el sol y una gastronomía de clase mundial, Barcelona es un destino turístico muy popular para viajeros de todo el mundo. La ciudad es famosa por su arquitectura única, con obras maestras de Antoni Gaudí como la Sagrada Familia, el Parque Güell y la Casa Batlló. Pasear por el casco antiguo de Barcelona es como viajar en el tiempo, con sus calles empedradas y sus edificios históricos que cuentan la historia de la ciudad. Barcelona también es conocida por su vibrante vida nocturna, con bares y clubes para todos los gustos y edades. Además, su ubicación junto al Mediterráneo ofrece una gran variedad de actividades acuáticas, desde relajantes tardes en la playa hasta emocionantes deportes acuáticos. La gastronomía es otro punto fuerte de Barcelona, con una gran variedad de platos tradicionales y modernos. Desde tapas hasta paella, pasando por mariscos frescos y cocina internacional, hay opciones para todos los gustos y presupuestos. En resumen, Barcelona es una ciudad fascinante que tiene algo para todo el mundo. Con su mezcla de historia, cultura, playas y gastronomía, es un destino turístico imprescindible para aquellos que buscan una experiencia única y auténtica.");
      
      try {
            setDestinationImage(barcelona, "/images/Barcelona.jpg");
      } 
      catch (IOException e) {
            e.printStackTrace();
      }
      destinationRepository.save(barcelona);

      Destination plus1 = new Destination("plus1", "Pues barcelona blablablabalabsdhaufhajskdfha","Barcelona es una ciudad vibrante, llena de cultura, historia y vida. Con su impresionante arquitectura modernista, playas bañadas por el sol y una gastronomía de clase mundial, Barcelona es un destino turístico muy popular para viajeros de todo el mundo. La ciudad es famosa por su arquitectura única, con obras maestras de Antoni Gaudí como la Sagrada Familia, el Parque Güell y la Casa Batlló. Pasear por el casco antiguo de Barcelona es como viajar en el tiempo, con sus calles empedradas y sus edificios históricos que cuentan la historia de la ciudad. Barcelona también es conocida por su vibrante vida nocturna, con bares y clubes para todos los gustos y edades. Además, su ubicación junto al Mediterráneo ofrece una gran variedad de actividades acuáticas, desde relajantes tardes en la playa hasta emocionantes deportes acuáticos. La gastronomía es otro punto fuerte de Barcelona, con una gran variedad de platos tradicionales y modernos. Desde tapas hasta paella, pasando por mariscos frescos y cocina internacional, hay opciones para todos los gustos y presupuestos. En resumen, Barcelona es una ciudad fascinante que tiene algo para todo el mundo. Con su mezcla de historia, cultura, playas y gastronomía, es un destino turístico imprescindible para aquellos que buscan una experiencia única y auténtica.");
      
      try {
            setDestinationImage(plus1, "/images/plus1.jpg");
      } 
      catch (IOException e) {
            e.printStackTrace();
      }
      destinationRepository.save(plus1);

      Destination plus2 = new Destination("plus2", "Pues barcelona blablablabalabsdhaufhajskdfha","Barcelona es una ciudad vibrante, llena de cultura, historia y vida. Con su impresionante arquitectura modernista, playas bañadas por el sol y una gastronomía de clase mundial, Barcelona es un destino turístico muy popular para viajeros de todo el mundo. La ciudad es famosa por su arquitectura única, con obras maestras de Antoni Gaudí como la Sagrada Familia, el Parque Güell y la Casa Batlló. Pasear por el casco antiguo de Barcelona es como viajar en el tiempo, con sus calles empedradas y sus edificios históricos que cuentan la historia de la ciudad. Barcelona también es conocida por su vibrante vida nocturna, con bares y clubes para todos los gustos y edades. Además, su ubicación junto al Mediterráneo ofrece una gran variedad de actividades acuáticas, desde relajantes tardes en la playa hasta emocionantes deportes acuáticos. La gastronomía es otro punto fuerte de Barcelona, con una gran variedad de platos tradicionales y modernos. Desde tapas hasta paella, pasando por mariscos frescos y cocina internacional, hay opciones para todos los gustos y presupuestos. En resumen, Barcelona es una ciudad fascinante que tiene algo para todo el mundo. Con su mezcla de historia, cultura, playas y gastronomía, es un destino turístico imprescindible para aquellos que buscan una experiencia única y auténtica.");
      
      try {
            setDestinationImage(plus2, "/images/plus2.jpg");
      } 
      catch (IOException e) {
            e.printStackTrace();
      }
      destinationRepository.save(plus2);
      
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
      comment1.setNota(5);
      commentRepository.save(comment1);

      Comment comment2 = new Comment("Pues Barcelona es muy bonito y me gustó el edificio Gaudí.");
      comment2.setNota(1);
      commentRepository.save(comment2);

      Comment comment3 = new Comment("Madrid es una ciudad increíble llena de historia y cultura.");
      comment3.setNota(5);
      commentRepository.save(comment3);

      Comment comment4 = new Comment("Berlín es una ciudad vibrante y emocionante con mucho que ofrecer.");
      comment4.setNota(3);
      commentRepository.save(comment4);

      Comment comment5 = new Comment("Amsterdam es una ciudad encantadora con canales pintorescos y una vibrante escena cultural.");
      comment5.setNota(1);
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
      tripAmsterdam.setComment(comment4);
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

      tripBarcelona2.setComment(comment4);
      tripBarcelona2.setUser(user1);
      tripBarcelona2.setDestination(barcelona);
      tripRepository.save(tripBarcelona2);

   }

   public void setDestinationImage(Destination destination, String classpathResource) throws IOException {
		Resource image = new ClassPathResource(classpathResource);
		destination.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
	}


   /*public static SerialBlob fileToBlob(String rutaImagen) throws SerialException, SQLException, IOException {
      File file = new File(rutaImagen);
      InputStream inputStream = new FileInputStream(file);
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      byte[] buffer = new byte[4096];
      int bytesRead = -1;
      while ((bytesRead = inputStream.read(buffer)) != -1) {
          outputStream.write(buffer, 0, bytesRead);
      }
      byte[] imageBytes = outputStream.toByteArray();
      SerialBlob blob = new SerialBlob(imageBytes);
      inputStream.close();
      outputStream.close();
      return blob;
  }*/

  

}
