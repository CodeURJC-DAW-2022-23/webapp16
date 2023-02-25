package es.codeurjc;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
