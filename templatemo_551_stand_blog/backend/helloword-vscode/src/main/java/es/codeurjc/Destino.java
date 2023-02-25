package es.codeurjc;

import java.util.*;

import javax.persistence.OneToMany;

@Entity
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    String nombre;
    @OneToMany(mappedBy = "destino")
    ArrayList<Viaje> listaViajes;
    

}
