package com.curso.spring.tp.libreria.repos;

import com.curso.spring.tp.libreria.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICompraRepository extends JpaRepository<Compra, Long> {
            @Query(value = "select * from compra c inner join compra_libro l on c.id_compra = l.id_compra where c.id_usuario = :idUser",nativeQuery = true)
            List<Compra> findById_usuario(@Param("idUser") long idUser);

            @Query(value = "select * from compra c inner join compra_libro l on c.id_compra = l.id_compra where c.id_usuario = :idUser and c.estado=0",nativeQuery = true)
            List<Compra> findById_usuarioPedido(@Param("idUser") long idUser);
}
