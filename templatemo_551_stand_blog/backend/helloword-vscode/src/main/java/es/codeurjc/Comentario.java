package es.codeurjc;

import javax.persistence.GenerationType;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    String texto;

}
