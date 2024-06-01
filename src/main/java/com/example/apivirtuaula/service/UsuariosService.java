package com.example.apivirtuaula.service;

import com.example.apivirtuaula.model.Usuarios;

import java.util.List;
import java.util.Optional;

public interface UsuariosService {
    List<Usuarios> findAllUsuarios();

    Optional<Usuarios> findUsuarioById(String id);

    Usuarios saveUsuario(Usuarios usuario);

    boolean deleteUsuario(String id);

    Usuarios updateUsuario(Usuarios usuario);

    Optional<Usuarios> findUsuarioByNombreAndClave(String nombre, String clave);

    Optional<Usuarios> findUsuarioByDniAndClave(String dni, String clave);

    boolean ponerCambiarClaveATrue(String dni);

    boolean cambiarClave(String dni, String clave);

}
