package com.example.apivirtuaula.repository;

import com.example.apivirtuaula.model.Equipos;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquiposRepository extends JpaRepository<Equipos, Integer> {

    @Query("SELECT e FROM Equipos e WHERE e.estado='Libre'")
    List<Equipos> findEquiposLibres();

    @Query("SELECT e FROM Equipos e WHERE e.clase.nombre=?1")
    List<Equipos> findEquiposByNombreClase(String nombre);

    @Query("SELECT e FROM Equipos e WHERE e.clase.nombre=?1 AND e.estado='Libre'")
    List<Equipos> findEquiposByNombreClaseAndLibres(String nombre);

    @Query("SELECT COUNT(e) FROM Equipos e WHERE e.clase.codClase=?1")
    int getCountEquiposClase(int codClase);

    @Modifying
    @Transactional
    @Query("UPDATE Equipos e SET e.estado='Ocupado' WHERE e.nomEquipo=?1")
    int changeEstadoAOcupado(String nombre);

    @Modifying
    @Transactional
    @Query("UPDATE Equipos e SET e.estado='Libre' WHERE e.nomEquipo=?1")
    int changeEstadoARoto(String nombre);

    @Modifying
    @Transactional
    @Query("UPDATE Equipos e SET e.estado='Roto' WHERE e.nomEquipo=?1")
    int changeEstadoALibre(String nombre);


}
