package com.curso.spring.tp.libreria.repos;

import com.curso.spring.tp.libreria.entity.Autor;
import com.curso.spring.tp.libreria.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IAutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByNombreContaining(String nombre);

    List<Autor> findByApellidoContaining(String apellido);

    List<Autor> findDistinctByLibrosIn(Libro libro);

    long countByNombreContaining(String nombre);

}
