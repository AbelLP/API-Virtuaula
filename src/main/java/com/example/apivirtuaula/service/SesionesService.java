package com.example.apivirtuaula.service;

import com.example.apivirtuaula.model.Sesiones;

import java.util.List;
import java.util.Optional;

public interface SesionesService {
    List<Sesiones> findAllSesiones();

    Optional<Sesiones> findSesionById(int id);

    List<Sesiones> findSesionByDni(String dni);

    List<Sesiones> findSesionByCodEquipo(int codEquipo);

    List<Sesiones> findSesionByClase(String nombre);

    boolean aniadirHoraFin(int id, String fechaHoraFin);

    Sesiones saveSesion(Sesiones sesion);

    boolean deleteSesion(int id);

    Sesiones updateSesion(Sesiones sesion);
}
