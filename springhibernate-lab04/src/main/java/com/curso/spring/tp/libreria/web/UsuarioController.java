package com.curso.spring.tp.libreria.web;

import com.curso.spring.tp.libreria.entity.Compra;
import com.curso.spring.tp.libreria.entity.Libro;
import com.curso.spring.tp.libreria.entity.Usuario;
import com.curso.spring.tp.libreria.service.ICompraService;
import com.curso.spring.tp.libreria.service.ILibroService;
import com.curso.spring.tp.libreria.service.IUsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Logger;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    private  final IUsuarioService usuarioService;
    private final ILibroService libroService;
    private final ICompraService compraService;
    private String classError="alert alert-danger";
    private String classSuccess="alert alert-success";
    private String display="display:block;";
    Logger logger;


    @Inject
    public UsuarioController(IUsuarioService usuarioService, ILibroService libroService, ICompraService compraService) {
        this.usuarioService = usuarioService;
        this.libroService=libroService;
        this.compraService = compraService;
    }

    @RequestMapping("/volver")
    public String volver(){
        return "redirect:/home";
    }

    @RequestMapping("/nuevo")
    public String nuevoUsuario(Model model) {
        model.addAttribute("usuarioForm", new Usuario());
        return "usuario-edicion";
    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.POST)
    public String nuevoUsuario(Model model,@ModelAttribute("usuarioForm") @Valid Usuario usuarioForm, BindingResult result) {
       String classError="";
       String msj="";
        if (result.hasErrors()) {
            return "usuario-edicion";
        }
        try{
            usuarioService.insertar(usuarioForm);
            model.addAttribute("clase",classSuccess);
            model.addAttribute("mensaje","Se creo el usuario con exito!");
        }catch (Exception ex){
            logger.info("Error: Create Usuario - Info:"+ ex.getMessage());
            model.addAttribute("clase",classError);
            model.addAttribute("mensaje","Hubo un error - Intente nuevamente mas tarde");
        }
        return "usuario-edicion";
    }

    //Micuenta : GET : Retorna al usuario
    @RequestMapping("/{usuarioId}")
    public String newUsuario(Model model,@PathVariable("usuarioId") long usuarioId,@ModelAttribute("compraForm") Compra compraForm) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(usuarioId);
        List<Libro> libroAll = libroService.traerTodosOrdenadosPorMasReciente();
        //validar form compra : fechape,fechallegada,usuario
        if (compraForm.getCantidad()>0){
            try {
                createCompra(compraForm,usuario);
                model.addAttribute("clase",classSuccess);
                model.addAttribute("mensaje","Se realizo la compra con exito!");
            }catch (Exception e){
                model.addAttribute("clase",classError);
                model.addAttribute("mensaje","Hubo un error - Intente nuevamente mas tarde");
            }

        }
        List<Compra> misComp= compraService.listCompXUser(usuarioId);
        model.addAttribute("misCompras", misComp);
        model.addAttribute("compraForm", new Compra());
        model.addAttribute("usuario",usuario.orElse(null));
        model.addAttribute("librosMasRecientes", libroAll);
        return "micuenta";
    }

    public void createCompra(Compra newCompra,Optional<Usuario> user) {
        newCompra.setUsuario(user.get());
        newCompra.setFechaPedido(fechaNow());
        newCompra.setFechaLlegada(fechaPedi());
        compraService.insertar(newCompra);
    }

    public Date fechaNow(){
        Date now = new Date();
        return  now;
    }

    //Se calcula unos 4 dias de llegada
    public Date fechaPedi(){
        Date now = new Date();
        Date update= new Date();
        update.setDate(now.getDay()+4);
        return  update;
    }

    @RequestMapping("/ver/{usuarioId}")
    public ModelAndView verUsuario(@PathVariable("usuarioId") long usuarioId) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(usuarioId);
        Map<String, Object> model = Collections.singletonMap("usuario", usuario.orElse(null));
        return new ModelAndView("usuario-vista", model);
    }


    @RequestMapping("/{usuarioId}/editar")
    public String editarUsuario(Model model, @PathVariable("usuarioId") long usuarioId) {
        Usuario usuario = usuarioService.buscarPorId(usuarioId)
                .orElseThrow(RuntimeException::new);
        model.addAttribute("usuarioForm", usuario);
        return "usuario-edicion";
    }

    @RequestMapping(value = "/{usuarioId}/editar", method = RequestMethod.POST)
    public String editarUsuario(
            @PathVariable("usuarioId") long autorId,
            @ModelAttribute("usuarioForm") @Valid Usuario usuarioForm,
            BindingResult result) {

        usuarioForm.setId(autorId);

        usuarioService.buscarPorId(autorId)
                .orElseThrow(RuntimeException::new);

        if (result.hasErrors()) {
            return "usuario-edicion";
        }

        usuarioService.actualizar(usuarioForm);

        return "redirect:/usuario/" + usuarioForm.getId();
    }

    //Comprar del user.
    @RequestMapping(value = "precio/",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public String consulCompra(@RequestParam("id") String id ) {
        long idV = Long.parseLong(id);
        Optional<Libro> libro = libroService.buscarId(idV);
        return libro.get().getPrecio();
    }


}
