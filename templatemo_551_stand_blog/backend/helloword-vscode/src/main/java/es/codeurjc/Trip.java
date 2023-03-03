package es.codeurjc;

import java.io.File;
import java.util.List;

import javax.persistence.*;

@Entity
public class Trip {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany (cascade=CascadeType.ALL)
    private List<File> archives_list;

    @OneToOne
    private User user;

    @OneToOne
    private Destination destination;

    @OneToOne (cascade=CascadeType.ALL)
    private Comment comment;


}
