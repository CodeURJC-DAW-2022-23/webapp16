package es.codeurjc.hellowordvscode.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.hellowordvscode.Entitys.Archive;

//import es.codeurjc.daw.library.model.Book;


public interface ArchiveRepository extends JpaRepository<Archive, Long>{

}
