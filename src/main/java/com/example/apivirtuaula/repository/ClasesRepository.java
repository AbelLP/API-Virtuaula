package com.example.apivirtuaula.repository;

import com.example.apivirtuaula.model.Clases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClasesRepository extends JpaRepository<Clases, Integer> {

    @Query("UPDATE Clases c SET c.nombre=?2 WHERE c.nombre=?1")
    boolean cambiarNombreClase(String nombreViejo, String nombreNuevo);

}
