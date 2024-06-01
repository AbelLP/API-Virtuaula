package com.example.apivirtuaula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Clases")
@NoArgsConstructor
@Getter
@Setter
public class Clases {

    @Id
    @Column(name = "id_clase")
    public int codClase;

    @Column(name="nombre")
    public String nombre;

    @Column(name="tamanio")
    public int tamanio;

}
