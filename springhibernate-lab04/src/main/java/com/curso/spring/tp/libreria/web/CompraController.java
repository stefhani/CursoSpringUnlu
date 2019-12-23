package com.curso.spring.tp.libreria.web;

import com.curso.spring.tp.libreria.entity.Compra;
import com.curso.spring.tp.libreria.service.ICompraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/compra")
public class CompraController {
    private final ICompraService compraService;

    @Inject
    public CompraController(ICompraService compraService) {
        this.compraService = compraService;
    }


    @RequestMapping("/{usuarioId}")
    public String vercompras(Model model, @PathVariable("usuarioId") long usuarioId) {
        List<Compra> listado= compraService.listCompXUserPedido(usuarioId);
        model.addAttribute("vistaCompraForm", new Compra());
        model.addAttribute("listadoCompra",listado);
        return "compra-vista";
    }

    @RequestMapping("/{compraId}/borrar")
    public String deleteCompra(Model model, @PathVariable("compraId") long compraId) {
        Optional<Compra> compra = compraService.buscarId(compraId);
        Compra compraP  =compra.get();
        long usuarioId = compra.get().getUsuario().getId();
        model.addAttribute("compra", compraP);
        model.addAttribute("usuarioId",usuarioId);
        return "compra-borrar";
    }

    //eliminar
    @RequestMapping("/{compraId}/usuario/{usuarioId}/borrar")
    public String deleteCompra(Model model, @PathVariable("compraId") long compraId, @PathVariable("usuarioId") long usuarioId) {
               compraService.eliminar(compraId);
        return "redirect:/usuario/" + usuarioId;
    }
}
