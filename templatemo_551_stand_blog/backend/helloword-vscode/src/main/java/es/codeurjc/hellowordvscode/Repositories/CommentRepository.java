package es.codeurjc.hellowordvscode.Repositories;

import es.codeurjc.Comment;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//import es.codeurjc.daw.library.model.Book;


public interface CommentRepository extends JpaRepository<Comment, Long>{




}
