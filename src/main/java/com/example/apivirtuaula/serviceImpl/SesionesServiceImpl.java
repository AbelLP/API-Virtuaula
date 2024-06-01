package com.example.apivirtuaula.serviceImpl;

import com.example.apivirtuaula.model.Sesiones;
import com.example.apivirtuaula.repository.SesionesRepository;
import com.example.apivirtuaula.service.SesionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SesionesServiceImpl implements SesionesService {

    @Autowired
    private SesionesRepository sesionesRepository;

    @Override
    public List<Sesiones> findAllSesiones(){
        return sesionesRepository.findAll();
    }

    @Override
    public Optional<Sesiones> findSesionById(int id) {
        return sesionesRepository.findById(id);
    }

    @Override
    public List<Sesiones> findSesionByDni(String dni) {
        return sesionesRepository.findSesionesByDni(dni);
    }

    @Override
    public List<Sesiones> findSesionByCodEquipo(int codEquipo) {
        return sesionesRepository.findSesionesByCodEquipo(codEquipo);
    }

    @Override
    public List<Sesiones> findSesionByClase(String nombre) {
        return sesionesRepository.findSesionesByClases(nombre);
    }

    @Override
    public boolean aniadirHoraFin(int id, String fechaHoraFin){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime fhFLocal=LocalDateTime.parse(fechaHoraFin, formatter);
        Timestamp fHF=Timestamp.valueOf(fhFLocal);
        boolean cambiado=false;
        int filas=sesionesRepository.aniadirHoraFin(id, fHF);
        if(filas>0){
            cambiado=true;
        }
        return cambiado;
    }

    @Override
    public Sesiones saveSesion(Sesiones sesion){
        if(sesion!=null){
            return sesionesRepository.save(sesion);
        }
        return null;
    }

    @Override
    public boolean deleteSesion(int id) {
        Optional<Sesiones> sesion=sesionesRepository.findById(id);
        if(sesion.isPresent()){
            sesionesRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Sesiones updateSesion(Sesiones sesion){
        if(sesionesRepository.findById(sesion.getIdSesion()).isPresent()){
            return sesionesRepository.save(sesion);
        }
        return null;
    }

}
