package es.codeurjc.hellowordvscode.Entitys;

import javax.persistence.*;

public class Archive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

}
