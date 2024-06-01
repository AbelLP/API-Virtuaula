package com.example.apivirtuaula.repository;

import com.example.apivirtuaula.model.Reservas;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservasRepository extends JpaRepository<Reservas, Long> {

    @Query("SELECT r FROM Reservas r WHERE r.usuario.dni =?1")
    List<Reservas> findReservasByDni(String dni);

    @Query("SELECT r FROM Reservas r WHERE r.equipo.clase.nombre =?1")
    List<Reservas> findReservasByEquipoClaseNombre(String nombre);

    @Query("SELECT r FROM Reservas r WHERE r.fechaHoraReserva >=?1 AND r.fechaHoraReserva<?2")
    List<Reservas> findReservasByHora(Timestamp horaC, Timestamp horaF);

    @Query("SELECT r FROM Reservas r WHERE r.caducado='no'")
    List<Reservas> findReservasByNoCaducadas();

    @Query("SELECT r FROM Reservas r WHERE r.usuario.dni =?1 AND r.caducado='no'")
    List<Reservas> findReservasByDniAndNoCaducadas(String dni);

    @Query("SELECT r FROM Reservas r WHERE r.equipo.clase.nombre =?1 AND r.caducado='no'")
    List<Reservas> findReservasByEquipoClaseNombreAndNoCaducado(String nombre);

    @Query("SELECT r FROM Reservas r WHERE r.fechaHoraReserva>=?1 AND r.fechaHoraReserva<?2 AND r.caducado='no'")
    List<Reservas> findReservasByHoraAndNoCaducada(Timestamp horaC, Timestamp horaF);

    @Query("SELECT r FROM Reservas r WHERE r.equipo.codEquipo=?1")
    Reservas findReservasByEquipoId(int codEquipo);

    @Modifying
    @Transactional
    @Query("UPDATE Reservas r SET r.caducado='si' WHERE r.fechaHoraReserva<?1 AND r.caducado='no'")
    int caducarReservas(LocalDateTime fechaActual);

}
