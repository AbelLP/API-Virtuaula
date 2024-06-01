package com.example.apivirtuaula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="Sesiones")
@Getter
@Setter
@NoArgsConstructor
public class Sesiones {
    @Id
    @Column(name="id_sesion")
    public int idSesion;

    @Column(name="fecha_hora_comienzo")
    public Date fechaHoraComienzo;

    @Column(name="fecha_hora_fin")
    public Date fechaHoraFin;

    @ManyToOne
    @JoinColumn(name = "dni")
    public Usuarios usuarios;

    @ManyToOne
    @JoinColumn(name = "cod_equipo")
    public Equipos equipos;

}
