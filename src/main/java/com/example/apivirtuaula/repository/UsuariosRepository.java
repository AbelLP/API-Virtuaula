package com.example.apivirtuaula.repository;

import com.example.apivirtuaula.model.Usuarios;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuarios, String> {

    @Query("SELECT u FROM Usuarios u WHERE u.nombre =?1 AND u.clave=?2")
    Optional<Usuarios> findUsuarioByNombreAndClave(String nombre, String clave);

    @Query("SELECT u FROM Usuarios u WHERE u.dni =?1 AND u.clave=?2")
    Optional<Usuarios> findUsuarioByDniAndClave(String dni, String clave);

    @Modifying
    @Transactional
    @Query("UPDATE Usuarios u SET u.cambiarClave=TRUE WHERE u.dni=?1")
    int ponerCambiarClaveATrue(String dni);

    @Modifying
    @Transactional
    @Query("UPDATE Usuarios u SET u.clave=?2 WHERE u.dni=?1")
    int cambiarClave(String dni, String clave);



}
