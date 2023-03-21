package es.codeurjc.hellowordvscode.Entitys;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Trip {
    
    public Trip() {
    }
    public Trip(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;//name of the trip, for user's identification

    @ManyToOne 
    private User user;

    @ManyToOne (cascade=CascadeType.ALL)
    private Destination destination;

    @OneToOne (cascade=CascadeType.ALL)
    private Comment comment;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }


}
