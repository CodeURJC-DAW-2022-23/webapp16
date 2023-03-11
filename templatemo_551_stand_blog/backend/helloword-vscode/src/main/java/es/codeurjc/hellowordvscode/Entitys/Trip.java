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
