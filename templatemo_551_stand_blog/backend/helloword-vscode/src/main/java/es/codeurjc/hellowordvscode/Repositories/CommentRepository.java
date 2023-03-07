package es.codeurjc.hellowordvscode.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
=======
>>>>>>> 2f590d3416dc0eb9e64ef8799132c4f5db37d3fc

import es.codeurjc.hellowordvscode.Entitys.Comment;


<<<<<<< HEAD
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, QuerydslPredicateExecutor<Comment>{
=======
public interface CommentRepository extends JpaRepository<Comment, Long>{
>>>>>>> 2f590d3416dc0eb9e64ef8799132c4f5db37d3fc




}
