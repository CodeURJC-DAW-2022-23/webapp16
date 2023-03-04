package es.codeurjc.hellowordvscode.Entitys;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import es.codeurjc.hellowordvscode.Entitys.Comment;
import es.codeurjc.hellowordvscode.Entitys.Destination;

@Entity
public class Trip {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /*@OneToMany (mappedBy= "trip", cascade=CascadeType.ALL)
    private List<Archive> archives_list;*/

    @ManyToOne 
    private User user;

    @ManyToOne
    private Destination destination;

    @OneToOne (cascade=CascadeType.ALL)
    private Comment comment;


}
