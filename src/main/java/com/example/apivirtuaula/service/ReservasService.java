package com.example.apivirtuaula.service;

import com.example.apivirtuaula.model.Reservas;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservasService {
    List<Reservas> findAllReservas();

    Optional<Reservas> findReservasById(Long id);

    List<Reservas> findReservaByDni(String dni);

    List<Reservas> findReservasByEquipoClaseNombre(String nombre);

    List<Reservas> findReservasByHora(String hora);

    List<Reservas> findReservasByNoCaducadas();

    List<Reservas> findReservasByDniAndNoCaducadas(String dni);

    List<Reservas> findReservasByEquipoClaseNombreAndNoCaducadas(String nombre);

    List<Reservas> findReservasByHoraAndNoCaducada(String hora);

    Reservas findReservaByCodEquipo(int codEquipo);

    Reservas saveReserva (Reservas reserva);

    boolean deleteReserva(Long id);

    Reservas updateReservas(Reservas reservas);
}
