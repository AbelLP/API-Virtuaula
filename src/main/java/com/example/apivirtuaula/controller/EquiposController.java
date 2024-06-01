package com.example.apivirtuaula.controller;

import com.example.apivirtuaula.model.Equipos;
import com.example.apivirtuaula.service.EquiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.Optional;

@RestController
public class EquiposController {

    @Autowired
    private EquiposService equiposService;

    @GetMapping("/equipos")
    public List<Equipos> getEquipos(){
        return equiposService.findAllEquipos();
    }

    @GetMapping("/equipos/{id}")
    public Optional<Equipos> getEquipoById(@PathVariable int id){
        return equiposService.findEquipoById(id);
    }

    @GetMapping("/equipos/libres")
    public List<Equipos> getEquiposLibres(){
        return equiposService.findEquiposLibres();
    }

    @GetMapping("/equipos/clase/{clase}")
    public List<Equipos> getEquiposByNombreClase(@PathVariable String clase){
        return equiposService.findEquiposByNombreClase(clase);
    }

    @GetMapping("/equipos/libres/clase/{clase}")
    public List<Equipos> getEquiposByNombreClaseAndLibres(@PathVariable String clase){
        return equiposService.findEquiposByNombreClaseAndLibres(clase);
    }

    @GetMapping("/equipos/contar/{codClase}")
    public int getCountEquiposClase(@PathVariable int codClase){
        return equiposService.getCountEquiposClase(codClase);
    }

    @GetMapping("/equipos/ocupado/{nombre}")
    public String modifyEstadoAOcupado(@PathVariable String nombre){
        if(equiposService.changeEstadoAOcupado(nombre)){
            return "Actualización correcta";
        }else{
            return "Error en la actualización";
        }
    }

    @GetMapping("/equipos/roto/{nombre}")
    public String modifyEstadoARoto(@PathVariable String nombre){
        if(equiposService.changeEstadoARoto(nombre)){
            return "Actualización correcta";
        }else{
            return "Error en la actualización";
        }
    }

    @GetMapping("/equipos/libre/{nombre}")
    public String modifyEstadoALibre(@PathVariable String nombre){
        if(equiposService.changeEstadoALibre(nombre)){
            return "Actualización correcta";
        }else{
            return "Error en la actualización";
        }
    }

    @PostMapping("/equipos")
    public Equipos addEquipo(@RequestBody Equipos equipo){
        return equiposService.saveEquipo(equipo);
    }

    @DeleteMapping(value = "/equipos/{id}")
    public String deleteEquipo(@PathVariable int id){
        if(equiposService.deleteEquipo(id)){
            return "El equipo ha sido eliminado correctamente";
        }else{
            return "El equipo no existe";
        }
    }

    @PutMapping("/equipos")
    public Equipos updateEquipos(@RequestBody Equipos equipos){
        return equiposService.updateEquipo(equipos);
    }

}
