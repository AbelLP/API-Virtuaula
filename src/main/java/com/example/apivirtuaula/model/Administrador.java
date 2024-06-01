package com.example.apivirtuaula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Administrador")
@Getter
@Setter
@NoArgsConstructor
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_administrador")
    public String cod_administrador;

    @Column(name="nombre")
    public String nombre;

    @Column(name="apellidos")
    public String apellidos;

    @Column(name="clave")
    public String clave;

    @Column(name="telefono")
    public String telefono;
}
