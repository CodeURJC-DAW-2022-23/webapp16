package es.codeurjc.hellowordvscode.Repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.hellowordvscode.Entitys.Comment;
import es.codeurjc.hellowordvscode.Entitys.Destination;
import es.codeurjc.hellowordvscode.Entitys.Trip;


public interface CommentRepository extends JpaRepository<Comment, Long>{


       
    


}
