package com.example.apivirtuaula.controller;

import com.example.apivirtuaula.model.Administrador;
import com.example.apivirtuaula.model.Permisos;
import com.example.apivirtuaula.service.PermisosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PermisosController {

    @Autowired
    private PermisosService permisosService;

    @GetMapping("/permisos")
    public List<Permisos> getPermisos(){
        return permisosService.findAllPermisos();
    }

    @GetMapping("/permisos/{id}")
    public Optional<Permisos> getPermisoById(@PathVariable String id){
        return permisosService.findPermisoById(id);
    }

    @PostMapping("/permisos")
    public Permisos addPermisos(@RequestBody Permisos permiso){
        if(permiso!=null){
            return permisosService.savePermiso(permiso);
        }
        return null;
    }

    @DeleteMapping("/permisos/{id}")
    public String deletePermisos(@PathVariable String id){
        if(permisosService.deletePermiso(id)){
            return "Pemisos borrados con éxito";
        }else {
            return "Estos permisos no existen";
        }
    }

    @PutMapping("/permisos")
    public Permisos updateAdministrador(Permisos permiso){
        return permisosService.updatePermiso(permiso);
    }

}
