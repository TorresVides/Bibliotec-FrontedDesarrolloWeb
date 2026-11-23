package com.example.demo.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad JPA que representa un libro.
 * El lado N contiene la referencia obligatoria al lado 1.
 */
@Entity
@Table(name = "libros")
@Getter
@Setter
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(name = "anio_publicacion", nullable = false)
    private Integer anioPublicacion;

    // Muchos libros pertenecen a una sola biblioteca.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "biblioteca_id", nullable = false)
    @JsonBackReference
    private Biblioteca biblioteca;

}
