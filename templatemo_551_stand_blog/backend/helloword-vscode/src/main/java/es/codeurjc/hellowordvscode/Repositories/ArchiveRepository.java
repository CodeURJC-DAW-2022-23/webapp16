package es.codeurjc.hellowordvscode.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
=======
>>>>>>> 2f590d3416dc0eb9e64ef8799132c4f5db37d3fc

import es.codeurjc.hellowordvscode.Entitys.Archive;

//import es.codeurjc.daw.library.model.Book;

<<<<<<< HEAD
@Repository
public interface ArchiveRepository extends JpaRepository<Archive, Long>, QuerydslPredicateExecutor<Archive>{



=======

public interface ArchiveRepository extends JpaRepository<Archive, Long>{
>>>>>>> 2f590d3416dc0eb9e64ef8799132c4f5db37d3fc

}
