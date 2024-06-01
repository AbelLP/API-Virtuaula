package com.example.apivirtuaula.serviceImpl;

import com.example.apivirtuaula.model.Reservas;
import com.example.apivirtuaula.repository.ReservasRepository;
import com.example.apivirtuaula.service.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservasServiceImpl implements ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

    @Override
    public List<Reservas> findAllReservas() {
        return reservasRepository.findAll();
    }

    @Override
    public Optional<Reservas> findReservasById(Long id) {
        return reservasRepository.findById(id);
    }

    @Override
    public List<Reservas> findReservaByDni(String dni){
        return reservasRepository.findReservasByDni(dni);
    }

    @Override
    public List<Reservas> findReservasByEquipoClaseNombre(String nombre){
        return reservasRepository.findReservasByEquipoClaseNombre(nombre);
    }

    @Override
    public List<Reservas> findReservasByHora(String hor){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime startTime = LocalTime.parse(hor, formatter);
        LocalTime endTime = startTime.plusHours(1);
        String horF=endTime.toString();
        Timestamp hora= Timestamp.valueOf(hor);
        Timestamp horaF=Timestamp.valueOf(horF);
        return reservasRepository.findReservasByHora(hora, horaF);
    }

    @Override
    public List<Reservas> findReservasByNoCaducadas(){
        return reservasRepository.findReservasByNoCaducadas();
    }

    @Override
    public List<Reservas> findReservasByDniAndNoCaducadas(String dni) {
        return reservasRepository.findReservasByDniAndNoCaducadas(dni);
    }

    @Override
    public List<Reservas> findReservasByEquipoClaseNombreAndNoCaducadas(String nombre) {
        return reservasRepository.findReservasByEquipoClaseNombreAndNoCaducado(nombre);
    }

    @Override
    public List<Reservas> findReservasByHoraAndNoCaducada(String hora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime startTime = LocalTime.parse(hora, formatter);
        LocalTime endTime = startTime.plusHours(1);
        // Obtener la fecha actual
        LocalDate currentDate = LocalDate.now();

        // Combinar la fecha actual con las horas especificadas
        LocalDateTime startDateTime = LocalDateTime.of(currentDate, startTime);
        LocalDateTime endDateTime = LocalDateTime.of(currentDate, endTime);

        // Convertir a Timestamp
        Timestamp hor = Timestamp.valueOf(startDateTime);
        Timestamp horaF = Timestamp.valueOf(endDateTime);

        return reservasRepository.findReservasByHora(hor, horaF);

    }

    @Override
    public Reservas findReservaByCodEquipo(int codEquipo){
        return reservasRepository.findReservasByEquipoId(codEquipo);
    }

    @Override
    public Reservas saveReserva(Reservas reserva) {
        if(reserva!=null){
            return reservasRepository.save(reserva);
        }
        return null;
    }

    @Override
    public boolean deleteReserva(Long id) {
        Optional<Reservas> reserva=findReservasById(id);
        if(reserva.isPresent()){
            reservasRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Reservas updateReservas(Reservas reservas) {
        if(reservasRepository.findById(reservas.getIdReserva()).isPresent()){
            return reservasRepository.save(reservas);
        }
        return null;
    }
}
