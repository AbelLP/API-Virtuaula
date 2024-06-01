package com.example.apivirtuaula.service;

import com.example.apivirtuaula.model.Equipos;

import java.util.List;
import java.util.Optional;

public interface EquiposService {
    List <Equipos> findAllEquipos();

    Optional<Equipos> findEquipoById(int id);

    List<Equipos> findEquiposLibres();

    List<Equipos> findEquiposByNombreClase(String nombre);

    List<Equipos> findEquiposByNombreClaseAndLibres(String nombre);

    int getCountEquiposClase(int codClase);

    boolean changeEstadoAOcupado(String nombre);

    boolean changeEstadoARoto(String nombre);

    boolean changeEstadoALibre(String nombre);

    Equipos saveEquipo(Equipos equipo);

    boolean deleteEquipo(int id);

    Equipos updateEquipo(Equipos equipo);

}
