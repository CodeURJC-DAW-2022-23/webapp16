package es.codeurjc;

import javax.persistence.*;

@Entity
public class Viaje {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    Usuario usuario;

    @ManyToOne
    Destino destino;

    @OneToOne
    Comentario comentario;

}
