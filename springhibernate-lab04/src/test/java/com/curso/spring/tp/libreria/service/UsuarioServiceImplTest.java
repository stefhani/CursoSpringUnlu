package com.curso.spring.tp.libreria.service;

import com.curso.spring.tp.libreria.LibreriaApp;
import com.curso.spring.tp.libreria.entity.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = LibreriaApp.class,
        initializers = ConfigFileApplicationContextInitializer.class)
public class UsuarioServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImplTest.class);

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Test
    public void buscarPorId() {
        Optional<Usuario> UsuarioDNI = usuarioService.buscarPorId(1);
        assertThat(UsuarioDNI);
    }

    @Test
    public void buscarPorDni(){
        List<Usuario> usuarioXDNI = usuarioService.buscarPorDni("93567890");
        assertThat(usuarioXDNI).hasSize(1);
    }

    @Test
    public void buscarPorNombre(){
        List<Usuario> usuarioXNombre = usuarioService.buscarPorNombre("Little");
        assertThat(usuarioXNombre);
    }

    @Test
    public void insertarUser(){
        Usuario usuario = new Usuario();
        usuario.setId((long)222);
        usuario.setApellido("Gomez");
        usuario.setNombre("Luis");
        usuario.setDni("19091238");
        usuario.setEmail("gomez.luis@gmail.com");
        usuario.setTelefono("1123456542");
        usuario.setPassword("1234gomez");

        usuarioService.insertar(usuario);
        logger.debug("usuario guardado = {}", usuario);
    }

    @Test
    public void buscarPorApellido(){
        List<Usuario> usuarioXApellido= usuarioService.buscarPorApellido("Banderas");
        assertThat(usuarioXApellido);
    }
    @Test
    public void actualizarUser(){
        Usuario usuario = new Usuario();
        usuario.setId((long)222);
        usuario.setApellido("Gomez");
        usuario.setNombre("Luis");
        usuario.setDni("19091238");
        usuario.setEmail("gomez.luis@gmail.com");
        usuario.setTelefono("1123456542");
        usuario.setPassword("7777"); // se cambia la password

        usuarioService.actualizar(usuario);
        logger.debug("usuario actualizado = {}", usuario);
    }

    @Test
    public void eliminarUser(){
        Optional<Usuario> usuarioE = usuarioService.buscarPorId(222);
        usuarioService.eliminar(usuarioE.get().getId());
        logger.debug("usuario eliminado = {}");
    }


}