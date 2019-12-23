package com.curso.spring.tp.libreria.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "compra")
public class Compra  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_compra")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id  ;

    @Column(name = "estado")
    private int estado ;

    @Column(name = "fechaP")
    private Date fechaPedido;

    @Column (name = "fechaL")
    private Date fechaLlegada;

    @Column(name = "tipoC")
    private byte tipoCompra;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "monto_total")
    private double montoTotal;

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE},  fetch = FetchType.EAGER)
    @JoinTable(
            name = "compra_libro",
            joinColumns = { @JoinColumn(name = "id_compra", referencedColumnName = "id_compra")},
            inverseJoinColumns = {@JoinColumn(name = "id_libro",referencedColumnName = "id_libro")}
    )
    @NotNull
    private Set<Libro> libro = new HashSet<>();

    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false,  fetch = FetchType.EAGER)
    @NotNull
    private Usuario usuario;

    public Compra() {
    }

    public Compra(Long id, int estado, Date fechaPedido, Date fechaLlegada, byte tipoCompra, int cantidad, double montoTotal, @NotNull Set<Libro> libro, @NotNull Usuario usuario) {
        this.id = id;
        this.estado = estado;
        this.fechaPedido = fechaPedido;
        this.fechaLlegada = fechaLlegada;
        this.tipoCompra = tipoCompra;
        this.cantidad = cantidad;
        this.montoTotal = montoTotal;
        this.libro = libro;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public byte getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(byte tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Set<Libro> getLibro() {
        return libro;
    }

    public void setLibro(Set<Libro> libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return id == compra.id &&
                estado == compra.estado &&
                tipoCompra == compra.tipoCompra &&
                cantidad == compra.cantidad &&
                Double.compare(compra.montoTotal, montoTotal) == 0 &&
                Objects.equals(fechaPedido, compra.fechaPedido) &&
                Objects.equals(fechaLlegada, compra.fechaLlegada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estado, fechaPedido, fechaLlegada, tipoCompra, cantidad, montoTotal);
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", estado=" + estado +
                ", fechaPedido=" + fechaPedido +
                ", fechaLlegada=" + fechaLlegada +
                ", tipoCompra=" + tipoCompra +
                ", cantidad=" + cantidad +
                ", montoTotal=" + montoTotal +
                '}';
    }
}
