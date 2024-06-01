package com.example.apivirtuaula.controller;

import com.example.apivirtuaula.model.Administrador;
import com.example.apivirtuaula.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping("/administrador")
    public List<Administrador> getAdministradores(){
        return administradorService.findAllAdministradores();
    }

    @GetMapping("/administrador/{id}")
    public Optional<Administrador> getAdministradorById(@PathVariable String id){
        return administradorService.findAdministradorById(id);
    }

    @PostMapping("/administrador")
    public Administrador addAdministrador(@RequestBody Administrador administrador){
        return administradorService.saveAdministrador(administrador);
    }

    @DeleteMapping("/administrador/{id}")
    public String deleteAdministrador(@PathVariable String id){
        if(administradorService.deleteAdministrador(id)){
            return "Administrador eliminado correctamente.";
        }else {
            return "El usuario no existe";
        }
    }

    @PutMapping("/administrador")
    public Administrador updateAdministrador(@RequestBody Administrador administrador){
        return administradorService.updateAdministrador(administrador);
    }

}
