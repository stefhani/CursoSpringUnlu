package com.curso.spring.tp.libreria.service;

import com.curso.spring.tp.libreria.LibreriaApp;
import com.curso.spring.tp.libreria.entity.Autor;
import com.curso.spring.tp.libreria.entity.Libro;
import com.curso.spring.tp.libreria.repos.ILibroRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = LibreriaApp.class,
        initializers = ConfigFileApplicationContextInitializer.class)
public class LibroServiceImplTest {
    @Autowired
    private LibroServiceImpl libroService;

    @Test
    public void buscarId() {
        Optional<Libro> optionalLibro = libroService.buscarId(1);
        assertThat(optionalLibro);
    }

    @Test
    public void buscarPorTitulo(){
        List<Libro> libroPortitulo= libroService.buscarPorTitulo("100 años de soledad");
        assertThat(libroPortitulo);
    }
    @Test
    public void buscarPorISBN(){
       Optional<Libro> libroPorIsbn= libroService.buscarPorISBN("49233");
       assertThat(libroPorIsbn);
    }
    @Test
    public void listarAutor(){
        Autor autor= new Autor();
        autor.setId((long) 1);
        autor.setApellido("Cortázar");
        autor.setNombre("Julio");
        List<Libro> listaAutor = libroService.buscarPorAutor(autor);
        assertThat(listaAutor);
    }
    @Test
    public void insertarLibro() {
        Libro libro= new Libro();
        libro.setId((long) 10);
        libro.setTitulo("El quijote");
        libro.setSinopsis("El hombre de la mancha contra los gigantes");
        libro.setIsbn("3458");
        libro.setPrecio("345.00");

        Autor autor= new Autor();
        autor.setId((long) 20);
        autor.setApellido("Cortázar");
        autor.setNombre("Julio");

        libro.setAutor(autor);
        libroService.insertar(libro);

    }
}