package com.curso.spring.tp.libreria.web;

import com.curso.spring.tp.libreria.entity.Libro;
import com.curso.spring.tp.libreria.entity.Usuario;
import com.curso.spring.tp.libreria.service.IAutorService;
import com.curso.spring.tp.libreria.service.ILibroService;
import com.curso.spring.tp.libreria.service.IUsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/home")
public class LibroController{

    private final ILibroService libroService;
    private final IAutorService autorService;
    private  final IUsuarioService usuarioService;
    Logger logger;
    @Inject
    public LibroController(ILibroService libroService, IAutorService autorService,IUsuarioService usuarioService) {
        this.libroService = libroService;
        this.autorService = autorService;
        this.usuarioService=usuarioService;
    }

    @RequestMapping("")
    public String mostrarLibros(Model model) {
        model.addAttribute("usuarioLogin", new Usuario());
        List<Libro> libroAll = libroService.traerTodosOrdenadosPorMasReciente();
        model.addAttribute("librosMasRecientes", libroAll);
        return "home-page";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String nowUsuario(Model model,@ModelAttribute("usuarioLogin") @Valid Usuario usuarioLogin, BindingResult result) {

        List<Usuario> usuarioXEmail = null;
        String pwdUser="";
        String pwdLogin="";
        String clase="alert alert-danger";
        String display="display:block;";
        String mensaje="";

           usuarioXEmail =  usuarioService.buscarPorEmail(usuarioLogin.getEmail());
            //verificar su password
            if(usuarioXEmail.size() < 1){
                model.addAttribute("clase",clase);
                model.addAttribute("mensaje","Error: No Exite el usuario");
                model.addAttribute("usuarioLogin", new Usuario());
                List<Libro> libroAll = libroService.traerTodosOrdenadosPorMasReciente();
                model.addAttribute("librosMasRecientes", libroAll);
                return "home-page";
            }
            pwdUser=usuarioLogin.getPassword();
            pwdLogin=usuarioXEmail.get(0).getPassword();
            if(! pwdUser.equals(pwdLogin) ){
                model.addAttribute("clase",clase);
                model.addAttribute("mensaje","Error:La password es incorrecto");
                model.addAttribute("usuarioLogin", new Usuario());
                List<Libro> libroAll = libroService.traerTodosOrdenadosPorMasReciente();
                model.addAttribute("librosMasRecientes", libroAll);
                return "home-page";
            }

        return "redirect:/usuario/" + usuarioXEmail.get(0).getId();
    }

    //Ver libro
    @RequestMapping(value = "/libro/ver/{libroId}")
    public String verLibro(Model model,@PathVariable("libroId") long libroId) {
        Optional<Libro> libro = libroService.buscarId(libroId);
        model.addAttribute("libro", libro.orElse(null));
        return "libro-vista";
    }

}

