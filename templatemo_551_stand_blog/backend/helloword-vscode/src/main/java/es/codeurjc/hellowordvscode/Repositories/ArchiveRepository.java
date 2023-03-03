package es.codeurjc.hellowordvscode.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.hellowordvscode.Entitys.Archive;
import es.codeurjc.hellowordvscode.Entitys.Comment;

//import es.codeurjc.daw.library.model.Book;


public interface ArchiveRepository extends JpaRepository<Archive, Long>{




}
