package es.codeurjc.hellowordvscode.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import es.codeurjc.hellowordvscode.Entitys.Comment;

//import es.codeurjc.daw.library.model.Book;


public interface CommentRepository extends JpaRepository<Comment, Long>, QuerydslPredicateExecutor<Comment>{




}
