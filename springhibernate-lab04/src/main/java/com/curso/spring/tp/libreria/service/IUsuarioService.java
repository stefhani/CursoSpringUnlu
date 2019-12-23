package com.curso.spring.tp.libreria.service;

import com.curso.spring.tp.libreria.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    Optional<Usuario> buscarPorId(long id);

    List<Usuario> buscarPorNombre(String nombre);

    List<Usuario> buscarPorApellido(String apellido);

    List<Usuario> buscarPorDni(String dni);

    List<Usuario> buscarPorEmail(String email);


    @Transactional
    void insertar(Usuario l);

    @Transactional
    void eliminar(long id);

    @Transactional
    void actualizar(Usuario l);
}
