package com.example.apivirtuaula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="Permisos")
@Getter
@Setter
@NoArgsConstructor
public class Permisos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_permiso")
    public String id_permiso;

    @Column(name="nombre")
    public String nombre;

    @Column(name="descripcion_permiso")
    public String descripcionPermiso;

    @Column(name="fecha_creacion")
    public Date fechaCreacion;
}
