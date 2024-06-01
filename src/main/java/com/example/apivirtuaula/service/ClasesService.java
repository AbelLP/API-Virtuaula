package com.example.apivirtuaula.service;

import com.example.apivirtuaula.model.Clases;

import java.util.List;
import java.util.Optional;

public interface ClasesService {

    List<Clases> findAllClases();

    Optional<Clases> findClasesById(int id);

    Clases saveClase(Clases clase);

    boolean deleteClase(int id);

    Clases updateClase(Clases clase);

}
