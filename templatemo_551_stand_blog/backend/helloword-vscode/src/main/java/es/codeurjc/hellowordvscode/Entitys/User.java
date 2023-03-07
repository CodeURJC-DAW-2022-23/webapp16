package es.codeurjc.hellowordvscode.Entitys;

import java.sql.Blob;
import java.util.*;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "UserTable")
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


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Trip> trip_list = new ArrayList<>();
    


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

    public String[] getRoles() {
        if (admin){
            String[] value = {"USER","ADMIN"};
            return value;
        }
        String[] value = {"USER"};
        return value;
    }

    public String getEncodedPassword() {
        return null;
    }


}
