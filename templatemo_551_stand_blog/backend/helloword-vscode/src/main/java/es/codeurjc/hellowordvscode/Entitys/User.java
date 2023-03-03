package es.codeurjc.hellowordvscode.Entitys;

import java.sql.Blob;
import java.util.*;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String email;
    private String name;
    Boolean admin;
    
    @Lob
    @JsonIgnore
    Blob imageFile;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Trip")
    ArrayList<Trip> trip_list;


    public void setImage(String string) {
    }

    public void setImageFile(Blob generateProxy) {
    }

    public Blob getImageFile() {
        return imageFile;
    }

    public String getNombre(){
        return name;
    }

   
    

}
