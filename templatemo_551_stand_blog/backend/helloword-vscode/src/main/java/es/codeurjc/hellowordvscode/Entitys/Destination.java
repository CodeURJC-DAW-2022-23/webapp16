package es.codeurjc.hellowordvscode.Entitys;

import java.sql.Blob;
import java.util.*;

import javax.persistence.*;

@Entity
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String information;
    private Blob image;

    @OneToMany (mappedBy="destination")   
    private List<Trip> trip_list;

    public String getNombre(){
        return name;
    }

    public String getInformation(){
        return information;
    }


}
