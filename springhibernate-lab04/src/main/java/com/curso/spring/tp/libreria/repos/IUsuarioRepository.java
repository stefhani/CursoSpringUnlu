package com.curso.spring.tp.libreria.repos;

import com.curso.spring.tp.libreria.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNombreContaining(String nombre);

    List<Usuario> findByApellidoContaining(String apellido);

    List<Usuario> findByDniContaining(String dni);

    List<Usuario> findByEmailContaining(String email);

}
