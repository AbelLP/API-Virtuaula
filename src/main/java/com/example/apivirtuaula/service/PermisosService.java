package com.example.apivirtuaula.service;

import com.example.apivirtuaula.model.Permisos;

import java.util.List;
import java.util.Optional;

public interface PermisosService {
    List<Permisos> findAllPermisos();

    Optional<Permisos> findPermisoById(String id);

    Permisos savePermiso(Permisos permiso);

    boolean deletePermiso(String id);

    Permisos updatePermiso(Permisos permiso);
}
