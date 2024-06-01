package com.example.apivirtuaula.repository;

import com.example.apivirtuaula.model.Sesiones;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface SesionesRepository extends JpaRepository<Sesiones, Integer> {

    @Query("SELECT s FROM Sesiones s WHERE s.usuarios.dni=?1")
    List<Sesiones> findSesionesByDni(String dni);

    @Query("SELECT s FROM Sesiones s WHERE s.equipos.codEquipo=?1")
    List<Sesiones> findSesionesByCodEquipo(int codEquipo);

    @Query("SELECT s FROM Sesiones s WHERE s.equipos.clase.nombre=?1")
    List<Sesiones> findSesionesByClases(String nombre);

    @Modifying
    @Transactional
    @Query("UPDATE Sesiones s SET s.fechaHoraFin=?2 WHERE s.idSesion=?1")
    int aniadirHoraFin(int id, Date fechaHoraFin);

}
