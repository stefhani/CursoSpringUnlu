package com.curso.spring.tp.libreria.service;

import com.curso.spring.tp.libreria.entity.Compra;
import com.curso.spring.tp.libreria.repos.ICompraRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
@Service
public class CompraServiceImpl implements ICompraService{

    private final ICompraRepository compraRepository;

    @Inject
    public CompraServiceImpl(ICompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public List<Compra> listAll() {
        return compraRepository.findAll();
    }

    @Override
    public List<Compra> listCompXUserPedido(long idUser) {
        return compraRepository.findById_usuarioPedido(idUser);
    }

    @Override
    public List<Compra> listCompXUser(long idUser) {
        return compraRepository.findById_usuario(idUser);
    }

    @Override
    public Optional<Compra> buscarId(long id) {
        return compraRepository.findById(id);
    }

    @Override
    public void insertar(Compra compra) {
        compraRepository.save(compra);
    }

    @Override
    public void eliminar(long idCompra) {
        compraRepository.deleteById(idCompra);
    }

    @Override
    public void actualizar(Compra compra) {
        compraRepository.save(compra);
    }
}
