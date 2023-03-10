package es.codeurjc.hellowordvscode.Entitys;

import java.sql.Blob;
import java.util.*;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "UserTable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String email;
    private String name;
    private String encodedPassword;


    @ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

    public User(){}

    public User(String email, String name, String encodedPassword, String roles) {
        this.name = name;
        this.email = email;
        this.encodedPassword = encodedPassword;
        this.roles = List.of(roles);
    }


    @Lob
    @JsonIgnore
    Blob imageFile;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Trip> trip_list = new ArrayList<>();
    
    

    public void setImage(String string) {
    }

    public void setImageFile(Blob generateProxy) {
    }

    public Blob getImageFile() {
        return imageFile;
    }

    public String getNombre(){
        return name;
    }

    public List<String> getRoles() {
		return roles;
	}

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }


	public void setEncodedPassword(String encodedPassword) {
		this.encodedPassword = encodedPassword;
	}

    public String getEncodedPassword() {
        return null;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    


}
