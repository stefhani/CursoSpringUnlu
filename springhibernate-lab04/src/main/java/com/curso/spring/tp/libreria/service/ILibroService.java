package com.curso.spring.tp.libreria.service;

import com.curso.spring.tp.libreria.entity.Autor;
import com.curso.spring.tp.libreria.entity.Libro;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ILibroService {

    List<Libro> buscarPorTitulo(String titulo);

    Optional<Libro> buscarPorISBN(String isbn);

    List<Libro> buscarPorAutor(Autor autor);

    Optional<Libro> buscarId(long id);

    List<Libro> listarTodo();

    List<Libro> traerTodosOrdenadosPorMasReciente();

    @Transactional
    void insertar(Libro l);

    @Transactional
    void eliminar(long id);

    @Transactional
    void actualizar(Libro l);

}
