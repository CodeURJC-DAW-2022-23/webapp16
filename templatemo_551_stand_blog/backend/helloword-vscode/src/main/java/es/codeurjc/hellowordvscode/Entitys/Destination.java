package es.codeurjc.hellowordvscode.Entitys;

import java.sql.Blob;
import java.util.*;

import javax.persistence.*;

@Entity
public class Destination {

    public Destination(){}

    public Destination(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String information;
    

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany (mappedBy="destination")   
    private List<Trip> trip_list;

    public String getName(){
        return name;
    }

    public String getInformation(){
        return information;
    }

    public void setInformation(String information) {
        this.information=information;
    }


}
