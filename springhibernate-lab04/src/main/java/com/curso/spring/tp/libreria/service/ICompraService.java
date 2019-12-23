package com.curso.spring.tp.libreria.service;

import com.curso.spring.tp.libreria.entity.Compra;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ICompraService {

    Optional<Compra> buscarId(long id);

     List<Compra> listAll();

     List<Compra> listCompXUser(long idUser);

    List<Compra> listCompXUserPedido(long idUser);

    @Transactional
    void insertar(Compra compra);

    @Transactional
    void eliminar(long idCompra);

    @Transactional
    void actualizar(Compra compra);
}
