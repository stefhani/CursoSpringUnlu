package com.curso.spring.tp.libreria.service;

import com.curso.spring.tp.libreria.entity.Usuario;
import com.curso.spring.tp.libreria.repos.IUsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;

    @Inject
    public UsuarioServiceImpl (IUsuarioRepository usuarioRepository) { this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> buscarPorId(long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> buscarPorNombre(String nombre) {
        return usuarioRepository.findByNombreContaining(nombre);
    }

    @Override
    public List<Usuario> buscarPorApellido(String apellido) {
        return usuarioRepository.findByApellidoContaining(apellido);
    }

    @Override
    public List<Usuario> buscarPorDni(String dni) {
        return usuarioRepository.findByDniContaining(dni);
    }

    @Override
    public List<Usuario> buscarPorEmail(String email)  {
        return usuarioRepository.findByEmailContaining(email);
    }

    @Transactional
    @Override
    public void insertar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    @Transactional
    @Override
    public void eliminar(long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
    @Transactional
    @Override
    public void actualizar(Usuario usuario) {
            usuarioRepository.save(usuario);
    }
}
