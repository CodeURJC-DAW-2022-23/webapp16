package es.codeurjc;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String correo;
    String nombre;
    Boolean admin;

    @OneToMany(mappedBy = "usuario")
    ArrayList<Viaje> listaViajes;

    @Lob
    @JsonIgnore
    Blob imageFile;//avatar
    

}
