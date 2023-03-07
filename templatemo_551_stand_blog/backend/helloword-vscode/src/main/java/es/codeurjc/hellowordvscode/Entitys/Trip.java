package es.codeurjc.hellowordvscode.Entitys;

import javax.persistence.*;

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
