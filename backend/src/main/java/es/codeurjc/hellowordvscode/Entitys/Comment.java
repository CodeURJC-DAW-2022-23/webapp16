package es.codeurjc.hellowordvscode.Entitys;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
public class Comment{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int note;//valoration of destination


    private String text;//main text of destination


    public Comment() {
    }

    public Comment(String text) {
        this.text = text;
    }

   

    @OneToOne (cascade=CascadeType.ALL)   
    private Trip trip;
    
    public int getNota(){
        return note;
    }

    public void setNota(int note){
        this.note=note;
    }

    public String getTexto(){
        return text;
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

    public void setTexto(String text){
        this.text=text;
    }

}
