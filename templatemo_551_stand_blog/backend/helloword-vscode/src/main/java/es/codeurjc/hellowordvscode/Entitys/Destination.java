package es.codeurjc.hellowordvscode.Entitys;

import java.sql.Blob;
import java.util.*;

import javax.persistence.*;

@Entity
public class Destination {

    public Destination(){}

    public Destination(String name, String information) {
        this.name = name;
        this.information=information;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String information;
    

    @OneToMany (cascade = CascadeType.ALL, mappedBy="destination")   
    private List<Trip> trip_list;

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public List<Trip> getTrip_list() {
        return trip_list;
    }

    public void setTrip_list(List<Trip> trip_list) {
        this.trip_list = trip_list;
    }

    public String getName(){
        return name;
    }

    public String getInformation(){
        return information;
    }

    public void setInformation(String information) {
        this.information=information;
    }

    public void setId(long l) {
    }


}
