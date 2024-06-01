package com.example.apivirtuaula.serviceImpl;

import com.example.apivirtuaula.model.Equipos;
import com.example.apivirtuaula.repository.EquiposRepository;
import com.example.apivirtuaula.service.EquiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquiposServiceImpl implements EquiposService {

    @Autowired
    private EquiposRepository equiposRepository;

    @Override
    public List<Equipos> findAllEquipos(){
        return equiposRepository.findAll();
    }

    @Override
    public Optional<Equipos> findEquipoById(int id){
        return equiposRepository.findById(id);
    }

    @Override
    public List<Equipos> findEquiposLibres(){
        return equiposRepository.findEquiposLibres();
    }

    @Override
    public List<Equipos> findEquiposByNombreClase(String nombre){
        return equiposRepository.findEquiposByNombreClase(nombre);
    }

    @Override
    public List<Equipos> findEquiposByNombreClaseAndLibres(String nombre){
        return equiposRepository.findEquiposByNombreClaseAndLibres(nombre);
    }

    @Override
    public int getCountEquiposClase(int codClase){
        return equiposRepository.getCountEquiposClase(codClase);
    }

    @Override
    public boolean changeEstadoAOcupado(String nombre){
        boolean cambiado=false;
        int filas=equiposRepository.changeEstadoAOcupado(nombre);
        if(filas>0){
            cambiado=true;
        }
        return cambiado;
    }

    @Override
    public boolean changeEstadoARoto(String nombre){
        boolean cambiado=false;
        int filas=equiposRepository.changeEstadoARoto(nombre);
        if(filas>0){
            cambiado=true;
        }
        return cambiado;
    }

    @Override
    public boolean changeEstadoALibre(String nombre){
        boolean cambiado=false;
        int filas=equiposRepository.changeEstadoALibre(nombre);
        if(filas>0){
            cambiado=true;
        }
        return cambiado;
    }

    @Override
    public Equipos saveEquipo(Equipos equipo){
        if(equipo!=null){
            return equiposRepository.save(equipo);
        }
        return null;
    }

    @Override
    public boolean deleteEquipo(int id) {
        Optional<Equipos> equipo=equiposRepository.findById(id);
        if(equipo.isPresent()){
            equiposRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Equipos updateEquipo(Equipos equipo){
        if(equiposRepository.findById(equipo.getCodEquipo()).isPresent()){
            return equiposRepository.save(equipo);
        }
        return null;
    }


}
