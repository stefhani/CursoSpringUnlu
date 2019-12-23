package com.curso.spring.tp.libreria.service;

import com.curso.spring.tp.libreria.entity.Autor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IAutorService {

    List<Autor> traerTodosOrdenadosPorMasReciente();

    List<Autor> findByNombreContaining(String nombre);

    List<Autor> findByApellidoContaining(String apellido);

    Optional<Autor> buscarId(long id);

    @Transactional
    void insertar(Autor autor);

    @Transactional
    void eliminar(long idAutor);

    @Transactional
    void actualizar(Autor autor);

}
