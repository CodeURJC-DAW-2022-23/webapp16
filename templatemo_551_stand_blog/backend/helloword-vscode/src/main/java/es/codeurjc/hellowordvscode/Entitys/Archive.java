package es.codeurjc.hellowordvscode.Entitys;

import javax.persistence.*;

@Entity
public class Archive {


    public Archive() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /*@ManyToOne
    private Trip trip;*/
    
}
