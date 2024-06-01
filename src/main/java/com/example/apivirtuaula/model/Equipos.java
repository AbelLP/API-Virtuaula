package com.example.apivirtuaula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="Equipos")
@Getter
@Setter
@NoArgsConstructor
public class Equipos {
    @Id
    @Column(name = "cod_equipo")
    public int codEquipo;

    @Column(name = "nombre_equipo")
    public String nomEquipo;

    @Column(name="estado")
    public String estado;

    @Column(name = "fecha_alta")
    public Date fechaAlta;

    @Column(name = "especificaciones")
    public String especificaciones;

    @ManyToOne
    @JoinColumn(name="id_clase")
    public Clases clase;


}
