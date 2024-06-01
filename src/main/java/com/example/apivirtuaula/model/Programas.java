package com.example.apivirtuaula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Programas")
@Getter
@Setter
@NoArgsConstructor
public class Programas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_programa")
    public String cod_programa;

    @Column(name="nombre")
    public String nombre;

    @Column(name="categoria")
    public String categoria;

    @Column(name="fabricante")
    public String fabricante;
}
