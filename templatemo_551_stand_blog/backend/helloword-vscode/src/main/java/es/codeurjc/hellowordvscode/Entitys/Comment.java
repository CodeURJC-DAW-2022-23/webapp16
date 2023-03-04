package es.codeurjc.hellowordvscode.Entitys;

import java.util.ArrayList;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
public class Comment{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String texto;

    @OneToOne    
    private Trip id_viaje;
    

}
