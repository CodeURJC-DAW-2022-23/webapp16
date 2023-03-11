package es.codeurjc.hellowordvscode.Entitys;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
public class Comment{

    public Comment() {
    }

    public Comment(String texto) {
        this.texto = texto;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String texto;

    @OneToOne (cascade=CascadeType.ALL)   
    private Trip trip;
    
    public String getTexto(){
        return texto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void setTexto(String texto){
        this.texto=texto;
    }

}
