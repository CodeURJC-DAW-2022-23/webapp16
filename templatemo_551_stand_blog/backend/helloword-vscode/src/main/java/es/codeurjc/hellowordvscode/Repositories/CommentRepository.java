package es.codeurjc.hellowordvscode.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.hellowordvscode.Entitys.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long>{




}
