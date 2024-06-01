package com.example.apivirtuaula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="Reservas")
@Getter
@Setter
@NoArgsConstructor
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_reserva")
    public Long idReserva;

    @Column(name="fecha_hora_reserva")
    public Date fechaHoraReserva;

    @Column(name = "caducado")
    public String caducado;

    @ManyToOne
    @JoinColumn(name="dni")
    public Usuarios usuario;

    @ManyToOne
    @JoinColumn(name="cod_equipo")
    public Equipos equipo;


}
