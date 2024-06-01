package com.example.apivirtuaula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="usuarios")
@Getter
@Setter
@NoArgsConstructor
public class Usuarios {
    @Id
    @Column(name="dni")
    public String dni;

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "apellidos")
    public String apellidos;

    @Column(name = "telefono")
    public String telefono;

    @Column(name = "email")
    public String email;

    @Column(name="clave")
    public String clave;

    @Column(name="cambiar_clave")
    public boolean cambiarClave;

    @Column(name = "descripcion")
    public String descripcion;



}
