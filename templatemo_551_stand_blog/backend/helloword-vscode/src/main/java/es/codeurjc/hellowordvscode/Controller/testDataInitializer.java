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
      Destination madrid = new Destination("Madrid", "This is information about Madrid city.", "Madrid es una ciudad que te envuelve en su energ??a y te hace sentir vivo. Desde el primer momento en que pones un pie en la ciudad, te das cuenta de que hay algo especial en ella. Sus calles empedradas, sus edificios hist??ricos, sus parques llenos de vida y su gastronom??a son solo algunas de las cosas que la hacen ??nica. Pasear por el centro de Madrid es una experiencia que no te puedes perder. La Gran V??a, la Puerta del Sol, la Plaza Mayor y la Puerta de Alcal?? son solo algunos de los lugares m??s emblem??ticos de la ciudad. Pero m??s all?? de los sitios tur??sticos, lo que realmente hace que Madrid sea especial son sus barrios. Desde la bohemia Malasa??a hasta la elegante Salamanca, cada barrio tiene su propia personalidad y ofrece algo ??nico. En cuanto a la gastronom??a, Madrid es un  ra??so para los amantes de la comida. Desde los cl??sicos bocadillos de calamares hasta los famosos churros con chocolate, la ciudad ofrece una gran variedad de deliciosos platos. Adem??s, Madrid es conocida por su animada vida nocturna, con bares y discotecas para todos los gustos. Pero Madrid no es solo una ciudad para los turistas. Los madrile??os son amables y acogedores, y la ciudad es un lugar ideal para vivir. Es un centro cultural importante, con una gran cantidad de museos y teatros, y ofrece una amplia variedad de actividades para todos los gustos. En resumen, Madrid es una ciudad que tiene todo lo que uno puede desear: una rica historia, cultura, comida, vida nocturna y gente amable. Si buscas una ciudad que te deje con ganas de m??s, no puedes equivocarte con Madrid.");
      destinationRepository.save(madrid);

      Destination berlin = new Destination("Berlin", "This is information about Berlin city.", "Descubre la vibrante ciudad de Berl??n, la capital de Alemania que tiene algo para todos. Desde su rica historia y cultura hasta su vida nocturna ??nica y ambiente creativo, Berl??n es una ciudad que no te puedes perder. Uno de los mayores atractivos de Berl??n es su historia, que se remonta a la ??poca medieval. Visita los restos del Muro de Berl??n y el Checkpoint Charlie para aprender m??s sobre la divisi??n de la ciudad durante la Guerra Fr??a. Tambi??n puedes visitar la ic??nica Puerta de Brandenburgo, el Reichstag y el Museo de la Topograf??a del Terror para profundizar en la historia de Berl??n. Adem??s de su historia, Berl??n es conocida por su vibrante vida nocturna. Desde bares y clubes hasta festivales de m??sica electr??nica, Berl??n tiene algo para todos los gustos. Si te gusta la m??sica, no te pierdas el famoso club Berghain, que es conocido por su m??sica electr??nica de alta calidad y sus fiestas interminables. Berl??n tambi??n es una ciudad creativa, con una escena art??stica pr??spera y una cultura underground ??nica. Pasea por el barrio de Kreuzberg para descubrir tiendas de moda alternativa, galer??as de arte y murales de grafiti. Adem??s, Berl??n es el hogar de una variedad de festivales de arte y cine, como el Festival Internacional de Cine de Berl??n. Por ??ltimo, no puedes irte de Berl??n sin probar su deliciosa comida callejera. Desde la cl??sica salchicha alemana hasta la comida turca y vietnamita, Berl??n tiene una variedad de opciones gastron??micas para satisfacer todos los antojos. En resumen, Berl??n es una ciudad que ofrece algo para todos, desde su rica historia y cultura hasta su vibrante vida nocturna y ambiente creativo. Si est??s buscando un destino emocionante y diverso, ??Berl??n es el lugar perfecto para ti!");
      destinationRepository.save(berlin);

      Destination amsterdam = new Destination("Amsterdam", "This is information about Amsterdam city.","Amsterdam, la ciudad de los canales, los tulipanes y la bicicleta. En la capital holandesa, hay algo que ver y hacer en cada esquina. Desde pasear por los canales y disfrutar de la arquitectura t??pica holandesa hasta visitar sus famosos museos, como el Rijksmuseum y el Van Gogh Museum. Pero ??msterdam no es solo una ciudad de turismo cultural, sino que tambi??n es un lugar muy animado, con una vibrante vida nocturna y una gran oferta de restaurantes, bares y cafeter??as. Adem??s, es una ciudad muy accesible en bicicleta, lo que la convierte en una experiencia muy divertida y pr??ctica para moverse por la ciudad. Y no podemos olvidar mencionar que en ??msterdam se encuentra el famoso Barrio Rojo, un lugar hist??rico que atrae a muchos turistas por sus luces rojas y sus escaparates.En resumen, ??msterdam es una ciudad que lo tiene todo: cultura, historia, diversi??n y una belleza ??nica que no dejar?? de sorprenderte. Si tienes la oportunidad de visitarla, no dudes en hacerlo, ??no te arrepentir??s!");
      destinationRepository.save(amsterdam);

      Destination tokyo = new Destination("Tokyo", "This is information about Tokyo city.", "Tokyo es una ciudad fascinante que combina la modernidad m??s avanzada con una rica cultura tradicional. Esta metr??poli es conocida por su deliciosa comida, su impresionante arquitectura, sus vibrantes barrios y su incomparable tecnolog??a. Tokyo es una ciudad que nunca duerme, donde siempre hay algo nuevo por descubrir. Paseando por las calles de Tokyo, es f??cil encontrar templos y santuarios antiguos que contrastan con la tecnolog??a de vanguardia de los edificios m??s modernos. Los barrios de Shibuya y Shinjuku son especialmente populares por su vida nocturna y sus tiendas de moda. Los amantes de la comida encontrar??n en Tokyo un para??so gastron??mico. Desde sushi y ramen hasta okonomiyaki y takoyaki, la comida callejera japonesa es una delicia para los sentidos. Adem??s, los mercados de pescado de la ciudad, como el famoso Tsukiji, ofrecen una experiencia ??nica. La cultura popular tambi??n es una parte importante de Tokyo. Desde el anime y el manga hasta la m??sica J-Pop y la moda callejera, la ciudad es el hogar de muchas subculturas que tienen una gran influencia en todo el mundo. En definitiva, Tokyo es una ciudad emocionante y ??nica que tiene algo que ofrecer para todos los gustos. Ya sea por su cultura, su comida, su tecnolog??a o su vibrante vida nocturna, esta ciudad te dejar?? con recuerdos inolvidables.");
      destinationRepository.save(tokyo);

      Destination paris = new Destination("Paris", "informaci??n de paris", "Par??s es la ciudad del amor, la moda y la gastronom??a. Con su ic??nica Torre Eiffel y los encantadores caf??s en las calles empedradas, Par??s atrae a millones de visitantes cada a??o. Pasear por los Jardines de Luxemburgo o por el barrio de Montmartre es una experiencia ??nica. Adem??s, la ciudad cuenta con algunos de los museos m??s famosos del mundo, como el Louvre, que alberga obras de arte invaluables como la Mona Lisa. Los macarons y croissants reci??n horneados son solo una muestra de la deliciosa gastronom??a francesa que puede encontrarse en la ciudad. En resumen, Par??s es una ciudad que ofrece una mezcla perfecta de cultura, romance y deliciosa comida que la hace imposible de resistir para cualquier amante de los viajes.");
      destinationRepository.save(paris);

      Destination roma = new Destination("Roma", "informaci??n de Roma", "Roma es una ciudad llena de historia y cultura que cautiva a todo aquel que la visita. Conocida como la Ciudad Eterna, sus calles empedradas, impresionantes monumentos y plazas llenas de vida la hacen una de las ciudades m??s fascinantes de Europa. El Coliseo, el Pante??n, la Fontana di Trevi y el Vaticano son solo algunos de los lugares que no puedes dejar de visitar. Adem??s de su impresionante patrimonio hist??rico, Roma es una ciudad llena de sabor y vida. La comida es deliciosa y variada, desde la aut??ntica pizza napolitana hasta la pasta fresca y los helados artesanales. En Roma, la vida se vive en la calle, en sus mercados y plazas donde se respira el aut??ntico esp??ritu italiano. Si tienes tiempo, te recomendamos perderte por los barrios m??s aut??nticos de la ciudad, como Trastevere o Monti, donde encontrar??s tiendas, restaurantes y bares con mucho encanto. En definitiva, Roma es una ciudad que te enamorar??, llena de rincones por descubrir y experiencias por vivir. Sin duda, una visita obligada para todo viajero que quiera conocer la verdadera esencia de Italia.");
      destinationRepository.save(roma);

      Destination londres = new Destination("Londres", "informaci??n de Londres", "Londres, la capital de Inglaterra, es una ciudad vibrante y diversa con una rica historia y cultura. En el centro de la ciudad, se encuentran famosos lugares tur??sticos como el Big Ben, el Palacio de Buckingham, el London Eye y la Torre de Londres. Los turistas pueden disfrutar de una caminata por el r??o T??mesis o visitar algunos de los mejores museos del mundo, como el British Museum, la National Gallery y la Tate Modern. Los amantes de la moda pueden explorar las tiendas de Oxford Street y Carnaby Street, mientras que los fan??ticos de la m??sica pueden pasear por el distrito de Camden. Los aficionados al teatro pueden disfrutar de un espect??culo en el West End, y aquellos interesados en la ciencia pueden visitar el Museo de la Ciencia o el Observatorio de Greenwich. Adem??s, Londres tiene una gran variedad de restaurantes, desde la cocina brit??nica tradicional hasta la comida internacional de alta calidad. Sin duda, una visita a Londres es una experiencia ??nica y emocionante que dejar?? a los viajeros con recuerdos inolvidables.");
      destinationRepository.save(londres);

      Destination bruselas = new Destination("Bruselas", "informaci??n de Bruselas", "Bruselas, la capital de B??lgica, es una ciudad con una rica historia y cultura. Conocida por su arquitectura impresionante, deliciosa comida y una vibrante escena cultural, Bruselas es un destino que no puede faltar en cualquier itinerario europeo. Una de las atracciones m??s populares de la ciudad es la Grand Place, una impresionante plaza del siglo XVII rodeada de edificios hist??ricos, como el Ayuntamiento de Bruselas y la Casa del Rey. Otras joyas arquitect??nicas incluyen la Bas??lica del Sagrado Coraz??n, la Torre del Atomium y el Palacio Real de Bruselas. La ciudad tambi??n es conocida por su deliciosa comida, especialmente por sus famosos chocolates y cervezas. Los visitantes pueden disfrutar de una amplia variedad de restaurantes, cafeter??as y bares, y tambi??n pueden explorar los mercados de alimentos locales para probar algunos de los productos frescos de la regi??n. Adem??s, Bruselas es un importante centro cultural con una variedad de museos, teatros y galer??as de arte. El Museo de Arte e Historia es una visita obligada para los amantes del arte y la historia, mientras que el Centro Belga del C??mic es un lugar ??nico dedicado a la historia del c??mic belga. Con su encanto hist??rico y su moderna vibraci??n cultural, Bruselas es una ciudad que atrae a visitantes de todo el mundo y seguramente dejar?? una impresi??n duradera en todos aquellos que la visiten.");
      destinationRepository.save(bruselas);

      Destination barcelona = new Destination("Barcelona", "Pues barcelona blablablabalabsdhaufhajskdfha","Barcelona es una ciudad vibrante, llena de cultura, historia y vida. Con su impresionante arquitectura modernista, playas ba??adas por el sol y una gastronom??a de clase mundial, Barcelona es un destino tur??stico muy popular para viajeros de todo el mundo. La ciudad es famosa por su arquitectura ??nica, con obras maestras de Antoni Gaud?? como la Sagrada Familia, el Parque G??ell y la Casa Batll??. Pasear por el casco antiguo de Barcelona es como viajar en el tiempo, con sus calles empedradas y sus edificios hist??ricos que cuentan la historia de la ciudad. Barcelona tambi??n es conocida por su vibrante vida nocturna, con bares y clubes para todos los gustos y edades. Adem??s, su ubicaci??n junto al Mediterr??neo ofrece una gran variedad de actividades acu??ticas, desde relajantes tardes en la playa hasta emocionantes deportes acu??ticos. La gastronom??a es otro punto fuerte de Barcelona, con una gran variedad de platos tradicionales y modernos. Desde tapas hasta paella, pasando por mariscos frescos y cocina internacional, hay opciones para todos los gustos y presupuestos. En resumen, Barcelona es una ciudad fascinante que tiene algo para todo el mundo. Con su mezcla de historia, cultura, playas y gastronom??a, es un destino tur??stico imprescindible para aquellos que buscan una experiencia ??nica y aut??ntica.");
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

      Comment comment2 = new Comment("Pues Barcelona es muy bonito y me gust?? el edificio Gaud??.");
      commentRepository.save(comment2);

      Comment comment3 = new Comment("Madrid es una ciudad incre??ble llena de historia y cultura.");
      commentRepository.save(comment3);

      Comment comment4 = new Comment("Berl??n es una ciudad vibrante y emocionante con mucho que ofrecer.");
      commentRepository.save(comment4);

      Comment comment5 = new Comment("Amsterdam es una ciudad encantadora con canales pintorescos y una vibrante escena cultural.");
      commentRepository.save(comment5);

      Comment comment6 = new Comment("Tokio es una ciudad futurista y tecnol??gica con una rica cultura tradicional.");
      commentRepository.save(comment6);

      Comment comment7 = new Comment("Par??s es conocida como la ciudad del amor y tiene algunos de los museos m??s famosos del mundo.");
      commentRepository.save(comment7);

      Comment comment8 = new Comment("Roma es una ciudad llena de historia y arte, y tiene algunos de los monumentos m??s ic??nicos del mundo.");
      commentRepository.save(comment8);

      Comment comment9 = new Comment("Londres es una ciudad cosmopolita y diversa con una gran cantidad de atracciones tur??sticas.");
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

      tripBarcelona2.setComment(comment4);
      tripBarcelona2.setUser(user1);
      tripBarcelona2.setDestination(barcelona);
      tripRepository.save(tripBarcelona2);

   }

}