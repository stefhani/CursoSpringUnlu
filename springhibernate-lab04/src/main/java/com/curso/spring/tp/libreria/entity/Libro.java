package com.curso.spring.tp.libreria.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

@Entity
@Table(name = "libro")
@EntityListeners(AuditingEntityListener.class)
public class Libro extends AuditableBaseEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_libro")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic(optional = false)
    @Column(name = "titulo")
    @Size(min = 2, max = 200)
    private String titulo;

    @Basic(optional = false)
    @Column(name = "sinopsis")
    private String sinopsis;

    @Basic(optional = false)
    @Column(name = "isbn")
    @NaturalId
    @Digits(integer = 13, fraction = 0)
    private String isbn;

    @Column(name = "precio")
    private String precio;

    @JoinColumn(name = "id_autor", referencedColumnName = "id")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false, fetch = FetchType.EAGER)
    @NotNull
    private Autor autor;

    @ManyToMany (mappedBy = "libro")
    private Set<Compra> compras = new HashSet<>();

    public Libro() {
    }

    public Libro(Long id, @Size(min = 2, max = 200) String titulo, String sinopsis, @Digits(integer = 13, fraction = 0) String isbn, String precio, Autor autor, Set<Compra> compras) {
        this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.isbn = isbn;
        this.precio = precio;
        this.autor = autor;
        this.compras = compras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Set<Compra> getCompras() {
        return compras;
    }

    public void setCompras(Set<Compra> compras) {
        this.compras = compras;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Libro.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("titulo='" + titulo + "'")
                .add("isbn='" + isbn + "'")
                .toString();
    }
}
