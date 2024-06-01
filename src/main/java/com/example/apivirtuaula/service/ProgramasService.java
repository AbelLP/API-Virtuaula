package com.example.apivirtuaula.service;

import com.example.apivirtuaula.model.Programas;

import java.util.List;
import java.util.Optional;

public interface ProgramasService {
    List<Programas> findAllProgramas();

    Optional<Programas> findProgramaById(String id);

    Programas savePrograma(Programas programa);

    boolean deletePrograma(String id);

    Programas updatePrograma(Programas programas);
}
