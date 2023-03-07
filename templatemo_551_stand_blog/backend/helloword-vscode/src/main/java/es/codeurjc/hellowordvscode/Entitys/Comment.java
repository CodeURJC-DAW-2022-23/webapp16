package es.codeurjc.hellowordvscode.Entitys;

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
    
    public String getTexto(){
        return texto;
    }

    public void setTexto(String texto){
        this.texto=texto;
    }

}
