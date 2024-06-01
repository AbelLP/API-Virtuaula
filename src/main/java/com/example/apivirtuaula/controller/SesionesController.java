package com.example.apivirtuaula.controller;

import com.example.apivirtuaula.model.Sesiones;
import com.example.apivirtuaula.service.SesionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SesionesController {

    @Autowired
    private SesionesService sesionesService;

    @GetMapping("/sesiones")
    public List<Sesiones> getAllSesiones(){
        return sesionesService.findAllSesiones();
    }

    @GetMapping("/sesiones/{id}")
    public Optional<Sesiones> getSesionById(@PathVariable int id){
        return sesionesService.findSesionById(id);
    }

    @GetMapping("/sesiones/usuario/{dni}")
    public List<Sesiones> getSesionesByUsuario(@PathVariable String dni){
        return sesionesService.findSesionByDni(dni);
    }

    @GetMapping("/sesiones/equipo/{codEquipo}")
    public List<Sesiones> getSesionesByEquipos(@PathVariable int codEquipo){
        return sesionesService.findSesionByCodEquipo(codEquipo);
    }

    @GetMapping("/sesiones/clase/{nombre}")
    public List<Sesiones> getSesionesByClase(@PathVariable String nombre){
        return sesionesService.findSesionByClase(nombre);
    }

    @GetMapping("/sesiones/{idSesion}/fecha/{fechaHoraFin}")
    public String aniadirHoraFin(@PathVariable int idSesion, @PathVariable String fechaHoraFin){
        if(sesionesService.aniadirHoraFin(idSesion, fechaHoraFin)){
            return "Cierre de sesión completado";
        }else{
            return "Error en el cierre de sesión";
        }
    }

    @PostMapping("/sesiones")
    public Sesiones addSesiones(@RequestBody Sesiones sesion){
        return sesionesService.saveSesion(sesion);
    }

    @DeleteMapping("/sesiones/{id}")
    public String deleteSesiones(@PathVariable int id){
        if(sesionesService.deleteSesion(id)){
            return "Sesión eliminada correctamente";
        }else{
            return "Error al eliminar la sesión";
        }
    }

    @PutMapping("/sesiones")
    public Sesiones updateSesiones(@RequestBody Sesiones sesion){
        return sesionesService.updateSesion(sesion);
    }


}
