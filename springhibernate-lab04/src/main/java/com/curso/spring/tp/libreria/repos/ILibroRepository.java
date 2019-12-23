package com.curso.spring.tp.libreria.repos;

import com.curso.spring.tp.libreria.entity.Autor;
import com.curso.spring.tp.libreria.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ILibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByAutor(Autor autor);

    Optional<Libro> findByIsbn(String isbn);

    List<Libro> findByTituloContaining(String titulo);

    List<Libro> findByTituloAndAutor_Apellido(String titulo, String apellido_autor);

    long deleteByIsbn(String isbn);

    List<Libro> removeByTitulo(String titulo);
}
