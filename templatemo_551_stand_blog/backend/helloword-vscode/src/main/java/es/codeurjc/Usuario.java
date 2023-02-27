package es.codeurjc;

import java.sql.Blob;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String correo;
    String nombre;
    Boolean admin;

    @OneToMany(mappedBy = "usuario")
    ArrayList<Viaje> listaViajes;

    @Lob
    @JsonIgnore
    Blob imageFile;//avatar

    public void setImage(String string) {
    }

    public void setImageFile(Blob generateProxy) {
    }

    public Object getImageFile() {
        return null;
    }
    

}
