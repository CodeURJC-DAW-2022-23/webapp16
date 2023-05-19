package es.codeurjc.hellowordvscode.Entitys;

import java.sql.Blob;
import java.util.*;

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "UserTable")
public class User {

        
    public User(){

    }

    public User(String email, String name, String encodedPassword, String... roles) {
        this.name = name;
        this.email = email;
        this.encodedPassword = encodedPassword;
        this.roles = List.of(roles);
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String email;
    private String name;//user's username
    private String encodedPassword;//user's password (encoded)


    @ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

    @Lob
    @JsonIgnore
    Blob imageFile;//Avatar


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Trip> trip_list = new ArrayList<>();
    

    public void setImage(String string) {
        
    }

    public void setImageFile(Blob generateProxy) {
    }

    public Blob getImageFile() {
        return imageFile;
    }


    public List<String> getRoles() {
		return roles;
	}

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }


	public void setEncodedPassword(String encodedPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.encodedPassword = passwordEncoder.encode(encodedPassword);
	}

    public String getEncodedPassword() {
        return encodedPassword;
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
