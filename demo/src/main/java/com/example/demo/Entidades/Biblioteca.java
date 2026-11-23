package com.example.demo.Entidades;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

// Entidad: almacena los datos de una biblioteca y su relación con los libros.
@Entity
@Table(name = "bibliotecas")
@Getter
@Setter
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String ciudad;

    @OneToMany(mappedBy = "biblioteca", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Libro> libros = new ArrayList<>();
}
